import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int filaArrays = 3;
    private static int[] Arrays = new int[filaArrays];
    private static final int casillasVacias = 0;
    private static int numUsuario = 0;

    private static void inicializarTablero() {
        // Rellenamos el array de casillas vacías
        for (int i = 0; i < filaArrays; i++) {
            Arrays[i] = casillasVacias;
        }
        imprimirArrays();
    }

    private static void numUsuarioRepeticionArrays() {
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("Introduce el número de repeticiones:");
            numUsuario = leer.nextInt();
        } while (numUsuario <= 0);
    }

    private static void añadirNumAleatorios() {
        Random aleatorio = new Random();
        int numAleatorio;

        // Se genera el array y se imprime el número de veces que el usuario indico
        for (int j = 0; j < numUsuario; j++) {
            for (int i = 0; i < filaArrays; i++) {
                do {
                    numAleatorio = aleatorio.nextInt(-10000, 10000);    // Genera entre -10,000 y 10,000
                } while (numAleatorio == 0);  // Se pueden imprimir todos los numeros menos el 0
                Arrays[i] = numAleatorio;
            }
            imprimirArrays();   //Se repite en cada vuelta del bucle
            compararNumeros();
            System.out.println("");
            System.out.println("");
        }
    }

    private static void compararNumeros() {
        int A = Arrays[0];
        int B = Arrays[1];
        int C = Arrays[2];

        //Calcular distancias
        int distanciaA = Math.abs(A - B);
        int distanciaC = Math.abs(C - B);

        //Comparar Distancias

        if (distanciaA < distanciaC) {
            System.out.println("El número más cercano a " + B + " es: " + A);
        } else if (distanciaA > distanciaC) {
            System.out.println("El número más cercano a " + B + " es: " + C);
        } else {
            System.out.println("EMPATE");
        }
    }

    private static void imprimirArrays() {
        for (int i = 0; i < filaArrays; i++) {
            System.out.print(" [ " + Arrays[i] + " ] ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        inicializarTablero();
        numUsuarioRepeticionArrays();
        añadirNumAleatorios();
    }
}
