public class LinkedList<T> implements TDAList<T> {
    protected Node<T> first;
    protected int count;

    public LinkedList() {
        this.first = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int lenght() {
        return this.count;
    }

    public void destroyList() {
        while (this.first != null) {
            this.first = first.getNext();
        }
        this.count = 0;
    }

    public int search(T searchItem) {
        int idx = 0;
        Node<T> nodoAux = this.first;
        while (nodoAux != null && nodoAux.getData().equals(searchItem)) {
            idx++;
            nodoAux = nodoAux.getNext();
        }
        if (nodoAux != null) {
            return idx;
        }
        return -1;
    }

    public void insertFirst(T newItem) {
        this.first = new Node<T>(newItem, this.first);
        this.count++;
        return;
    }

    public void insertLast(T newItem) {
        Node<T> nodoNuevo = new Node<T>(newItem);
        if (this.isEmpty()) {
            this.first = nodoNuevo;
            this.count++;
            return;
        }
        Node<T> nodoAux = this.first;
        while (nodoAux.getNext() != null) {
            nodoAux = nodoAux.getNext();
        }
        nodoAux.setNext(nodoNuevo);
        this.count++;
    }

    public void remove(T deleteItem) {
        if (this.first.getData().equals(deleteItem)) {
            this.first = this.first.getNext();
            return;
        }
        Node<T> nodoAux = this.first;
        while (nodoAux.getNext() != null) {
            if (nodoAux.getNext().getData().equals(deleteItem)) {
                nodoAux.setNext(nodoAux.getNext().getNext());
                return;
            }
            nodoAux = nodoAux.getNext();
        }
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> aux = this.first;
        for (; aux != null; aux = aux.getNext()) {
            str += aux.toString() + ",";
        }
        return str;
    }

}
