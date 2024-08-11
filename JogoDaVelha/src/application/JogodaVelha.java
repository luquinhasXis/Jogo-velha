package application;

import java.util.Scanner;

import entitity.Campo;

public class JogodaVelha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//[][] significa matriz de N linhas e N colunas
		
		Campo[][] jogodaVelha = new Campo[3][3];
		char quemJoga = 'X';
		Boolean jogo = true;
		char vitoria =' ';
		
		Campo.iniciarJogo(jogodaVelha);
	
		while(jogo) {
			Campo.desenhaJogo(jogodaVelha);
			vitoria = Campo.ganhador(jogodaVelha);
			if(vitoria!=(' ')) {
				System.out.printf("Jogar %s venceu%n", vitoria);
				jogo = false;
				break;
			}
			try {
				if(Campo.quemJoga(jogodaVelha, Campo.jogar(sc, quemJoga), quemJoga)) {
					if(quemJoga=='X') {
						quemJoga='O';
					}
					else {
						quemJoga='X';
					}
				}
			}catch(Exception e) {
				System.out.println("Erro.");
			}
		}
		System.out.println("Fim de jogo.");

		sc.close();
	}
}