import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matriz = new int[3][9];

        llenarMatriz(matriz);
        System.out.println("Matriz inicial:");
        imprimirMatriz(matriz);

        ordenarColumnas(matriz);
        System.out.println("\nMatriz ordenada por columnas:");
        imprimirMatriz(matriz);
    }

    // Llenar la matriz con números aleatorios en rangos específicos para cada columna
    private static void llenarMatriz(int[][] matriz) {
        Random aleatorio = new Random();
        for (int columna = 0; columna < matriz[0].length; columna++) {
            int minimo = 10 + (columna * 10); // valor mínimo para la columna actual
            int maximo = minimo + 9;          // valor máximo para la columna actual

            for (int fila = 0; fila < matriz.length; fila++) {
                matriz[fila][columna] = aleatorio.nextInt(maximo - minimo + 1) + minimo;
            }
        }
    }

    // Imprimir la matriz
    private static void imprimirMatriz(int[][] matriz) {
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[0].length; columna++) {
                System.out.print(matriz[fila][columna] + "\t");
            }
            System.out.println();
        }
    }

    // Ordenar cada columna de la matriz de menor a mayor
    private static void ordenarColumnas(int[][] matriz) {
        for (int columna = 0; columna < matriz[0].length; columna++) {
            for (int fila = 0; fila < matriz.length - 1; fila++) {
                for (int i = 0; i < matriz.length - fila - 1; i++) {
                    if (matriz[i][columna] > matriz[i + 1][columna]) {
                        int temp = matriz[i][columna];
                        matriz[i][columna] = matriz[i + 1][columna];
                        matriz[i + 1][columna] = temp;
                    }
                }
            }
        }
    }
}
