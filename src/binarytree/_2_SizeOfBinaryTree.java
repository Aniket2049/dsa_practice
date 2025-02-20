package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class _2_SizeOfBinaryTree {

	public int sizeOfBTRecursive(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int left = root.left == null ? 0 : sizeOfBTRecursive(root.left);
		int right = root.right == null ? 0 : sizeOfBTRecursive(root.right);
		return 1 + left + right;
	}

	public int sizeOfBIterative(BinaryTreeNode root) {
		int count = 0;
		if (root == null)
			return count;

		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			count++;
			BinaryTreeNode temp = q.poll();
			if (temp != null) {
				if (temp.left != null) {
					q.offer(temp.left);
				}

				if (temp.right != null) {
					q.offer(temp.right);
				}
			}
		}

		return count;
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

		System.out.println(new _2_SizeOfBinaryTree().sizeOfBTRecursive(root));
		System.out.println(new _2_SizeOfBinaryTree().sizeOfBIterative(root));
	}

}
