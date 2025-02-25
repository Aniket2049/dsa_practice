package binarytree;

import java.util.HashMap;

// construct a binary tree from given inorder and preorder traversals
// https://www.youtube.com/watch?v=aZNaLrVebKQ
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
public class _12_105_BinaryTreeFromInorderPreorder {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> inorderIndexes = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inorderIndexes.put(inorder[i], i);
		}

		TreeNode root = buildTreeRecursive(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1,
				inorderIndexes);
		return root;
	}

	private TreeNode buildTreeRecursive(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			HashMap<Integer, Integer> inorderIndexes) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preStart]);
		int inorderIndexOfRoot = inorderIndexes.get(root.val);
		int noOfLeftSubTreeNodes = inorderIndexOfRoot - inStart;

		root.left = buildTreeRecursive(preorder, preStart + 1, preStart + noOfLeftSubTreeNodes, inorder, inStart,
				inorderIndexOfRoot - 1, inorderIndexes);
		root.right = buildTreeRecursive(preorder, preStart + noOfLeftSubTreeNodes + 1, preEnd, inorder,
				inorderIndexOfRoot + 1, inEnd, inorderIndexes);

		return root;
	}

	public static void main(String[] args) {
		int[] preorder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };

		TreeNode root = new _12_105_BinaryTreeFromInorderPreorder().buildTree(preorder, inorder);
		printInorder(root);

	}

	static void printInorder(TreeNode root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.val + " ");
			printInorder(root.right);
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
