public class Main {
    public static void main(String[] args) {
        try {
            // Crear un árbol binario de búsqueda
            BSTree<Integer> bst = new BSTree<>();

            // Insertar elementos en el árbol
            bst.insert(10);
            bst.insert(5);
            bst.insert(15);
            bst.insert(3);
            bst.insert(7);
            bst.insert(12);
            bst.insert(17);

            // Mostrar el árbol en preorden de manera iterativa
            System.out.println("Recorrido PreOrden Iterativo:");
            bst.iterativePreOrden();
            System.out.println();

            // Mostrar el número total de nodos en el árbol de manera recursiva
            System.out.println("Número total de nodos en el árbol: " + bst.countNodesRecursive());
        } catch (ItemDuplicated e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
