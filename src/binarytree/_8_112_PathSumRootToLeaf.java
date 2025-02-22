package binarytree;

// https://leetcode.com/problems/path-sum/
public class _8_112_PathSumRootToLeaf {

	private boolean hasPathSumHelper(TreeNode root, int targetSum, int currentSum) {
		if(root == null) return false;
		if (root.left == null && root.right == null) {
			if (root.val + currentSum == targetSum) {
				return true;
			} else {
				return false;
			}
		}

		boolean resLeft = false;
		boolean resRight = false;
		resLeft = hasPathSumHelper(root.left, targetSum, currentSum + root.val);
		resRight = hasPathSumHelper(root.right, targetSum, currentSum + root.val);

		return resRight || resLeft;
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		boolean result = hasPathSumHelper(root, targetSum, 0);
		return result;
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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(new _8_112_PathSumRootToLeaf().hasPathSum(root, 6));
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
