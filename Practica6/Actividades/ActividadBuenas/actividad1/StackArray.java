package actividad1;

public class StackArray<E> implements Stack<E> {
    private E[] array;
    private int tope;
    private int capacity;

    public StackArray(int capacity) {
        this.array = (E[]) new Object[capacity];
        this.capacity = capacity;
        tope = -1;
    }

    public void push(E x) {
        if (isFull()) {
            System.out.println("La pila está llena. No se puede agregar más elementos.");
            return;
        }
        tope++;
        array[tope] = x;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía. No se puede realizar pop.");
        }
        E element = array[tope];
        array[tope] = null;
        tope--;
        return element;
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía. No se puede obtener el elemento superior.");
        }
        return array[tope];
    }

    public boolean isEmpty() {
        return this.tope == -1;
    }

    public boolean isFull() {
        return this.tope == capacity - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        for (int i = tope; i >= 0; i--) {
            sb.append(array[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
