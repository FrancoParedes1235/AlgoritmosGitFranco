public class LinkedList<T extends Comparable<T>> implements TDAList<T> {
    protected Node<T> first;
    protected int count;

    public LinkedList() {
        this.first = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int length() {
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
        while (nodoAux != null && searchItem.compareTo(nodoAux.getData()) > 0) {
            idx++;
            nodoAux = nodoAux.getNext();
        }
        if (nodoAux != null && nodoAux.getData().equals(searchItem)) {
            return idx;
        }
        return -1;
    }

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

    public void deleteDuplicates() {
        Node<T> current = this.first;
        while (current != null) {
            Node<T> runner = current;
            while (runner.getNext() != null) {
                if (current.getData().compareTo(runner.getNext().getData()) == 0) {
                    runner.setNext(runner.getNext().getNext());
                    this.count--;
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }

    public void insertNth(T data, int position) {
        if (position < 0 || position > this.count) {
            System.out.println("Error: índice fuera de rango");
            return;
        }
        Node<T> newNode = new Node<>(data);
        if (position == 0) {
            newNode.setNext(this.first);
            this.first = newNode;
        } else {
            Node<T> current = this.first;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        this.count++;
    }

    public void deleteNth(int position) {
        if (position < 0 || position >= this.count) {
            System.out.println("Error: índice fuera de rango");
            return;
        }
        if (position == 0) {
            this.first = this.first.getNext();
        } else {
            Node<T> current = this.first;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        this.count--;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> aux = this.first;
        while (aux != null) {
            str.append(aux.toString()).append(",");
            aux = aux.getNext();
        }
        return str.toString();
    }
}
