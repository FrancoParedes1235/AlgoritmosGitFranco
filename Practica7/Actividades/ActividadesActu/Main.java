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
            System.out.println("Árbol después de insertar 10, 5, 15, 1: " + bst.toString());

            // Buscando elementos en el BST
            System.out.println("Buscando elementos...");
            System.out.println("Buscar 10: " + bst.search(10));
            System.out.println("Buscar 5: " + bst.search(5));
            System.out.println("Buscar 15: " + bst.search(15));
            System.out.println("Buscar 1: " + bst.search(1));

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
            bst.remove(10);
            System.out.println("Árbol después de eliminar 1: " + bst.toString());

            System.out.println("Árbol vacío: " + bst.isEmpty());
        } catch (ItemDuplicated e) {
            System.out.println("Elemento duplicado: " + e.getMessage());
        } catch (ItemNotFound e) {
            System.out.println("Elemento no encontrado: " + e.getMessage());
        }
    }
}
