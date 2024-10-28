import java.util.Scanner;

public class Main {
    // Método para calcular la altura mínima de la pirámide con n bloques
    private static int alturaMinima(int n) {
        int h = 0; // Inicializa la altura de la pirámide en 0
        int bloques = 0; // Inicializa el contador de bloques en 0


        while (bloques <= n) {
            h++; // Incrementa la altura de la pirámide
            bloques += h * h;
        }
        return h - 1; // Devuelve la altura menos 1, ya que la última suma excedió n
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe un numero: ");

        while (true) {
            int n = leer.nextInt(); // Lee el número de bloques de piedra
            if (n == 0) break;
            System.out.println(alturaMinima(n)); // Imprime la altura mínima de la pirámide
        }

        leer.close(); 
    }
}
