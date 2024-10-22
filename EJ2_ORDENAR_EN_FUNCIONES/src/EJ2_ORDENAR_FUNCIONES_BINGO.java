import java.util.Random;

public class EJ2_ORDENAR_FUNCIONES_BINGO {

    private static final int filas = 10; // Número de filas
    private static final int columnas = 9; // Número de columnas
    private static int tablero[][] = new int[filas][columnas];  // Inicializar tablero

    private static void numAleaSinRepetirse() {
        Random aleatorio = new Random();

        // Llenar el tablero con números aleatorios sin repetirse
        for (int j = 0; j < columnas; j++) {    // Primero columnas
            for (int i = 0; i < filas; i++) {   // Segundo fials
                int numInicio = 10 + j * 10; // Columna 1 empieza en el 10, la 2 en el 20, etc.
                int numFinal = numInicio + 9; // Columna 1 termina en 19, la 2 en 29, etc.
                int numeroAleatorio;

                boolean repetido;
                do {
                    numeroAleatorio = aleatorio.nextInt(numInicio, numFinal + 1); // Generar número aleatorio en el rango de cada columna
                    repetido = false;

                    // Verificar si el número esta ya puesto en la columna
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
    }

    private static void ordenarNumColumnasTablero() {
        // Ordenar columnas del tablero

        for (int j = 0; j < columnas; j++) {
            for (int i = 0; i < filas - 1; i++) {
                for (int k = 0; k < filas - 1 - i; k++) {
                    if (tablero[k][j] > tablero[k + 1][j]) { // Comparar los números
                        // Intercambiar números de posición
                        int aux = tablero[k][j];
                        tablero[k][j] = tablero[k + 1][j];
                        tablero[k + 1][j] = aux;
                    }
                }
            }
        }
    }

    private static void imprimirTablero() {
        // Imprimir tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " "); // Imprimir cada número
            }
            System.out.println(); // Nueva línea después de cada fila
        }
        System.out.println(""); // Espacio adicional
    }

    public static void main(String[] args) {
        numAleaSinRepetirse();
        imprimirTablero();
        ordenarNumColumnasTablero();
        imprimirTablero();
    }
}
