# Mini-Game RPG

Este é um exemplo simples de um jogo de batalha em Java, onde você é um jogador enfrentando inimigos gerados aleatoriamente. O jogo permite que você ataque inimigos, se cure e colete poções para se curar. O objetivo é derrotar 10 inimigos para vencer o jogo.

## JogoRpg.java

A classe principal que controla o fluxo do jogo. Ela permite que você procure inimigos, lute contra eles e colete poções.

## Inimigo.java

Uma classe base abstrata que representa um inimigo. Contém métodos para atacar o jogador e exibir informações do inimigo.

## Minion.java e MinionGuerreiro.java

Classes que herdam de `Inimigo` e representam tipos específicos de inimigos com diferentes atributos.

## Jogador

Uma classe interna que representa o jogador. Ela possui métodos para atacar e se curar, além de exibir informações sobre o jogador.

## Como Jogar

1. Compile todas as classes fornecidas.
2. Execute a classe `JogoRpg` no seu ambiente Java.
3. O jogo apresentará opções para procurar inimigos ou permanecer parado. Você pode atacar inimigos, se curar usando poções e obter informações sobre o jogador ou inimigo.
4. O objetivo é derrotar 10 inimigos para vencer o jogo.
