package study.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithm {
	public static int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj) {
		boolean vis[] = new boolean[V];
		int inDeg[] = new int[V];
		for(ArrayList<Integer> list : adj) {
			for(Integer e : list) {
				inDeg[e]++;
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		bfs(adj,V,vis,ans,inDeg);
		
		int ans1[] = new int[V];
		
		
		return ans1;
	}

	private static void bfs(ArrayList<ArrayList<Integer>> adj, int V, boolean[] vis, ArrayList<Integer> ans,
			int[] inDeg) {
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<V;i++) {
			if(inDeg[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur= q.poll();
			ans.add(cur);
			
			for(int neighbor : adj.get(cur)) {
				if(--inDeg[neighbor]==0) {
					q.add(neighbor);
				}
			}
		}
	}
}
