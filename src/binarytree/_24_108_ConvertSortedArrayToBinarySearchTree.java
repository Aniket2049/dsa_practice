package binarytree;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
// 
public class _24_108_ConvertSortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;

		return constructTree(nums, 0, nums.length - 1);
	}

	private TreeNode constructTree(int[] nums, int left, int right) {
		if (left > right)
			return null;

		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = constructTree(nums, left, mid - 1);
		root.right = constructTree(nums, mid + 1, right);

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
