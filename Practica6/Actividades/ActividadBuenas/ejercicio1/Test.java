package ejercicio1;

import exeptions.ExceptionIsEmpty;
import stack.Stack;

public class Test {
    public static void main(String[] args) {
        // Crear una pila de tipo String
        Stack<Integer> stack = new StackLink<>();

        // Agregar elementos a la pila
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Mostrar la pila
        System.out.println("Pila:");
        System.out.println(stack);

        // Obtener y eliminar el elemento en la cima de la pila
        try {
            System.out.println("Elemento en la cima de la pila: " + stack.top());
            System.out.println("Elemento eliminado de la cima de la pila: " + stack.pop());
        } catch (ExceptionIsEmpty e) {
            System.out.println("La pila está vacía.");
        }

        // Mostrar la pila después de eliminar un elemento
        System.out.println("Pila después de eliminar un elemento:");
        System.out.println(stack);

        // Verificar si la pila está vacía
        System.out.println("¿La pila está vacía? " + stack.isEmpty());
    }
}
