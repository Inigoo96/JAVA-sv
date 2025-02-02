public class PRENDA {
    //ATRIBUTOS
    private String tipo;
    private String color;
    private Double pesoPrenda;
    private Integer nivelSuciedad;


    //CONSTRUCTOR
    public PRENDA(String tipo, String color, Double pesoPrenda, Integer nivelSuciedad) {
        this.tipo = tipo;
        this.color = color;
        this.pesoPrenda = pesoPrenda;
        this.nivelSuciedad = nivelSuciedad;
    }


    //METODOS
    //no hay metodos ya que la ropa no hace nada por si sola, solo le podemos definir atributos

    //GETTERS AND SETTERS, TO STRING
    @Override
    public String toString() {
        return getTipo() +
                " de color " + getColor() +
                " (" + getPesoPrenda() + " Kg) - Suciedad: " + getNivelSuciedad() + "%" ;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPesoPrenda() {
        return pesoPrenda;
    }

    public void setPesoPrenda(Double pesoPrenda) {
        this.pesoPrenda = pesoPrenda;
    }

    public Integer getNivelSuciedad() {
        return nivelSuciedad;
    }

    public void setNivelSuciedad(Integer nivelSuciedad) {
        if (nivelSuciedad < 0) {
            this.nivelSuciedad = 0; // Evitamos valores negativos
        } else if (nivelSuciedad > 100) {
            this.nivelSuciedad = 100; // Evitamos valores mayores que 100
        } else {
            this.nivelSuciedad = nivelSuciedad; // Asignamos el valor correcto
        }
    }

}
