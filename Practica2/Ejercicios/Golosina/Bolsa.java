import java.util.ArrayList;
import java.util.Iterator;

// Clase Bolsa que implementa Iterable
public class Bolsa<T> implements Iterable<T> {
    private ArrayList<T> lista = new ArrayList<T>(); // ArrayList para almacenar los elementos
    private int tope; // Capacidad máxima de la bolsa

    public Bolsa(int tope) {
        super();
        this.tope = tope; // Inicializar la capacidad máxima
    }

    // Método para añadir un objeto a la bolsa
    public void add(T objeto) {
        if (lista.size() < tope) { // Comprobar si la bolsa está llena
            lista.add(objeto); // Añadir el objeto a la lista
        } else {
            throw new RuntimeException("no caben mas"); // Lanzar una excepción si la bolsa está llena
        }
    }

    // Método para obtener un iterador sobre la bolsa
    public Iterator<T> iterator() {
        return lista.iterator(); // Devolver un iterador sobre la lista
    }
}