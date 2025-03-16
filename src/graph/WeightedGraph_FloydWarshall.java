package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedGraph_FloydWarshall {

	ArrayList<WeightedNode_FW> nodeList = new ArrayList<WeightedNode_FW>();

	public WeightedGraph_FloydWarshall(ArrayList<WeightedNode_FW> nodeList) {
		this.nodeList = nodeList;
	}

	public static void pathPrint(WeightedNode_FW node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
	}

	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode_FW first = nodeList.get(i);
		WeightedNode_FW second = nodeList.get(j);
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
			WeightedNode_FW first = nodeList.get(i);
			for (int j = 0; j < size; j++) {
				WeightedNode_FW second = nodeList.get(j);
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
		ArrayList<WeightedNode_FW> nodeList = new ArrayList<WeightedNode_FW>();
		nodeList.add(new WeightedNode_FW("A", 0));
		nodeList.add(new WeightedNode_FW("B", 1));
		nodeList.add(new WeightedNode_FW("C", 2));
		nodeList.add(new WeightedNode_FW("D", 3));

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

}

class WeightedNode_FW implements Comparable<WeightedNode_FW> {
	public String name;
	public ArrayList<WeightedNode_FW> neighbors = new ArrayList<WeightedNode_FW>();
	public HashMap<WeightedNode_FW, Integer> weightMap = new HashMap<>();
	public boolean isVisited = false;
	public WeightedNode_FW parent;
	public int distance;
	public int index;

	public WeightedNode_FW(String name, int index) {
		this.name = name;
		distance = Integer.MAX_VALUE;
		this.index = index;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(WeightedNode_FW o) {
		return this.distance - o.distance;
	}

}