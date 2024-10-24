/*el usuario escribe un numero
el usuario tiene 10 intentos
tablero reprentado por XX
si el numero del usuario coincide con el numero del tablero, cambiar XX por el numero
num aleatrios del 10-99
*/

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int filaTablero1 = 10;
    private static int columnaTablero1 = 10;
    private static int filaTablero2 = 10;
    private static int columnaTablero2 = 10;
    private static int[][] tablero1 = new int[filaTablero1][columnaTablero1];
    private static String[][] tablero2 = new String[filaTablero2][columnaTablero2];
    private static int numAleatorio;

    private static void inicializarTablero1() {
        Random aleatorio = new Random();
        for (int i = 0; i < filaTablero1; i++) {
            for (int j = 0; j < columnaTablero1; j++) {
                tablero1[i][j] = aleatorio.nextInt(10, 100);;
            }
        }
    }

    private static void imprimirTablero1() {
        System.out.println("TABLERO1: ");
        for (int i = 0; i < filaTablero1; i++) {
            for (int j = 0; j < columnaTablero1; j++) {
                System.out.print("[" + tablero1[i][j] + "]");
            }
            System.out.println(" ");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static void inicializarTablero2() {
        for (int i = 0; i < filaTablero2; i++) {
            for (int j = 0; j < columnaTablero2; j++) {
                tablero2[i][j] = "XX";
            }
        }
    }

    private static void imprimirTablero2() {
        System.out.println("TABLERO2 USUARIO: ");
        for (int i = 0; i < filaTablero2; i++) {
            for (int j = 0; j < columnaTablero2; j++) {
                System.out.print("[" + tablero2[i][j] + "]");
            }
            System.out.println(" ");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static void respuestaUsuarioJugar() {
        Scanner leer = new Scanner(System.in);
        int vidas = 10;
        boolean encontrado;
        int numUsuario;

        while (vidas > 0) {
            encontrado = false;
            System.out.println("Escribe un numero: ");
            numUsuario = leer.nextInt();

            for (int i = 0; i < filaTablero1; i++) {
                for (int j = 0; j < columnaTablero1; j++) {
                    if (tablero1[i][j] == numUsuario) {
                        tablero2[i][j] = String.valueOf(numUsuario);
                        encontrado = true;
                    } else if (!encontrado) {
                        vidas--;
                        System.out.println("Te quedan " + vidas + " vidas.Intentalo de nuevo: ");
                    }
                }
            }
            imprimirTablero2();
        }
        System.out.println("Juego terminado. Te has quedado sin vidas.");
    }

    public static void main(String[] args) {
        inicializarTablero1();
        imprimirTablero1();
        inicializarTablero2();
        imprimirTablero2();
        respuestaUsuarioJugar();
    }
}
