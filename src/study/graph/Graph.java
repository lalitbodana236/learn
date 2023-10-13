package study.graph;

import java.util.LinkedList;
import java.util.Scanner;

public class Graph {

	public static void main(String[] args) {
		int v = 5;
		int e =10;
		LinkedList<LinkedList<Integer>> adj = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		for(int i=0; i< v ;i++) {
			adj.add(new LinkedList<Integer>());
		}
		int source=0;
		int dest=0;
		addEdge(adj,source,dest)

	}
	
	static void addEdge(LinkedList<LinkedList<Integer>> adj, int source,int dest) {
		adj.get(source).add(dest);
		adj.get(dest).add(source);
	}

}
