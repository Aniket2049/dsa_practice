package binarytree;

import java.util.Vector;

// https://www.geeksforgeeks.org/print-path-between-any-two-nodes-in-a-binary-tree/
public class _21_PathBetweenTwoNodesInBinaryTree {

	// Function to check if there is a path from root 
	// to the given node. It also populates 
	// 'arr' with the given path 
	static boolean getPath(BinaryTreeNode root, Vector<Integer> arr, int x) {
		// if root is null 
		// there is no path 
		if (root == null)
			return false;

		// push the node's value in 'arr' 
		arr.add(root.data);

		// if it is the required node 
		// return true 
		if (root.data == x)
			return true;

		// else check whether the required node lies 
		// in the left subtree or right subtree of 
		// the current node 
		if (getPath(root.left, arr, x) || getPath(root.right, arr, x))
			return true;

		// required node does not lie either in the 
		// left or right subtree of the current node 
		// Thus, remove current node's value from 
		// 'arr'and then return false 
		arr.remove(arr.size() - 1);
		return false;
	}

	// Function to print the path between 
	// any two nodes in a binary tree 
	private static void printPathBetweenNodes(BinaryTreeNode root, int node1, int node2) {
		// vector to store the path of 
		// first node n1 from root 
		Vector<Integer> path1 = new Vector<Integer>();

		// vector to store the path of 
		// second node n2 from root 
		Vector<Integer> path2 = new Vector<Integer>();

		getPath(root, path1, node1);
		getPath(root, path2, node2);

		int intersection = -1;

		// Get intersection point 
		int i = 0, j = 0;
		while (i != path1.size() || j != path2.size()) {

			// Keep moving forward until no intersection 
			// is found 
			if (i == j && path1.get(i) == path2.get(i)) {
				i++;
				j++;
			} else {
				intersection = j - 1;
				break;
			}
		}

		// Print the required path 
		for (i = path1.size() - 1; i > intersection; i--)
			System.out.print(path1.get(i) + " ");

		for (i = intersection; i < path2.size(); i++)
			System.out.print(path2.get(i) + " ");
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

		BinaryTreeNode root = new BinaryTreeNode(5);
		root.left = new BinaryTreeNode(2);
		root.left.left = new BinaryTreeNode(1);
		root.left.right = new BinaryTreeNode(3);
		root.right = new BinaryTreeNode(12);
		root.right.left = new BinaryTreeNode(9);
		root.right.right = new BinaryTreeNode(21);
		root.right.right.left = new BinaryTreeNode(19);
		root.right.right.right = new BinaryTreeNode(25);

		int node1 = 3;
		int node2 = 12;
		printPathBetweenNodes(root, node1, node2);

	}
}
