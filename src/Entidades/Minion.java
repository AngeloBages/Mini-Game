package Entidades;

public class Minion extends Inimigo{

	public Minion(){
	
		vida = random.nextInt(10,21);
		dano = random.nextInt(3,7);
		nome = "Minion";    
	}
	
	@Override
	public int atacar(int vidaDoJogador) {
		
		dano = random.nextInt(3,7);
		
        vidaDoJogador-=dano;
        System.out.print(" Você recebe um ataque do inimigo");
        System.out.println(System.lineSeparator().repeat(6));
        
        return vidaDoJogador;
    }
}
