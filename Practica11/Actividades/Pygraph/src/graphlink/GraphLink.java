package graphlink;

import java.util.*;

public class GraphLink<E> {
    protected LinkedList<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new LinkedList<>();
    }

    public void insertVertex(E data) {
        Vertex<E> newVertex = new Vertex<>(data);
        if (!listVertex.contains(newVertex)) {
            listVertex.add(newVertex);
        }
    }

    public void insertEdge(E verOri, E verDes) {
        Vertex<E> v1 = findVertex(verOri);
        Vertex<E> v2 = findVertex(verDes);
        if (v1 != null && v2 != null) {
            v1.adjList.add(new Edge<>(v2));
        }
    }

    public void insertEdgeWeight(E verOri, E verDes, int weight) {
        Vertex<E> v1 = findVertex(verOri);
        Vertex<E> v2 = findVertex(verDes);
        if (v1 != null && v2 != null) {
            v1.adjList.add(new Edge<>(v2, weight));
        }
    }

    private Vertex<E> findVertex(E data) {
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(data)) {
                return vertex;
            }
        }
        return null;
    }

    public boolean searchVertex(E data) {
        return findVertex(data) != null;
    }

    public boolean searchEdge(E verOri, E verDes) {
        Vertex<E> v1 = findVertex(verOri);
        if (v1 != null) {
            for (Edge<E> edge : v1.adjList) {
                if (edge.getDest().getData().equals(verDes)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeVertex(E data) {
        Vertex<E> vertexToRemove = findVertex(data);
        if (vertexToRemove != null) {
            listVertex.remove(vertexToRemove);
            for (Vertex<E> vertex : listVertex) {
                vertex.adjList.removeIf(edge -> edge.getDest().equals(vertexToRemove));
            }
        }
    }

    public void removeEdge(E verOri, E verDes) {
        Vertex<E> v1 = findVertex(verOri);
        Vertex<E> v2 = findVertex(verDes);
        if (v1 != null && v2 != null) {
            v1.adjList.removeIf(edge -> edge.getDest().equals(v2));
        }
    }

    public void dfs(E start) {
        Vertex<E> startVertex = findVertex(start);
        if (startVertex != null) {
            Stack<Vertex<E>> stack = new Stack<>();
            stack.push(startVertex);

            while (!stack.isEmpty()) {
                Vertex<E> current = stack.pop();
                if (!current.isVisited()) {
                    current.setVisited(true);
                    System.out.print(current.getData() + " ");
                    for (Edge<E> edge : current.adjList) {
                        if (!edge.getDest().isVisited()) {
                            stack.push(edge.getDest());
                        }
                    }
                }
            }
            // Reset visited status for all vertices
            for (Vertex<E> vertex : listVertex) {
                vertex.setVisited(false);
            }
        }
    }

    public void bfs(E start) {
        Vertex<E> startVertex = findVertex(start);
        if (startVertex != null) {
            Queue<Vertex<E>> queue = new LinkedList<>();
            queue.add(startVertex);
            startVertex.setVisited(true);

            while (!queue.isEmpty()) {
                Vertex<E> current = queue.poll();
                System.out.print(current.getData() + " ");
                for (Edge<E> edge : current.adjList) {
                    Vertex<E> neighbor = edge.getDest();
                    if (!neighbor.isVisited()) {
                        neighbor.setVisited(true);
                        queue.add(neighbor);
                    }
                }
            }
            // Reset visited status for all vertices
            for (Vertex<E> vertex : listVertex) {
                vertex.setVisited(false);
            }
        }
    }

    public List<E> bfsPath(E start, E end) {
        Vertex<E> startVertex = findVertex(start);
        Vertex<E> endVertex = findVertex(end);
        List<E> path = new ArrayList<>();
        if (startVertex != null && endVertex != null) {
            Queue<Vertex<E>> queue = new LinkedList<>();
            Map<Vertex<E>, Vertex<E>> parentMap = new HashMap<>();
            queue.add(startVertex);
            startVertex.setVisited(true);
            parentMap.put(startVertex, null);

            while (!queue.isEmpty()) {
                Vertex<E> current = queue.poll();
                if (current.equals(endVertex)) {
                    break;
                }
                for (Edge<E> edge : current.adjList) {
                    Vertex<E> neighbor = edge.getDest();
                    if (!neighbor.isVisited()) {
                        neighbor.setVisited(true);
                        parentMap.put(neighbor, current);
                        queue.add(neighbor);
                    }
                }
            }
            // Build the path
            Vertex<E> step = endVertex;
            while (step != null) {
                path.add(0, step.getData());
                step = parentMap.get(step);
            }
            // Reset visited status for all vertices
            for (Vertex<E> vertex : listVertex) {
                vertex.setVisited(false);
            }
        }
        return path;
    }

    public List<E> shortPath(E start, E end) {
        Vertex<E> startVertex = findVertex(start);
        Vertex<E> endVertex = findVertex(end);
        List<E> path = new ArrayList<>();
        if (startVertex != null && endVertex != null) {
            PriorityQueue<VertexDistancePair<E>> queue = new PriorityQueue<>(
                    Comparator.comparingInt(VertexDistancePair::getDistance));
            Map<Vertex<E>, Integer> distances = new HashMap<>();
            Map<Vertex<E>, Vertex<E>> parentMap = new HashMap<>();

            for (Vertex<E> vertex : listVertex) {
                distances.put(vertex, Integer.MAX_VALUE);
            }
            distances.put(startVertex, 0);
            queue.add(new VertexDistancePair<>(startVertex, 0));

            while (!queue.isEmpty()) {
                VertexDistancePair<E> currentPair = queue.poll();
                Vertex<E> current = currentPair.getVertex();

                for (Edge<E> edge : current.adjList) {
                    Vertex<E> neighbor = edge.getDest();
                    int newDist = distances.get(current) + edge.getWeight();
                    if (newDist < distances.get(neighbor)) {
                        distances.put(neighbor, newDist);
                        parentMap.put(neighbor, current);
                        queue.add(new VertexDistancePair<>(neighbor, newDist));
                    }
                }
            }
            // Build the path
            Vertex<E> step = endVertex;
            while (step != null) {
                path.add(0, step.getData());
                step = parentMap.get(step);
            }
        }
        return path;
    }

    @Override
    public String toString() {
        return this.listVertex.toString();
    }

    // Inner class for Dijkstra's algorithm
    private static class VertexDistancePair<E> {
        private final Vertex<E> vertex;
        private final int distance;

        public VertexDistancePair(Vertex<E> vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public Vertex<E> getVertex() {
            return vertex;
        }

        public int getDistance() {
            return distance;
        }
    }
}
