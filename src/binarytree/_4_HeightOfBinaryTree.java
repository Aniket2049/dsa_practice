package binarytree;

public class _4_HeightOfBinaryTree {

	public int heightOfBT(BinaryTreeNode root) {
		if (root == null)
			return 0;

		int leftH = heightOfBT(root.left);
		int rightH = heightOfBT(root.right);

		return 1 + (leftH > rightH ? leftH : rightH);
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
		//					  \
		//					   \
		//						8
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		root.right.right.right = new BinaryTreeNode(8);

		System.out.println(new _4_HeightOfBinaryTree().heightOfBT(root));
	}

}
