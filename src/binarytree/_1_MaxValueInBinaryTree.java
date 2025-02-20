package binarytree;

import java.util.LinkedList;
import java.util.Queue;

// find maximum value in binary tree
public class _1_MaxValueInBinaryTree {

	public int maxValueInBTRecursive(BinaryTreeNode root) {
		int maxVal = Integer.MIN_VALUE;

		if (root != null) {
			int leftmax = maxValueInBTRecursive(root.left);
			int rightmax = maxValueInBTRecursive(root.right);

			if (leftmax > rightmax)
				maxVal = leftmax;
			else
				maxVal = rightmax;

			if (root.data > maxVal)
				maxVal = root.data;
		}

		return maxVal;
	}

	public int maxValueInBTIterative(BinaryTreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;

		int max = Integer.MIN_VALUE;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp != null && temp.data > max)
				max = temp.data;

			if (temp != null) {
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}
		}

		return max;
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
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);

		System.out.println(new _1_MaxValueInBinaryTree().maxValueInBTRecursive(root));
		System.out.println(new _1_MaxValueInBinaryTree().maxValueInBTIterative(root));
	}

}
