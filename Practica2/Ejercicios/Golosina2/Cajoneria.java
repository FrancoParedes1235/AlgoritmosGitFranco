import java.util.ArrayList;
import java.util.Iterator;

// Modificación de la clase Bolsa para convertirla en Cajoneria
public class Cajoneria<T> implements Iterable<T> {
    private ArrayList<T> lista = new ArrayList<T>(); // ArrayList para almacenar los elementos
    private int tope; // Capacidad máxima de la cajonería

    public Cajoneria(int tope) {
        super();
        this.tope = tope; // Inicializar la capacidad máxima
    }

    // Método para añadir un objeto a la cajonería
    public void add(T objeto) {
        if (lista.size() < tope) { // Comprobar si la cajonería está llena
            lista.add(objeto); // Añadir el objeto a la lista
        } else {
            throw new RuntimeException("No caben más elementos en la cajonería"); // Lanzar una excepción si la cajonería está llena
        }
    }

    // Método para obtener un iterador sobre la cajonería
    public Iterator<T> iterator() {
        return lista.iterator(); // Devolver un iterador sobre la lista
    }
}
