package ejercicio2;

import actividad2.QueueLink;
import actividad1.ExceptionIsEmpty;
import actividad3.PriorityQueue;

public class PriorityQueueLinked<E, P extends Comparable<P>> implements PriorityQueue<E, P> {
    private QueueLink<E>[] queues;
    private int numPriorities;

    public PriorityQueueLinked(int numPriorities) {
        this.numPriorities = numPriorities;
        queues = new QueueLink[numPriorities];
        for (int i = 0; i < numPriorities; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    @Override
    public void enqueue(E x, P pr) {
        int priorityIndex = prToIndex(pr);
        queues[priorityIndex].enqueue(x);
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("No se puede eliminar de una cola de prioridad vacía.");
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].front();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía.");
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        for (int i = numPriorities - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].back();
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía.");
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < numPriorities; i++) {
            if (!queues[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private int prToIndex(P pr) {
        // devuelve integer si pr es integer sino 0
        return pr instanceof Integer ? (Integer) pr : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PriorityQueueLinked: [");
        for (int i = 0; i < numPriorities; i++) {
            sb.append("Priority ").append(i).append(": ").append(queues[i]).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
