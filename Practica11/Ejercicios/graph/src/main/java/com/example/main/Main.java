package com.example.main;

import com.example.graphmatrix.GraphMat;
import com.example.graphmatrix.Edge;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GraphMat<String> graph = new GraphMat<>(5);
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        graph.insertEdgeWeight("A", "B", 3);
        graph.insertEdgeWeight("A", "C", 8);
        graph.insertEdgeWeight("B", "C", 2);
        graph.insertEdgeWeight("B", "D", 5);
        graph.insertEdgeWeight("C", "D", 1);
        graph.insertEdgeWeight("D", "E", 4);
        graph.insertEdgeWeight("E", "A", 7);

        System.out.println("Grafo:");
        System.out.println(graph);

        System.out.println("\nDFS comenzando desde el vértice A:");
        graph.dfs("A");

        int[][] dist = graph.floydWarshall();
        System.out.println("\nCaminos más cortos usando Floyd-Warshall:");
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }

        List<String> path = graph.dijkstra("A", "E");
        System.out.println("\nCamino más corto de A a E usando Dijkstra:");
        System.out.println(path);

        List<Edge<String>> mstPrim = graph.prim("A");
        System.out.println("\nÁrbol de expansión mínima usando Prim:");
        for (Edge<String> edge : mstPrim) {
            System.out.println(edge);
        }

        List<Edge<String>> mstKruskal = graph.kruskal();
        System.out.println("\nÁrbol de expansión mínima usando Kruskal:");
        for (Edge<String> edge : mstKruskal) {
            System.out.println(edge);
        }
    }
}
