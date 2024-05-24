public class OrderListLinked<T extends Comparable<T>> extends LinkedList<T> {

    public OrderListLinked() {
        super();
    }

    @Override
    public int search(T searchItem) {
        int idx = 0;
        Node<T> nodoAux = this.first;
        while (nodoAux != null && searchItem.compareTo(nodoAux.getData()) > 0) {
            idx++;
            nodoAux = nodoAux.getNext();
        }
        if (nodoAux != null && nodoAux.getData().equals(searchItem)) {
            return idx;
        }
        return -1;
    }

    @Override
    public void insert(T newItem) {
        Node<T> nodoNuevo = new Node<>(newItem);
        if (this.first == null || newItem.compareTo(this.first.getData()) < 0) {
            nodoNuevo.setNext(this.first);
            this.first = nodoNuevo;
        } else {
            Node<T> nodoAux = this.first;
            while (nodoAux.getNext() != null && newItem.compareTo(nodoAux.getNext().getData()) > 0) {
                nodoAux = nodoAux.getNext();
            }
            nodoNuevo.setNext(nodoAux.getNext());
            nodoAux.setNext(nodoNuevo);
        }
        this.count++;
    }

    @Override
    public void remove(T deleteItem) {
        if (this.first == null) {
            return;
        }
        if (this.first.getData().equals(deleteItem)) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }
        Node<T> nodoAux = this.first;
        while (nodoAux.getNext() != null && !nodoAux.getNext().getData().equals(deleteItem)) {
            nodoAux = nodoAux.getNext();
        }
        if (nodoAux.getNext() != null) {
            nodoAux.setNext(nodoAux.getNext().getNext());
            this.count--;
        }
    }
}
