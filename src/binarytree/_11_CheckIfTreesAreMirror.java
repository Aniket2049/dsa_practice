package binarytree;

// program to check if two given binary trees are mirror images of each other
public class _11_CheckIfTreesAreMirror {

	public boolean areMirrorImages(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		} else {
			return areMirrorImages(root1.left, root2.right) && areMirrorImages(root1.right, root2.left);
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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		// Constructing binary tree.
		//
		//             1
		//            / \
		//           /   \
		//          3     2
		//         / \   / \
		//        /   \ /   \
		//       7    6 5    4
		TreeNode root2 = new TreeNode(1);
		root2.right = new TreeNode(2);
		root2.left = new TreeNode(3);
		root2.right.right = new TreeNode(4);
		root2.right.left = new TreeNode(5);
		root2.left.right = new TreeNode(6);
		root2.left.left = new TreeNode(7);

		System.out.println(new _11_CheckIfTreesAreMirror().areMirrorImages(root, root2));
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
