package actividad3;

import exeptions.ExceptionIsEmpty;
import node.Node;
import priorityq.PriorityQueue;

public class PriorityQueueLinkSort<E, P extends Comparable<P>> implements PriorityQueue<E, P> {

    class EntryNode {
        E data;
        P priority;

        EntryNode(E data, P priority) {
            this.data = data;
            this.priority = priority;
        }

        public E getData() {
            return data;
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    void enqueue(E x, P pr) {
        if (isEmpty()) {
            this.first = new Node<EntryNode>(new EntryNode(x, pr));
            this.last = this.first;
        } else if (pr.compareTo(this.first.getData().priority) < 0) {
            this.first = new Node<EntryNode>(new EntryNode(x, pr), this.first);
        } else {
            Node<EntryNode> aux = this.first;
            while (aux.getNext() != null && pr.compareTo(aux.getNext().getData().priority) >= 0) {
                aux = aux.getNext();
            }
            aux.setNext(new Node<EntryNode>(new EntryNode(x, pr), aux.getNext()));
            if (aux == this.last) {
                this.last = aux.getNext();
            }
        }
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("No se puede eliminar de una cola vacía.");
        }
        E data = this.first.getData().data;
        this.first = this.first.getNext();
        if (this.first == null) {
            this.last = null;
        }
        return data;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        return this.first.getData().getData();
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        return this.last.getData().getData();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public String toString() {
        String str = new String();
        Node<EntryNode> aux = this.first;
        while (aux != null) {
            str += aux.getData().getData() + " ";
            aux = aux.getNext();
        }
        return str;
    }

}
