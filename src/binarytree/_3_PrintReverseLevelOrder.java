package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _3_PrintReverseLevelOrder {

	public void printReverseLevelOrder(BinaryTreeNode root) {
		if (root == null)
			return;

		Stack<String> dataToPrint = new Stack<String>();

		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			int length = q.size();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < length; i++) {
				BinaryTreeNode temp = q.poll();
				// BFS print
				System.out.print(temp.data + " ");
				
				sb.append(temp.data + " ");

				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
			}

			// BFS print
			System.out.println();
			
			dataToPrint.push(sb.toString() + "\n");

		}

		System.out.println("-----------------------");

		while (!dataToPrint.isEmpty()) {
			System.out.print(dataToPrint.pop());
		}
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

		new _3_PrintReverseLevelOrder().printReverseLevelOrder(root);
	}

}
