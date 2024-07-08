package graphmatrix;

public class Main {
    public static void main(String[] args) {
        GraphMat<String> graph = new GraphMat<>(5);
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");

        graph.insertEdge("A", "B");
        graph.insertEdge("A", "C");
        graph.insertEdge("B", "D");
        graph.insertEdge("C", "D");

        System.out.println("Graph:");
        System.out.println(graph);

        System.out.println("\nDFS starting from vertex A:");
        graph.dfs("A");

        System.out.println("\n\nSearch Vertex B: " + graph.searchVertex("B"));
        System.out.println("Search Edge A -> C: " + graph.searchEdge("A", "C"));
    }
}
