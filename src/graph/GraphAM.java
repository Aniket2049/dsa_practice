package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAM {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	int[][] adjacencyMatrix;

	public GraphAM(ArrayList<GraphNode> nodeList) {
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
	public ArrayList<GraphNode> getNeighbors(GraphNode node) {
		ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
		int nodeIndex = node.index;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[nodeIndex][i] == 1) {
				neighbors.add(nodeList.get(i));
			}
		}
		return neighbors;

	}

	// BSF internal
	void bfsVisit(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
			for (GraphNode neighbor : neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}

	public void bfs() {
		for (GraphNode node : nodeList) {
			node.isVisited = false;
		}

		for (GraphNode node : nodeList) {
			if (!node.isVisited) {
				bfsVisit(node);
			}
		}
	}

	void dfsVisit(GraphNode node) {
		Stack<GraphNode> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			GraphNode currentNode = stack.pop();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
			for (GraphNode neighbor : neighbors) {
				if (!neighbor.isVisited) {
					stack.push(neighbor);
					neighbor.isVisited = true;
				}
			}

		}
	}

	void dfs() {
		for (GraphNode node : nodeList) {
			node.isVisited = false;
		}

		for (GraphNode node : nodeList) {
			if (!node.isVisited) {
				dfsVisit(node);
			}
		}
	}

	//  Topological Sort
	public void addDirectedEdge(int i, int j) {
		adjacencyMatrix[i][j] = 1;
	}

	void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		ArrayList<GraphNode> neighbors = getNeighbors(node);
		for (GraphNode neighbor : neighbors) {
			if (!neighbor.isVisited) {
				topologicalVisit(neighbor, stack);
			}
		}
		node.isVisited = true;
		stack.push(node);
	}

	void topologicalSort() {
		Stack<GraphNode> stack = new Stack<>();
		for (GraphNode node : nodeList) {
			if (!node.isVisited) {
				topologicalVisit(node, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().name + " ");
		}
	}

	static class GraphNode {
		public String name;
		public int index;
		public boolean isVisited = false;

		public GraphNode(String name, int index) {
			this.name = name;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		ArrayList<GraphNode> nodeList = new ArrayList<GraphAM.GraphNode>();
		nodeList.add(new GraphNode("A", 0));
		nodeList.add(new GraphNode("B", 1));
		nodeList.add(new GraphNode("C", 2));
		nodeList.add(new GraphNode("D", 3));
		nodeList.add(new GraphNode("E", 4));

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
		ArrayList<GraphNode> nodeList2 = new ArrayList<GraphAM.GraphNode>();
		nodeList2.add(new GraphNode("A", 0));
		nodeList2.add(new GraphNode("B", 1));
		nodeList2.add(new GraphNode("C", 2));
		nodeList2.add(new GraphNode("D", 3));
		nodeList2.add(new GraphNode("E", 4));
		nodeList2.add(new GraphNode("F", 5));
		nodeList2.add(new GraphNode("G", 6));
		nodeList2.add(new GraphNode("H", 7));

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
	}
}
