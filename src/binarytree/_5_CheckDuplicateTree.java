package binarytree;

// given two binary trees check if they are structuraly identical/duplicate
public class _5_CheckDuplicateTree {

	public boolean isIdentitalTrees(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		return isIdentitalTrees(root1.left, root2.right) && isIdentitalTrees(root1.right, root2.left);

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

		// Constructing binary tree.
		//
		//             1
		//            / \
		//           /   \
		//          2     3
		//         / \   / \
		//        /   \ /   \
		//       4    5 6    7
		BinaryTreeNode root2 = new BinaryTreeNode(1);
		root2.left = new BinaryTreeNode(2);
		root2.right = new BinaryTreeNode(3);
		root2.left.left = new BinaryTreeNode(4);
		root2.left.right = new BinaryTreeNode(5);
		root2.right.left = new BinaryTreeNode(6);
//		root2.right.right = new BinaryTreeNode(7);

		System.out.println(new _5_CheckDuplicateTree().isIdentitalTrees(root, root2));

	}

}
