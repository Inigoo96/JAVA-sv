import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String linea = scanner.nextLine();
            if (linea.contains("FIN")) break;

            char charCodificacion = linea.charAt(0);
            int desplazamiento = charCodificacion - 'p';

            String mensaje = linea.substring(1);
            String mensajeDecodificado = "";
            for (int i = 0; i < mensaje.length(); i++) {
                char c = mensaje.charAt(i);
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char decodificado = (char) ((c - base - desplazamiento + 26) % 26 + base);
                    mensajeDecodificado += decodificado;
                } else {
                    mensajeDecodificado += c;
                }
            }

            int conteoVocales = 0;
            for (int i = 0; i < mensajeDecodificado.length(); i++) {
                char c = mensajeDecodificado.charAt(i);
                if ("AEIOUaeiou".indexOf(c) != -1) {
                    conteoVocales++;
                }
            }

            System.out.println(conteoVocales);
        }
    }
}
