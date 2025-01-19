public class LAVADORA {
    //ATRIBUTOS
    private String planLavado;
    private Double capacidad;
    private Boolean llena;
    private String estado;
    private Integer contTiempoLavado;
    private String estadoLavado;
    private String puerta;
    private String pantalla;
    private Integer revXMinuto;
    private Integer tempAgua;
    private String cajetil;
    private Integer capacidadCajetil;
    private String tamborLavadora;
    private String detergente;

    //CONSTRUCTOR
    public LAVADORA (String planLavado, Double capacidad) {
           this.planLavado = planLavado;
           this.capacidad = capacidad;

           //Ponemos el resto de atributos por defecto
            this.llena = false;
            this.estado = "apagada";
            this.contTiempoLavado = 0;
            this.estadoLavado = "sin lavar";
            this.puerta = "cerrada";
            this.pantalla = "apagada";
            this.revXMinuto = 0;
            this.tempAgua = 0;
            this.cajetil = "cerrado";
            this.capacidadCajetil = 1;
            this.tamborLavadora = "parado";
            this.detergente = "suficiente";
    }

    //MÉTODOS
    //encendemos la lavadora
    public void encenderLavadora() {
        this.estado = "encendida";
        this.pantalla = "encendida";
    }

    //cerramos la puerta de la lavadora
    public String cerrarPuerta() {
        if (puerta.equalsIgnoreCase("abierta")) {
            this.puerta = "cerrada";
            return "cerrada";
        }
        return "error";
    }

    //abrir lavadora durante el lavado
    public String abrirLavadora() {
        if (estadoLavado.equalsIgnoreCase("lavando")) {
            return "error, lavadora en funcionamiento";
        }
        this.puerta = "abierta";
        return "abierta";
    }

    //introducir ropa dentro de la lavadora si es menor o igual a su capacidad
    public Boolean introducirRopa(Double peso) {
        if (puerta.equalsIgnoreCase("abierta")) {
            if (peso <= capacidad) {
                llena = true;
                return true;  // Metemos la ropa en la lavadora
            }
            return false;     // El peso es mayor que la capacidad
        }
        return false;         // La puerta esta cerrada
    }

    //La lavadora guarda el plan de lavado con la temperatura y revXMinuto dependiendo de su plan de lavado
    public void definirPlanLavado(String planLavado) {
        this.planLavado = planLavado;
        if (planLavado.equalsIgnoreCase("caliente")) {
            tempAgua = 40;
            revXMinuto = 1200;
            contTiempoLavado = 120;
        } else if (planLavado.equalsIgnoreCase("frio")) {
            tempAgua = 20;
            revXMinuto = 800;
            contTiempoLavado = 90;
        }
        this.estadoLavado = "programado";
        System.out.println("Lavadora programada: " +
                "\n - Plan: " + planLavado +
                "\n - Temperatura: " + tempAgua + "°C" +
                "\n - Revoluciones: " + revXMinuto + " rpm" +
                "\n - Tiempo: " + contTiempoLavado + " minutos");
    }

    //iniciamos el proceso de lavado si se cumple las siguientes condiciones
    public Boolean iniciarLavado() {
        if (puerta.equalsIgnoreCase("cerrada") && estado.equalsIgnoreCase("encendida") && detergente.equalsIgnoreCase("suficiente")) {
            this.estadoLavado = "lavando";
            this.tamborLavadora = "girando";
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "LAVADORA{" +
                "planLavado='" + planLavado + '\'' +
                ", capacidad=" + capacidad +
                ", llena=" + llena +
                ", estado='" + estado + '\'' +
                ", contTiempoLavado=" + contTiempoLavado +
                ", estadoLavado='" + estadoLavado + '\'' +
                ", puerta='" + puerta + '\'' +
                ", pantalla='" + pantalla + '\'' +
                ", revXMinuto=" + revXMinuto +
                ", tempAgua=" + tempAgua +
                ", cajetil='" + cajetil + '\'' +
                ", capacidadCajetil=" + capacidadCajetil +
                ", tamborLavadora='" + tamborLavadora + '\'' +
                ", detergente='" + detergente + '\'' +
                '}';
    }


    //Getters y Setters
    public String getPlanLavado() {
        return planLavado;
    }

    public void setPlanLavado(String planLavado) {
        this.planLavado = planLavado;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getLlena() {
        return llena;
    }

    public void setLlena(Boolean llena) {
        this.llena = llena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getContTiempoLavado() {
        return contTiempoLavado;
    }

    public void setContTiempoLavado(Integer contTiempoLavado) {
        this.contTiempoLavado = contTiempoLavado;
    }

    public String getEstadoLavado() {
        return estadoLavado;
    }

    public void setEstadoLavado(String estadoLavado) {
        this.estadoLavado = estadoLavado;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public Integer getRevXMinuto() {
        return revXMinuto;
    }

    public void setRevXMinuto(Integer revXMinuto) {
        this.revXMinuto = revXMinuto;
    }

    public Integer getTempAgua() {
        return tempAgua;
    }

    public void setTempAgua(Integer tempAgua) {
        this.tempAgua = tempAgua;
    }

    public String getCajetil() {
        return cajetil;
    }

    public void setCajetil(String cajetil) {
        this.cajetil = cajetil;
    }

    public Integer getCapacidadCajetil() {
        return capacidadCajetil;
    }

    public void setCapacidadCajetil(Integer capacidadCajetil) {
        this.capacidadCajetil = capacidadCajetil;
    }

    public String getTamborLavadora() {
        return tamborLavadora;
    }

    public void setTamborLavadora(String tamborLavadora) {
        this.tamborLavadora = tamborLavadora;
    }

    public String getDetergente() {
        return detergente;
    }

    public void setDetergente(String detergente) {
        this.detergente = detergente;
    }
}
