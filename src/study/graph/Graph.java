package study.graph;

import java.util.ArrayList;
import java.util.List;

// Base class for representing a graph
public class Graph {
    protected int[][] adjacencyMatrix;
    protected List<List<Integer>> adjacencyList;
    protected int numVertices;

    public Graph(int vertices) {
        numVertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyList.get(source).add(destination);
    }

    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printAdjacencyList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

// WeightedGraph inherits from Graph
class WeightedGraph extends Graph {
    private int[][] weightedAdjacencyMatrix;
    private List<List<WeightedEdge>> weightedAdjacencyList;

    public WeightedGraph(int vertices) {
        super(vertices);
        weightedAdjacencyMatrix = new int[vertices][vertices];
        weightedAdjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            weightedAdjacencyList.add(new ArrayList<>());
        }
    }

    public void addWeightedEdge(int source, int destination, int weight) {
        weightedAdjacencyMatrix[source][destination] = weight;
        weightedAdjacencyList.get(source).add(new WeightedEdge(destination, weight));
    }

    public void printWeightedAdjacencyMatrix() {
        System.out.println("Weighted Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(weightedAdjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printWeightedAdjacencyList() {
        System.out.println("Weighted Adjacency List:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " -> ");
            for (WeightedEdge edge : weightedAdjacencyList.get(i)) {
                System.out.print(edge.destination + " (w=" + edge.weight + ") ");
            }
            System.out.println();
        }
    }
}

class WeightedEdge {
    int destination;
    int weight;

    public WeightedEdge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}







