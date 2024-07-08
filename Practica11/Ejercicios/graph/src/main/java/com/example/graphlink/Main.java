package com.example.graphlink;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GraphLink<String> graph = new GraphLink<>();
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

        System.out.println("\n\nBFS starting from vertex A:");
        graph.bfs("A");

        System.out.println("\n\nPath from A to D:");
        List<String> path = graph.bfsPath("A", "D");
        System.out.println(path);

        graph.insertEdgeWeight("A", "B", 1);
        graph.insertEdgeWeight("A", "C", 2);
        graph.insertEdgeWeight("B", "D", 4);
        graph.insertEdgeWeight("C", "D", 1);

        System.out.println("\nShortest path from A to D:");
        List<String> shortestPath = graph.shortPath("A", "D");
        System.out.println(shortestPath);
    }
}
