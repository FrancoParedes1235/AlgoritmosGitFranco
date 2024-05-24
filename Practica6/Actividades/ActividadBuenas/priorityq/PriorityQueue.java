package priorityq;

import exeptions.ExceptionIsEmpty;

public interface PriorityQueue<E, P> {


    E dequeue() throws ExceptionIsEmpty;

    E front() throws ExceptionIsEmpty;

    E back() throws ExceptionIsEmpty;

    boolean isEmpty();
}
