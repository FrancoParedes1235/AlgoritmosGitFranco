public class TestComparacion {
    public static void main(String[] args) {
        try {
            // Crear un árbol BST
            BSTree<Integer> bst = new BSTree<>();
            // Crear un árbol AVL
            AVLTree<Integer> avl = new AVLTree<>();

            // Caso de prueba: Inserciones que causan desbalance en el BST pero se corrigen
            // en el AVL
            System.out.println("Insertando elementos: 10, 20, 30, 40, 50, 25");
            int[] elementos = { 10, 20, 30, 40, 50, 25 };

            for (int elem : elementos) {
                bst.insert(elem);
                avl.insert(elem);
            }

            System.out.println("\nBST (preorden):");
            bst.iterativePreOrden();
            System.out.println("\nAVL (preorden):");
            avl.iterativePreOrden();

            // Altura de los árboles después de las inserciones
            System.out.println("\nAltura de BST:");
            System.out.println("Altura: " + bst.height(bst.root));
            System.out.println("Altura de AVL:");
            System.out.println("Altura: " + avl.height(avl.root));

            // Búsqueda de elementos en ambos árboles
            System.out.println("\nBuscar 25 en BST:");
            System.out.println("Encontrado: " + bst.search(25));
            System.out.println("Buscar 25 en AVL:");
            System.out.println("Encontrado: " + avl.search(25));

            // Eliminación de elementos
            System.out.println("\nEliminando el elemento 30");
            bst.remove(30);
            avl.remove(30);

            System.out.println("\nBST (preorden) después de eliminar 30:");
            bst.iterativePreOrden();
            System.out.println("\nAVL (preorden) después de eliminar 30:");
            avl.iterativePreOrden();

            System.out.println("\nAltura de BST después de eliminar 30:");
            System.out.println("Altura: " + bst.height(bst.root));
            System.out.println("Altura de AVL después de eliminar 30:");
            System.out.println("Altura: " + avl.height(avl.root));

        } catch (ItemDuplicated | ItemNotFound e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
