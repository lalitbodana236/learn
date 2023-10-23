package study.tree;

public class BurnTree {
	public int minTime(Node root,int target) {
		Depth depth = new Depth(-1);
		burn(root,target,depth);
		return ans;
	}
	static int ans = -1;
	
	private int burn(Node root, int target, Depth depth) {
		if(root == null) return 0;
		
		if(root.data == target) {
			depth.d = 1;
			return 1;
		}
		
		Depth ld = new Depth(-1);
		Depth rd = new Depth(-1);
		int lh =burn(root.left,target,ld);
		int rh = burn(root.right,target,rd);
		
		if(ld.d != -1) {
			ans = Math.max(ans, ld.d+1+rh);
			depth.d = ld.d+1;
		}else if(rd.d!=-1) {
			ans = Math.max(ans, rd.d+1+lh);
			depth.d= rd.d+1;
		}
		return Math.max(lh, rh)+1;
	}
}
 class Depth{
	int d;
	public Depth(int d) {
	this.d=d;
	}
}
