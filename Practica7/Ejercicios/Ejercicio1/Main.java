public class Main {
    public static void main(String[] args) {
        try {
            BSTree<Integer> bst = new BSTree<>();
            System.out.println("Árbol vacío: " + bst.isEmpty());

            // Insertando elementos en el BST
            System.out.println("Insertando elementos...");
            bst.insert(10);
            bst.insert(5);
            bst.insert(15);
            bst.insert(1);
            bst.insert(7);
            System.out.println("Árbol después de insertar 10, 5, 15, 1, 7: " + bst.toString());

            // Contar nodos no-hojas
            System.out.println("Número de nodos no-hojas: " + bst.countNodes());

            // Altura de nodos específicos
            System.out.println("Altura del nodo con valor 10: " + bst.height(10));
            System.out.println("Altura del nodo con valor 5: " + bst.height(5));
            System.out.println("Altura del nodo con valor 1: " + bst.height(1));

            // Encontrando el valor mínimo
            System.out.println("Valor mínimo en el árbol: " + bst.findMin());

            // Eliminando elementos del BST
            System.out.println("Eliminando elementos...");
            bst.remove(5);
            System.out.println("Árbol después de eliminar 5: " + bst.toString());
            bst.remove(15);
            System.out.println("Árbol después de eliminar 15: " + bst.toString());
            bst.remove(10);
            System.out.println("Árbol después de eliminar 10: " + bst.toString());
            bst.remove(1);
            System.out.println("Árbol después de eliminar 1: " + bst.toString());

            System.out.println("Árbol vacío: " + bst.isEmpty());
        } catch (ItemDuplicated | ItemNotFound e) {
            System.err.println(e.getMessage());
        }
    }
}
