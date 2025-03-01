package binarytree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// https://algo.monster/liteproblems/987
public class _17_987_VerticalOrderTraversalOfABinaryTree {

    // Helper method to perform depth-first search (DFS).
    private void dfs(TreeNode node, int column, int row, List<int[]> nodes) {
        if (node == null) {
            return; // Base case: if the node is null, then just return.
        }
        // Add the current node's data as a tuple (column, row, value) to the nodes list.
        nodes.add(new int[]{column, row, node.val});
        // Continue DFS on the left subtree, decrementing column and row for left traversal.
        dfs(node.left, column - 1, row - 1, nodes);
        // Continue DFS on the right subtree, incrementing column and decrementing row for right traversal.
        dfs(node.right, column + 1, row - 1, nodes);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>(); // List to hold nodes data (column, row, value).
        dfs(root, 0, 0, nodes); // Start DFS with the root node at column 0, row 0.

        // Sort the list of nodes based on their column, row and value.
        nodes.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] node1, int[] node2) {
                // Primary sort by column (x-axis).
                if (node1[0] != node2[0]) return Integer.compare(node1[0], node2[0]);
                // Secondary sort by row (y-axis) in descending order.
                if (node1[1] != node2[1]) return Integer.compare(node2[1], node1[1]);
                // Tertiary sort by value.
                return Integer.compare(node1[2], node2[2]);
            }
        });

        List<List<Integer>> result = new ArrayList<>(); // Initialize the result list.
        int previousColumn = Integer.MIN_VALUE; // Variable to track the previous column index.
      
        for (int[] currentNode : nodes) {
            // Check if the current node's column index is different than the previous column's.
            if (previousColumn != currentNode[0]) {
                // If so, add a new list to the result since we've moved to a new column.
                result.add(new ArrayList<>());
                previousColumn = currentNode[0]; // Update the previous column index.
            }
            // Add the current node's value to the last list in the result. This list corresponds
            // to the current column we are populating.
            result.get(result.size() - 1).add(currentNode[2]);
        }
        return result; // Return the list of lists representing vertical order traversal.
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

		List<List<Integer>> answer = new _17_987_VerticalOrderTraversalOfABinaryTree().verticalTraversal(root);

		for (int i = 0; i < answer.size(); i++) {
			for (int j = 0; j < answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j) + " ");
			}
			System.out.println();
		}

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
