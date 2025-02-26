package binarytree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
// https://www.youtube.com/watch?v=WO1tfq2sbsI
public class _15_236_LowestCommonAncestorOfABinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		if (root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		} else {
			if (left != null)
				return left;
			else
				return right;
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
		TreeNode node3 = new TreeNode(3);
		TreeNode node7 = new TreeNode(7);
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = node3;
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = node7;

		System.out
				.println(new _15_236_LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, node7, node3).val);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
