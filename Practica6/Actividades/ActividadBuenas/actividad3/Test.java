package actividad3;

import exeptions.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        // Crear una cola de prioridad de tipo String y Integer
        PriorityQueueLinkSort<String, Integer> priorityQueue = new PriorityQueueLinkSort<>();

        // Agregar elementos a la cola de prioridad
        priorityQueue.enqueue("Tarea 1", 3);
        priorityQueue.enqueue("Tarea 2", 1);
        priorityQueue.enqueue("Tarea 3", 2);

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
