import java.util.ArrayList;
import java.util.Iterator;

public class Cajoneria<T> implements Iterable<T> {
    private ArrayList<Caja<T>> cajones = new ArrayList<>(); // ArrayList para almacenar las cajas
    private int tope; // Capacidad máxima de la cajonería

    public Cajoneria(int tope) {
        this.tope = tope; // Inicializar la capacidad máxima
    }

    // Método para agregar un objeto a la cajonería con un color específico
    public void add(T objeto, String color) {
        if (cajones.size() < tope) { // Comprobar si la cajonería está llena
            Caja<T> caja = new Caja<>(color); // Crear una nueva caja con el color especificado
            caja.pon(objeto); // Colocar el objeto en la caja
            cajones.add(caja); // Agregar la caja al ArrayList de cajones
        } else {
            throw new RuntimeException("No caben más elementos en la cajonería"); // Lanzar una excepción si la
                                                                                  // cajonería está llena
        }
    }

    // Método para obtener un iterador sobre los objetos almacenados en las cajas
    public Iterator<T> iterator() {
        ArrayList<T> elementos = new ArrayList<>(); // ArrayList para almacenar los elementos de las cajas
        for (Caja<T> caja : cajones) { // Iterar sobre cada caja en la cajonería
            elementos.add(caja.dame()); // Agregar el contenido de la caja al ArrayList de elementos
        }
        return elementos.iterator(); // Devolver un iterador sobre los elementos
    }

    // Método para buscar un objeto en las cajas y devolver su posición y color si
    // se encuentra
    public String search(T objeto) {
        for (int i = 0; i < cajones.size(); i++) { // Iterar sobre cada caja en la cajonería
            T contenido = cajones.get(i).dame(); // Obtener el contenido de la caja actual
            if (contenido != null && contenido.equals(objeto)) { // Comprobar si el contenido de la caja es igual al
                                                                 // objeto buscado
                return "Posicion: " + (i + 1) + "\tColor Caja: " + cajones.get(i).getColor() + "\tObjeto: "
                        + objeto.toString(); // Devolver la posición, color y objeto encontrado
            }
        }
        return "El objeto no se encuentra en ninguna caja."; // Devolver un mensaje si el objeto no se encuentra en
                                                             // ninguna caja
    }

    // Método para eliminar un objeto de una de las cajas si se encuentra y
    // devolverlo
    public T delete(T objeto) {
        for (Caja<T> caja : cajones) { // Iterar sobre cada caja en la cajonería
            T contenido = caja.dame(); // Obtener el contenido de la caja actual
            if (contenido != null && contenido.equals(objeto)) { // Comprobar si el contenido de la caja es igual al
                                                                 // objeto buscado
                caja.pon(null); // Eliminar el objeto de la caja asignándole null
                return objeto; // Devolver el objeto eliminado
            }
        }
        return null; // Devolver null si el objeto no se encuentra en ninguna caja
    }

    // Método para obtener una representación de cadena de la cajonería
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // StringBuilder para construir la cadena de salida
        sb.append("Posicion\tColor Caja\tObjeto\n"); // Encabezado de la tabla
        for (int i = 0; i < cajones.size(); i++) { // Iterar sobre cada caja en la cajonería
            Caja<T> caja = cajones.get(i); // Obtener la caja actual
            T objeto = caja.dame(); // Obtener el objeto contenido en la caja
            String objetoString = (objeto != null) ? objeto.toString() : "Caja vacía"; // Mensaje descriptivo para caja
                                                                                       // vacía
            sb.append((i + 1) + "\t\t" + caja.getColor() + "\t\t" + objetoString + "\n");
        }
        return sb.toString(); // Devolver la representación de cadena de la cajonería
    }

}