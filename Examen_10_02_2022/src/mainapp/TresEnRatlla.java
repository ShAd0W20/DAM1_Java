package mainapp;

import java.util.Scanner;

public class TresEnRatlla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] tauler = new char[3][3];
		char guanyador = 'N';
		String pos1 = "";
		String pos2 = "";
		Scanner lector = new Scanner(System.in);

		inicializarTablero(tauler);
		System.out.println(dibuixarTauler(tauler));
		
		System.out.println("Entra la posicio X");
		pos2=lector.nextLine();
		tiradaInicialUsuari('X',pos2,tauler);
		System.out.println(dibuixarTauler(tauler));
		
		System.out.println("Entra la posicio O");
		pos2=lector.nextLine();
		tiradaInicialUsuari('O',pos2,tauler);
		System.out.println(dibuixarTauler(tauler));
	
		System.out.println("Entra la posicio X");
		pos2=lector.nextLine();
		tiradaInicialUsuari('X',pos2,tauler);
		System.out.println(dibuixarTauler(tauler));
		
		System.out.println("Entra la posicio O");
		pos2=lector.nextLine();
		tiradaInicialUsuari('O',pos2,tauler);
		System.out.println(dibuixarTauler(tauler));
	
		System.out.println("Entra la posicio X");
		pos2=lector.nextLine();
		tiradaInicialUsuari('X',pos2,tauler);
		System.out.println(dibuixarTauler(tauler));
		if(comprovarHoritzontal('X',pos2,tauler)||comprovarVertical('X',pos2,tauler)||comprovarDiagonal('X',pos2,tauler)) guanyador='X';
	
		if(guanyador=='N') {
			System.out.println("Entra la posicio O");
			pos2=lector.nextLine();
			tiradaInicialUsuari('O',pos2,tauler);
			System.out.println(dibuixarTauler(tauler));
			if(comprovarHoritzontal('O',pos2,tauler)||comprovarVertical('O',pos2,tauler)||comprovarDiagonal('O',pos2,tauler)) guanyador='O';
		}

		while (guanyador == 'N') {
			System.out.println("Entra la posicio inicial X");
			pos1 = lector.nextLine();
			System.out.println("Entra la posicio final X");
			pos2 = lector.nextLine();
			tiradaUsuari('X', pos1, pos2, tauler);
			System.out.println(dibuixarTauler(tauler));
			if (comprovarHoritzontal('X', pos2, tauler) || comprovarVertical('X', pos2, tauler)
					|| comprovarDiagonal('X', pos2, tauler))
				guanyador = 'X';

			if (guanyador == 'N') {
				System.out.println("Entra la posicio inicial O");
				pos1 = lector.nextLine();
				System.out.println("Entra la posicio final O");
				pos2 = lector.nextLine();
				tiradaUsuari('O', pos1, pos2, tauler);
				System.out.println(dibuixarTauler(tauler));
				if (comprovarHoritzontal('O', pos2, tauler) || comprovarVertical('O', pos2, tauler)
						|| comprovarDiagonal('O', pos2, tauler))
					guanyador = 'O';

			}
		}
		System.out.println("El guanyador ha estat " + guanyador);

	}

	static void inicializarTablero(char[][] tauler) {

		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler.length; j++) {
				tauler[i][j] = '-';
			}
		}

	}

	static void tiradaUsuari(char jugador, String posicioInicial, String posicioFinal, char[][] tauler) {
		char initialPost = '-';
		int intInitialPost = 0;
		int finalPost = 0;
		initialPost = posicioInicial.charAt(0);
		finalPost = Integer.parseInt(String.valueOf(posicioInicial.charAt(1))) - 1;
		
		if(initialPost == 'A') {
			intInitialPost = 0;
		} else if(initialPost ==  'B') {
			intInitialPost = 1;
		} else if(initialPost ==  'C') {
			intInitialPost = 2;
		}
		
		tauler[finalPost][intInitialPost] = '-';
		
		char initialPost2 = '-';
		int intInitialPost2 = 0;
		int finalPost2 = 0;
		initialPost2 = posicioFinal.charAt(0);
		finalPost2 = Integer.parseInt(String.valueOf(posicioFinal.charAt(1))) - 1;
		
		if(initialPost2 == 'A') {
			intInitialPost2 = 0;
		} else if(initialPost2 ==  'B') {
			intInitialPost2 = 1;
		} else if(initialPost2 ==  'C') {
			intInitialPost2 = 2;
		}
		
		tauler[finalPost2][intInitialPost2] = jugador;
	}

	static void tiradaInicialUsuari(char jugador, String posicioFinal, char[][] tauler) {
		char initialPost = '-';
		int intInitialPost = 0;
		int finalPost = 0;
		initialPost = posicioFinal.charAt(0);
		finalPost = Integer.parseInt(String.valueOf(posicioFinal.charAt(1))) - 1;
		
		if(initialPost == 'A') {
			intInitialPost = 0;
		} else if(initialPost ==  'B') {
			intInitialPost = 1;
		} else if(initialPost ==  'C') {
			intInitialPost = 2;
		}
		
		tauler[finalPost][intInitialPost] = jugador;
	}

	static String dibuixarTauler(char[][] tauler) {
		String dibujo = "";
		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler[0].length; j++) {
				dibujo += tauler[i][j] + " ";
			}
			dibujo += "\n";
		}
		return dibujo;
	}

	static boolean comprovarHoritzontal(char jugador, String posicioFinal, char[][] tauler) {
		char simbolo;
		boolean coincidencia;

		for (int i = 0; i < tauler.length; i++) {

			coincidencia = true;

			simbolo = tauler[i][0];
			if (simbolo != '-') {
				for (int j = 1; j < tauler[0].length; j++) {
					if (simbolo != tauler[i][j]) {
						coincidencia = false;
					}
				}

				if (coincidencia) {
					return true;
				}

			}
		}
		return false;
	}

	static boolean comprovarVertical(char jugador, String posicioFinal, char[][] tauler) {
		char simbolo;
		boolean coincidencia;

		for (int j = 0; j < tauler.length; j++) {

			coincidencia = true;
			simbolo = tauler[0][j];
			if (simbolo != '-') {
				for (int i = 1; i < tauler[0].length; i++) {
					if (simbolo != tauler[i][j]) {
						coincidencia = false;
					}
				}

				if (coincidencia) {
					return true;
				}

			}

		}

		return false;
	}

	static boolean comprovarDiagonal(char jugador, String posicioFinal, char[][] tauler) {
		char simbolo;
        boolean coincidencia = true;
       
        simbolo = tauler[0][0];
        if (simbolo != '-') {
            for (int i = 1; i < tauler.length; i++) {
                if (simbolo != tauler[i][i]) {
                    coincidencia = false;
                }
            }
 
            if (coincidencia) {
                return true;
            }
 
        }
 
        coincidencia = true;
        
        simbolo = tauler[0][2];
        if (simbolo != '-') {
            for (int i = 1, j = 1; i < tauler.length; i++, j--) {
                if (simbolo != tauler[i][j]) {
                    coincidencia = false;
                }
            }
            
            if (coincidencia) {
                return true;
            }
        }
 
		return false;
	}

}
