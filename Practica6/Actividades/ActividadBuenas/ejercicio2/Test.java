package ejercicio2;

import actividad1.ExceptionIsEmpty;
import actividad3.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        // Crear una cola de prioridad de tipo String e Integer con 3 prioridades
        PriorityQueue<String, Integer> priorityQueue = new PriorityQueueLinked<>(3);

        // Agregar elementos a la cola de prioridad
        priorityQueue.enqueue("a", 2);
        priorityQueue.enqueue("b", 1);
        priorityQueue.enqueue("c", 0);
        priorityQueue.enqueue("d", 1);

        // Mostrar la cola de prioridad
        System.out.println("Cola de prioridad:");
        System.out.println(priorityQueue);

        // Obtener y eliminar el elemento del frente de la cola de prioridad
        try {
            System.out.println("Elemento del frente: " + priorityQueue.front());
            System.out.println("Elemento eliminado del frente: " + priorityQueue.dequeue());
        } catch (ExceptionIsEmpty e) {
            System.out.println("La cola de prioridad está vacía.");
        }

        // Mostrar la cola de prioridad después de eliminar un elemento
        System.out.println("Cola de prioridad después de eliminar un elemento:");
        System.out.println(priorityQueue);

        // Verificar si la cola de prioridad está vacía
        System.out.println("¿La cola de prioridad está vacía? " + priorityQueue.isEmpty());
    }
}
