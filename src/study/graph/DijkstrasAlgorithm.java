package study.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
	//find sortest path
	public static int[] spanningTree(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj,int S) {
		boolean[] vis = new boolean[V];
		
		PriorityQueue<Pair> q = new PriorityQueue<>();
		
		q.add(new Pair(S, 0));
		int[] ans= new int[V];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[S]=0;
		
		while(q.size()!=0) {
			Pair cur = q.remove();
			
			int u = cur.v;
			if(vis[u]) {
				continue;
			}
		//	ans+=cur.wt;
			vis[u]=true;
			
			ArrayList<ArrayList<Integer>> neighbors = adj.get(u);
			
			for(ArrayList<Integer> list : neighbors) {
				int vertex = list.get(0);
				
				int wt = list.get(1);
				if(ans[vertex] > ans[u]+wt) {
					ans[vertex] = ans[u]+wt;
					q.add(new Pair(vertex,ans[vertex]));
				}
			}
		}
		return ans;
		
	}
	
}
