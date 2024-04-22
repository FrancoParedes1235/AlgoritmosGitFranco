import java.util.ArrayList;

// Clase que representa un límite de un subarreglo
class Limits {
    int[] a; // Arreglo
    int prim; // Índice del primer elemento
    int ult; // Índice del último elemento
}

// Clase que gestiona conjuntos de límites de subarreglos heterogéneos y homogéneos
class SetVectors {
    ArrayList<Limits> heterogeneo = new ArrayList<>(); // Conjunto de subarreglos heterogéneos
    ArrayList<Limits> homogeneo = new ArrayList<>(); // Conjunto de subarreglos homogéneos

    // Método para insertar un límite de subarreglo en un conjunto
    public static void Insertar(ArrayList<Limits> conjunto, Limits p) {
        conjunto.add(p);
    }

    // Método para encontrar la longitud del subarreglo más grande en un conjunto
    public static int Long_Mayor(ArrayList<Limits> conjunto) {
        int mayor = 0;
        for (Limits p : conjunto) {
            int length = p.ult - p.prim;
            if (length > mayor) {
                mayor = length;
            }
        }
        return mayor;
    }

    // Método para encontrar el límite del subarreglo más grande en un conjunto
    public static Limits Mayor(ArrayList<Limits> conjunto) {
        Limits mayor = conjunto.get(0);
        for (Limits p : conjunto) {
            if (p.ult - p.prim > mayor.ult - mayor.prim) {
                mayor = p;
            }
        }
        return mayor;
    }

    // Método para verificar si un conjunto está vacío
    public static boolean Esvacio(ArrayList<Limits> conjunto) {
        return conjunto.isEmpty();
    }

    // Método para destruir un conjunto, limpiándolo
    public static void Destruir(ArrayList<Limits> conjunto) {
        conjunto.clear();
    }
}

// Clase que implementa el algoritmo para encontrar la moda de un arreglo
public class Moda3 {
    // Método para encontrar la moda de un subarreglo
    public static int moda3(int[] a, int prim, int ult) {
        Limits p = new Limits(); // Límite del subarreglo
        SetVectors homogeneo = new SetVectors(); // Conjunto de subarreglos homogéneos
        SetVectors heterogeneo = new SetVectors(); // Conjunto de subarreglos heterogéneos
        int mediana; // Mediana de las medianas
        int izq, der; // Índices para dividir el subarreglo en dos partes

        p.a = a;
        p.prim = prim;
        p.ult = ult;
        SetVectors.Insertar(heterogeneo.heterogeneo, p); // Inserta el límite del subarreglo en el conjunto heterogéneo

        // Mientras la longitud del subarreglo más grande del conjunto heterogéneo sea mayor que el del conjunto homogéneo
        while (SetVectors.Long_Mayor(heterogeneo.heterogeneo) > SetVectors.Long_Mayor(homogeneo.homogeneo)) {
            p = SetVectors.Mayor(heterogeneo.heterogeneo); // Obtiene el límite del subarreglo más grande
            mediana = p.a[(p.prim + p.ult) / 2]; // Calcula la mediana de las medianas
            izq = p.prim;
            der = p.ult;
            Pivote2(p.a, mediana, p.prim, p.ult, izq, der); // Particiona el subarreglo en dos partes

            // Crea tres subarreglos basados en la partición y los inserta en el conjunto heterogéneo
            Limits p1 = new Limits();
            p1.a = p.a;
            p1.prim = p.prim;
            p1.ult = izq - 1;
            Limits p2 = new Limits();
            p2.a = p.a;
            p2.prim = izq;
            p2.ult = der - 1;
            Limits p3 = new Limits();
            p3.a = p.a;
            p3.prim = der;
            p3.ult = p.ult;
            if (p1.prim < p1.ult) {
                SetVectors.Insertar(heterogeneo.heterogeneo, p1);
            }
            if (p3.prim < p3.ult) {
                SetVectors.Insertar(heterogeneo.heterogeneo, p3);
            }
            if (p2.prim < p2.ult) {
                SetVectors.Insertar(homogeneo.homogeneo, p2);
            }
        }

        // Si no hay subarreglos homogéneos, la moda es el primer elemento del subarreglo original
        if (SetVectors.Esvacio(homogeneo.homogeneo)) {
            return a[prim];
        }

        // De lo contrario, la moda es el primer elemento del subarreglo homogéneo más grande
        p = SetVectors.Mayor(homogeneo.homogeneo);
        SetVectors.Destruir(homogeneo.homogeneo); // Limpia el conjunto homogéneo
        SetVectors.Destruir(heterogeneo.heterogeneo); // Limpia el conjunto heterogéneo
        return p.a[p.prim]; // Devuelve la moda encontrada
    }

    // Método para particionar el subarreglo en dos partes
    private static void Pivote2(int[] a, int mediana, int prim, int ult, int izq, int der) {
        izq = prim;
        der = ult;
        int i = prim;
        while (i <= der) {
            if (a[i] < mediana) {
                swap(a, i, izq);
                i++;
                izq++;
            } else if (a[i] > mediana) {
                swap(a, i, der);
                der--;
            } else {
                i++;
            }
        }
    }

    // Método para intercambiar dos elementos en un arreglo
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Método main para probar la función moda3
    public static void main(String[] args) {
        int[] vector = { 3, 1, 2, 3, 2, 3, 1, 3, 2 }; // Arreglo de enteros
        int moda = moda3(vector, 0, vector.length - 1); // Calcula la moda del arreglo
        System.out.println("Moda: " + moda); // Imprime la moda
    }
}
