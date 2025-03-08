package binarytree;

// https://leetcode.com/problems/validate-binary-search-tree/
// https://algo.monster/liteproblems/98
public class _23_98_ValidateBinarySearchTree {
	private Integer previousValue; // variable to store the previously visited node's value

	/**
	 * Validates if the given binary tree is a valid binary search tree (BST).
	 *
	 * @param root The root of the binary tree to check.
	 * @return true if the given tree is a BST, false otherwise.
	 */
	public boolean isValidBST(TreeNode root) {
		previousValue = null; // Initialize previousValue as null before starting traversal
		return inOrderTraversal(root);
	}

	/**
	 * Performs an in-order depth-first traversal on the binary tree to validate BST property.
	 * It ensures that every node's value is greater than the values of all nodes in its left subtree
	 * and less than the values of all nodes in its right subtree.
	 *
	 * @param node The current node being visited in the traversal.
	 * @return true if the subtree rooted at 'node' satisfies BST properties, false otherwise.
	 */
	private boolean inOrderTraversal(TreeNode node) {
		if (node == null) {
			return true; // Base case: An empty tree is a valid BST.
		}
		// Traverse the left subtree. If it's not a valid BST, return false immediately.
		if (!inOrderTraversal(node.left)) {
			return false;
		}
		// Check the current node value with the previous node's value.
		// As it's an in-order traversal, previousValue should be less than the current node's value.
		if (previousValue != null && previousValue >= node.val) {
			return false; // The BST property is violated.
		}
		previousValue = node.val; // Update previousValue with the current node's value.
		// Traverse the right subtree. If it's not a valid BST, return false immediately.
		if (!inOrderTraversal(node.right)) {
			return false;
		}
		return true; // All checks passed, it's a valid BST.
	}

	public static void main(String[] args) {
		// creating the binary search tree
		//          5
		//        /   \
		//       2     12
		//      / \    /  \
		//     1   3  9    21
		//                /  \
		//              19    25

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(12);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(21);
		root.right.right.left = new TreeNode(19);
		root.right.right.right = new TreeNode(25);
		
		System.out.println(new _23_98_ValidateBinarySearchTree().inOrderTraversal(root));
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
