package graphmatrix;

public class Edge<E> {
    private Vertex<E> dest;
    private int weight;

    public Edge(Vertex<E> dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex<E> getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "(" + dest + ", " + weight + ")";
    }
}
