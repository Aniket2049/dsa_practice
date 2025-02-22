package binarytree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/description/
// 
public class _7_257_RootToLeafPaths {

	public List<String> res = new ArrayList<String>();

	public String printHelper(List<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if (i != list.size() - 1) {
				sb.append("->");
			}
		}

		return sb.toString();
	}

	public void binaryTreePathsHelper(TreeNode root, List<Integer> currentList) {

		currentList.add(root.val);

		if (root.left != null) {
			binaryTreePathsHelper(root.left, currentList);
			currentList.removeLast();
		}

		if (root.right != null) {
			binaryTreePathsHelper(root.right, currentList);
			currentList.removeLast();
		}

		if (root.left == null && root.right == null) {
			res.add(printHelper(currentList));
			System.out.println(printHelper(currentList));
			return;
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		ArrayList<Integer> mainList = new ArrayList<Integer>();
		binaryTreePathsHelper(root, mainList);
		return res;
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

		List<String> result = new _7_257_RootToLeafPaths().binaryTreePaths(root);

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
