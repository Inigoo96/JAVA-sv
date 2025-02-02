//IMPORTS
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    //LISTA DE PRENDAS
    private static List<PRENDA> prendas = new ArrayList<>();
    public static void reintegrarPrendas(List<PRENDA> prendasLimpias) {
        prendas.addAll(prendasLimpias);
        System.out.println("Las prendas lavadas han sido devueltas a la lista general.");
    }

    public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);  //Para leer la entrada del usuario

    //LISTA DE LAVADORAS
    List<LAVADORA> lavadoras = new ArrayList<>();

    //CREAMOS 3 LAVADORAS
    lavadoras.add(new LAVADORA(6.0, "Caliente"));
    lavadoras.add(new LAVADORA(8.0, "Frío"));
    lavadoras.add(new LAVADORA(10.0, "Eco"));
    System.out.println("3 lavadoras diferentes creadas");

    //CREAMOS 10 PRENDAS
        prendas.add(new PRENDA("pantalón", "azul marino", 0.4, 70));
        prendas.add(new PRENDA("camiseta", "blanca", 0.2, 50));
        prendas.add(new PRENDA("sudadera", "negra", 0.6, 80));
        prendas.add(new PRENDA("chaqueta", "gris", 1.0, 60));
        prendas.add(new PRENDA("calcetines", "rojos", 0.1, 90));
        prendas.add(new PRENDA("bufanda", "verde oscuro", 0.3, 75));
        prendas.add(new PRENDA("vaqueros", "celeste", 0.8, 65));
        prendas.add(new PRENDA("falda", "rosa", 0.3, 55));
        prendas.add(new PRENDA("guantes", "marrón", 0.2, 85));
        prendas.add(new PRENDA("jersey", "beige", 0.7, 40));

        System.out.println("10 prendas diferentes creadas.");

     //MENÚ LAVADORA
     while (true) {
         System.out.println("\nMENÚ LAVADORA:");
         System.out.println("Añadir nueva prenda (1)");
         System.out.println("Cambiar nivel suciedad (2)");
         System.out.println("Introducir prenda en la lavadora (3)");
         System.out.println("Iniciar lavado (4)");
         System.out.println("Ver las prendas que hay dentro (5)");
         System.out.println("Salir (6)");

         System.out.println("Selecciona una opcion del menú:");

         // Verificamos si el usuario ingresó un número
         if (!leer.hasNextInt()) {
             System.out.println("Debes introducir un número válido.");
             leer.next();  // Limpiar la entrada incorrecta
             continue;  // Volver a mostrar el menú
         }

         int opcion = leer.nextInt();

         //VARIABLE REUTILIZABLES
         String tipo = "";   //Reutilizamos variable en el case 1 y 4
         String color = "";   //Reutilizamos variable en el case 1 y 4
         double peso = 0.0;    //Reutilizamos variable en el case 1 y 4
         PRENDA nuevaPrenda = null;    //Reutilizamos variable en el case 1 y 4
         int nivelSuciedad = 0;
         LAVADORA lavadoraSeleccionada = null; //Reutilizamos la variable en el case 3 y 4
         int indiceListaPrenda = -1; //Reutilizamos variable en el case 2 y 3
         int indiceListaLavadora = -1;   //Reutilizamos variable en el case 3 y 4

         //AJUSTAMOS LAS OPCIONES DEL MENU
         switch (opcion) {
             case 1:    //AÑADIR NUEVA PRENDA
                 System.out.println("Introduce el tipo de prenda:");
                 tipo = leer.nextLine(); //Leemos el tipo de prenda

                 System.out.println("Introduce el color de la prenda:");
                 color = leer.nextLine();    //Leemos el color de la prenda

                 do {
                     System.out.println("Introduce el peso(Kg) de la prenda:");

                     if (!leer.hasNextDouble()) {  // Verificamos si lo ingresado es un número válido
                         System.out.println("Debes introducir un número válido.");
                         leer.next();  // Limpiamos la entrada incorrecta
                         continue;  // Volvemos a pedir la entrada
                     }

                      peso = leer.nextDouble();  //Leemos el peso de la prenda

                     if (peso <= 0 || peso > 1) {
                         System.out.println("El peso debe ser mayor que 0 y menor que 1, introduce el peso de nuevo");
                     }

                 } while (peso <= 0 || peso > 1);   //Si el usuario introduce un peso valido, le pedimos que ingrese de nuevo un peso nuevo valido

                 do {
                     System.out.println("Introduce el nivel de suciedad de la prenda (0-100):");

                     if (!leer.hasNextInt()) {  // Verificamos si lo ingresado es un número entero
                         System.out.println("Debes introducir un número entero válido.");
                         leer.next();  // Limpiamos la entrada incorrecta
                         continue;  // Volvemos a pedir la entrada
                     }

                     nivelSuciedad = leer.nextInt();    //Leemos el nivel de suciedad de la prenda

                     if (nivelSuciedad <= 0 || nivelSuciedad > 100) {
                         System.out.println("El nivel de suciedad debe ser mayor que 0 y menor o igual que 100. Intenta de nuevo");
                     }
                 } while(nivelSuciedad <= 0 || nivelSuciedad > 100);

                 //Si todos los valores se han introducido correctamente, añadimos la prenda a la lista
                 nuevaPrenda = new PRENDA(tipo, color, peso, nivelSuciedad);
                 prendas.add(nuevaPrenda);  //Añadimos la prenda que acabamos de crear al array list de prendas

                 System.out.println("Has añadido una nueva prenda: " + nuevaPrenda);
                 break;

             case 2:    //MOD. NIVEL DE SUCIEDAD DE UNA PRENDA
                 //Si la lista de prendas esta vacia
                 if (prendas.isEmpty()) {
                     System.out.println("No hay prendas disponibles para modificar, agrega nuevas prendas antes de intentarlo");
                     break;
                 }

                 //mostramos la lista de prendas para que el usuario vea mejor cual quiere modificar
                 System.out.println("\nLISTA DE PRENDAS:");
                 for (int i = 0; i < prendas.size(); i++) {
                     System.out.println((i +1) + ") " + prendas.get(i));
                 }
                 System.out.println("-------------------------------------");

                 //Ahora leemos la prenda seleccionada del indice;
                 do {
                     System.out.println("Selecciona el numero de la prenda que quieres modificar su nivel de suciedad:");

                     if (!leer.hasNextInt()) {  // Verificamos si lo ingresado es un número
                         System.out.println("Error: Debes introducir un número válido.");
                         leer.next();  // Limpiamos la entrada incorrecta
                         continue;  // Volvemos a pedir la entrada
                     }

                     indiceListaPrenda = leer.nextInt() -1;

                     if (indiceListaPrenda < 0 || indiceListaPrenda >= prendas.size()) {
                         System.out.println("Seleccione un numero de la lista valido");
                     }

                 }while(indiceListaPrenda < 0 || indiceListaPrenda >= prendas.size());

                 //Pedimos que introduzca que nuevo nivel de suciedad quiere que tenga la prenda seleccionada
                 int nuevoNivelSuciedad = 0;
                 do {
                     System.out.println("Introduce el nuevo nivel de suciedad que tendrá la prenda (0-100):");

                     if (!leer.hasNextInt()) {
                         System.out.println("Error: Debes introducir un número válido.");
                         leer.next();  // Limpiamos la entrada incorrecta
                         continue;
                     }

                     nuevoNivelSuciedad = leer.nextInt();

                     if (nuevoNivelSuciedad < 0 || nuevoNivelSuciedad > 100) {
                         System.out.println("El nivel de suciedad debe de estar entre 0-100");
                     }

                 } while(nuevoNivelSuciedad < 0 || nuevoNivelSuciedad > 100);

                 //Le cambiamos el nivel de suciedad segun ha indicado el usuario
                 prendas.get(indiceListaPrenda).setNivelSuciedad(nuevoNivelSuciedad);
                 System.out.println("Nuevo nivel de suciedad actualizado correctamente: " + prendas.get(indiceListaPrenda));
                 break;

             case 3:    //METEMOS UNA PRENDA EN UNA DE LAS 3 LAVADORAS
                 //Si la lista de prendas esta vacia
                 if (prendas.isEmpty()) {
                     System.out.println("No hay prendas disponibles en la lista para meter en la lavadora");
                     System.out.println("Añade nuevas prendas desde la opción (1) del menú.");
                     break;
                 }

                 //Mostramos las lavadoras que hay en la lista
                 System.out.println("\nLISTA DE LAVADORAS:");
                 for (int i = 0; i < lavadoras.size(); i++) {
                     System.out.println((i +1) + ") " + lavadoras.get(i));
                 }

                 //Pedimos el numero de la lavadora y validamos si es correcto el numero introducido
                 do {
                     System.out.println("Introdcue el nuemro de la laavdora en la cual se desea introducir la prenda:");

                     if (!leer.hasNextInt()) {  // Verificamos si la entrada es un número válido
                         System.out.println("Error: Debes introducir un número válido.");
                         leer.next();  // Limpiamos la entrada incorrecta
                         continue;  // Volvemos a pedir el dato
                     }

                     indiceListaLavadora = leer.nextInt() -1;

                     if (indiceListaLavadora < 0 || indiceListaLavadora >= lavadoras.size()) {
                         System.out.println("Seleccione un numero de la lista valido");
                     }

                 } while(indiceListaLavadora < 0 || indiceListaLavadora >= lavadoras.size());

                 //mostramos la lista de prendas para que el usuario vea mejor cual quiere introducir
                 System.out.println("\nLISTA DE PRENDAS:");
                 for (int i = 0; i < prendas.size(); i++) {
                     System.out.println((i +1) + ") " + prendas.get(i));
                 }
                 System.out.println("-------------------------------------");

                 do {
                     System.out.print("Selecciona el número de la prenda para añadir: ");

                     if (!leer.hasNextInt()) {  // Verificamos si la entrada es un número válido
                         System.out.println("Error: Debes introducir un número válido.");
                         leer.next();  // Limpiamos la entrada incorrecta
                         continue;  // Volvemos a pedir la entrada
                     }

                     indiceListaPrenda = leer.nextInt() - 1;

                     if (indiceListaPrenda < 0 || indiceListaPrenda >= prendas.size()) {
                         System.out.println("Número inválido. Introduce un número entre 1 y " + prendas.size());
                     }

                 } while (indiceListaPrenda < 0 || indiceListaPrenda >= prendas.size());

                 // Obtener la prenda seleccionada
                 PRENDA prendaSeleccionada = prendas.get(indiceListaPrenda);

                 // Introducir prenda en la lavadora seleccionada
                 lavadoras.get(indiceListaLavadora).introducirPrenda(prendaSeleccionada);

                 // Quitar la prenda de la lista general de prendas
                 prendas.remove(prendaSeleccionada);

                 System.out.println("Prenda introducida en la lavadora.");
                 break;

             case 4:    //INICIAR LAVADO
                 // Si no hay lavadoras disponibles, no se puede hacer nada
                 if (lavadoras.isEmpty()) {
                     System.out.println("No hay lavadoras disponibles. Agrega una nueva lavadora antes de iniciar el lavado");
                     break;
                 }

                 //Mostramos las lavadoras que hay en la lista
                 System.out.println("\nLISTA DE LAVADORAS:");
                 for (int i = 0; i < lavadoras.size(); i++) {
                     System.out.println((i +1) + ") " + lavadoras.get(i));
                 }
                 System.out.println("---------------------------------------");

                 //Pedimos el numero de la lavadora y validamos si es correcto el numero introducido
                 do {
                     System.out.println("Introdcue el nuemro de la laavdora en la cual se desea iniciar el lavado:");

                     if (!leer.hasNextInt()) {  // Verificamos si la entrada es un número válido
                         System.out.println("Debes introducir un número válido.");
                         leer.next();  // Limpiamos la entrada incorrecta
                         continue;  // Volvemos a pedir la entrada
                     }

                     indiceListaLavadora = leer.nextInt() -1;

                     if (indiceListaLavadora < 0 || indiceListaLavadora >= lavadoras.size()) {
                         System.out.println("Seleccione un numero de la lista valido");
                     }

                 } while(indiceListaLavadora < 0 || indiceListaLavadora >= lavadoras.size());

                 lavadoraSeleccionada = lavadoras.get(indiceListaLavadora);    //Seleccionamos la lavadora seleccionada

                 //Verificamos si hay prendas dentro y preguntamos si quiere añadir una prenda
                 if (lavadoraSeleccionada.getPrendas().isEmpty()) {
                     System.out.println("No hay prendas dentro de la lavadora, queires añadir alguna? (si/no):");
                     leer.nextLine();  // Consumir cualquier salto de línea pendiente
                     String eleccion = leer.next().toLowerCase();

                     while (!eleccion.equalsIgnoreCase("si") && !eleccion.equalsIgnoreCase("no")) {
                         System.out.println("Respuesta no valida, quieres añadir alguna prenda? (si/no):");
                         eleccion = leer.nextLine().toLowerCase();
                     }

                     if (eleccion.equalsIgnoreCase("si")) {
                         do {
                             if (prendas.isEmpty()) {
                                 System.out.println("Desea introducir una prenda manualmente? (si/no):");
                                 eleccion = leer.next().toLowerCase();

                                 while (!eleccion.equalsIgnoreCase("si") && !eleccion.equalsIgnoreCase("no")) {
                                     System.out.println("Respuesta invalida, desea introducir una prenda manualmente? (si/no):");
                                     eleccion = leer.next().toLowerCase();
                                 }

                                 if (eleccion.equalsIgnoreCase("si")) {
                                     System.out.println("Introduce el tipo de prenda:");
                                     tipo = leer.next(); //Leemos el tipo de prenda

                                     System.out.println("Introduce el color de la prenda:");
                                     color = leer.next();    //Leemos el color de la prenda

                                     do {
                                         System.out.println("Introduce el peso(Kg) de la prenda:");
                                         peso = leer.nextDouble();  //Leemos el peso de la prenda

                                         if (peso <= 0 || peso > 1) {
                                             System.out.println("El peso debe ser mayor que 0 y menor que 1, introduce el peso de nuevo");
                                         }
                                     } while (peso <= 0 || peso > 1);   //Si el usuario introduce un peso valido, le pedimos que ingrese de nuevo un peso nuevo valido

                                     do {
                                         System.out.println("Introduce el nivel de suciedad de la prenda (0-100):");
                                         nivelSuciedad = leer.nextInt();    //Leemos el nivel de suciedad de la prenda

                                         if (nivelSuciedad <= 0 || nivelSuciedad > 100) {
                                             System.out.println("El nivel de suciedad debe ser mayor que 0 y menor o igual que 100. Intenta de nuevo");
                                         }
                                     } while (nivelSuciedad <= 0 || nivelSuciedad > 100);

                                     //Si todos los valores se han introducido correctamente, añadimos la prenda a la lista
                                     nuevaPrenda = new PRENDA(tipo, color, peso, nivelSuciedad);
                                     prendas.add(nuevaPrenda);  //Añadimos la prenda que acabamos de crear al array list de prendas

                                     System.out.println("Has añadido una nueva prenda: " + nuevaPrenda);
                                 } else if (eleccion.equalsIgnoreCase("no")) {
                                     System.out.println("Lavado cancelado, la lavadora esta vacia");
                                 }

                             } else {
                                 //mostramos la lista de prendas para que el usuario vea cual quiere introducir
                                 System.out.println("\nLISTA DE PRENDAS:");
                                 for (int i = 0; i < prendas.size(); i++) {
                                     System.out.println((i + 1) + ") " + prendas.get(i));
                                 }

                                 //Ahora leemos la prenda seleccionada del indice;
                                 do {
                                     System.out.println("Selecciona el número de la prenda para añadir:");

                                     if (!leer.hasNextInt()) {
                                         System.out.println("Error: Debes introducir un número válido.");
                                         leer.next();
                                         continue;
                                     }

                                     indiceListaPrenda = leer.nextInt() - 1;

                                     if (indiceListaPrenda < 0 || indiceListaPrenda >= prendas.size()) {
                                         System.out.println("Seleccione un numero de la lista valido");
                                     }

                                 } while (indiceListaPrenda < 0 || indiceListaPrenda >= prendas.size());

                                 lavadoraSeleccionada.introducirPrenda(prendas.get(indiceListaPrenda)); //Introducimos la prenda dentro de la lavadora
                                 prendas.remove(indiceListaPrenda); //Eliminamos la prenda de la lista de prendas
                             }

                                // Preguntar si quiere añadir otra prenda
                                if (lavadoraSeleccionada.calcularPesoTotal() < lavadoraSeleccionada.getCapacidad()) {
                                    System.out.println("¿Quieres añadir otra prenda? (si/no):");
                                    leer.nextLine(); // Limpiar buffer
                                    eleccion = leer.nextLine().toLowerCase();
                                    while (!eleccion.equalsIgnoreCase("si") && !eleccion.equalsIgnoreCase("no")) {
                                        System.out.println("Respuesta no válida, ¿quieres añadir otra prenda? (si/no):");
                                        eleccion = leer.nextLine().toLowerCase();
                                    }
                                } else {
                                    System.out.println("La lavadora ha alcanzado su capacidad máxima.");
                                    break;
                                }
                            } while (eleccion.equalsIgnoreCase("si"));

                         // Si la lavadora sigue vacía después de todo cancelamos el lavado
                         if (lavadoraSeleccionada.getPrendas().isEmpty()) {
                             System.out.println("Lavado cancelado. La lavadora sigue vacía.");
                             return;
                         }

                     } else if (eleccion.equalsIgnoreCase("no")) {
                         System.out.println("Lavado cancelado, no hay prendas dentro de la lavadora");
                         break;
                     }
                 }

                 //Verifiacmos si la lavadora esta apagada y si la queire encender
                 if (!lavadoraSeleccionada.getEncendida()) {
                     System.out.println("La lavadora esta apagada, la queires encender? (si/no);");
                     leer.nextLine();  // Limpiar buffer si hay datos previos
                     String eleccion = leer.nextLine().toLowerCase();

                     while(!eleccion.equalsIgnoreCase("si") && !eleccion.equalsIgnoreCase("no")) {
                         System.out.println("Respuesta no valida, quieres encenderla) (si/no):");
                         eleccion = leer.nextLine().toLowerCase();
                     }

                     if (eleccion.equalsIgnoreCase("si")) {
                         lavadoraSeleccionada.encenderLavadora();
                     } else if (eleccion.equalsIgnoreCase("no")) {
                         System.out.println("Lavado cancelado, lavadora no encendida");
                         break;
                     }
                 }

                 //Verificamos si la puerta esta abierta y preguntar si la desea cerrar
                 if (lavadoraSeleccionada.getPuertaAbierta()) {
                     System.out.println("La puerta esta abierta, la quieres cerrar? (si/no):");
                     leer.nextLine();  // Limpiar buffer si hay datos previos
                     String eleccion = leer.nextLine().toLowerCase();

                     while(!eleccion.equalsIgnoreCase("si") && !eleccion.equalsIgnoreCase("no")) {
                         System.out.println("Respeusta no valida, quieres cerrar la puerta? (si/no):");
                         eleccion = leer.nextLine().toLowerCase();
                     }

                     if (eleccion.equalsIgnoreCase("si")) {
                         lavadoraSeleccionada.cerrarPuerta();
                     } else if (eleccion.equalsIgnoreCase("no")) {
                         System.out.println("Lavado cancelado, puerta no cerrada");
                         break;
                     }
                 }

                 //Iniciamos lavado
                 lavadoraSeleccionada.iniciarLavado();
                 break;

             case 5:    //VER PRENDAS QUE HAY DENTRO DE CADA LAVADORA
                 if (lavadoras.isEmpty()) {
                     System.out.println("No hay lavadoras en la lista de lavadoras. Añade una nueva lavadora antes de intentar ver su contenido");
                     break;
                 }

                 //Mostramos las prendas que hay dentro de cada lavadora
                 for (int i = 0; i < lavadoras.size(); i++) {
                     LAVADORA lavadora = lavadoras.get(i);
                     System.out.println("\n---------------------------------");
                     System.out.println("\n LAVADORA " + (i + 1) + ":");

                     if (lavadora.getPrendas().isEmpty()) {
                         System.out.println("Esta lavadora esta vacia");
                     } else {
                         System.out.println("Lista de las prendas que hay dentro:");
                         for (PRENDA prenda : lavadora.getPrendas()) {
                             System.out.println("   -" + prenda);
                         }
                     }
                 }
                 System.out.println("---------------------------------");
                 break;

             case 6:
                 System.out.println("Estas seguro de que quieres salir? (si/no):");
                 leer.nextLine();
                 String confirmacion = leer.nextLine().toLowerCase();

                 while (!confirmacion.equalsIgnoreCase("si") && !confirmacion.equalsIgnoreCase("no")) {
                     System.out.println("Respuesta no valida, queires salir del menú lavadora? (si/no):");
                     confirmacion = leer.nextLine().toLowerCase();
                 }

                 if (confirmacion.equalsIgnoreCase("si")) {
                     System.out.println("Te has salido del menú lavadora.");
                     leer.close();  // Cerramos el Scanner
                     return;  // Salimos del programa
                 } else {
                     System.out.println("Cancelado, volviendo al menú principal");
                 }
                 break;

             default:
                 System.out.println("Opcion no valida, introduce un numero entre 1 y 6");
                 break;
         }
     }
    }
}