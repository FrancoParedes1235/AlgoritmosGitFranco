package graphmatrix;

public class Vertex<E> {
    private E data;
    private int index;

    public Vertex(E data, int index) {
        this.data = data;
        this.index = index;
    }

    public E getData() {
        return data;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex<?>) {
            Vertex<?> v = (Vertex<?>) o;
            return this.data.equals(v.data);
        }
        return false;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
