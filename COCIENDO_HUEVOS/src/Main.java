import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int h = scanner.nextInt(); // Número de huevos
            int c = scanner.nextInt(); // Capacidad de la olla

            // Condición de salida
            if (h == 0 && c == 0) {
                break;
            }

            // Calculamos el número de tandas necesarias
            int tandas = (h + c - 1) / c;
            // Calculamos el tiempo total en minutos
            int tiempoTotal = tandas * 10;

            // Imprimimos el resultado
            System.out.println(tiempoTotal);
        }

        scanner.close();
    }
}
