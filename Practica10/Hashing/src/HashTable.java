import java.util.Arrays;

public class HashTable {
    private Empleado[] table;
    private int[] searchLengths; // Para almacenar la longitud de la búsqueda de cada elemento

    public HashTable(int size) {
        table = new Empleado[size];
        searchLengths = new int[size];
        Arrays.fill(searchLengths, -1); // Inicializar con -1 que indica vacío
    }

    public void insert(Empleado emp) {
        int key = emp.getCodigo();
        int hash = key % table.length;
        int i = 0;
        int pos = hash;

        while (table[pos] != null && i < table.length) {
            i++;
            pos = (hash + i * i) % table.length; // Búsqueda cuadrática
        }

        if (table[pos] == null) {
            table[pos] = emp;
            searchLengths[pos] = i; // Guardar la longitud de la búsqueda para este elemento
        } else {
            System.out.println("Tabla llena o no se puede insertar después de múltiples intentos.");
        }
    }

    public void display() {
        System.out.println("D.Real\tD.Hash\tEmpleado\tLongitud de Búsqueda");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.println(
                        i + "\t" + (table[i].getCodigo() % table.length) + "\t" + table[i] + "\t" + searchLengths[i]);
            } else {
                System.out.println(i + "\t" + "empty");
            }
        }
    }
}
