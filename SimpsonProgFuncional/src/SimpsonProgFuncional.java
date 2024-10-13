import java.util.Random;
import java.util.Scanner;

public class SimpsonProgFuncional {

    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static char[][] tablero;
    private static int filaBart;
    private static int columnaBart;


    private static void imprimirTablero(){
        // Imprimir tablero(GENERAL)
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
    private static void asignarLibreACasilla(char caracter){
        // 2º) Rellenamos el tablero de 'L' casillas vacias
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_FILA_TABLERO; j++) {
                //[0,0][0,1][0,2], etc.
                tablero[i][j] = caracter;
            }
        }
    }
    private static void asignarPersonajesACasillasLibres(char caracter, int numRepetciones) {
        // 4º)Asignar a Bart
        Random aleatorio = new Random();
        int filaAleatorio = -1;
        int columnaAleatorio = -1;
        for (int i = 0; i < numRepetciones; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);//0-9
                columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);//0-9
            } while (tablero[filaAleatorio][columnaAleatorio] != 'L');
            tablero[filaAleatorio][columnaAleatorio] = caracter;
        }
        if (caracter=='B'){
            filaBart = filaAleatorio;
            columnaBart = columnaAleatorio;
        }


    }
//    private static void asignarCaracterACasillasLibres(char caracter){
//        Random aleatorio = new Random();
//        // 6º) Repartir 10 Homers en el tablero
//        int filaAleatorioHomer;
//        int columnaAleatorioHomer;
//        for (int i = 0; i <10 ; i++) {
//            do {
//                filaAleatorioHomer = aleatorio.nextInt(MAX_FILA_TABLERO);//0-9
//                columnaAleatorioHomer = aleatorio.nextInt(MAX_COLUMNA_TABLERO);//0-9
//            }while (tablero[filaAleatorioHomer][columnaAleatorioHomer] != 'L');
//            //Cuando tablero[filaAleatorioHomer][columnaAleatorioHomer] != 'L'
//            tablero[filaAleatorioHomer][columnaAleatorioHomer] = caracter;
//        }
//    }

    public static void main(String[] args) {
        // 1º) Inicializamos el tablero
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
        asignarLibreACasilla('L');
        // 3º) Imprimir tablero
        imprimirTablero();

        asignarPersonajesACasillasLibres('B',1);
        // 5º) Imprimir tablero
        imprimirTablero();

        asignarPersonajesACasillasLibres('H',10);
        // 7º) Imprimir tablero
        imprimirTablero();

        asignarPersonajesACasillasLibres('M',10);
        // 9º) Imprimir tablero
        imprimirTablero();

        // 10º) Casilla Final(Meta)
        tablero[MAX_FILA_TABLERO-1][MAX_COLUMNA_TABLERO-1] = 'F';
        //11º) Imprimir tablero
        imprimirTablero();

        //Desplazamiento de Bart
        //a--->Izquierda
        //d--->Derecha
        //w--->Arriba
        //s--->Abajo
        Scanner lector = new Scanner(System.in);

        //*******************************************************************************
        //JUGAR
        //*******************************************************************************
        int vidas = 3;
        System.out.println("Mueve a Bart: ");
        System.out.println("Desplazamiento de Bart:\n" +
                "        a--->Izquierda\n" +
                "        d--->Derecha\n" +
                "        w--->Arriba\n" +
                "        s--->Abajo");

        do{
            String desplazamiento = lector.nextLine();
            System.out.println("Desplazamiento=" + desplazamiento);
            switch(desplazamiento){
                case "a"://Izquierda
                    if((columnaBart -1) >=0){
                        columnaBart = columnaBart -1;
                        switch(tablero[filaBart][columnaBart]){
                            case 'H':
                                vidas = vidas -1;
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart +1] = 'L';
                                System.out.println("Has perdido una vida " + "Te quedan: " +vidas + " vidas");
                                break;
                            case 'M':
                                System.out.println("Has golpeado un muro!!!");
                                columnaBart = columnaBart +1;
                                break;
                        }
                        tablero[filaBart][columnaBart] = 'B';
                        tablero[filaBart][columnaBart +1] = 'L';
                    }else{
                        System.out.println("Desplazamiento Prohibido. Limite de tablero");
                    }
                    break;

                case "d"://Derecha
                    if((columnaBart +1) <=10){
                        columnaBart = columnaBart +1;
                        switch(tablero[filaBart][columnaBart]){
                            case 'H':
                                vidas = vidas -1;
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart -1] = 'L';
                                System.out.println("Has perdido una vida " + "Te quedan: " +vidas + " vidas");
                                break;
                            case 'M':
                                System.out.println("Has golpeado un muro!!!");
                                columnaBart = columnaBart -1;
                                break;
                            case 'F':
                                System.out.println("Enhorabuena has llegado a la meta!!!");
                        }
                        tablero[filaBart][columnaBart] = 'B';
                        tablero[filaBart][columnaBart -1] = 'L';
                    }else{
                        System.out.println("Desplazamiento Prohibido. Limite de tablero");
                    }
                    break;

                case "w"://Arriba
                    if((filaBart -1) >=0){
                        filaBart = filaBart -1;
                        switch(tablero[filaBart][columnaBart]){
                            case 'H':
                                vidas = vidas -1;
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart +1][columnaBart] = 'L';
                                System.out.println("Has perdido una vida " + "Te quedan: " +vidas + " vidas");
                                break;
                            case 'M':
                                System.out.println("Has golpeado un muro!!!");
                                filaBart = filaBart +1;
                                break;
                        }
                        tablero[filaBart][columnaBart] = 'B';
                        tablero[filaBart +1][columnaBart] = 'L';
                    }else{
                        System.out.println("Desplazamiento Prohibido. Limite de tablero");
                    }
                    break;

                case "s"://Abajo
                    if((filaBart +1) <=10){
                        filaBart = filaBart +1;
                        switch(tablero[filaBart][columnaBart]){
                            case 'H':
                                vidas = vidas -1;
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart -1][columnaBart] = 'L';
                                System.out.println("Has perdido una vida " + "Te quedan: " +vidas + " vidas");
                                break;
                            case 'M':
                                System.out.println("Has golpeado un muro!!!");
                                filaBart = filaBart -1;
                                break;
                            case 'F':
                                System.out.println("Enhorabuena has llegado a la meta!!!");
                        }
                        tablero[filaBart][columnaBart] = 'B';
                        tablero[filaBart -1][columnaBart] = 'L';
                    }else{
                        System.out.println("Desplazamiento Prohibido. Limite de tablero");
                    }
                    break;
                default:
                    break;
            }
            imprimirTablero();
        }while(vidas>0);
    }
}