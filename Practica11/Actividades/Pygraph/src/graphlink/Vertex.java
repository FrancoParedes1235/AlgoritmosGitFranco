package graphlink;

import java.util.LinkedList;

public class Vertex<X> {
    private X data;
    protected LinkedList<Edge<X>> adjList;
    private boolean visited; // para el recorrido

    public Vertex(X data) {
        this.data = data;
        this.adjList = new LinkedList<>();
        this.visited = false; // inicializamos como no visitado
    }

    public X getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex<?>) {
            @SuppressWarnings("unchecked")
            Vertex<X> v = (Vertex<X>) o;
            return this.data.equals(v.data);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.data).append(" -> ");
        for (Edge<X> edge : this.adjList) {
            sb.append(edge.getDest().getData());
            if (edge.getWeight() > -1) {
                sb.append(" [").append(edge.getWeight()).append("]");
            }
            sb.append(", ");
        }
        if (!this.adjList.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove last comma and space
        }
        sb.append("\n");
        return sb.toString();
    }

}
