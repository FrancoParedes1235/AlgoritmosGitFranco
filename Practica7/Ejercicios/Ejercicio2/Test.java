
public class Test {
    public static void main(String[] args) throws ItemNotFound {
        try {
            BSTree<Integer> bst1 = new BSTree<>();
            BSTree<Integer> bst2 = new BSTree<>();
            System.out.println(" ");

            // Insertar elementos en bst1
            bst1.insert(10);
            bst1.insert(5);
            bst1.insert(15);
            bst1.insert(1);
            bst1.insert(7);

            // Insertar elementos en bst2
            bst2.insert(20);
            bst2.insert(10);
            bst2.insert(30);
            bst2.insert(5);
            bst2.insert(15);

            // Comparar área de bst1 y bst2
            System.out.println("Área de bst1: " + bst1.area());
            System.out.println("Área de bst2: " + bst2.area());
            System.out.println("¿Tienen la misma área? " + sameArea(bst1, bst2));
        } catch (ItemDuplicated e) {
            System.err.println(e.getMessage());
        }
    }

    public static <E extends Comparable<E>> boolean sameArea(BSTree<E> bst1, BSTree<E> bst2) {
        return bst1.area() == bst2.area();
    }
}
