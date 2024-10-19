//import java.util.HashSet;
//import java.util.Set;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Collections;
import java.util.Random;
import java.util.Arrays;

public class EJ4_BINGO {

    private static final int filaBingo = 3;
    private static final int columnaBingo = 9;

    public static void main(String[] args) {
        // Escribimos el tablero de casillas vacías
        int[][] tablero = new int[filaBingo][columnaBingo];
        for (int i = 0; i < filaBingo; i++) {
            for (int j = 0; j < columnaBingo; j++) {
                System.out.print("[_]");
            }
            System.out.println(" ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");

        // Asignamos números aleatorios para cada columna
        Random alea = new Random();
        for (int i = 0; i < filaBingo; i++) {
            for (int j = 0; j < columnaBingo; j++) {
                int numInicio = 10 + j * 10; // Columna 1 empieza en el 10, la 2 en el 20, etc.
                int numFinal = numInicio + 9; // Columna 1 termina en 19, la 2 en 29, etc.
                int numeroAleatorio = alea.nextInt(numFinal - numInicio + 1) + numInicio;
                tablero[i][j] = numeroAleatorio; // Genera número aleatorio en cada columna
            }
        }

        // Imprimimos el tablero con los números aleatorios
        for (int i = 0; i < filaBingo; i++) {
            for (int j = 0; j < columnaBingo; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println(" ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");

        // Números aleatorios sin repetirse en la misma columna
        boolean repetido;
        for (int j = 0; j < columnaBingo; j++) { // Iterar por columnas primero
            for (int i = 0; i < filaBingo; i++) { // Luego por filas
                int numInicio = 10 + j * 10; // Columna 1 empieza en el 10, la 2 en el 20, etc.
                int numFinal = numInicio + 9; // Columna 1 termina en 19, la 2 en 29, etc.
                int numeroAleatorio;

                // Generar un número aleatorio y verificar si ya existe en la columna
                do {
                    numeroAleatorio = alea.nextInt(numFinal - numInicio + 1) + numInicio;
                    repetido = false;

                    // Verificar si el número ya está en la columna actual
                    for (int k = 0; k < i; k++) {
                        if (tablero[k][j] == numeroAleatorio) {
                            repetido = true;
                            break;
                        }
                    }
                } while (repetido);

                // Asignar el número al tablero
                tablero[i][j] = numeroAleatorio;
            }
        }

        // Imprimimos el tablero con los números aleatorios sin repetirse, por columna
        for (int i = 0; i < filaBingo; i++) {
            for (int j = 0; j < columnaBingo; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println(" ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");

        // Ordenar los números en cada columna
        for (int j = 0; j < columnaBingo; j++) {
            int[] columna = new int[filaBingo];

            // Extraer los elementos de la columna
            for (int i = 0; i < filaBingo; i++) {
                columna[i] = tablero[i][j];
            }

            // Ordenar la columna
            Arrays.sort(columna);

            // Colocar los elementos ordenados de vuelta en la columna original
            for (int i = 0; i < filaBingo; i++) {
                tablero[i][j] = columna[i];
            }
        }

        // Imprimimos el tablero final con los números ordenados por columna
        for (int i = 0; i < filaBingo; i++) {
            for (int j = 0; j < columnaBingo; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println(" ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}
