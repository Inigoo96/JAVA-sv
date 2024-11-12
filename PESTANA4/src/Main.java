import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];

        // Llenar y mostrar el array en diferentes formas
        rellenarAscendente(array);
        mostrarArray("Array en orden ascendente", array);

        mostrarInverso(array);

        rellenarPares(array);
        mostrarArray("Array con números pares", array);

        mostrarDeDosEnDos(array);

        rellenarImpares(array);
        mostrarArray("Array con números impares", array);

        duplicarElementos(array);
        mostrarArray("Array con cada elemento duplicado", array);

        calcularSuma(array);

        encontrarMaxMin(array);
    }

    // Rellenar el array en orden ascendente
    private static void rellenarAscendente(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    // Mostrar el array en orden inverso
    private static void mostrarInverso(int[] array) {
        System.out.print("Array en orden inverso: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Rellenar el array con números pares
    private static void rellenarPares(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }
    }

    // Mostrar elementos de dos en dos
    private static void mostrarDeDosEnDos(int[] array) {
        System.out.print("Elementos de dos en dos: ");
        for (int i = 0; i < array.length; i += 2) {
            System.out.print("[" + array[i] + ", " + (i + 1 < array.length ? array[i + 1] : " ") + "] ");
        }
        System.out.println();
    }

    // Rellenar el array con números impares
    private static void rellenarImpares(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2 + 1;
        }
    }

    // Duplicar cada elemento del array
    private static void duplicarElementos(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
    }

    // Calcular la suma de los elementos
    private static void calcularSuma(int[] array) {
        int suma = 0;
        for (int num : array) {
            suma += num;
        }
        System.out.println("Suma de todos los elementos: " + suma);
    }

    // Encontrar el valor máximo y mínimo
    private static void encontrarMaxMin(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int num : array) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("Valor máximo: " + max);
        System.out.println("Valor mínimo: " + min);
    }

    // Función auxiliar para mostrar el array
    private static void mostrarArray(String mensaje, int[] array) {
        System.out.println(mensaje + ": " + Arrays.toString(array));
    }
}
