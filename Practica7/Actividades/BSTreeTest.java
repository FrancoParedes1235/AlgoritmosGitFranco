public class BSTreeTest {
    public static void main(String[] args) {
        // Crear una instancia del árbol
        BSTree<Integer> bst = new BSTree<>();

        // Prueba de inserción
        try {
            bst.insert(10);
            bst.insert(5);
            bst.insert(20);
            bst.insert(3);
            bst.insert(7);
            bst.insert(15);
            bst.insert(25);
            System.out.println("Inserciones completadas: " + bst.toString());
        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }

        // Prueba de búsqueda

        try {
            System.out.println("Buscando 7: " + bst.search(7));
        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Buscando 15: " + bst.search(15));
        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Buscando 100 (no existe): " + bst.search(100));
        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }

        // Prueba de eliminación
        try {
            bst.remove(3); // Eliminando una hoja
            System.out.println("Eliminado 3: " + bst.toString());
        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            bst.remove(20); // Eliminando un nodo con dos hijos
            System.out.println("Eliminado 20: " + bst.toString());
        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            bst.remove(5); // Eliminando un nodo con un hijo
            System.out.println("Eliminado 5: " + bst.toString());
        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            bst.remove(100); // Intentando eliminar un nodo que no existe
        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }

        // Prueba de encontrar el mínimo
        try {
            System.out.println("Mínimo del BST: " + bst.findMin());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        // Prueba de árbol vacío
        try {
            BSTree<Integer> emptyBst = new BSTree<>();
            System.out.println("Mínimo del BST vacío: " + emptyBst.findMin());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
        /*
         * // Crear una instancia del árbol
         * BSTree<Integer> bst = new BSTree<>();
         * 
         * // Prueba de inserción
         * try {
         * bst.insert(10);
         * bst.insert(5);
         * bst.insert(20);
         * bst.insert(3);
         * bst.insert(7);
         * bst.insert(15);
         * bst.insert(25);
         * System.out.println("Inserciones completadas: " + bst.toString());
         * } catch (ItemDuplicated e) {
         * System.out.println(e.getMessage());
         * }
         * 
         * // Prueba de búsqueda
         * Integer[] searchKeys = { 7, 15, 100 }; // Elementos a buscar
         * for (Integer key : searchKeys) {
         * System.out.println("Buscando " + key + ": ");
         * try {
         * System.out.println("Encontrado: " + bst.search(key));
         * } catch (ItemNotFound e) {
         * System.out.println(e.getMessage());
         * }
         * }
         * 
         * // Prueba de eliminación
         * Integer[] removeKeys = { 3, 20, 5, 100 }; // Elementos a eliminar
         * for (Integer key : removeKeys) {
         * try {
         * bst.remove(key);
         * System.out.println("Eliminado " + key + ": " + bst.toString());
         * } catch (ItemNotFound e) {
         * System.out.println(e.getMessage());
         * }
         * }
         * 
         * // Prueba de encontrar el mínimo
         * try {
         * System.out.println("Mínimo del BST: " + bst.findMin());
         * } catch (ExceptionIsEmpty e) {
         * System.out.println(e.getMessage());
         * }
         * 
         * // Prueba de árbol vacío
         * try {
         * BSTree<Integer> emptyBst = new BSTree<>();
         * System.out.println("Mínimo del BST vacío: " + emptyBst.findMin());
         * } catch (ExceptionIsEmpty e) {
         * System.out.println(e.getMessage());
         * }
         */
    }
}
