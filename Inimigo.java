package algo_13;
import java.util.Random;

class Inimigo {
	
    Random ran = new Random();
	
    protected int vida;
	protected int dano;
    protected String nome;
    
    protected int atacar(int vida) {
	
        vida-=dano;
        System.out.print(" Você recebe um ataque do inimigo");
        System.out.println(System.lineSeparator().repeat(6));
        
        return vida;
    }
    protected void infoIni() {
	
	    System.out.printf("\n               %s",nome);
	    System.out.printf("\n vida: %s\n",vida);
    }
}
