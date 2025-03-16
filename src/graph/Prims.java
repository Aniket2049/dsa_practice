package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {

	ArrayList<WeightedNode_DS> nodeList = new ArrayList<WeightedNode_DS>();

	//Constructor
	public Prims(ArrayList<WeightedNode_DS> nodeList) {
		this.nodeList = nodeList;
	}//end of method

	// Prim's algorithm from source node
	void prims(WeightedNode_DS node) {
		for (int counter = 0; counter < nodeList.size(); counter++) {
			nodeList.get(counter).distance = Integer.MAX_VALUE;
		}
		node.distance = 0; // Setting '0' distance for Source Vertex

		PriorityQueue<WeightedNode_DS> queue = new PriorityQueue<>();

		queue.addAll(nodeList);
		while (!queue.isEmpty()) {
			WeightedNode_DS presentNode = queue.remove(); // Remove vertex which has min distance

			for (WeightedNode_DS neighbor : presentNode.neighbors) {
				if (queue.contains(neighbor)) {//If vertex is not processed, only then enter in if-else
					//If known weight of this �adjacent vertex� is more than current edge,
					//then update �adjacent vertex�s� distance and parent
					if (neighbor.distance > presentNode.weightMap.get(neighbor)) {
						neighbor.distance = presentNode.weightMap.get(neighbor);
						neighbor.parent = presentNode;
						queue.remove(neighbor); // Refresh the priority queue
						queue.add(neighbor);
					}//end of if-else
				}//end of if-else
			}//end of for loop
		}//end of while loop

		int cost = 0;
		// print table of node with minimum distance and shortest path from source
		for (WeightedNode_DS nodeToCheck : nodeList) {
			System.out.println(
					"Node " + nodeToCheck + ", key: " + nodeToCheck.distance + ", Parent: " + nodeToCheck.parent);
			cost = cost + nodeToCheck.distance;
		}//end of for loop

		System.out.println("\nTotal cost of MST: " + cost);
	}//end of method

	// add a weighted undirected edge between two nodes
	public void addWeightedUndirectedEdge(int i, int j, int d) {
		WeightedNode_DS first = nodeList.get(i);
		WeightedNode_DS second = nodeList.get(j);
		first.neighbors.add(second);
		second.neighbors.add(first);
		first.weightMap.put(second, d);
		second.weightMap.put(first, d);
	}//end of method

	public static void main(String[] args) {
		ArrayList<WeightedNode_DS> nodeList = new ArrayList<WeightedNode_DS>();
		nodeList.add(new WeightedNode_DS("A"));
		nodeList.add(new WeightedNode_DS("B"));
		nodeList.add(new WeightedNode_DS("C"));
		nodeList.add(new WeightedNode_DS("D"));
		nodeList.add(new WeightedNode_DS("E"));

		Prims graph = new Prims(nodeList);
		graph.addWeightedUndirectedEdge(0, 1, 5);
		graph.addWeightedUndirectedEdge(0, 2, 13);
		graph.addWeightedUndirectedEdge(0, 4, 15);
		graph.addWeightedUndirectedEdge(1, 2, 10);
		graph.addWeightedUndirectedEdge(1, 3, 8);
		graph.addWeightedUndirectedEdge(2, 3, 6);
		graph.addWeightedUndirectedEdge(2, 4, 20);
		System.out.println("Kruskal");
		graph.prims(nodeList.get(0));

	}

}
