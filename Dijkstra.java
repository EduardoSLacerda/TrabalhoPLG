package trabalho;

import java.util.Random;

import javax.swing.JOptionPane;

public class Dijkstra {

	public static int Fila() {
		Random randomico = new Random();
		int fila = randomico.nextInt(3);
		return fila;
	}

	public static void main(String args[]) {
		int DA[] = new int[324];
		int Ant[] = new int[324];
		boolean ExpA[] = new boolean[324];
		int N, Origem, Destino, i, C, NovaDA, Min;
		N = 18;
		int[][] D = {
				//	0	1	2	3	4	5	6	7	8	9	10	 11	  12   13   14   15   16   17	    
			  /*0*/{0,  72, 0,  112,0,  0,  0,  0,  0,	0,  0,   0,   0,   0,   0,   0,   0,   0},
			  /*1*/{0,  0,  99, 0,  0,  0,  0,  0,  0,  0,  0,   0,   0,   0,   0,   0,   0,   0},
			  /*2*/{0,  0,  0,  69, 0,  260,0,  0,  0,  0,	0,   0,   0,   0,	0,   0,   0,   0},
		      /*3*/{0,  0,  0,  0,  319,0,  0,  0,  0,  0,  0,   0,   0,   0,   0,   0,   0,   0},
			  /*4*/{0,  0,  0,  0,  0,  0,  343,0,  0,  0,  0,   0,   0,   0,   0,   0,   0,   0},
			  /*5*/{0,  0,  0,  0,  0,  0,  330,0,  0,  252,0,   0,   0,   0,   0,   0,   0,   0},
			  /*6*/{0,  0,  0,  0,  0,  330,0,  116,0, 	0,  0,   0,   0,   0,   0,   0,   0,   0},
			  /*7*/{0,  0,  0,  0,  0,	0,  0,  0,  210,0,  259, 0,   0,   0,   0,	 0,   0,   0},
			  /*8*/{0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,   0,   0,   0,   286, 0,   0,   0},
			  /*9*/{0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  404, 0,   0,   0,   0,   0,   0,   0},
			 /*10*/{0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,   0,   100, 246, 0,   0,   0,   0},
			 /*11*/{0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,   0,   0,   94,  0,   0,   0,   0},
		     /*12*/{0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,   0,   0,   0,   199, 0,   142, 0},
			 /*13*/{0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,   0,   0,   0,   95,  0,   0,   0},
		     /*14*/{0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,   0,  199,  0,   0,   146, 0,   0},
		     /*15*/{0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,   0,   0,   0,   0,   0,   135, 0},
		     /*16*/{0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,   0,   0,   0,   0,   0,   0,   58},
		     /*17*/{0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,   0,   0,   0,   0,   0,   0,   0}
		};
		Origem = Integer.parseInt(JOptionPane.showInputDialog("Digite a cidade de origem"));
		Destino = Integer.parseInt(JOptionPane.showInputDialog("Digite a cidade de destino"));

		D[5][9] *= Fila();
		D[7][10] *= Fila();
		D[8][14] *= Fila();
		D[15][16] *= Fila();

		for(i=0; i<N; i++) {
			ExpA[i] = false;
			DA[i] = 10000;
		}
		C = Origem;
		DA[C] = 0;
		while((C != Destino) && (C!=-1)) {
			for(i=0;i<N;i++) { //Expansao de C
				if ((D[C][i] != 0)&&(!ExpA[i])) {
					NovaDA = DA[C] + D[C][i];
					if (NovaDA < DA[i]) {
						DA[i] = NovaDA;
						Ant[i] = C;
					}
				}
			}
			ExpA[C] = true;
			//Determinacao do Proximo C
			Min = 10000;
			C = -1;
			for(i=0;i<N;i++) {
				if( (!ExpA[i]) && (DA[i] < Min)) {
					Min = DA[i];
					C = i;
				}
			}
		}
		if (C == Destino) {
			String saida = "Caminho mais curto de " + Origem
					+ " ate o destino " + Destino + "\n";
			saida = saida + Destino + "\n";
			while (C != Origem) {
				C = Ant[C];
				saida = saida + C + "\n";
			}
			JOptionPane.showMessageDialog(null, saida);
		} else {
			JOptionPane.showMessageDialog(null, "Nao existe caminho entre as cidades");
		}
	}
}
