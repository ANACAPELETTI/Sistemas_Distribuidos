<h1 align="center"> Problema da Roleta </h1>

## ✔️ Descrição do problema
O exercício consiste em uma instância (ContadorCentral) que é compartilhada por duas threads. Uma thread sempre que observa a entrada de uma pessoa, adiciona 1 ao contador, enquanto a outra thread adiciona 3. Devido a este compartilhamento, algumas execuções funcionam perfeitamente, enquanto outras apresentam erros de contagem devido ao problema de "atualização perdida", como mostra o exemplo abaixo.

<p align="center">
◆━━━━━━◆❃◆━━━━━━◆
</p>

<p align="center">
<img src="https://user-images.githubusercontent.com/75649546/200617302-cf6effcd-36c1-4a04-8a77-bb5a11a73205.png"/>
</p>

<p align="center">
◆━━━━━━◆❃◆━━━━━━◆
</p>

Para facilitar ainda mais a explicação do exercício, abaixo encontra-se o diagrama de atividades de como o programa funcionava:

<p align="center">
<img src="https://user-images.githubusercontent.com/75649546/200619802-2779e543-cd48-4cc7-9ff5-a5dd783f5c76.png"/>
</p>

Ou seja, a parte do código que faz a atualização da variável numPessoas é uma seção crítica e, com isso, somente um processo (thread) pode executá-lo por vez. Para impedir que mais de uma thread atualize numPessoas, utilizei a palavra-chave “synchronized”. Após consertar o problema utilizando o synchronized o diagrama ficou da seguinte forma:

<p align="center">
<img src="https://user-images.githubusercontent.com/75649546/200620046-e0cd21c0-07e2-48a5-9613-e666c9d40748.png"/>
</p>

Deixando de ocorrer os problemas de “atualização perdida” e resolvendo o problema da questão. Para visualizar o código, [clique aqui](https://github.com/ANACAPELETTI/Sistemas_Distribuidos/blob/main/Main.java).
