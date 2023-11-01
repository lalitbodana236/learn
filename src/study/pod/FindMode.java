package study.pod;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import study.tree.Node;
import study.tree.TreeNode;

public class FindMode {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		n1.left=null;
		n1.right = new TreeNode(2);
		n1.right.left = new TreeNode(2);
		n1.right.right=null;

		findMode(n1);


	}

	public static int[] findMode(TreeNode root) {
		if (root == null) {
            return new int[0];
        }

        List<Integer> modes = new ArrayList();
        int maxCount = 0;
        int currentCount = 0;
        TreeNode prevNode = null;
        
     // Initialize a stack for in-order traversal.
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (prevNode != null && prevNode.val == root.val) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                modes.clear();
                modes.add(root.val);
                maxCount = currentCount;
            } else if (currentCount == maxCount) {
                modes.add(root.val);
            }

            prevNode = root;
            root = root.right;
        }

        // Convert the list of modes to an array.
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;

	}

}
