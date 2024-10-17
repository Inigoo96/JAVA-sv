//ÍÑIGO ANDRES LAYA
import java.util.Random;
import java.util.Scanner;

public class SimpsonsTest {

    public static void main(String[] args) {
        int[][] tablero = new int[10][10];
        Random aleatorio = new Random();
        Scanner lector = new Scanner(System.in);

        // Escribir tablero de casillas vacias [V]
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print("[_]");
            }
            System.out.println(" ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");

        // Bart en posición aleatoria del tablero
        int filaBart = aleatorio.nextInt(10);
        int columnaBart = aleatorio.nextInt(10);
        tablero[filaBart][columnaBart] = 1;

        // Escribir tablero con la posición de Bart
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("[B]"); // Bart
                } else {
                    System.out.print("[_]"); // Casilla vacía
                }
            }
            System.out.println(" ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");

        // Posicionar 10 Homers en posiciones aleatorias del tablero
        int homers = 0;
        while (homers < 10) {
            int filaHomer = aleatorio.nextInt(10);
            int columnaHomer = aleatorio.nextInt(10);
            if (tablero[filaHomer][columnaHomer] == 0) { // Asegurar que la posición esté vacía
                tablero[filaHomer][columnaHomer] = 2; // Representamos a Homer con el número 2
                homers++;
            }
        }

        // Posicionar 10 Muros en posiciones aleatorias del tablero
        int muros = 0;
        while (muros < 10) {
            int filaMuros = aleatorio.nextInt(10);
            int columnaMuros = aleatorio.nextInt(10);
            if (tablero[filaMuros][columnaMuros] == 0) { // Asegurar que la posición esté vacía
                tablero[filaMuros][columnaMuros] = 3; // Representamos a Muros con el número 3
                muros++;
            }
        }

        // Posicionar la meta en la posición [9][9]
        tablero[9][9] = 4; // Representamos la meta con el número 4

        // Escribir tablero con las posiciones de Bart, Homers, Muros y la Meta
                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero[i].length; j++) {
                        if (tablero[i][j] == 1) {
                            System.out.print("[B]"); // Bart
                        } else if (tablero[i][j] == 2) {
                            System.out.print("[H]"); // Homer
                        } else if (tablero[i][j] == 3) {
                            System.out.print("[M]"); // Muro
                        } else if (tablero[i][j] == 4) {
                            System.out.print("[F]"); // Meta
                        } else {
                            System.out.print("[_]"); // Casilla vacía
                        }
                    }
                    System.out.println(" ");
                }
        System.out.println("");
        System.out.println("");
        System.out.println("");

        // Mover a Bart con las teclas: a, w, s, d
        // a -----> izquierda
        // d -----> derecha
        // w -----> arriba
        // s -----> abajo
        int vidas = 3;

        System.out.println("Mueve a Bart(B) hasta la meta(F) con las teclas: a, w, s, d");
        System.out.println("Desplazate con Bart por las casillas vacias(_)");
        System.out.println("Los Homers(H) te quitan vidas!!! Asi que alejate de ellos!!! Tienes 3 vidas");
        System.out.println("Ten cuidado y no golpees Muros(M)!!!");

        do {
            System.out.println("Tu movimiento: ");
            String desplazamiento = lector.nextLine();
            System.out.println("Desplazamiento=" + desplazamiento);
            switch (desplazamiento) {
                case "a": // Izquierda
                    if ((columnaBart - 1) >= 0) {
                        int columnaAnterior = columnaBart;
                        columnaBart = columnaBart - 1;
                        switch (tablero[filaBart][columnaBart]) {
                            case 2: // Homer
                                vidas = vidas - 1;
                                System.out.println("Has perdido una vida " + "Te quedan: " + vidas + " vidas");
                                break;
                            case 3: // Muro
                                System.out.println("Has golpeado un muro!!!");
                                columnaBart = columnaAnterior; // Deshacer el movimiento
                                break;
                            case 4: // Meta
                                System.out.println("Enhorabuena has llegado a la meta!!!");
                                vidas = 0; // Termina el juego
                                break;
                        }
                        // Actualizar la casilla anterior de Bart a vacía
                        tablero[filaBart][columnaAnterior] = 0;
                        // Actualizar la nueva posición de Bart
                        tablero[filaBart][columnaBart] = 1;
                    } else {
                        System.out.println("Desplazamiento Prohibido. Limite de tablero");
                    }
                    break;

                case "d": // Derecha
                    if ((columnaBart + 1) < 10) {
                        int columnaAnterior = columnaBart;
                        columnaBart = columnaBart + 1;
                        switch (tablero[filaBart][columnaBart]) {
                            case 2: // Homer
                                vidas = vidas - 1;
                                System.out.println("Has perdido una vida " + "Te quedan: " + vidas + " vidas");
                                break;
                            case 3: // Muro
                                System.out.println("Has golpeado un muro!!!");
                                columnaBart = columnaAnterior; // Deshacer el movimiento
                                break;
                            case 4: // Meta
                                System.out.println("Enhorabuena has llegado a la meta!!!");
                                vidas = 0; // Termina el juego
                                break;
                        }
                        // Actualizar la casilla anterior de Bart a vacía
                        tablero[filaBart][columnaAnterior] = 0;
                        // Actualizar la nueva posición de Bart
                        tablero[filaBart][columnaBart] = 1;
                    } else {
                        System.out.println("Desplazamiento Prohibido. Limite de tablero");
                    }
                    break;

                case "w": // Arriba
                    if ((filaBart - 1) >= 0) {
                        int filaAnterior = filaBart;
                        filaBart = filaBart - 1;
                        switch (tablero[filaBart][columnaBart]) {
                            case 2: // Homer
                                vidas = vidas - 1;
                                System.out.println("Has perdido una vida " + "Te quedan: " + vidas + " vidas");
                                break;
                            case 3: // Muro
                                System.out.println("Has golpeado un muro!!!");
                                filaBart = filaAnterior; // Deshacer el movimiento
                                break;
                            case 4: // Meta
                                System.out.println("Enhorabuena has llegado a la meta!!!");
                                vidas = 0; // Termina el juego
                                break;
                        }
                        // Actualizar la casilla anterior de Bart a vacía
                        tablero[filaAnterior][columnaBart] = 0;
                        // Actualizar la nueva posición de Bart
                        tablero[filaBart][columnaBart] = 1;
                    } else {
                        System.out.println("Desplazamiento Prohibido. Limite de tablero");
                    }
                    break;

                case "s": // Abajo
                    if ((filaBart + 1) < 10) {
                        int filaAnterior = filaBart;
                        filaBart = filaBart + 1;
                        switch (tablero[filaBart][columnaBart]) {
                            case 2: // Homer
                                vidas = vidas - 1;
                                System.out.println("Has perdido una vida " + "Te quedan: " + vidas + " vidas");
                                break;
                            case 3: // Muro
                                System.out.println("Has golpeado un muro!!!");
                                filaBart = filaAnterior; // Deshacer el movimiento
                                break;
                            case 4: // Meta
                                System.out.println("Enhorabuena has llegado a la meta!!!");
                                vidas = 0; // Termina el juego
                                break;
                        }
                        // Actualizar la casilla anterior de Bart a vacía
                        tablero[filaAnterior][columnaBart] = 0;
                        // Actualizar la nueva posición de Bart
                        tablero[filaBart][columnaBart] = 1;
                    } else {
                        System.out.println("Desplazamiento Prohibido. Limite de tablero");
                    }
                    break;

                default:
                    System.out.println("Movimiento no válido. Usa a, w, s, d para moverte.");
                    break;
            }

            // Imprimir tablero actualizado
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    if (tablero[i][j] == 1) {
                        System.out.print("[B]"); // Bart
                    } else if (tablero[i][j] == 2) {
                        System.out.print("[H]"); // Homer
                    } else if (tablero[i][j] == 3) {
                        System.out.print("[M]"); // Muro
                    }else if (tablero[i][j] == 4) {
                        System.out.print("[F]"); // Meta
                    } else {
                        System.out.print("[_]"); // Casilla vacía
                    }
                }
                System.out.println(" ");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
        } while (vidas > 0);
    }
}
