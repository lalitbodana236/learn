package study.tree;

import java.awt.geom.QuadCurve2D;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversalBT {
	ArrayList<Integer> verticalOrder(Node root){
		Queue<Pair> q = new ArrayDeque<>();
		
		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
		q.add(new Pair(0, root));
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			if(map.containsKey(cur.hd)) {
				map.get(cur.hd).add(cur.node.data);
			}else {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(cur.node.data);
				map.put(cur.hd, temp);
			}
			
			if(cur.node.left!=null) {
				q.add(new Pair(cur.hd-1, cur.node.left));
			}
			if(cur.node.right!=null) {
				q.add(new Pair(cur.hd+1, cur.node.right));
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		for(Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()) {
			ans.addAll(entry.getValue());
		}
		
		return ans;
	}
}
