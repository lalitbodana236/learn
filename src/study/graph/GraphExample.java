package study.graph;

public class GraphExample {
    public static void main(String[] args) {
        int vertices = 5;

        // Create an unweighted, undirected graph
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.printAdjacencyMatrix();
        System.out.println();
        graph.printAdjacencyList();

        System.out.println();

        // Create a weighted, directed graph
        WeightedGraph weightedGraph = new WeightedGraph(vertices);
        weightedGraph.addWeightedEdge(0, 1, 3);
        weightedGraph.addWeightedEdge(0, 2, 5);
        weightedGraph.addWeightedEdge(2, 4, 2);
        weightedGraph.printWeightedAdjacencyMatrix();
        System.out.println();
        weightedGraph.printWeightedAdjacencyList();
    }
}

