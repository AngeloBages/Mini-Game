package Entidades;

public class MinionGuerreiro extends Inimigo {

	public MinionGuerreiro(){
	
		vida = random.nextInt(20,31);
		dano = random.nextInt(6,10);
		nome = "Minion guerreiro";
	}
	
	@Override
	public int atacar(int vidaDoJogador) {
		
		dano = random.nextInt(6,10);
		
        vidaDoJogador-=dano;
        System.out.print(" Você recebe um ataque do inimigo");
        System.out.println(System.lineSeparator().repeat(6));
        
        return vidaDoJogador;
    }
}