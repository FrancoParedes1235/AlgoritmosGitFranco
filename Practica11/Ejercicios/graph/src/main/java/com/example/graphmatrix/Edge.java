package com.example.graphmatrix;

public class Edge<E> {
    private Vertex<E> source;
    private Vertex<E> dest;
    private int weight;

    public Edge(Vertex<E> source, Vertex<E> dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex<E> getSource() {
        return source;
    }

    public Vertex<E> getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " -> " + dest + " (" + weight + ")";
    }
}
