package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class WeightedGraph_BellmanFord {

	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	public WeightedGraph_BellmanFord(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	public static void pathPrint(WeightedNode node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
	}

	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j);
		first.neighbors.add(second);
		first.weightMap.put(second, d);
	}

	// single source shortest path for weighted with negative cycle graph
	// Bellman Ford Algorithm
	void bellmanFord(WeightedNode sourceNode) {
		sourceNode.distance = 0;
		for (int i = 0; i < nodeList.size(); i++) {
			for (WeightedNode currentNode : nodeList) {
				for (WeightedNode neighbor : currentNode.neighbors) {
					if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
						neighbor.distance = (currentNode.distance + currentNode.weightMap.get(neighbor));
						neighbor.parent = currentNode;
					}
				}
			}
		}
		System.out.println("Checking for Negative Cycle..");
		for (WeightedNode currentNode : nodeList) {
			for (WeightedNode neighbor : currentNode.neighbors) {
				if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
					System.out.println("Negative cycle found: \n");
					System.out.println("Vertex name: " + neighbor.name);
					System.out.println("Old cost: " + neighbor.distance);
					int newDistance = currentNode.distance + currentNode.weightMap.get(neighbor);
					System.out.println("new cost: " + newDistance);
					return;
				}
			}
		}
		System.out.println("Negative Cycle not found");

		for (WeightedNode nodeToCheck : nodeList) {
			System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}

	}

	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<WeightedGraph_BellmanFord.WeightedNode>();
		nodeList.add(new WeightedNode("A", 0));
		nodeList.add(new WeightedNode("B", 1));
		nodeList.add(new WeightedNode("C", 2));
		nodeList.add(new WeightedNode("D", 3));
		nodeList.add(new WeightedNode("E", 4));
		nodeList.add(new WeightedNode("F", 5));
		nodeList.add(new WeightedNode("G", 6));

		WeightedGraph_BellmanFord graph = new WeightedGraph_BellmanFord(nodeList);
		graph.addWeightedEdge(0, 1, 2);
		graph.addWeightedEdge(0, 2, 5);
		graph.addWeightedEdge(1, 2, 6);
		graph.addWeightedEdge(1, 3, 1);
		graph.addWeightedEdge(1, 4, 3);
		graph.addWeightedEdge(2, 5, 8);
		graph.addWeightedEdge(3, 4, 2);
		graph.addWeightedEdge(4, 6, 9);
		graph.addWeightedEdge(5, 6, 7);

		System.out.println("BellmanFord");
		graph.bellmanFord(nodeList.get(0));

	}

	static class WeightedNode implements Comparable<WeightedNode> {
		public String name;
		public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
		public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
		public boolean isVisited = false;
		public WeightedNode parent;
		public int distance;
		public int index;

		public WeightedNode(String name, int index) {
			this.name = name;
			distance = Integer.MAX_VALUE;
			this.index = index;
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public int compareTo(WeightedNode o) {
			return this.distance - o.distance;
		}

	}
}
