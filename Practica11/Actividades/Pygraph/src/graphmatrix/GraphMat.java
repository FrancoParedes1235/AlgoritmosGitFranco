package graphmatrix;

import java.util.*;

public class GraphMat<E> {
    private final Map<E, Integer> vertices;
    private final List<E> verticesList;
    private boolean[][] adjMatrix;
    private int[][] weightMatrix;
    private int size;

    public GraphMat(int initialCapacity) {
        vertices = new HashMap<>();
        verticesList = new ArrayList<>();
        adjMatrix = new boolean[initialCapacity][initialCapacity];
        weightMatrix = new int[initialCapacity][initialCapacity];
        for (int[] row : weightMatrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        size = 0;
    }

    public void insertVertex(E v) {
        if (!vertices.containsKey(v)) {
            vertices.put(v, size);
            verticesList.add(v);
            size++;
            if (size > adjMatrix.length) {
                resizeMatrix();
            }
        }
    }

    private void resizeMatrix() {
        int newSize = adjMatrix.length * 2;
        boolean[][] newAdjMatrix = new boolean[newSize][newSize];
        int[][] newWeightMatrix = new int[newSize][newSize];
        for (int[] row : newWeightMatrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < adjMatrix.length; i++) {
            System.arraycopy(adjMatrix[i], 0, newAdjMatrix[i], 0, adjMatrix.length);
            System.arraycopy(weightMatrix[i], 0, newWeightMatrix[i], 0, weightMatrix.length);
        }

        adjMatrix = newAdjMatrix;
        weightMatrix = newWeightMatrix;
    }

    public void insertEdge(E v, E z) {
        insertEdgeWeight(v, z, 1); // Default weight is 1
    }

    public void insertEdgeWeight(E v, E z, int weight) {
        Integer vIndex = vertices.get(v);
        Integer zIndex = vertices.get(z);
        if (vIndex != null && zIndex != null) {
            adjMatrix[vIndex][zIndex] = true;
            weightMatrix[vIndex][zIndex] = weight;
        }
    }

    public boolean searchVertex(E v) {
        return vertices.containsKey(v);
    }

    public boolean searchEdge(E v, E z) {
        Integer vIndex = vertices.get(v);
        Integer zIndex = vertices.get(z);
        return vIndex != null && zIndex != null && adjMatrix[vIndex][zIndex];
    }

    public void dfs(E start) {
        Integer startIndex = vertices.get(start);
        if (startIndex == null) {
            return;
        }

        boolean[] visited = new boolean[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(startIndex);

        while (!stack.isEmpty()) {
            int currentIndex = stack.pop();
            if (!visited[currentIndex]) {
                visited[currentIndex] = true;
                System.out.print(verticesList.get(currentIndex) + " ");
                for (int i = 0; i < size; i++) {
                    if (adjMatrix[currentIndex][i] && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
    }

    public int[][] floydWarshall() {
        int[][] dist = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (adjMatrix[i][j]) {
                    dist[i][j] = weightMatrix[i][j];
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }

    public List<E> dijkstra(E start, E end) {
        Integer startIndex = vertices.get(start);
        Integer endIndex = vertices.get(end);
        if (startIndex == null || endIndex == null) {
            return Collections.emptyList();
        }

        int[] dist = new int[size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startIndex] = 0;

        boolean[] visited = new boolean[size];
        PriorityQueue<VertexDistancePair> queue = new PriorityQueue<>(
                Comparator.comparingInt(VertexDistancePair::getDistance));
        queue.add(new VertexDistancePair(startIndex, 0));

        int[] prev = new int[size];
        Arrays.fill(prev, -1);

        while (!queue.isEmpty()) {
            VertexDistancePair pair = queue.poll();
            int current = pair.getVertex();
            if (visited[current])
                continue;
            visited[current] = true;

            for (int i = 0; i < size; i++) {
                if (adjMatrix[current][i] && !visited[i]) {
                    int newDist = dist[current] + weightMatrix[current][i];
                    if (newDist < dist[i]) {
                        dist[i] = newDist;
                        prev[i] = current;
                        queue.add(new VertexDistancePair(i, newDist));
                    }
                }
            }
        }

        List<E> path = new ArrayList<>();
        for (int at = endIndex; at != -1; at = prev[at]) {
            path.add(verticesList.get(at));
        }
        Collections.reverse(path);
        if (path.get(0).equals(start)) {
            return path;
        } else {
            return Collections.emptyList();
        }
    }

    public List<Edge<E>> prim(E start) {
        Integer startIndex = vertices.get(start);
        if (startIndex == null) {
            return Collections.emptyList();
        }

        boolean[] visited = new boolean[size];
        PriorityQueue<Edge<E>> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        List<Edge<E>> mst = new ArrayList<>();

        addEdges(startIndex, visited, queue);

        while (!queue.isEmpty() && mst.size() < size - 1) {
            Edge<E> edge = queue.poll();
            if (!visited[edge.getDest().getIndex()]) {
                mst.add(edge);
                addEdges(edge.getDest().getIndex(), visited, queue);
            }
        }

        return mst;
    }

    private void addEdges(int index, boolean[] visited, PriorityQueue<Edge<E>> queue) {
        visited[index] = true;
        for (int i = 0; i < size; i++) {
            if (adjMatrix[index][i] && !visited[i]) {
                queue.add(new Edge<>(new Vertex<>(verticesList.get(i), i), weightMatrix[index][i]));
            }
        }
    }

    public List<Edge<E>> kruskal() {
        PriorityQueue<Edge<E>> edges = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (adjMatrix[i][j]) {
                    edges.add(new Edge<>(new Vertex<>(verticesList.get(j), j), weightMatrix[i][j]));
                }
            }
        }

        UnionFind uf = new UnionFind(size);
        List<Edge<E>> mst = new ArrayList<>();

        while (!edges.isEmpty() && mst.size() < size - 1) {
            Edge<E> edge = edges.poll();
            int u = vertices.get(edge.getSource().getData());
            int v = vertices.get(edge.getDest().getData());
            if (uf.find(u) != uf.find(v)) {
                mst.add(edge);
                uf.union(u, v);
            }
        }

        return mst;
    }

    private static class VertexDistancePair {
        private final int vertex;
        private final int distance;

        public VertexDistancePair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int getVertex() {
            return vertex;
        }

        public int getDistance() {
            return distance;
        }
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    rank[rootP]++;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(verticesList.get(i)).append(" -> ");
            for (int j = 0; j < size; j++) {
                if (adjMatrix[i][j]) {
                    sb.append(verticesList.get(j)).append(", ");
                }
            }
            if (sb.length() > 4 && sb.charAt(sb.length() - 2) == ',') {
                sb.setLength(sb.length() - 2); // Remove the last comma and space
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
