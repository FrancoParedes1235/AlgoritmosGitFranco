import java.util.Objects;

public class Chocolatina {
    private String nombre;

    // Constructor de la clase Chocolatina
    public Chocolatina(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para obtener el nombre de la chocolatina
    public String getNombre() {
        return nombre;
    }

    // Método setter para establecer el nombre de la chocolatina
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método toString para representar la chocolatina como una cadena de texto
    @Override
    public String toString() {
        return "Nombre: " + nombre;
    }

    // Método equals para comparar dos objetos Chocolatina por su nombre
    @Override
    public boolean equals(Object obj) {
        if (this == obj) // Comprueba si los objetos son idénticos
            return true;
        if (obj == null || getClass() != obj.getClass()) // Comprueba si el objeto es nulo o no es una instancia de
                                                         // Chocolatina
            return false;
        Chocolatina otra = (Chocolatina) obj; // Convierte el objeto genérico a Chocolatina
        return nombre.equals(otra.nombre); // Compara los nombres de las chocolatinas
    }

    // Método hashCode para generar un código hash basado en el nombre de la
    // chocolatina
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
