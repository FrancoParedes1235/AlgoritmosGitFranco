import java.util.Objects;

public class Golosina {
    private String nombre;

    public Golosina(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método equals para comparar golosinas por su nombre
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Golosina golosina = (Golosina) obj;
        return Objects.equals(nombre, golosina.nombre);
    }

    // Método toString para imprimir la golosina de manera legible
    @Override
    public String toString() {
        return "Nombre: " + nombre;
    }

    // Método hashCode para respetar contrato con equals
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
