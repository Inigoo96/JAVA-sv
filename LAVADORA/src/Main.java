public class Main {
    public static void main(String[] args) {
        // Crear las 3 lavadoras (2 diferentes, 2 iguales)
        LAVADORA siemens = new LAVADORA("frio", 8.0);    // Caracteristicas lavadora siemens
        LAVADORA balay = new LAVADORA("caliente", 10.0); // Caracteristicas lavadora balay
        LAVADORA bosch = new LAVADORA("frio", 8.0);      // Caracteristicas lavadora bosch

        // Encender las lavadoras
        siemens.encenderLavadora();
        balay.encenderLavadora();
        bosch.encenderLavadora();

        // Probar abrir las puertas
        System.out.println("Abriendo Siemens: " + siemens.abrirLavadora());
        System.out.println("Abriendo Balay: " + balay.abrirLavadora());
        System.out.println("Abriendo Bosch: " + bosch.abrirLavadora());

        // Cargar lavadoras 1 y 3
        System.out.println("Cargando Siemens con 6kg: " + siemens.introducirRopa(6.0));
        System.out.println("Cargando Bosch con 12kg: " + bosch.introducirRopa(12.0));

        // Cerrar puertas
        siemens.cerrarPuerta();
        balay.cerrarPuerta();
        bosch.cerrarPuerta();

        // Programar lavadoras 1 y 2
        if (siemens.getEstado().equalsIgnoreCase("encendida")) {
            System.out.println("\nProgramando Siemens:");
            siemens.definirPlanLavado("frio");
        } else {
            System.out.println("Error: Siemens no está encendida");
        }

        if (balay.getEstado().equalsIgnoreCase("encendida")) {
            System.out.println("\nProgramando Balay:");
            balay.definirPlanLavado("caliente");
        } else {
            System.out.println("Error: Balay no está encendida");
        }

        // Iniciar lavado 1 y 3
        System.out.println("Iniciando lavado Siemens: " + siemens.iniciarLavado());
        System.out.println("Iniciando lavado Bosch: " + bosch.iniciarLavado());

        // Intentar abrir lavadora 1 durante lavado
        System.out.println("Intentando abrir Siemens durante lavado: " + siemens.abrirLavadora());
    }
}