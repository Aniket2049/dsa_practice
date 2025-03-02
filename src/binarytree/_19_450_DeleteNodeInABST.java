package binarytree;

// https://leetcode.com/problems/delete-node-in-a-bst/description/
// https://www.geeksforgeeks.org/deletion-in-binary-search-tree/
public class _19_450_DeleteNodeInABST {

	// This function deletes a given key x from the 
	// given BST  and returns the modified root of 
	// the BST (if it is modified).
	public static TreeNode deleteNode(TreeNode root, int key) {
		// Base case
		if (root == null) {
			return root;
		}

		// If key to be searched is in a subtree
		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			// If root matches with the given key

			// Cases when root has 0 children or
			// only right child
			if (root.left == null) {
				return root.right;
			}

			// When root has only left child
			if (root.right == null) {
				return root.left;
			}

			// When both children are present
			TreeNode successor = getSuccessor(root);
			root.val = successor.val;
			root.right = deleteNode(root.right, successor.val);
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(18);

		int x = 15;
		root = deleteNode(root, x);
		inorder(root);

	}

	// Note that it is not a generic inorder successor 
	// function. It mainly works when the right child
	// is not empty, which is the case we need in BST
	// delete. 
	static TreeNode getSuccessor(TreeNode curr) {
		curr = curr.right;
		while (curr != null && curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}

	// Utility function to do inorder traversal
	static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
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
