package binarytree;

// https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
// https://www.geeksforgeeks.org/insertion-in-binary-search-tree/
public class _18_701_InsertIntoABinarySearchTree {

	public static TreeNode insertIntoBST(TreeNode root, int val) {
		// If the tree is empty, return a new node
		if (root == null)
			return new TreeNode(val);

		// If the key is already present in the tree,
		// return the node
		if (root.val == val)
			return root;

		// Otherwise, recur down the tree
		if (val < root.val)
			root.left = insertIntoBST(root.left, val);
		else
			root.right = insertIntoBST(root.right, val);

		// Return the (unchanged) node pointer
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = null;

		// Creating the following BST
		//      50
		//     /  \
		//    30   70
		//   / \   / \
		//  20 40 60 80

		root = insertIntoBST(root, 50);
		root = insertIntoBST(root, 30);
		root = insertIntoBST(root, 20);
		root = insertIntoBST(root, 40);
		root = insertIntoBST(root, 70);
		root = insertIntoBST(root, 60);
		root = insertIntoBST(root, 80);

		// Print inorder traversal of the BST
        inorder(root);
	}

	// A utility function to do inorder tree traversal
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
