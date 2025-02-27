package binarytree;

import binarytree._14_PrintAncestors.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
// https://www.youtube.com/watch?v=gs2LMfuOR9k
public class _16_235_LowestCommonAncestorOfABinarySearchTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode current = root;

		while (current != null) {
			if (p.val > current.val && q.val > current.val) {
				current = current.right;
			} else if (p.val < current.val && q.val < current.val) {
				current = current.left;
			} else {
				return current;
			}
		}

		return current;
	}

	public static void main(String[] args) {
		// Constructing binary tree.
		//
		//             5
		//            / \
		//           /   \
		//          3     8
		//         / \   / \
		//        /   \ /   \
		//       1    4 7    9
		TreeNode root = new TreeNode(5);
		TreeNode root8 = new TreeNode(8);
		TreeNode root3 = new TreeNode(3);
		root.left = root3;
		root.right = root8;
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		System.out.println(
				new _16_235_LowestCommonAncestorOfABinarySearchTree().lowestCommonAncestor(root, root8, root3).val);
	}

}
