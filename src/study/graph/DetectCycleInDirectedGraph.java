package study.graph;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[V];
		boolean[] recS = new boolean[V];
		
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				if(dfs(i,adj,visited,-1,recS))
					return true;
			}
		}
		return false;
	}

	private boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent,boolean[] recS) {
		visited[v]=true;
		recS[v]=true;
		for(Integer neighbor : adj.get(v)) {
			if(!visited[neighbor]) {
				if(dfs(neighbor, adj, visited, v,recS))
					return true;
			}else if(recS[neighbor]) {
				return true;
			}
		}
		recS[v]=false;
		return false;
	}
}
