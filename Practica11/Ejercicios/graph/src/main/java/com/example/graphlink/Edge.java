package com.example.graphlink;

public class Edge<X> {
    private Vertex<X> dest;
    private int weight;

    public Edge(Vertex<X> dest) {
        this(dest, -1);
    }

    public Edge(Vertex<X> dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex<X> getDest() {
        return dest;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge<?>) {
            @SuppressWarnings("unchecked")
            Edge<X> e = (Edge<X>) o;
            return this.dest.equals(e.dest);
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.weight > -1)
            return dest.getData() + " [" + this.weight + "], ";
        else
            return dest.getData() + ", ";
    }

    public void setDest(Vertex<X> dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
