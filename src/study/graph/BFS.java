package study.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		int n=3;  

		int[][] edges = new int[10][10];
		int[][] trust = {{1,3},{2,3},{3,1}};
		int[] trusted = new int[n + 1];
        int[] untrusted = new int[n + 1];
       
        for (int[] t : trust){
            trusted[t[1]]++;
            untrusted[t[0]]++;
        }
        
        for (int t : trusted){
        	System.out.println("t "+t);
        }
        
        for (int t : untrusted){
        	System.out.println("u "+t);
        }

        for (int i = 1; i < n + 1; i++){
            if (trusted[i] == n - 1 && untrusted[i] == 0)
                System.out.println("inside if " +i);         
        }
		
		
		 ArrayList< ArrayList<Integer>> adjacencyList = new ArrayList();
		 
		 for (int i = 0; i < n; i++) {
		        adjacencyList.add(new ArrayList<>());
		    }
		    
		    for (int[] edge : edges) {
		        int u = edge[0];
		        int v = edge[1];
		        adjacencyList.get(u).add(v);
		        adjacencyList.get(v).add(u); // Assuming it's an undirected graph
		    }


	}
	
	private static boolean bfs(ArrayList<ArrayList<Integer>> adj,int src,int dest,int v,int pred[] ,int dist[]) {
		
		LinkedList<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[v];
		for(int i=0;i<v;i++) {
			visited[i]=false;
			dist[i]=Integer.MAX_VALUE;
			pred[i]=-1;
		}
		
		visited[src] = true;
		dist[src]=0;
		queue.add(src);
		
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			for(int i=0;i<adj.get(v).size();i++) {
				int neighbor= adj.get(v).get(i);
				if(visited[neighbor]==false) {
					visited[neighbor]  = true;
					dist[neighbor] = dist[cur]+1;
					pred[neighbor] = cur;
					queue.add(neighbor);
					
					
					
					if(neighbor==dest) {
						return true;
					}
					
				}
			}
		}
		
		return false;
		
	}
	
	 public static ArrayList<Integer> bfsOfGraph(int v, List<List<Integer>> adjacencyList) {
	        ArrayList<Integer> traversal = new ArrayList<>();
		    Queue<Integer> queue = new LinkedList<>();
		
			int size = adjacencyList.size();
			boolean[] visited = new boolean[size];
			queue.add(0);
			visited[0] = true;
			
			while(!queue.isEmpty()){
				int pop = queue.poll();
				traversal.add(pop);
				for(int i = 0 ; i < adjacencyList.get(pop).size() ; i++){
					int current = adjacencyList.get(pop).get(i);
					if(!traversal.contains(current) && visited[current] != true){
						queue.add(current);
						visited[current] = true;
					}
				}
					//System.out.println("q : "+queue);
				//	System.out.println("t : "+traversal);
			}
			return traversal;
	    }

}
