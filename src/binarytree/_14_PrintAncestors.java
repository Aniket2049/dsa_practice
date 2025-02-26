package binarytree;

public class _14_PrintAncestors {

	boolean printAncestors(TreeNode node, int target) {
		/* base cases */
		if (node == null)
			return false;

		if (node.val == target)
			return true;

		/* If target is present in either left or right subtree 
		   of this node, then print this node */
		if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
			System.out.print(node.val + " ");
			return true;
		}

		/* Else return false */
		return false;
	}

	public static void main(String[] args) {
		// Constructing binary tree.
		//
		//             1
		//            / \
		//           /   \
		//          2     3
		//         / \   / \
		//        /   \ /   \
		//       4    5 6    7
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		System.out.println(new _14_PrintAncestors().printAncestors(root, 6));

	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
