import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        while(true) {
            System.out.println("Escribe el numero del codigo de barras EAN-8 o EAN-13:");
            System.out.println("Escriba 0 si quiere salir.");
            System.out.println();
            String codigoUsuario;
            codigoUsuario = leer.nextLine().trim(); // Eliminar espacios en blanco

            if (codigoUsuario.equals("0")) {
                leer.close();   // Cerrar el scanner
                break;  // Salir del bucle
            }

            boolean ean8 = codigoUsuario.length() <= 8; // Es EAN-8 si el código tiene <= 8 dígitos
            boolean ean13 = codigoUsuario.length() > 8 && codigoUsuario.length() <= 13; // Es EAN-13 si el código tiene > 8 y <= 13 dígitos

            if (ean8) {
                while (codigoUsuario.length() < 8) {
                    codigoUsuario = "0" + codigoUsuario; // Añadir ceros a la izquierda si tiene menos de 8 dígitos
                }
            } else if (ean13) {
                while (codigoUsuario.length() < 13) {
                    codigoUsuario = "0" + codigoUsuario; // Añadir ceros a la izquierda si tiene menos de 13 dígitos
                }
            }

            int numPares = 0;
            int numImpares = 0;
            int pasarPosicion = 0;

            for (int i = codigoUsuario.length() - 2; i >= 0 ; i--) { // Saltar el último dígito (dígito de control)
                int num = Character.getNumericValue(codigoUsuario.charAt(i));
                pasarPosicion++; // Incrementar la posición desde el final hasta el principio

                if (pasarPosicion % 2 == 0) {
                    numPares += num * 1; // Sumar a numPares
                } else {
                    numImpares += num * 3; // Sumar a numImpares
                }
            }

            int sumaTotal = numPares + numImpares; // Calcular la suma total
            int resto = sumaTotal % 10; // Calcular el resto de sumaTotal

            // Calcular el dígito de control
            int digitoControlCalculado;
            if (resto == 0) {
                digitoControlCalculado = 0; // Si el resto es 0, el dígito de control es 0
            } else {
                digitoControlCalculado = 10 - resto; // Si no, restamos 10 - resto para obtener el dígito de control
            }

            // Obtener el dígito de control real
            int digitoControl = Character.getNumericValue(codigoUsuario.charAt(codigoUsuario.length() - 1));

            // Verificar el dígito de control
            if (digitoControlCalculado == digitoControl) {
                if (ean8) {
                    System.out.println("SI");
                }

                if (ean13){
                    int[] numPaises = {0, 539, 759, 380, 560, 850, 50, 70, 890};
                    String[] nombrePaises = {"EEUU", "Irlanda", "Venezuela", "Bulgaria", "Portugal", "Cuba", "Inglaterra", "Noruega", "India"};
                    String otrosPaises = "Desconocido";

                    for (int i = 0; i < numPaises.length; i++) {    // Iterar a través del array de numPaises
                        int prefijoLongitud = String.valueOf(numPaises[i]).length();    // Obtener la longitud del numPaises actual convirtiéndolo a String y obteniendo su longitud
                        int prefijoPais = Integer.parseInt(codigoUsuario.substring(0, prefijoLongitud));    // Extraer el numPaises del código de barras desde el inicio hasta la longitud del prefijo y convertirlo a entero

                        if (numPaises[i] == prefijoPais) {  // Comparar el numPaises del array con el numPaises extraído del código de barras
                            otrosPaises = nombrePaises[i];  // Si coinciden, asignar el nombrePaises correspondiente
                            break;  // Salir del bucle una vez encontrado el nombrePaís correspondiente
                        }
                    }
                    System.out.println("SI " + otrosPaises);
                }

            } else {
                System.out.println("NO");   // Si no es un codigo de barras valido
            }
        }
    }
}
