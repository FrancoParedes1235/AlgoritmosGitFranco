
public class TestComparacion {
    public static void main(String[] args) {
        try {
            // Crear un árbol BST
            BSTree<Integer> bst = new BSTree<>();
            // Crear un árbol AVL
            AVLTree<Integer> avl = new AVLTree<>();

            // Caso de prueba 1: Inserciones que causan desbalance en el BST pero se
            // corrigen en el AVL
            System.out.println("Caso de prueba 1:");
            int[] elementos = { 10, 20, 30, 40, 50, 25 };

            for (int elem : elementos) {
                bst.insert(elem);
                avl.insert(elem);
            }

            System.out.println("BST (preorden):");
            bst.iterativePreOrden();
            System.out.println("\nAVL (preorden):");
            avl.iterativePreOrden();

            // Búsqueda de elementos en ambos árboles
            System.out.println("\nBuscar 25 en BST:");
            System.out.println("Encontrado: " + bst.search(25));
            System.out.println("Buscar 25 en AVL:");
            System.out.println("Encontrado: " + avl.search(25));

            // Altura de los árboles
            System.out.println("\nAltura de BST:");
            System.out.println("Altura: " + bst.height());
            System.out.println("Altura de AVL:");
            System.out.println("Altura: " + avl.height());

            // Caso de prueba 2: Eliminación de elementos y rebalanceo
            System.out.println("\nCaso de prueba 2:");

            bst.remove(30);
            avl.remove(30);

            System.out.println("BST (preorden) después de eliminar 30:");
            bst.iterativePreOrden();
            System.out.println("\nAVL (preorden) después de eliminar 30:");
            avl.iterativePreOrden();

            System.out.println("\nAltura de BST después de eliminar 30:");
            System.out.println("Altura: " + bst.height());
            System.out.println("Altura de AVL después de eliminar 30:");
            System.out.println("Altura: " + avl.height());

        } catch (ItemDuplicated | ItemNotFound e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
