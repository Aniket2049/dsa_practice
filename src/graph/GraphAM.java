package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAM {
	ArrayList<GraphNode_AM> nodeList = new ArrayList<GraphNode_AM>();
	int[][] adjacencyMatrix;

	public GraphAM(ArrayList<GraphNode_AM> nodeList) {
		this.nodeList = nodeList;
		adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
	}

	public void addUndirectedEdge(int i, int j) {
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("   ");
		for (int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).name + " ");
		}
		s.append("\n");
		for (int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).name + ": ");
			for (int j : adjacencyMatrix[i]) {
				s.append((j) + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}

	// get Neighbors
	public ArrayList<GraphNode_AM> getNeighbors(GraphNode_AM node) {
		ArrayList<GraphNode_AM> neighbors = new ArrayList<GraphNode_AM>();
		int nodeIndex = node.index;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[nodeIndex][i] == 1) {
				neighbors.add(nodeList.get(i));
			}
		}
		return neighbors;

	}

	// BSF internal
	void bfsVisit(GraphNode_AM node) {
		LinkedList<GraphNode_AM> queue = new LinkedList<GraphNode_AM>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode_AM currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			ArrayList<GraphNode_AM> neighbors = getNeighbors(currentNode);
			for (GraphNode_AM neighbor : neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}

	public void bfs() {
		for (GraphNode_AM node : nodeList) {
			node.isVisited = false;
		}

		for (GraphNode_AM node : nodeList) {
			if (!node.isVisited) {
				bfsVisit(node);
			}
		}
	}

	void dfsVisit(GraphNode_AM node) {
		Stack<GraphNode_AM> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			GraphNode_AM currentNode = stack.pop();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			ArrayList<GraphNode_AM> neighbors = getNeighbors(currentNode);
			for (GraphNode_AM neighbor : neighbors) {
				if (!neighbor.isVisited) {
					stack.push(neighbor);
					neighbor.isVisited = true;
				}
			}

		}
	}

	void dfs() {
		for (GraphNode_AM node : nodeList) {
			node.isVisited = false;
		}

		for (GraphNode_AM node : nodeList) {
			if (!node.isVisited) {
				dfsVisit(node);
			}
		}
	}

	//  Topological Sort
	public void addDirectedEdge(int i, int j) {
		adjacencyMatrix[i][j] = 1;
	}

	void topologicalVisit(GraphNode_AM node, Stack<GraphNode_AM> stack) {
		ArrayList<GraphNode_AM> neighbors = getNeighbors(node);
		for (GraphNode_AM neighbor : neighbors) {
			if (!neighbor.isVisited) {
				topologicalVisit(neighbor, stack);
			}
		}
		node.isVisited = true;
		stack.push(node);
	}

	void topologicalSort() {
		Stack<GraphNode_AM> stack = new Stack<>();
		for (GraphNode_AM node : nodeList) {
			if (!node.isVisited) {
				topologicalVisit(node, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().name + " ");
		}
	}

	// SSSP
	public static void pathPrint(GraphNode_AM node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
	}

	public void BFSForSSSPP(GraphNode_AM node) {
		LinkedList<GraphNode_AM> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode_AM currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print("Printing path for node " + currentNode.name + ": ");
			pathPrint(currentNode);
			System.out.println();
			ArrayList<GraphNode_AM> neighbors = getNeighbors(currentNode);
			for (GraphNode_AM neighbor : neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
					neighbor.parent = currentNode;
				}
			}

		}
	}

	public static void main(String[] args) {
		ArrayList<GraphNode_AM> nodeList = new ArrayList<GraphNode_AM>();
		nodeList.add(new GraphNode_AM("A", 0));
		nodeList.add(new GraphNode_AM("B", 1));
		nodeList.add(new GraphNode_AM("C", 2));
		nodeList.add(new GraphNode_AM("D", 3));
		nodeList.add(new GraphNode_AM("E", 4));

		GraphAM graph = new GraphAM(nodeList);
		graph.addUndirectedEdge(0, 1);
		graph.addUndirectedEdge(0, 2);
		graph.addUndirectedEdge(0, 3);
		graph.addUndirectedEdge(1, 4);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(3, 4);

		System.out.println("Adjacency Matrix");
		System.out.println(graph.toString());

		// ----- bfs -----
		System.out.println("\nBFS Visit");
		graph.bfs();

		// ----- dfs -----
		System.out.println("\n\nDFS Visit");
		graph.dfs();
		System.out.println();

		// ----- new graph for topological sort -----
		ArrayList<GraphNode_AM> nodeList2 = new ArrayList<GraphNode_AM>();
		nodeList2.add(new GraphNode_AM("A", 0));
		nodeList2.add(new GraphNode_AM("B", 1));
		nodeList2.add(new GraphNode_AM("C", 2));
		nodeList2.add(new GraphNode_AM("D", 3));
		nodeList2.add(new GraphNode_AM("E", 4));
		nodeList2.add(new GraphNode_AM("F", 5));
		nodeList2.add(new GraphNode_AM("G", 6));
		nodeList2.add(new GraphNode_AM("H", 7));

		GraphAM graph2 = new GraphAM(nodeList2);
		graph2.addDirectedEdge(0, 2);
		graph2.addDirectedEdge(2, 4);
		graph2.addDirectedEdge(4, 7);
		graph2.addDirectedEdge(4, 5);
		graph2.addDirectedEdge(5, 6);
		graph2.addDirectedEdge(1, 2);
		graph2.addDirectedEdge(1, 3);
		graph2.addDirectedEdge(3, 5);

		System.out.println("\nAdjacency Matrix");
		System.out.println(graph2.toString());

		// ----- topological sort -----
		System.out.println("Topological Sort");
		graph2.topologicalSort();

		// ----- single source shortest path -----
		ArrayList<GraphNode_AM> nodeList3 = new ArrayList<GraphNode_AM>();
		nodeList3.add(new GraphNode_AM("A", 0));
		nodeList3.add(new GraphNode_AM("B", 1));
		nodeList3.add(new GraphNode_AM("C", 2));
		nodeList3.add(new GraphNode_AM("D", 3));
		nodeList3.add(new GraphNode_AM("E", 4));
		nodeList3.add(new GraphNode_AM("F", 5));
		nodeList3.add(new GraphNode_AM("G", 6));

		GraphAM graph3 = new GraphAM(nodeList3);
		graph3.addUndirectedEdge(0, 1);
		graph3.addUndirectedEdge(0, 2);
		graph3.addUndirectedEdge(1, 3);
		graph3.addUndirectedEdge(1, 6);
		graph3.addUndirectedEdge(2, 3);
		graph3.addUndirectedEdge(2, 4);
		graph3.addUndirectedEdge(3, 5);
		graph3.addUndirectedEdge(4, 5);
		graph3.addUndirectedEdge(5, 6);

		System.out.println(graph3.toString());
		System.out.println("\nSingle Source Shortest Path from A(0)");
		graph3.BFSForSSSPP(nodeList3.get(0));
	}
}

class GraphNode_AM {
	public String name;
	public int index;
	public boolean isVisited = false;
	public GraphNode_AM parent;

	public GraphNode_AM(String name, int index) {
		this.name = name;
		this.index = index;
	}
}