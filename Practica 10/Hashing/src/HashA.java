import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class HashA<E extends Comparable<E>> {

    protected class Element {
        int key;
        E value;

        public Element(int key, E value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + ":" + value.toString();
        }
    }

    protected ArrayList<LinkedList<Element>> table;
    protected int m;

    public HashA(int n) {
        this.m = n;
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            this.table.add(new LinkedList<>());
        }
    }

    private int functionHash(int key) {
        return key % m;
    }

    public void insert(int key, E value) {
        int hash = functionHash(key);
        LinkedList<Element> chain = table.get(hash);
        for (Element element : chain) {
            if (element.key == key) {
                element.value = value; // Reemplazar valor si la clave ya existe
                return;
            }
        }
        chain.add(new Element(key, value));
    }

    public E search(int key) {
        int hash = functionHash(key);
        LinkedList<Element> chain = table.get(hash);
        for (Element element : chain) {
            if (element.key == key) {
                return element.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Index\tChain\n");
        for (int i = 0; i < m; i++) {
            s.append(i).append(" --> ").append(table.get(i).toString()).append("\n");
        }
        return s.toString();
    }
}
