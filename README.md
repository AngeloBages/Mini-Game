# Mini-Game RPG

Este é um exemplo simples de um jogo de batalha em Java. O jogo é baseado em turnos, onde você pode escolher entre atacar, curar ou obter informações sobre o seu personagem. O objetivo é derrotar 10 inimigos e, eventualmente, ser derrotado para finalizar o jogo.

### JogoRpg.java

A classe principal que controla o fluxo do jogo. Ela permite que você procure inimigos, lute contra eles e colete poções.

### Inimigo.java

Uma classe base abstrata que representa um inimigo. Contém métodos para atacar o jogador e exibir informações do inimigo.

### Minion.java e MinionGuerreiro.java

Classes que herdam de `Inimigo` e representam tipos específicos de inimigos com diferentes atributos.

### Jogador

Uma classe interna que representa o jogador. Ela possui métodos para atacar e se curar, além de exibir informações sobre o jogador.

## Funcionalidades Prinicipais

### Batalhar com Inimigos
O jogo oferece a opção de procurar inimigos. Caso escolha enfrentar um inimigo, a batalha se inicia, com turnos alternados entre você e o inimigo para atacar e se curar.

### Inimigos Aleatórios
Os inimigos são invocados aleatoriamente, podendo ser do tipo "Minion" ou "Minion Guerreiro". Cada inimigo possui sua própria vida e características.

### Dropar Poções
Ao derrotar um inimigo, há a possibilidade de ganhar poções, que podem ser usadas para curar o personagem durante a batalha.

### Salvar e Recuperar Jogadores
O jogo permite que você salve seu progresso, armazenando seu nome e a quantidade de inimigos derrotados. Além disso, é possível visualizar os dados de outros jogadores que venceram o jogo.

## Como Jogar

1. Compile todas as classes fornecidas.
2. Execute a classe `JogoRpg` no seu ambiente Java.
3. O jogo apresentará opções para procurar inimigos ou permanecer parado. Você pode atacar inimigos, se curar usando poções e obter informações sobre o jogador ou inimigo.
4. O objetivo é derrotar 10 inimigos para vencer o jogo.

## Observações
- Certifique-se de digitar valores numéricos quando solicitado.
- Seja estratégico nas batalhas, usando poções quando necessário e atacando com eficiência.
- Boa sorte e divirta-se jogando!
