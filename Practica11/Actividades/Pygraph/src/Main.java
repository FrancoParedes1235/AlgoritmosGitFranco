
public class Main {
    public static void main(String[] args) {
        GraphLink<String> graph = new GraphLink<>();
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");

        graph.insertEdge("A", "B");
        graph.insertEdge("A", "C");
        graph.insertEdge("B", "C");

        System.out.println(graph);
    }
}
