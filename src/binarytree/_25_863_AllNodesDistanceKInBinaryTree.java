package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// https://www.youtube.com/watch?v=2IHdqU48N2w
public class _25_863_AllNodesDistanceKInBinaryTree {

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		if (k < 1) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			res.add(target.val);
			return res;
		}
		HashMap<TreeNode, ArrayList<TreeNode>> graphList = new HashMap<_25_863_AllNodesDistanceKInBinaryTree.TreeNode, ArrayList<TreeNode>>();
		Queue<TreeNode> q = new LinkedList<_25_863_AllNodesDistanceKInBinaryTree.TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node.left != null) {
				if (!graphList.containsKey(node)) {
					graphList.put(node, new ArrayList<_25_863_AllNodesDistanceKInBinaryTree.TreeNode>());
				}
				graphList.get(node).add(node.left);

				if (!graphList.containsKey(node.left)) {
					graphList.put(node.left, new ArrayList<_25_863_AllNodesDistanceKInBinaryTree.TreeNode>());
				}
				graphList.get(node.left).add(node);

				q.add(node.left);
			}

			if (node.right != null) {
				if (!graphList.containsKey(node)) {
					graphList.put(node, new ArrayList<_25_863_AllNodesDistanceKInBinaryTree.TreeNode>());
				}
				graphList.get(node).add(node.right);

				if (!graphList.containsKey(node.right)) {
					graphList.put(node.right, new ArrayList<_25_863_AllNodesDistanceKInBinaryTree.TreeNode>());
				}
				graphList.get(node.right).add(node);
				q.add(node.right);
			}
		}

		ArrayList<Integer> res = new ArrayList<Integer>();
		HashSet<TreeNode> visited = new HashSet<_25_863_AllNodesDistanceKInBinaryTree.TreeNode>();
		visited.add(target);
		Queue<QData> q2 = new LinkedList<QData>();
		q2.add(new QData(target, 0));

		while (!q2.isEmpty()) {
			QData popped = q2.poll();
			TreeNode node = popped.getNode();
			int distance = popped.getDistance();

			if (distance == k) {
				res.add(node.val);
			} else {
				ArrayList<TreeNode> currentNodeNeighbours = graphList.get(node);
				if (currentNodeNeighbours != null) {
					for (TreeNode edge : currentNodeNeighbours) {
						if (!visited.contains(edge)) {
							visited.add(edge);
							q2.add(new QData(edge, distance + 1));
						}
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		TreeNode check = new TreeNode(1);
		List<Integer> res = new _25_863_AllNodesDistanceKInBinaryTree().distanceK(check, check, 3);
	}

	static class QData {
		TreeNode node;
		int distance;

		public QData(TreeNode node, int distance) {
			super();
			this.node = node;
			this.distance = distance;
		}

		public TreeNode getNode() {
			return node;
		}

		public void setNode(TreeNode node) {
			this.node = node;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
