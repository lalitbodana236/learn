package study.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
	//Minimum Spanning Tree
	
	public static int spanningTree(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		boolean[] vis = new boolean[V];
		
		PriorityQueue<Pair> q = new PriorityQueue<>();
		
		q.add(new Pair(0, 0));
		int ans=0;
		
		while(q.size()!=0) {
			Pair cur = q.remove();
			
			int u = cur.v;
			if(vis[u]) {
				continue;
			}
			ans+=cur.wt;
			vis[u]=true;
			
			ArrayList<ArrayList<Integer>> neighbors = adj.get(u);
			
			for(ArrayList<Integer> list : neighbors) {
				int vertex = list.get(0);
				
				int wt = list.get(1);
				
				if(!vis[vertex]) {
					q.add(new Pair(vertex,wt));
				}
			}
		}
		return ans;
		
	}
	
}

