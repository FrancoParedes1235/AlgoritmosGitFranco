import java.util.ArrayList;
import java.util.LinkedList;

class TablaHashCoordenadas {
    private int size; // Tamaño de la tabla hash
    private LinkedList<Element>[] table; // Tabla hash implementada como una lista de listas enlazadas

    // Clase interna para representar un elemento de la tabla hash
    private static class Element {
        int x, y; // Coordenadas
        String value; // Valor asociado

        Element(int x, int y, String value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Element element = (Element) o;
            return x == element.x && y == element.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ") : " + value;
        }
    }

    // Constructor para inicializar la tabla hash
    public TablaHashCoordenadas(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>(); // Inicializa cada lista enlazada
        }
    }

    // Método hash para calcular el índice en la tabla
    private int hash(int x, int y) {
        return (31 * x + y) % size; // Usa el operador módulo para calcular el índice
    }

    // Método para insertar un valor asociado a una coordenada en la tabla hash
    public void insertar(int x, int y, String value) {
        int index = hash(x, y); // Calcula el índice usando el método hash
        Element newElement = new Element(x, y, value);
        LinkedList<Element> bucket = table[index];

        for (Element element : bucket) {
            if (element.equals(newElement)) {
                element.value = value; // Reemplazar el valor si la coordenada ya existe
                return;
            }
        }

        bucket.add(newElement); // Añade el nuevo elemento a la lista enlazada
    }

    // Método para buscar un valor asociado a una coordenada en la tabla hash
    public String buscar(int x, int y) {
        int index = hash(x, y); // Calcula el índice usando el método hash
        LinkedList<Element> bucket = table[index];

        for (Element element : bucket) {
            if (element.x == x && element.y == y) {
                return element.value; // Devuelve el valor asociado si la coordenada se encuentra
            }
        }

        return null; // Devuelve null si la coordenada no se encuentra
    }

    // Método para eliminar un valor asociado a una coordenada en la tabla hash
    public String eliminar(int x, int y) {
        int index = hash(x, y); // Calcula el índice usando el método hash
        LinkedList<Element> bucket = table[index];

        for (Element element : bucket) {
            if (element.x == x && element.y == y) {
                bucket.remove(element); // Elimina el elemento si la coordenada se encuentra
                return element.value; // Devuelve el valor eliminado
            }
        }

        return null; // Devuelve null si la coordenada no se encuentra
    }

    // Método principal para probar la funcionalidad de la clase
    public static void main(String[] args) {
        TablaHashCoordenadas tabla = new TablaHashCoordenadas(10); // Crea una instancia de TablaHashCoordenadas con
                                                                   // tamaño 10

        // Inserta algunos valores
        tabla.insertar(1, 2, "valor1");
        tabla.insertar(3, 4, "valor2");

        // Busca y muestra los valores
        System.out.println(tabla.buscar(1, 2)); // Output: valor1
        System.out.println(tabla.buscar(3, 4)); // Output: valor2

        // Elimina un valor y muestra el resultado
        System.out.println(tabla.eliminar(1, 2)); // Output: valor1
        System.out.println(tabla.buscar(1, 2)); // Output: null
    }
}
