package study.tree;

public class AVLNode {
	int key,height;
	
	AVLNode left,right;

	public AVLNode(int key) {
		super();
		this.key = key;
		this.height=1;
	}
	
}
