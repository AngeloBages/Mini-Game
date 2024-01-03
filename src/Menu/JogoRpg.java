package Menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import Entidades.*;

public class JogoRpg {
	
	static Random random = new Random();
	static Scanner ler = new Scanner(System.in);
	static BufferedReader espaco = new BufferedReader(new InputStreamReader(System.in));
	
	static File arquivoDeSaves = new File("Saves.txt");
	static int inimigosDerrotados = 0;
	
	public static void main(String[] args) {
		
		int procurarInimigos;
		try {
			
			do {
				
				System.out.print("\n Procurar Inimigos:");
				System.out.print("\n [1]-Sim  [2]-Não\n\n ");
				System.out.println(System.lineSeparator().repeat(10));
				procurarInimigos = ler.nextInt();
			    
				switch(procurarInimigos) {                      
	                
				case 1:                                                              //Inicia batalha contra o inimigo
					
					Inimigo inimigo = invocarInimigo();
					
					while(inimigo.estaVivo() & Jogador.vivo) {
						
				        agir(inimigo);                                               //Escolhe ação a ser realizada
				        	  
				        if(!Jogador.vivo) {
				        	continue;
				        }
				        
			            inimigo.infoInimigo();
					}
				    System.out.println(System.lineSeparator().repeat(6));
					break;
					
				case 2:
		    		
		         	System.out.print("\n Você permanece parado");
		            System.out.println(System.lineSeparator().repeat(5));
		            break;
		            
				default:
					
		        	 System.out.println(" RESPOSTA INVÁLIDA\n Tente Novamente");
		        	 System.out.println(System.lineSeparator().repeat(5));
		        	 espaco.readLine();
		        	 break;
				}
				
			}while(procurarInimigos!=2 & Jogador.vivo == true & inimigosDerrotados < 50);
			
			System.out.printf(" Você derrotou %s inimigos.", inimigosDerrotados);
			System.out.println(System.lineSeparator().repeat(6));
			
			
			if(inimigosDerrotados >= 10) {                                            /*Caso o numero de inimigos mortos seja superior
			                                                                            a 10 o jogador vence o jogo*/ 
				                                                                     
				System.out.print("\n Você ganhou o jogo!");
	            System.out.println(System.lineSeparator().repeat(5));
	            espaco.readLine();
	            
	            salvarJogador();

	            System.out.println(System.lineSeparator().repeat(6));
		        System.out.print(" Ver o resultado de todos ganhadores?");
		        System.out.print("\n [1]-Sim [2]-Não");
		        System.out.println(System.lineSeparator().repeat(6));
		        int verResultados = ler.nextInt();
		        	
		        if(verResultados == 1) {
		        	recuperarJogadores();
		        }
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(InputMismatchException e){
			System.err.println("\n Erro:" + e.toString()
			+ "\n Digite apenas valores numéricos entre: \n "
			+ "-2.147.483.648 a 2.147.483.647");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    private static Inimigo invocarInimigo() {                                   //Invoca aleatoriamente um tipo de inimigo
		
		int numeroAleatorio = random.nextInt(2,6);
		
		Inimigo inimigo;                                                          
		
		    if(numeroAleatorio%2==0) {
		    	inimigo = new Minion();
			    
		    }else {
			    inimigo = new MinionGuerreiro();
		    }
		    
		    System.out.printf("\n Você encontrou um: %s",inimigo.getNome());
		    System.out.printf("\n vida: %s\n",inimigo.getVida());
		    
		return inimigo;
	}
    
    private static void agir(Inimigo inimigo) throws IOException {               
    	
		System.out.print("\n [1]-Atacar ");
		System.out.print(" [2]-Curar ");
		System.out.print(" [4]-Info\n\n ");
		
		System.out.println(System.lineSeparator().repeat(6));
		
		
		int acaoContraInimigo = ler.nextInt();
		
		switch(acaoContraInimigo) {
		
		case 1:
			Jogador.atacar(inimigo);                                       //turno do jogador
			espaco.readLine();
			
			inimigo.infoInimigo();
            System.out.println(System.lineSeparator().repeat(6));
            espaco.readLine();
            
            if(!inimigo.estaVivo()) {
				
				System.out.print(" Você derrotou o inimigo.");
				System.out.println(System.lineSeparator().repeat(6));
				inimigosDerrotados++;
				espaco.readLine();
				droparPocao();
				break;
			}
            
            Jogador.vida = inimigo.atacar(Jogador.vida);                   //turno do inimigo
            
            if(Jogador.vida <= 0) {
            	
            	espaco.readLine();
            	System.out.print("\n Você foi derrotado.");
            	System.out.println(System.lineSeparator().repeat(6));
				Jogador.vivo = false;
            }
			break;
			
		case 2:
			Jogador.curar();
			break;
			
		case 4:
			Jogador.infoJogador();
			break;
			
		default:
			System.out.println(System.lineSeparator().repeat(8));
			System.out.println("\n RESPOSTA INVÁLIDA\n Tente Novamente");
			System.out.println(System.lineSeparator().repeat(5));
			break;
		}
		
		espaco.readLine();
	}
    
    private static void droparPocao() {                                         //Pode dropar aleatóriamente uma pocao
   
    	int aleatorio;
    	aleatorio = random.nextInt(2,5);
    	
    	if(aleatorio%2 == 0) {                                                  
    		
    		Jogador.pocoes++;
    		System.out.print("\n O inimigo dropou uma poção.");
    		System.out.println(System.lineSeparator().repeat(6));
        }
    }
    
    private static void salvarJogador() throws IOException {                    //Armazena os dados do jogador em um arquivo
    	
    	System.out.println(System.lineSeparator().repeat(6));
    	System.out.println("Digite seu nome para salvar no Rank: ");
    	System.out.println(System.lineSeparator().repeat(6));
    	Jogador.nome = ler.next();
    	
    	BufferedWriter escritorDeSaves = new BufferedWriter(new FileWriter(arquivoDeSaves, true));
    	
    	escritorDeSaves.write("\n\n Nome:" + Jogador.nome
    			              + "\n nº inimgos derrotado: " + inimigosDerrotados);
    	
    	escritorDeSaves.close();
    }
    
    private static void recuperarJogadores() throws IOException {               //Le os dados de outros jogadores em um arquivo
    	
    	BufferedReader leitorDeSaves = new BufferedReader(new FileReader(arquivoDeSaves));
    	
    	String save = "";
    	
    	while((save = leitorDeSaves.readLine()) != null) {
    		
    		System.out.println(save);
    	}
    	
    	leitorDeSaves.close();
    }
    
    private static class Jogador{
		
		private static int vida = 30;
	    private static int dano;
	    private static boolean vivo = true;
		private static int pocoes = 0;
		private static String nome;
		
		private static void curar() {
			
			if(pocoes > 0) {
				
				vida += random.nextInt(7,13);
				System.out.print(" Você se curou.");
			    pocoes--;
			}else {
				
				System.out.print(" Você não possui poções. ");
			}
			
			System.out.println(System.lineSeparator().repeat(12));
		}
		
		private static void atacar(Inimigo inimigo) {
			
			dano= (int) ((random.nextInt(6,10)) + (0.15 * vida));
			
			inimigo.sofrerDano(dano);
			System.out.print(" Você realizou um ataque.");
			System.out.println(System.lineSeparator().repeat(12));
		}
		
		private static void infoJogador() {
			
			System.out.printf("      Jogador\n Vida: %s\n Poções: %s\n\n",vida ,pocoes);
			System.out.println(System.lineSeparator().repeat(9));
		}
	}
}
