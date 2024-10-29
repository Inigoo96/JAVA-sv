import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        // numeros y letras correspondientes
        int[] numeros = {1000000, 100000, 10000, 1000, 100, 10, 1};
        char[] letras = {'H', 'R', 'D', 'F', 'C', 'G', 'T'};

        while (true) {
            System.out.println("Escribe un numero, nosotros te lo pasamos a egipcio :) ");
            int numUsuario = leer.nextInt();
            if (numUsuario == 0) break;

            // Convertir número a egipcio
            String resultado = "";
            for (int i = 0; i < numeros.length; i++) {
                while (numUsuario >= numeros[i]) {
                    resultado = resultado + letras[i];
                    numUsuario = numUsuario - numeros[i];
                }
            }

            System.out.println(resultado);
        }
    }
}
