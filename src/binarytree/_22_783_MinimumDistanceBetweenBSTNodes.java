package binarytree;

// https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
// https://algo.monster/liteproblems/783
public class _22_783_MinimumDistanceBetweenBSTNodes {

	private int min;
	private int prevVal;

	private void dfs(TreeNode root) {
		if (root == null)
			return;

		dfs(root.left);
		if (Math.abs(root.val - prevVal) < min)
			min = Math.abs(root.val - prevVal);
		prevVal = root.val;
		dfs(root.right);
	}

	public int minDiffInBST(TreeNode root) {
		min = Integer.MAX_VALUE;
		prevVal = Integer.MAX_VALUE;
		dfs(root);
		return min;
	}

	public static void main(String[] args) {
		// creating the binary search tree
		//          5
		//        /   \
		//       2     12
		//      / \    /  \
		//     1   3  9    21
		//                /  \
		//              19    25

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(12);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(21);
		root.right.right.left = new TreeNode(19);
		root.right.right.right = new TreeNode(25);

		System.out.println(new _22_783_MinimumDistanceBetweenBSTNodes().minDiffInBST(root));

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
