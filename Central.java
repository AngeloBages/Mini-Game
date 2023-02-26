package algo_13;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Central {
	
	static Object inimigo;
	static Random ran = new Random();
	static Scanner ler = new Scanner(System.in);
	static BufferedReader es = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int opt1,opt2,derrotado = 0;
		boolean vivo = true;
		boolean inivivo;
		
		do {
			
			System.out.print("\n Procurar Inimigos:");
			System.out.print("\n [1]-Sim  [2]-Não\n\n ");
			System.out.println(System.lineSeparator().repeat(10));
			opt1 = ler.nextInt();
		    
			if(opt1 == 1) {                      //Procurar inimigos
                
				opt2 = 0;
				inimigo = invocar(opt1);
				inivivo = true;
				
				while(inivivo == true & vivo == true) {
					
			        opt2 = action();
			        
			        switch(opt2) {
			        
			        case 1:
			        	
			            ((Inimigo) inimigo).infoIni();
		                System.out.println(System.lineSeparator().repeat(6));
		                es.readLine();
		                
		                if(((Inimigo) inimigo).vida <= 0) {
		    				
		    				System.out.print(" Você derrotou o inimigo.");
		    				System.out.println(System.lineSeparator().repeat(6));
		    				es.readLine();
		    				derrotado++;
		    				inivivo = false;
		    				dropPotion();
		    				
		    				continue;
		    			}
		                
		                Jogador.vida = ((Inimigo) inimigo).atacar(Jogador.vida);
		                es.readLine();
		                
                        if(Jogador.vida <= 0) {
		                	
		                	System.out.print("\n Você foi derrotado.");
		                	System.out.println(System.lineSeparator().repeat(6));
		    				es.readLine();
		    				vivo = false;
		                }else {
		                
		                    ((Inimigo) inimigo).infoIni();
		                }
			        	break;
			      
			        case 4: 
			        	
			        	((Inimigo) inimigo).infoIni();
			        	break;
			        	
			        default:
			        	
			        	((Inimigo) inimigo).infoIni();
			        	break;
			        }
			        
			        System.out.println(System.lineSeparator().repeat(6));
				}
				
			}else if(opt1 == 2){
	    		
	         	System.out.print("\n Você permanece parado");
	            System.out.println(System.lineSeparator().repeat(5));
	            
			}else {
	        	 System.out.println(" RESPOSTA INVÁLIDA\n Tente Novamente");
	        	 System.out.println(System.lineSeparator().repeat(5));
	        	 es.readLine();
			}
			
		}while(opt1!=2 & vivo == true & derrotado < 10);
		
		System.out.printf(" Você derrotou %s inimigos.", derrotado);
		System.out.println(System.lineSeparator().repeat(6));
		
		if(derrotado == 10) {
			
			System.out.print("\n Você ganhou o jogo!");
            System.out.println(System.lineSeparator().repeat(5));
		}
	}
    private static Object invocar(int opt1) {
		
		int opt = ran.nextInt(2,5);
		
		    if(opt%2==0) {
			    Inimigo_01 inimigo01 = new Inimigo_01();
			    
			    System.out.printf("\n Você encontrou um: %s",inimigo01.nome);
			    System.out.printf("\n vida: %s\n",inimigo01.vida);
			    System.out.println(System.lineSeparator().repeat(5));
			
			    return inimigo01;
		    }else {
			    Inimigo_02 inimigo02 = new Inimigo_02();
			    
			    System.out.printf("\n Você encontrou um: %s",inimigo02.nome);
			    System.out.printf("\n vida: %s\n",inimigo02.vida);
			    System.out.println(System.lineSeparator().repeat(5));
			    
		    	return inimigo02;
		    }
	}
    private static int action() throws IOException {
		
		System.out.print("\n [1]-Atacar ");
		System.out.print(" [2]-Curar ");
		System.out.print(" [4]-Info\n\n ");
		
		
		int opt = ler.nextInt();
		
		switch(opt) {
		
		case 1:
			
			Jogador.atacar();
			System.out.print(" Você realizou um ataque.");
			System.out.println(System.lineSeparator().repeat(12));
			
			if(((Inimigo) inimigo).vida <= 0) {
				((Inimigo) inimigo).vida = 0;
			}
			break;
			
		case 2:
			
			if(Jogador.potion > 0) {
			    
				Jogador.curar();
			    System.out.print(" Você se curou.");
			    System.out.println(System.lineSeparator().repeat(12));
			    Jogador.potion--;
			}else {
				
				System.out.print(" Você não possui poções. ");
				System.out.println(System.lineSeparator().repeat(12));
			}
			break;
			
		case 4:
			
			Jogador.infoJog();
			System.out.println(System.lineSeparator().repeat(9));
			break;
			
		default:
			
			System.out.println(System.lineSeparator().repeat(8));
			System.out.println("\n RESPOSTA INVÁLIDA\n Tente Novamente");
			System.out.println(System.lineSeparator().repeat(5));
			break;
		}
		es.readLine();
		
		return opt;
	}
    static private void dropPotion() throws IOException {
    	
    	int aleatorio;
    	aleatorio = ran.nextInt(2,5);
    	
    	if(aleatorio%2 == 0) {
    		
    		Jogador.potion++;
    		System.out.print("\n O inimigo dropou uma poção.");
    		System.out.println(System.lineSeparator().repeat(6));
			es.readLine();
        }
    }
	
    private static class Jogador{
		
		private static int vida = 30;
	    private static int dano = ran.nextInt(7,11);
		private static int potion = 0;
		
		private static void curar() {
			
			if(potion > 0) {
				
				vida += ran.nextInt(5,11);
			}
		}
		private static void atacar() {
			
			 ((Inimigo) inimigo).vida-=dano;
		}
		private static void infoJog() {
			
			System.out.printf("      Jogador\n Vida: %s\n Poções: %s\n\n",vida ,potion);
		}
	}
}
