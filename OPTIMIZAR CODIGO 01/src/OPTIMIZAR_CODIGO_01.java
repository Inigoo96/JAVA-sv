import java.util.Scanner;

public class OPTIMIZAR_CODIGO_01 {

    public static void main(String[] args) {
        //Definimos el arrays del 1 al 26
        //Como ya tenemos nombre creados no hace falta que creemos un arrays
        //Usamos el String[]
        String[] nombresPersonajes = {
                "IRON", // posicion arryas 0
                "BED",
                "BED_CLOCK",
                "CACTUS",
                "BRICK_STAIRS",
                "BIRCH_WOOD_STAIRS",
                "BREWING_STAND",
                "CAKE",
                "CAKE_BLOCK",
                "CAULDRON",
                "CHEST",
                "CLAY",
                "SAND",
                "BURNING_FURNACE",
                "COBBLESTONE_STAIRS",
                "FENCE",
                "FENCE_GATE",
                "FIRE",
                "GRAVEL",
                "IRON_DOOR_BLOCK",
                "IRON_FENCE",
                "IRON_DOOR",
                "LADDER",
                "MELON",
                "LEAVES",
                "LOCKED_CHEST",
                "SANDSTONE_STAIRS"  // posicion arrays 26
        };

        Scanner leer = new Scanner(System.in);
        int numusuario;

        do {
            //Leemos respuesta usuario
            System.out.print("Escribe un número del 0 al 26: ");
            numusuario = leer.nextInt();

            if (numusuario >= 0 && numusuario <= 26) {
                System.out.println("El nombre es: " + nombresPersonajes[numusuario]);
            } else {
                System.out.println("Inténtalo de nuevo");
            }
        } while (numusuario < 0 || numusuario > 26); // Seguir repitiendo hasta que el numero este dentro del arrays
    }
}

