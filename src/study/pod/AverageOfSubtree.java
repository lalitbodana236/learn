package study.pod;

import study.tree.Node;
import study.tree.TreeNode;

public class AverageOfSubtree {
	
	 static int count;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left=new TreeNode(8);
		root.right=new TreeNode(5);
		
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		
		root.right.right = new TreeNode(6);
		
		 solve(root);
	       System.out.println( count);
	}
	
	public static Pair solve(TreeNode root){
        if(root==null) {
            Pair p = new Pair(0,0);
            return p;
        }
        Pair left1 = solve(root.left);
        Pair right1 = solve(root.right);
        
        int n= left1.val+right1.val+1;
        
        int sum=root.val+left1.node+right1.node;
        
        int avg = sum/n;
        
        if(avg==root.val) 
        	count++;
        return new Pair(sum,n);
    }
	
	public static void inorder(TreeNode root) {
		if(root==null) {
			return;
		}
		
		//System.out.print(root.val);
		System.out.println();
		inorder(root.left);
		inorder(root.right);
	}
	
	

}

class Pair{
    int node;
    int val;
    public Pair(int a,int b){
        this.node=a;
        this.val=b;
    }
}
