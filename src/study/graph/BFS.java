package study.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	
	 public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
	        ArrayList<Integer> traversal = new ArrayList<>();
		    Queue<Integer> queue = new LinkedList<>();
		
			int size = adj.size();
			boolean[] visited = new boolean[size];
			queue.add(0);
			visited[0] = true;
			
			while(!queue.isEmpty()){
				int pop = queue.poll();
				traversal.add(pop);
				for(int i = 0 ; i < adj.get(pop).size() ; i++){
					int current = adj.get(pop).get(i);
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
