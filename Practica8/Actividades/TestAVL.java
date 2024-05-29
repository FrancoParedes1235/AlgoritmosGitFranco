public class TestAVL {
    public static void main(String[] args) {
        try {
            // Crear un árbol AVL
            AVLTree<Integer> avl = new AVLTree<>();

            // Insertar elementos que causen rotaciones
            // Estas inserciones están diseñadas para causar rotaciones simples y dobles
            avl.insert(30); // Inserción inicial
            avl.insert(20); // Causará rotación a la izquierda en 30
            avl.insert(40); // Balanceado, no se requiere rotación
            avl.insert(10); // Causará rotación a la derecha en 20
            avl.insert(25); // Balanceado, no se requiere rotación
            avl.insert(35); // Causará rotación a la izquierda en 40
            avl.insert(50); // Balanceado, no se requiere rotación
            avl.insert(5); // Causará rotación a la derecha en 10
            avl.insert(15); // Causará rotación doble (derecha-izquierda) en 20
            avl.insert(27); // Causará rotación doble (izquierda-derecha) en 25

            // Mostrar el árbol en preorden de manera iterativa
            System.out.println("Recorrido PreOrden Iterativo:");
            avl.iterativePreOrden();
            System.out.println();

            // Mostrar el número total de nodos en el árbol
            System.out.println("Número total de nodos en el árbol: " + avl.countNodesRecursive());

            // Probar remociones que causen rebalanceo
            avl.remove(15); // Remoción de un nodo hoja
            avl.remove(25); // Remoción de un nodo con un solo hijo
            avl.remove(30); // Remoción de un nodo con dos hijos, causará rebalanceo

            System.out.println("Después de eliminar nodos:");
            avl.iterativePreOrden();
            System.out.println();
        } catch (ItemDuplicated | ItemNotFound e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
