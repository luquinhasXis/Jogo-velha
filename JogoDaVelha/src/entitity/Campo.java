package entitity;

import java.util.Scanner;

public class Campo {

	private char simbolo;
	
	public Campo() {
		this.simbolo=' ';
	}
	
	public char getSimbolo() {
		return this.simbolo;
	}
	
	public void setSimbolo(char simbolo) {
		if(this.simbolo ==' ') {
			this.simbolo = simbolo;
		}
		else {
			System.out.println("Campo usado.");
		}
	}

	// comando para fazer o desenho do jogo 
	public static void desenhaJogo(Campo[][] jogodaVelha) {
		
		System.out.println("    1    2    3");
		System.out.printf("0   %c | %c | %c %n",
				jogodaVelha[0][0].getSimbolo(),
				jogodaVelha[0][1].getSimbolo(),
				jogodaVelha[0][2].getSimbolo());
		System.out.println("    -----------");
		System.out.printf("1   %c | %c | %c %n",
				jogodaVelha[1][0].getSimbolo(),
				jogodaVelha[1][1].getSimbolo(),
				jogodaVelha[1][2].getSimbolo());
		System.out.println("    -----------");
		System.out.printf("2   %c | %c | %c %n",
				jogodaVelha[2][0].getSimbolo(),
				jogodaVelha[2][1].getSimbolo(),
				jogodaVelha[2][2].getSimbolo());
	}

	public static int[] jogar(Scanner sc, char sa) {
		int p[] = new int[2];
		System.out.printf("%s %c%n", "Quem joga: ", sa);
		System.out.print("Informe a linha: ");
		p[0] = sc.nextInt();
		System.out.println("Informe a coluna: ");
		p[1] = sc.nextInt();
		return p;
	}
	
	// comando para saber de quem é a vez
	public static Boolean quemJoga(Campo[][] jogodaVelha, int p[], char quemJoga) {
		if(jogodaVelha[p[0]][p[1]].getSimbolo()==' '){
			jogodaVelha[p[0]][p[1]].setSimbolo(quemJoga);
			return true;
			}
		else {
			return false;
		}
	}
	
	// comando para iniciar o jogo 
	public static void iniciarJogo(Campo[][] jogodaVelha) {
		for(int l=0; l<3; l++) {
			for(int c=0; c<3; c++) {
				jogodaVelha[l][c] = new Campo();
			}
		}
	}
	
	
	// comando para saber o vencedor da partida
	public static char ganhador(Campo[][] jogodaVelha) {
		
		for(int i=0;i<3;i++){
			if((jogodaVelha[i][0].getSimbolo()=='X' && jogodaVelha[i][1].getSimbolo()=='X'
					&& jogodaVelha[i][2].getSimbolo()=='X')||(jogodaVelha[i][0].getSimbolo()=='O'
					&& jogodaVelha[i][1].getSimbolo()=='O' && jogodaVelha[i][2].getSimbolo()=='O')){
				return jogodaVelha[i][0].getSimbolo();
			}
		}
		for(int i=0;i<3;i++){
			if((jogodaVelha[0][i].getSimbolo()=='X' && jogodaVelha[1][i].getSimbolo()=='X' 
					&& jogodaVelha[2][i].getSimbolo()=='X')||(jogodaVelha[0][i].getSimbolo()=='O'
					&& jogodaVelha[1][i].getSimbolo()=='O' && jogodaVelha[2][i].getSimbolo()=='O')){
				return jogodaVelha[0][i].getSimbolo();
			}
		}
		if((jogodaVelha[0][0].getSimbolo()=='X' && jogodaVelha[1][1].getSimbolo()=='X' 
				&& jogodaVelha[2][2].getSimbolo()=='X')||(jogodaVelha[0][2].getSimbolo()=='O'
				&& jogodaVelha[1][1].getSimbolo()=='O' && jogodaVelha[2][0].getSimbolo()=='O')){
			return jogodaVelha[0][0].getSimbolo();
		}
		return ' ';
	}
}
