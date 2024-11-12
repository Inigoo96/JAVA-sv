import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String[] palabras = {"sol", "luna", "estrella", "cielo", "mar", "montaña", "río", "nube", "flor", "árbol"};
        String[] respuestas = new String[palabras.length];

        System.out.println("¡Bienvenido al Juego de Memoria!");
        System.out.println("Trata de memorizar cada palabra en el orden correcto.");
        System.out.println("Escribe todas las palabras memorizadas hasta el momento después de cada nueva palabra.\n");

        // Iniciar el juego de memoria
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Palabra " + (i + 1) + ": " + palabras[i]);
            respuestas[i] = palabras[i];

            System.out.print("Escribe todas las palabras memorizadas: ");
            String entrada = leer.nextLine();

            // Crear la secuencia correcta de palabras hasta el momento
            String secuenciaCorrecta = "";
            for (int j = 0; j <= i; j++) {
                secuenciaCorrecta += respuestas[j] + " ";
            }
            secuenciaCorrecta = secuenciaCorrecta.trim();

            // Verificar si la entrada es correcta
            if (!entrada.equals(secuenciaCorrecta)) {
                System.out.println("¡Ups! La secuencia era: " + secuenciaCorrecta);

                System.out.print("¿Quieres intentarlo de nuevo desde el inicio? (s/n): ");
                String respuesta = leer.nextLine();
                if (respuesta.equalsIgnoreCase("s")) {
                    System.out.println("¡Ánimo! Vamos de nuevo.\n");
                    i = -1; // Reiniciar el juego
                } else {
                    System.out.println("Gracias por jugar. ¡Hasta la próxima!");
                    leer.close();
                    return;
                }
            } else {
                System.out.println("¡Bien hecho! Siguiente palabra.\n");
            }
        }

        System.out.println("¡Enhorabuena! Has memorizado todas las palabras correctamente. ¡Felicidades!");
        leer.close();
    }
}
