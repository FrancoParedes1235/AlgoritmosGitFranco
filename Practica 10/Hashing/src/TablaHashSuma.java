import java.util.ArrayList;
import java.util.LinkedList;

class TablaHashSuma {
    private int size; // Tamaño de la tabla hash
    private LinkedList<Integer>[] table; // Tabla hash implementada como una lista de listas enlazadas

    // Constructor para inicializar la tabla hash
    public TablaHashSuma(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>(); // Inicializa cada lista enlazada
        }
    }

    // Método hash para calcular el índice en la tabla
    private int hash(int key) {
        return key % size; // Usa el operador módulo para calcular el índice
    }

    // Método para insertar una clave en la tabla hash
    public void insertar(int key) {
        int index = hash(key); // Calcula el índice usando el método hash
        table[index].add(key); // Añade la clave a la lista enlazada correspondiente
    }

    // Método para buscar una clave en la tabla hash
    public boolean buscar(int key) {
        int index = hash(key); // Calcula el índice usando el método hash
        return table[index].contains(key); // Devuelve true si la clave está en la lista enlazada correspondiente
    }

    // Método para encontrar todos los pares de elementos en una lista que suman un
    // valor dado
    public ArrayList<int[]> encontrarPares(int[] lista, int suma) {
        ArrayList<int[]> pares = new ArrayList<>(); // Lista para almacenar los pares que suman el valor dado
        for (int numero : lista) {
            int complemento = suma - numero; // Calcula el complemento necesario para alcanzar la suma
            if (buscar(complemento)) { // Si el complemento ya está en la tabla, añade el par a la lista de pares
                pares.add(new int[] { complemento, numero });
            }
            insertar(numero); // Inserta el número actual en la tabla hash
        }
        return pares; // Devuelve la lista de pares
    }

    // Método principal para probar la funcionalidad de la clase
    public static void main(String[] args) {
        int[] lista = { 1, 2, 3, 4, 5 }; // Lista de ejemplo
        int suma = 6; // Valor de suma objetivo
        TablaHashSuma tabla = new TablaHashSuma(10); // Crea una instancia de TablaHashSuma con tamaño 10
        ArrayList<int[]> pares = tabla.encontrarPares(lista, suma); // Encuentra los pares que suman el valor objetivo

        // Mostrar los pares encontrados
        for (int[] par : pares) {
            System.out.println("(" + par[0] + ", " + par[1] + ")"); // Imprime cada par encontrado
        }
    }
}
