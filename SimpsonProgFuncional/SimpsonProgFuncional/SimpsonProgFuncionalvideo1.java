import java.util.Random;

public class SimpsonProgFuncional {

    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static char[][] tablero;

    public static void main(String[] args) {
        // 1º) Inicializamos el tablero
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

        // 2º) Rellenamos el tablero de 'L' casillas vacias
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_FILA_TABLERO; j++) {
                //[0,0][0,1][0,2], etc.
                tablero[i][j] = 'L';
            }
        }
        // 3º) Imprimir tablero
        imprimirTablero();

        // 4º)Asignar a Bart
        Random aleatorio = new Random();
        int filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);//0-9
        int columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);//0-9

        tablero[filaAleatorio][columnaAleatorio] = 'B';

        // 5º) Imprimir tablero
        imprimirTablero();

        // 6º) Repartir 10 Homers en el tablero
        int filaAleatorioHomer;
        int columnaAleatorioHomer;
        for (int i = 0; i <10 ; i++) {
            do {
                filaAleatorioHomer = aleatorio.nextInt(MAX_FILA_TABLERO);//0-9
                columnaAleatorioHomer = aleatorio.nextInt(MAX_COLUMNA_TABLERO);//0-9
            }while (tablero[filaAleatorioHomer][columnaAleatorioHomer] != 'L');
            //Cuando tablero[filaAleatorioHomer][columnaAleatorioHomer] != 'L'
            tablero[filaAleatorioHomer][columnaAleatorioHomer] = 'H';
        }

        // 7º) Imprimir tablero
        imprimirTablero();

        // 8º) Poner Muros
        int filaAleatorioMuro;
        int columnaAleatorioMuro;
        for (int i = 0; i <10 ; i++) {
            do {
                filaAleatorioMuro = aleatorio.nextInt(MAX_FILA_TABLERO);//0-9
                columnaAleatorioMuro = aleatorio.nextInt(MAX_COLUMNA_TABLERO);//0-9
            }while (tablero[filaAleatorioMuro][columnaAleatorioMuro] != 'L');
            //Cuando tablero[filaAleatorioMuro][columnaAleatorioMuro] != 'L'
            tablero[filaAleatorioMuro][columnaAleatorioMuro] = 'M';
        }
        // 9º) Imprimir tablero
        imprimirTablero();

        // 10º) Casilla Final(Meta)
        tablero[MAX_FILA_TABLERO-1][MAX_COLUMNA_TABLERO-1] = 'F';

        //11º) Imprimir tablero
        imprimirTablero();
    }

    private static void imprimirTablero(){
        // 8º) Imprimir tablero
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_FILA_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

}