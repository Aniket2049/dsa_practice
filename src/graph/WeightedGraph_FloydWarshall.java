package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedGraph_FloydWarshall {

	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	public WeightedGraph_FloydWarshall(ArrayList<WeightedNode> nodeList) {
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

	// all source shortest path for weighted graph - no negative cycle detected
	// Bellman Ford Algorithm
	void floydWarshall() {
		int size = nodeList.size();
		int[][] V = new int[size][size];

		// Initializing Distance table from adjacency list
		for (int i = 0; i < size; i++) {
			WeightedNode first = nodeList.get(i);
			for (int j = 0; j < size; j++) {
				WeightedNode second = nodeList.get(j);
				if (i == j)
					V[i][j] = 0;
				else if (first.weightMap.containsKey(second)) { //we have direct edge between i & j
					V[i][j] = first.weightMap.get(second);
				} else { //no direct edge between i & j, so mark it as infinity [divided by 10 to avoid arithmetic overflow]
					V[i][j] = Integer.MAX_VALUE / 10;
				}
			}
		}//end of loop

		// Floyd Warshall's Algorithm
		for (int k = 0; k < nodeList.size(); k++) {
			for (int i = 0; i < nodeList.size(); i++) {
				for (int j = 0; j < nodeList.size(); j++) {
					if (V[i][j] > V[i][k] + V[k][j]) {  // if update possible, then update path
						V[i][j] = V[i][k] + V[k][j];    // this will keep a track on path
					}
				}
			}
		}//end of loop

		// Print table of node with minimum distance and shortest path from each source
		for (int i = 0; i < size; i++) {
			System.out.print("Printing distance list for node " + nodeList.get(i) + ": ");
			for (int j = 0; j < size; j++) {
				System.out.print(V[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<WeightedGraph_FloydWarshall.WeightedNode>();
		nodeList.add(new WeightedNode("A", 0));
		nodeList.add(new WeightedNode("B", 1));
		nodeList.add(new WeightedNode("C", 2));
		nodeList.add(new WeightedNode("D", 3));

		WeightedGraph_FloydWarshall graph = new WeightedGraph_FloydWarshall(nodeList);
		graph.addWeightedEdge(0, 3, 1);
		graph.addWeightedEdge(0, 1, 8);
		graph.addWeightedEdge(1, 2, 1);
		graph.addWeightedEdge(2, 0, 4);
		graph.addWeightedEdge(3, 1, 2);
		graph.addWeightedEdge(3, 2, 9);

		System.out.println("Floyd Warshall");
		graph.floydWarshall();

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
