package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedGraph_BellmanFord {

	ArrayList<WeightedNode_BF> nodeList = new ArrayList<WeightedNode_BF>();

	public WeightedGraph_BellmanFord(ArrayList<WeightedNode_BF> nodeList) {
		this.nodeList = nodeList;
	}

	public static void pathPrint(WeightedNode_BF node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
	}

	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode_BF first = nodeList.get(i);
		WeightedNode_BF second = nodeList.get(j);
		first.neighbors.add(second);
		first.weightMap.put(second, d);
	}

	// single source shortest path for weighted with negative cycle graph
	// Bellman Ford Algorithm
	void bellmanFord(WeightedNode_BF sourceNode) {
		sourceNode.distance = 0;
		for (int i = 0; i < nodeList.size(); i++) {
			for (WeightedNode_BF currentNode : nodeList) {
				for (WeightedNode_BF neighbor : currentNode.neighbors) {
					if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
						neighbor.distance = (currentNode.distance + currentNode.weightMap.get(neighbor));
						neighbor.parent = currentNode;
					}
				}
			}
		}
		System.out.println("Checking for Negative Cycle..");
		for (WeightedNode_BF currentNode : nodeList) {
			for (WeightedNode_BF neighbor : currentNode.neighbors) {
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

		for (WeightedNode_BF nodeToCheck : nodeList) {
			System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}

	}

	public static void main(String[] args) {
		ArrayList<WeightedNode_BF> nodeList = new ArrayList<WeightedNode_BF>();
		nodeList.add(new WeightedNode_BF("A", 0));
		nodeList.add(new WeightedNode_BF("B", 1));
		nodeList.add(new WeightedNode_BF("C", 2));
		nodeList.add(new WeightedNode_BF("D", 3));
		nodeList.add(new WeightedNode_BF("E", 4));
		nodeList.add(new WeightedNode_BF("F", 5));
		nodeList.add(new WeightedNode_BF("G", 6));

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

}

class WeightedNode_BF implements Comparable<WeightedNode_BF> {
	public String name;
	public ArrayList<WeightedNode_BF> neighbors = new ArrayList<WeightedNode_BF>();
	public HashMap<WeightedNode_BF, Integer> weightMap = new HashMap<>();
	public boolean isVisited = false;
	public WeightedNode_BF parent;
	public int distance;
	public int index;

	public WeightedNode_BF(String name, int index) {
		this.name = name;
		distance = Integer.MAX_VALUE;
		this.index = index;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(WeightedNode_BF o) {
		return this.distance - o.distance;
	}

}
