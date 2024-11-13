import java.util.Random;
import java.util.Scanner;

public class Main {

    char[][] tableroYoda = new char[10][10];
    char[][] tableroVader = new char[10][10];
    int vidasYoda = 3, vidasVader = 3;
    int posYodaX, posYodaY, posVaderX, posVaderY;
    boolean yodaTienePocima = false, vaderTienePocima = false;

    public static void main(String[] args) {
        Main juego = new Main();
        juego.iniciarTableros();
        juego.jugar();
    }

    // Inicializar y configurar tableros
    private void iniciarTableros() {
        inicializarTablero(tableroYoda);
        inicializarTablero(tableroVader);

        colocarElementoAleatorio(tableroYoda, 'Y', 1);
        colocarElementoAleatorio(tableroVader, 'V', 1);

        colocarElementoAleatorio(tableroYoda, 'D', 5);
        colocarElementoAleatorio(tableroVader, 'R', 5);

        colocarElementoAleatorio(tableroYoda, 'M', 5);
        colocarElementoAleatorio(tableroVader, 'M', 5);

        colocarElementoAleatorio(tableroYoda, 'P', 5);
        colocarElementoAleatorio(tableroVader, 'P', 5);

        tableroYoda[9][9] = 'F';
        tableroVader[9][9] = 'F';

        imprimirTablero(tableroYoda);
        imprimirTablero(tableroVader);
    }

    private void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = 'L';
            }
        }
    }

    // Coloca elementos en posiciones aleatorias del tablero
    private void colocarElementoAleatorio(char[][] tablero, char elemento, int cantidad) {
        Random random = new Random();
        int placed = 0;
        while (placed < cantidad) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            if (tablero[x][y] == 'L') {
                tablero[x][y] = elemento;
                if (elemento == 'Y') { posYodaX = x; posYodaY = y; }
                if (elemento == 'V') { posVaderX = x; posVaderY = y; }
                placed++;
            }
        }
    }

    // Imprimir el tablero en pantalla
    private void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Bucle principal del juego
    private void jugar() {
        boolean juegoActivo = true;

        while (juegoActivo) {
            System.out.println("Turno de Yoda:");
            juegoActivo = moverJugador(tableroYoda, 'Y');
            if (!juegoActivo) break;

            System.out.println("Turno de Darth Vader:");
            juegoActivo = moverJugador(tableroVader, 'V');
            if (!juegoActivo) break;

            imprimirTablero(tableroYoda);
            imprimirTablero(tableroVader);
        }
    }

    // Movimiento de jugadores
    private boolean moverJugador(char[][] tablero, char jugador) {
        Scanner scanner = new Scanner(System.in);
        int x = (jugador == 'Y') ? posYodaX : posVaderX;
        int y = (jugador == 'Y') ? posYodaY : posVaderY;

        // Verificar si el jugador tiene una pócima
        if ((jugador == 'Y' && yodaTienePocima) || (jugador == 'V' && vaderTienePocima)) {
            System.out.println("Has recogido una pócima. Ingresa las coordenadas de la casilla a la que deseas teletransportarte.");
            while (true) {
                System.out.print("Ingresa la coordenada X (0-9): ");
                int nuevaX = scanner.nextInt();
                System.out.print("Ingresa la coordenada Y (0-9): ");
                int nuevaY = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                if (tablero[nuevaX][nuevaY] == 'L') { // Verificar si la casilla está libre
                    actualizarPosicion(tablero, jugador, nuevaX, nuevaY);
                    if (jugador == 'Y') yodaTienePocima = false;
                    else vaderTienePocima = false;
                    return true;
                } else {
                    System.out.println("La casilla no está libre. Intenta con otras coordenadas.");
                }
            }
        }

        // Movimiento normal
        System.out.print("Ingrese el movimiento (a,s,d,w,q,e,z,c): ");
        String movimiento = scanner.nextLine();

        switch (movimiento) {
            case "d": y += 1; break; // Derecha
            case "a": y -= 1; break; // Izquierda
            case "w": x -= 1; break; // Arriba
            case "s": x += 1; break; // Abajo
            case "q": x -= 1; y -= 1; break; // Diagonal arriba-izquierda
            case "e": x -= 1; y += 1; break; // Diagonal arriba-derecha
            case "z": x += 1; y -= 1; break; // Diagonal abajo-izquierda
            case "c": x += 1; y += 1; break; // Diagonal abajo-derecha
            default:
                System.out.println("Movimiento inválido.");
                return true;
        }

        x = (x + 10) % 10;
        y = (y + 10) % 10;

        return verificarMovimiento(tablero, jugador, x, y);
    }

    // Verificar el movimiento del jugador
    private boolean verificarMovimiento(char[][] tablero, char jugador, int x, int y) {
        if (tablero[x][y] == 'M') {
            System.out.println("Movimiento bloqueado por un muro.");
            return true;
        }

        if (tablero[x][y] == 'D' && jugador == 'Y') {
            vidasYoda--;
            System.out.println("Yoda pierde una vida. Vidas restantes: " + vidasYoda);
            if (vidasYoda == 0) {
                System.out.println("Yoda ha perdido todas las vidas. Darth Vader gana.");
                return false;
            }
        } else if (tablero[x][y] == 'R' && jugador == 'V') {
            vidasVader--;
            System.out.println("Vader pierde una vida. Vidas restantes: " + vidasVader);
            if (vidasVader == 0) {
                System.out.println("Vader ha perdido todas las vidas. Yoda gana.");
                return false;
            }
        }

        if (tablero[x][y] == 'P') {
            System.out.println("¡Pócima encontrada! Puedes teletransportarte en el próximo turno.");
            if (jugador == 'Y') yodaTienePocima = true;
            else vaderTienePocima = true;
        }

        if (tablero[x][y] == 'F') {
            System.out.println((jugador == 'Y' ? "Yoda" : "Vader") + " ha llegado a la casilla final. ¡Gana el juego!");
            return false;
        }

        actualizarPosicion(tablero, jugador, x, y);
        return true;
    }

    // Actualizar posición del jugador en el tablero
    private void actualizarPosicion(char[][] tablero, char jugador, int x, int y) {
        if (jugador == 'Y') {
            tablero[posYodaX][posYodaY] = 'L';
            posYodaX = x;
            posYodaY = y;
            tablero[x][y] = 'Y';
        } else {
            tablero[posVaderX][posVaderY] = 'L';
            posVaderX = x;
            posVaderY = y;
            tablero[x][y] = 'V';
        }
    }
}
