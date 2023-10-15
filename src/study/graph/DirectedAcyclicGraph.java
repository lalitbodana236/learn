package study.graph;

import java.util.ArrayList;
import java.util.Stack;

public class DirectedAcyclicGraph {
	public static int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj) {
		boolean vis[] = new boolean[V];
		Stack<Integer> stack = new Stack();
		
		for(int i=0;i<V;i++) {
			if(!vis[i]) {
				dfs(adj,i,stack,vis);
			}
		}
		int ans[] = new int[V];
		int i=0;
		while(!stack.isEmpty())
		{
			ans[i++]=stack.pop();
		}
		
		return ans;
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adj, int v, Stack<Integer> stack, boolean[] vis) {
		vis[v]=true;
		for(int neighbor :adj.get(v)) {
			if(!vis[neighbor]) {
				dfs(adj,neighbor,stack,vis);
			}
		}
		
		stack.push(v);
	}
}
