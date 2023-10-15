package study.graph;

public class GraphMatrix {
	static int a[][];
	public static void main(String[] args) {
		int v = 5;
		int e =10;
		 a= new int[v+1][v+1];

	}
	
	static void addEdge(int source,int dest) {
		a[source][dest] = 1;
		a[dest][source] = 1;
	}

}
