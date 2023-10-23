package study.tree;

public class DiameterOfBinaryTree {

	public static int diameter(Node root) {
		if(root==null) return 0;

		int dl = diameter(root.left);
		int dr = diameter(root.right);

		int cur = height(root.left)+height(root.right);

		return Math.max(cur, Math.max(dl, dr));
	}

	public static int height(Node root) {
		if(root==null) return 0;

		return 1+ Math.max(height(root.left), height(root.right));
	}
	
	int ans=0;
	public int heightDiameter(Node root) {
		if(root==null) return 0;
		
		int lh = heightDiameter(root.left);
		int rh = heightDiameter(root.right);
		
		ans = Math.max(ans,1+lh+rh);
		return 1+Math.max(lh, rh);
	}
}
