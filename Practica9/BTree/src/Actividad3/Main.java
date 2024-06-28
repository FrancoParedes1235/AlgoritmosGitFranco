package Actividad3;

public class Main {
    public static void main(String[] args) {
        // Crear un árbol B con orden adecuado (mínimo grado t = 4)

        BTree<Integer> bTree = new BTree<>(4); // BTree con orden 4 (máximo 3 claves por nodo)
        // Insertar las claves para formar el árbol deseado
        int[] keys = { 31, 12, 19, 41, 57, 63, 3, 10, 13, 16, 22, 25, 28, 33, 38, 40, 49, 52, 55, 60, 62, 67, 70, 72 };
        for (int key : keys) {
            bTree.insert(key);
        }

        // Imprimir el contenido del árbol
        System.out.println("Árbol B:");
        System.out.println(bTree);
        System.out.println("Árbol B:");
        System.out.println(bTree.printVisualTree());
        System.out.println(bTree.search(72));
        bTree.remove(49);
        bTree.remove(60);
        // System.out.println(bTree);
        System.out.println(bTree.printVisualTree());
        // System.out.println(bTree.search(3));

    }
}
