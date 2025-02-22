package binarytree;

// Given a binary tree, the task is to determine the diameter of the tree. 
// The diameter/width of a tree is defined as the number of edges on the 
// longest path between any two nodes.
// https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
// https://leetcode.com/problems/diameter-of-binary-tree/description/ 
public class _6_DiameterOfBinaryTree {

	private int diameterOfBinaryTreeHelper(BinaryTreeNode root, int[] res) {
		if (root == null)
			return 0;

		int leftHeight = diameterOfBinaryTreeHelper(root.left, res);
		int rightHeight = diameterOfBinaryTreeHelper(root.right, res);

		res[0] = Math.max(res[0], leftHeight + rightHeight);

		return 1 + Math.max(leftHeight, rightHeight);
	}

	public int diameterOfBinaryTree(BinaryTreeNode root) {
		int[] res = new int[1];
		diameterOfBinaryTreeHelper(root, res);
		return res[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
