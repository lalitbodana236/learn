package study.tree;

public class AVLTree {
	
	AVLNode root;
	
	int height(AVLNode N) {
		if(N==null)	return 0;
		return N.height;
	}
	
	int max(int a,int b) {
		return (a>b)? a: b;
	}
	
	
	
}
