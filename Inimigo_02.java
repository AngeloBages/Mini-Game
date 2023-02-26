package algo_13;

    class Inimigo_02 extends Inimigo {
	
	Inimigo_02(){
		
		vida = ran.nextInt(20,31);
		dano = ran.nextInt(6,10);
		nome = "Minion guerreiro";
	}
}
