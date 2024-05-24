package ejercicio1;

import exeptions.ExceptionIsEmpty;

import node.Node;
import stack.Stack;

public class StackLink<T> implements Stack<T> {
    private Node<T> top;

    public StackLink() {
        this.top = null;
    }

    @Override
    public void push(T x) {
        this.top = new Node<T>(x, this.top);
    }

    @Override
    public T pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("es empty");
        }
        T data = top.getData();
        top = top.getNext();
        return data;
    }

    @Override
    public T top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("es empty");
        }
        return top.getData();
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public String toString() {
        String str = new String();
        Node<T> aux = top;
        while (aux != null) {
            str += aux.getData() + " ";
            aux = aux.getNext();
        }
        return str;
    }

}
