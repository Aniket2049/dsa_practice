package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class WeightedGraph_Dijkstra {

	ArrayList<WeightedNode_D> nodeList = new ArrayList<WeightedNode_D>();

	public WeightedGraph_Dijkstra(ArrayList<WeightedNode_D> nodeList) {
		this.nodeList = nodeList;
	}

	// single source shortest path for weighted graph
	void dijkstra(WeightedNode_D node) {
		PriorityQueue<WeightedNode_D> queue = new PriorityQueue<>();
		node.distance = 0;
		queue.addAll(nodeList);
		while (!queue.isEmpty()) {
			WeightedNode_D currentNode = queue.remove();
			for (WeightedNode_D neighbor : currentNode.neighbors) {
				if (queue.contains(neighbor)) {
					if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
						neighbor.distance = (currentNode.distance + currentNode.weightMap.get(neighbor));
						neighbor.parent = currentNode;
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
		}

		for (WeightedNode_D nodeToCheck : nodeList) {
			System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}
	}

	public static void pathPrint(WeightedNode_D node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
	}

	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode_D first = nodeList.get(i);
		WeightedNode_D second = nodeList.get(j);
		first.neighbors.add(second);
		first.weightMap.put(second, d);
	}

	public static void main(String[] args) {
		ArrayList<WeightedNode_D> nodeList = new ArrayList<WeightedNode_D>();
		nodeList.add(new WeightedNode_D("A", 0));
		nodeList.add(new WeightedNode_D("B", 1));
		nodeList.add(new WeightedNode_D("C", 2));
		nodeList.add(new WeightedNode_D("D", 3));
		nodeList.add(new WeightedNode_D("E", 4));
		nodeList.add(new WeightedNode_D("F", 5));
		nodeList.add(new WeightedNode_D("G", 6));

		WeightedGraph_Dijkstra graph = new WeightedGraph_Dijkstra(nodeList);
		graph.addWeightedEdge(0, 1, 2);
		graph.addWeightedEdge(0, 2, 5);
		graph.addWeightedEdge(1, 2, 6);
		graph.addWeightedEdge(1, 3, 1);
		graph.addWeightedEdge(1, 4, 3);
		graph.addWeightedEdge(2, 5, 8);
		graph.addWeightedEdge(3, 4, 2);
		graph.addWeightedEdge(4, 6, 9);
		graph.addWeightedEdge(5, 6, 7);

		System.out.println("Dijkstra");
		graph.dijkstra(nodeList.get(0));

	}

}

class WeightedNode_D implements Comparable<WeightedNode_D> {
	public String name;
	public ArrayList<WeightedNode_D> neighbors = new ArrayList<WeightedNode_D>();
	public HashMap<WeightedNode_D, Integer> weightMap = new HashMap<>();
	public boolean isVisited = false;
	public WeightedNode_D parent;
	public int distance;
	public int index;

	public WeightedNode_D(String name, int index) {
		this.name = name;
		distance = Integer.MAX_VALUE;
		this.index = index;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(WeightedNode_D o) {
		return this.distance - o.distance;
	}

}