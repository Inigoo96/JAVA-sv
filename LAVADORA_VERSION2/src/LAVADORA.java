import java.util.ArrayList;
import java.util.List;

public class LAVADORA {
    //ATRIBUTOS
    private Double capacidad;
    private String planLavado;
    private Boolean encendida;
    private Boolean puertaAbierta;
    private ArrayList<PRENDA> prendas;

    //CONSTRUCTOR
    public LAVADORA(Double capacidad, String planLavado) {
        this.capacidad = capacidad;
        this.planLavado = planLavado;
        this.encendida = false;
        this.puertaAbierta = true;
        this.prendas = new ArrayList<>();   //LA LAVADORA EMPIEZA VACIA, Y LE VAMOS INTRODUCIENDO PRENDAS
    }

    //METODOS
    //metodo para encender la lavadora
    public void encenderLavadora() {
        if (!encendida) {
            this.encendida = true;
            System.out.println("Lavadora encendida");
        } else {
            System.out.println("La lavadora ya está encendida");
        }
    }

    //metodo para apagar la lavadora
    public void apagarLavadora() {
        if (encendida) {
            this.encendida = false;
            System.out.println("Lavadora apagada");
        } else {
            System.out.println("La lavadora ya está apagada");
        }
    }

    //metodo para abir la puerta de la lavadora
    public void abrirPuerta() {
        if (!encendida) {
            puertaAbierta = true;
            System.out.println("La puerta se ha abierto.");
        } else {
            puertaAbierta = false;
            System.out.println("No se puede abrir la puerta mientras la lavadora está encendida");
        }
    }

    //metodo para cerrar la puerta de la lavadora
    public void cerrarPuerta() {
        if (puertaAbierta) {
            puertaAbierta = false;
            System.out.println("La puerta se ha cerrado correctamente");
        } else {
            System.out.println("La puerta ya estaba cerrada");
        }
    }

    //calculamos el peso total de la lavadora que lo reutilizaremos en el siguiente metdodo(introducirPrenda)
    public double calcularPesoTotal() {
        double pesoTotal = 0;

        for(PRENDA prenda : prendas) {
            pesoTotal += prenda.getPesoPrenda();
        }
        return pesoTotal;
    }

    //introducir prendas en la lavadora
    public boolean introducirPrenda(PRENDA prenda) {
        //UTILIZAMOS DOS IFS PARA SABER QUE CONDICION NOS DARA EL FALLO SI LO HAY
        if (!puertaAbierta) {
            System.out.println("La puerta esta cerrada, abre la puerta para introducir ropa en la lavadora");
            return false;
        }

        if (calcularPesoTotal() + prenda.getPesoPrenda() > capacidad) {
            System.out.println("Has superado el limite de capacidad de la lavadora, error al introducir mas ropa");
            return false;
        }

        prendas.add(prenda);    //Si cumple con la condicion de los 2 ifs se añadira la prenda a la lavadora
        System.out.println("Prenda añadida: " + prenda);
        return true;
    }

    public void iniciarLavado() {
        if (!encendida) {
            System.out.println("Enciende la lavadora antes de iniciar el lavado");
            return;
        }

        if (puertaAbierta) {
            System.out.println("Cierra la puerta antes de proceder con el lavado");
            return;
        }

        if (prendas.isEmpty()) { //prendas.size() == 0
            System.out.println("No hay prendas que lavar, lavado cancelado");
            return;
        }

        System.out.println("Lavando...");
        // Guardamos las prendas antes de vaciar la lavadora
        List<PRENDA> prendasLimpias = new ArrayList<>();

        for (PRENDA prenda : prendas) {
            prenda.setNivelSuciedad(0);     //La prenda esta limpia despues del lavado
            prendasLimpias.add(prenda); // La guardamos en la lista de prendas limpias
        }
        prendas.clear(); //Vaciamos la lavadora despues de cada lavado

        System.out.println("Lavado finalizado, la lavadora está vacía.");

        // Ahora devolvemos las prendas limpias al array de `prendas` en `Main`
        Main.reintegrarPrendas(prendasLimpias);
    }

    //GETTERS AND SETTERS, TO STRING
    @Override
    public String toString() {
        return "LAVADORA (" +getPlanLavado() + ") " +
                "- Capacidad: " + getCapacidad() + " Kg " +
                "- Estado: " + (getEncendida() ?  "Encendida" : "Apagada") + " " +
                "- Puerta: " + (getPuertaAbierta() ?  "Abierta" : "Cerrada") + " " +
                "- Prendas dentro: " + prendas.size();
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    public String getPlanLavado() {
        return planLavado;
    }

    public void setPlanLavado(String planLavado) {
        this.planLavado = planLavado;
    }

    public Boolean getEncendida() {
        return encendida;
    }

    public void setEncendida(Boolean encendida) {
        this.encendida = encendida;
    }

    public Boolean getPuertaAbierta() {
        return puertaAbierta;
    }

    public void setPuertaAbierta(Boolean puertaAbierta) {
        this.puertaAbierta = puertaAbierta;
    }

    public ArrayList<PRENDA> getPrendas() {
        return prendas;
    }

    public void setPrendas(ArrayList<PRENDA> prendas) {
        this.prendas = prendas;
    }
}
