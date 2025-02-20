package binarytree;

// find maximum value in binary tree
public class _1_MaxValueInBinaryTree {

	public int maxValueInBT(BinaryTreeNode root) {
		int maxVal = Integer.MIN_VALUE;

		if (root != null) {
			int leftmax = maxValueInBT(root.left);
			int rightmax = maxValueInBT(root.right);

			if (leftmax > rightmax)
				maxVal = leftmax;
			else
				maxVal = rightmax;

			if (root.data > maxVal)
				maxVal = root.data;
		}

		return maxVal;
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

		System.out.println(new _1_MaxValueInBinaryTree().maxValueInBT(root));
	}

}
