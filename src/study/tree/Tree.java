package study.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Tree {
	static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Node root = createTree();

		System.out.println("*******************");
		System.out.println();

		inorder(root);

		System.out.println();
		System.out.println("*******************");

		preorder(root);

		System.out.println();
		System.out.println("*******************");

		postorder(root);
	}

	static Node createTree() {
		Node root = null;

		System.out.println("enter data");
		int data = sc.nextInt();
		if(data == -1) return null;

		root = new Node(data);

		System.out.println("enter for left "+data);
		root.left = createTree();

		System.out.println("enter for right "+data);
		root.right = createTree();

		return root;
	}

	static void inorder(Node root) {

		if(root == null) return;

		inorder(root.left);

		System.out.print(root.data+" ");

		inorder(root.right);

	}

	static void preorder(Node root) {

		if(root == null) return;

		System.out.print(root.data+" ");

		preorder(root.left);

		preorder(root.right);

	}

	static void postorder(Node root) {

		if(root == null) return;

		postorder(root.left);

		postorder(root.right);

		System.out.print(root.data+" ");

	}

	static int height(Node root) {
		if(root == null) return 0;

		return Math.max(height(root.left), height(root.right))+1;
	}

	static int size(Node root) {
		if(root == null) return 0;

		return size(root.left) + size(root.right) + 1;
	}

	static int maximum(Node root) {
		if(root == null) return Integer.MIN_VALUE;

		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
	}

	static int minimum(Node root) {
		if(root == null) return Integer.MAX_VALUE;

		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}

	static void printCurrentLevel(Node root,int level) {
		if(root == null) return ;

		if(level == 1) System.out.print(root.data+" ");
		else if( level > 1) {
			printCurrentLevel(root.left,level-1);
			printCurrentLevel(root.right,level-1);

		}
	}

	static void printLevelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();

		q.add(root);
		//for print next level in new line
		//	q.add(null);

		while(!q.isEmpty()) {
			Node cur = q.poll();
			//for print next level in new line
			/*	if(cur==null) {
				if(q.isEmpty())
					return ;
				q.add(null);
				System.out.println();
				continue;
			}*/
			//for print next level in new line

			System.out.print(cur.data);

			if(cur.left!= null) {
				q.add(cur.left);
			}
			if(cur.right!=null) {
				q.add(cur.right);
			}
		}
	}

	static void  printLeftView(Node root) {
		ArrayList<Node> list = new ArrayList<>();

		printLeftViewUtil(root,list,0);

		for(Node cur : list) {
			System.out.print(cur.data+" ");
		}
	}

	private static void printLeftViewUtil(Node root, ArrayList<Node> list, int level) {
		if(root==null)	return ;

		if(list.get(level)==null)
			list.add(root);

		printLeftViewUtil(root.left,list,level+1);
		printLeftViewUtil(root.right,list,level+1);
	}

	static void  printRightView(Node root) {
		ArrayList<Node> list = new ArrayList<>();

		printRightViewUtil(root,list,0);

		for(Node cur : list) {
			System.out.print(cur.data+" ");
		}
	}

	private static void printRightViewUtil(Node root, ArrayList<Node> list, int level) {
		if(root==null)	return ;

		if(list.get(level)==null)
			list.add(root);

		printRightViewUtil(root.right,list,level+1);
		printRightViewUtil(root.left,list,level+1);

	}

	static ArrayList<Integer> topView(Node root){
		Queue<Pair> q = new ArrayDeque<>();

		Map<Integer, Integer> map = new TreeMap<>();

		q.add(new Pair(0,root));

		while(!q.isEmpty()) {
			Pair cur = q.poll();

			if(!map.containsKey(cur.hd)) {
				map.put(cur.hd, cur.node.data);
			}

			if(cur.node.left!=null) {
				q.add(new Pair(cur.hd-1,cur.node.left));
			}
			if(cur.node.right!=null) {
				q.add(new Pair(cur.hd+1,cur.node.right));
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}

		return ans;

	}


	static ArrayList<Integer> bottomView(Node root){
		Queue<Pair> q = new ArrayDeque<>();

		Map<Integer, Integer> map = new TreeMap<>();

		q.add(new Pair(0,root));

		while(!q.isEmpty()) {
			Pair cur = q.poll();

			map.put(cur.hd, cur.node.data);

			if(cur.node.left!=null) {
				q.add(new Pair(cur.hd-1,cur.node.left));
			}
			if(cur.node.right!=null) {
				q.add(new Pair(cur.hd+1,cur.node.right));
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}

		return ans;

	}




}
