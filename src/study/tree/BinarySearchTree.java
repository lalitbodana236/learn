package study.tree;

import java.util.HashSet;
import java.util.Set;

public class BinarySearchTree {

	boolean search(Node root,int x) {
		if(root==null) return false;

		if(root.data==x)
			return true;

		if(root.data>x)
			return search(root.left,x);

		return search(root.right,x);
	}

	Node insert(Node root,int key) {
		if(root==null)
			return new Node(key);

		if(root.data>key)
			root.left = insert(root.left, key);
		else if(root.data<key)
			root.right = insert(root.right, key);

		return root;
	}

	Node insertIt(Node root,int key) {
		Node newnode = new Node(key);
		Node cur =root;
		Node parent  = null;

		while(cur!=null) {
			parent = cur;
			if(key< cur.data)
				cur = cur.left;
			else
				cur = cur.right;
		}

		if(parent==null)
			return newnode;
		else if(key<parent.data)
			parent.left=newnode;
		else
			parent.right=newnode;

		return parent;

	}

	Node deleteNode(Node root,int key) {
		if(root == null) return root;

		if(key<root.data) root.left = deleteNode(root.left, key);
		else if(key > root.data) root.right = deleteNode(root.right, key);
		else {
			if(root.left == null)	return root.right;
			else if(root.right==null) return root.left;
			root.data=minValue(root.right);
			root.right=deleteNode(root.right, root.data);
		}
		return root;
	}

	private int minValue(Node root) {
		int minV = root.data;
		while(root.left!=null) {
			minV = root.left.data;
			root = root.left;
		}
		return minV;
	}

	boolean isBST(Node root) {
		return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	private boolean isBSTUtil(Node node, int minValue, int maxValue) {
		if(node==null) return true;

		if(node.data<minValue || node.data>maxValue) return false;

		return (isBSTUtil(node.left, minValue, node.data-1) && isBSTUtil(node.right, node.data+1, maxValue));

	}
	Node prev= null;
	boolean isBSTInorder(Node root) {
		if(root!=null) {
			if(!isBSTInorder(root.left)) return false;
			
			if(prev!=null && root.data<=prev.data) return false;
			
			prev = root;
			
			return isBSTInorder(root.right);
		}
		return true;
	}
	
	int floor(Node root,int key) {
		int ans = Integer.MAX_VALUE;
		while(root!=null) {
			if(root.data==key)	return root.data;
			
			if(root.data>key) 
				root = root.left;
			else {
				ans = root.data;
				root=root.right;
			}
		}
		return ans;
	}
	
	int ceil(Node root,int key) {
		int ans = Integer.MIN_VALUE;
		while(root!=null) {
			if(root.data==key)	return root.data;
			
			if(root.data>key) {
				ans = root.data;
				root = root.left;
			}	
			else {
				root=root.right;
			}
		}
		return ans;
	}
	
	int isPairPresent(Node root,int target) {
		Set<Integer> set = new HashSet<>();
		return util(root,target,set) ? 1 : 0;
	}
	
	boolean util(Node root,int sum,Set<Integer> set) {
		if(root==null) return false;
		if(util(root.left,sum,set)==true) {
			return true;
		}
		
		if(set.contains(sum-root.data))
			return true;
		set.add(root.data);
		
		return util(root.right,sum,set);
	}
	
	 public Node sortedArrayToBST(int[] nums) {
	        return createBinaryTree(nums, 0, nums.length - 1);
	    }

	    private Node createBinaryTree(int nums[], int l, int r) {
	        if (l > r) { 
	            return null;
	        }

	        int mid = l + (r - l) / 2; 
	        Node root = new Node(nums[mid]); 

	        root.left = createBinaryTree(nums, l, mid - 1); 
	                                                 
	        root.right = createBinaryTree(nums, mid + 1, r); 

	        return root;
	    }
}
