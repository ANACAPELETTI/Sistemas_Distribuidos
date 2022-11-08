/*
 * Correção do exercício das roletas, passado pelo professor em sala
 */

import java.util.*;
import java.text.*;

//'Contador' é um objeto compartilhado pelas threads.
class ContadorCentral {
	protected int numPessoas = 0;
}

//A roleta controla uma entrada do parque.
class Roleta implements Runnable {
	public int totPessoas = 0;
	public int incr = 0;
	public ContadorCentral contadorCentral;
  
  public void run() {
		Thread thread = Thread.currentThread();
		for (int i = 0; i < 60000000; i++) {
			totPessoas = totPessoas + incr;
        contadorCentral.numPessoas = contadorCentral.numPessoas + incr;
		}
	}
}

public class Main {
	public static void main(String[] args) {
		ContadorCentral contador = new ContadorCentral();
		Roleta e1 = new Roleta();
		e1.contadorCentral = contador;
		e1.incr = 1;
		Roleta e2 = new Roleta();
		e2.contadorCentral = contador;
		e2.incr = 3;
		Thread t1 = new Thread(e1, "Entrada 1");
		Thread t2 = new Thread(e2, "Entrada 2");
		t1.start();
    synchronized(t1){
      try{
        System.out.println("Aguardando o t1 completar...");
        t1.wait();
      }catch(InterruptedException e){}
    }
    t2.start();
		try { //Aguarda as duas threads encerrarem para terminar a main
      t1.join();
			t2.join();
		} catch (InterruptedException e) {
		} finally {
			DecimalFormat estilo = new DecimalFormat("###,###,###,###");
			System.out.println("\n*** FIM DA CONTAGEM ***");
			System.out.println("*** Entrada 1: " + estilo.format(e1.totPessoas)
					+ " pessoas");
			System.out.println("*** Entrada 2: " + estilo.format(e2.totPessoas)
					+ " pessoas");
			System.out.println("*** Total: "
					+ estilo.format(e2.totPessoas + e1.totPessoas));
			System.out.println("*** Total CENTRALIZADO: "
					+ estilo.format(contador.numPessoas));
		}
	}
}
