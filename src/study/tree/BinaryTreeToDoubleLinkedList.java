package study.tree;

public class BinaryTreeToDoubleLinkedList {
	Node prev=null;
	Node head=null;
	
	public void convertToDll(Node root) {
		if(root==null) return;
		
		convertToDll(root.left);
		if(prev==null)
				head=root;
		else {
			root.left = prev;
			prev.right = root;
			
		}
		prev = root;
		convertToDll(root.right);
		
		
	}
}
