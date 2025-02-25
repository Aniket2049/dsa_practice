package binarytree;

import java.util.HashMap;

// construct a binary tree from given inorder and postorder traversals
// https://www.youtube.com/watch?v=LgLRTaEMRVc
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class _13_106_BinaryTreeFromInorderPostorder {

	public TreeNode buildTree(int[] postorder, int[] inorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;

		HashMap<Integer, Integer> inorderIndexes = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inorderIndexes.put(inorder[i], i);
		}

		TreeNode root = buildTreeRecursive(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1,
				inorderIndexes);
		return root;
	}

	private TreeNode buildTreeRecursive(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart,
			int inEnd, HashMap<Integer, Integer> inorderIndexes) {
		if (postStart > postEnd || inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[postEnd]);
		int inorderIndexOfRoot = inorderIndexes.get(root.val);
		int noOfLeftSubTreeNodes = inorderIndexOfRoot - inStart;

		root.left = buildTreeRecursive(postorder, postStart, postStart + noOfLeftSubTreeNodes - 1, inorder, inStart,
				inorderIndexOfRoot - 1, inorderIndexes);
		root.right = buildTreeRecursive(postorder, postStart + noOfLeftSubTreeNodes, postEnd - 1, inorder,
				inorderIndexOfRoot + 1, inEnd, inorderIndexes);

		return root;
	}

	public static void main(String[] args) {
		int[] postorder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };

		TreeNode root = new _13_106_BinaryTreeFromInorderPostorder().buildTree(postorder, inorder);
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
