package actividad1;

public class Test {
    public static void main(String[] args) {
        // Crear una pila de capacidad 5 para enteros
        Stack<Integer> stackInt = new StackArray<>(5);

        // Agregar elementos a la pila
        stackInt.push(10);
        stackInt.push(20);
        stackInt.push(30);
        stackInt.push(40);
        stackInt.push(50);

        // Mostrar la pila
        System.out.println("Pila de enteros:");
        System.out.println(stackInt);

        // Obtener el elemento superior de la pila sin eliminarlo
        try {
            System.out.println("Elemento superior: " + stackInt.top());
        } catch (ExceptionIsEmpty e) {
            System.out.println("La pila está vacía.");
        }

        // Eliminar elementos de la pila
        try {
            System.out.println("Elemento eliminado: " + stackInt.pop());
            System.out.println("Elemento eliminado: " + stackInt.pop());
        } catch (ExceptionIsEmpty e) {
            System.out.println("La pila está vacía.");
        }

        // Mostrar la pila después de eliminar elementos
        System.out.println("Pila después de eliminar elementos:");
        System.out.println(stackInt);

        // Verificar si la pila está vacía
        System.out.println("¿La pila está vacía? " + stackInt.isEmpty());
    }
}
