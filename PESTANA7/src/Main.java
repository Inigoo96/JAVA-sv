import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número entero positivo: ");
        int n = scanner.nextInt();
        int suma = 0;

        // Código optimizado para sumar solo los números pares
        for (int i = 2; i <= n; i += 2) {
            suma += i;
        }

        System.out.println("La suma de los números pares del 1 al " + n + " es: " + suma);
        scanner.close();
    }
}
