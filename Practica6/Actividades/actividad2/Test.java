package actividad2;

import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        // Crear una cola de tipo entero
        Queue<Integer> queueInt = new QueueLink<>();

        // Agregar elementos a la cola
        queueInt.enqueue(10);
        queueInt.enqueue(20);
        queueInt.enqueue(30);
        queueInt.enqueue(40);
        queueInt.enqueue(50);

        // Mostrar la cola
        System.out.println("Cola de enteros:");
        System.out.println(queueInt);

        // Obtener el elemento frontal y final de la cola
        try {
            System.out.println("Elemento frontal: " + queueInt.front());
            System.out.println("Elemento final: " + queueInt.back());
        } catch (ExceptionIsEmpty e) {
            System.out.println("La cola está vacía.");
        }

        // Eliminar elementos de la cola
        try {
            System.out.println("Elemento eliminado: " + queueInt.dequeue());
            System.out.println("Elemento eliminado: " + queueInt.dequeue());
        } catch (ExceptionIsEmpty e) {
            System.out.println("La cola está vacía.");
        }

        // Mostrar la cola después de eliminar elementos
        System.out.println("Cola después de eliminar elementos:");
        System.out.println(queueInt);

        // Verificar si la cola está vacía
        System.out.println("¿La cola está vacía? " + queueInt.isEmpty());
    }
}
