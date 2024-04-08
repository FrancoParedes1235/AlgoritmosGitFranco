public class Golosina {// Clase Golosina
    private String nombre; // Nombre de la golosina
    private double peso; // Peso de la golosina

    public Golosina(String nombre, double peso) {
        this.nombre = nombre; // Inicializar el nombre
        this.peso = peso; // Inicializar el peso
    }

    public Golosina(String nombre) {
        this.nombre = nombre; // Inicializar el nombre
        this.peso = 0.0; // Establecer un peso predeterminado
    }

    public String getNombre() {
        return this.nombre; // Obtener el nombre
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Establecer el nombre
    }

    public double getPeso() {
        return this.peso; // Obtener el peso
    }

    public void setPeso(double peso) {
        this.peso = peso; // Establecer el peso
    }
}