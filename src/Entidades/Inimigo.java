package Entidades;

import java.util.Random;

public abstract class Inimigo {
	
    Random random = new Random();
	
    protected int vida;
    protected int dano;
    protected String nome;
    protected boolean vivo = true;
    
    public int atacar(int vidaDoJogador) {
	
        vidaDoJogador-=dano;
        System.out.print(" Você recebe um ataque do inimigo");
        System.out.println(System.lineSeparator().repeat(6));
        
        return vidaDoJogador;
    }
    public void infoInimigo() {
	
	    System.out.printf("\n               %s",nome);
	    System.out.printf("\n vida: %s\n",vida);
    }
    public boolean estaVivo() {
    	return vivo;
    }
    public void derrotado() {
    	vivo = false;
    }
    public void sofrerDano(int dano) {
    	vida -= dano;
    	vida = vida <= 0? 0 : vida;
    	vivo = vida <= 0? false : true;
    }
	public int getVida() {
		return vida;
	}
	public String getNome(){
		return nome;
	}
}