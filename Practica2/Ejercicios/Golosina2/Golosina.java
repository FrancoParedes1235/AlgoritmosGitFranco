public class Golosina {
    private String nombre; // Nombre de la golosina

    public Golosina(String nombre) {
        this.nombre = nombre; // Inicializar el nombre
    }

    public String getNombre() {
        return nombre; // Obtener el nombre
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Establecer el nombre
    }

    // Método toString para imprimir la golosina de manera legible
    @Override
    public String toString() {
        return "Golosina [nombre=" + nombre + "]";
    }
}