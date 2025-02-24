package binarytree;

// find if there exists path of nodes (from root) whos summed value equals to value asked
public class _9_PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null && root.val == sum)
			return true;
		else
			return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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

		System.out.println(new _9_PathSum().hasPathSum(root, 9));
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
