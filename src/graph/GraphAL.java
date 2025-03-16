package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAL {
	ArrayList<GraphNode_AL> nodeList = new ArrayList<GraphNode_AL>();

	public GraphAL(ArrayList<GraphNode_AL> nodeList) {
		this.nodeList = nodeList;
	}

	public void addUndirectedEdge(int i, int j) {
		GraphNode_AL first = nodeList.get(i);
		GraphNode_AL second = nodeList.get(j);
		first.neighbors.add(second);
		second.neighbors.add(first);
	}

	// For printing Graph to the console
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).name + ": ");
			for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
				if (j == nodeList.get(i).neighbors.size() - 1) {
					s.append((nodeList.get(i).neighbors.get(j).name));
				} else {
					s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
				}
			}
			s.append("\n");
		}
		return s.toString();
	}

	// BFS internal
	void bfsVisit(GraphNode_AL node) {
		LinkedList<GraphNode_AL> queue = new LinkedList<GraphNode_AL>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode_AL currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			for (GraphNode_AL neighbor : currentNode.neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}

	void bfs() {
		for (GraphNode_AL node : nodeList) {
			node.isVisited = false;
		}

		for (GraphNode_AL node : nodeList) {
			if (!node.isVisited) {
				bfsVisit(node);
			}
		}
	}

	void dfsVisit(GraphNode_AL node) {
		Stack<GraphNode_AL> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			GraphNode_AL currentNode = stack.pop();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			for (GraphNode_AL neighbor : currentNode.neighbors) {
				if (!neighbor.isVisited) {
					stack.push(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}

	void dfs() {
		for (GraphNode_AL node : nodeList) {
			node.isVisited = false;
		}

		for (GraphNode_AL node : nodeList) {
			if (!node.isVisited) {
				dfsVisit(node);
			}
		}
	}

	// Topological Sort
	public void addDirectedEdge(int i, int j) {
		GraphNode_AL first = nodeList.get(i);
		GraphNode_AL second = nodeList.get(j);
		first.neighbors.add(second);
	}

	void topologicalVisit(GraphNode_AL node, Stack<GraphNode_AL> stack) {
		for (GraphNode_AL neighbor : node.neighbors) {
			if (!neighbor.isVisited) {
				topologicalVisit(neighbor, stack);
			}
		}
		node.isVisited = true;
		stack.push(node);
	}

	void topologicalSort() {
		Stack<GraphNode_AL> stack = new Stack<>();
		for (GraphNode_AL node : nodeList) {
			if (!node.isVisited) {
				topologicalVisit(node, stack);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().name + " ");
		}
	}

	// SSSP
	public static void pathPrint(GraphNode_AL node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
	}

	public void BFSForSSSPP(GraphNode_AL node) {
		LinkedList<GraphNode_AL> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode_AL currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print("Printing path for node " + currentNode.name + ": ");
			pathPrint(currentNode);
			System.out.println();
			for (GraphNode_AL neighbor : currentNode.neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
					neighbor.parent = currentNode;
				}
			}

		}
	}

	public static void main(String[] args) {
		ArrayList<GraphNode_AL> nodeList = new ArrayList<GraphNode_AL>();
		nodeList.add(new GraphNode_AL("A", 0));
		nodeList.add(new GraphNode_AL("B", 1));
		nodeList.add(new GraphNode_AL("C", 2));
		nodeList.add(new GraphNode_AL("D", 3));
		nodeList.add(new GraphNode_AL("E", 4));

		GraphAL graph = new GraphAL(nodeList);
		graph.addUndirectedEdge(0, 1);
		graph.addUndirectedEdge(0, 2);
		graph.addUndirectedEdge(0, 3);
		graph.addUndirectedEdge(1, 4);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(3, 4);

		System.out.println("Adjacency List");
		System.out.println(graph.toString());

		// ----- bfs -----
		System.out.println("\nBFS Visit");
		graph.bfs();

		// ----- dfs -----
		System.out.println("\n\nDFS Visit");
		graph.dfs();
		System.out.println("\n");

		// ----- new graph for topological sort -----
		ArrayList<GraphNode_AL> nodeList2 = new ArrayList<GraphNode_AL>();
		nodeList2.add(new GraphNode_AL("A", 0));
		nodeList2.add(new GraphNode_AL("B", 1));
		nodeList2.add(new GraphNode_AL("C", 2));
		nodeList2.add(new GraphNode_AL("D", 3));
		nodeList2.add(new GraphNode_AL("E", 4));
		nodeList2.add(new GraphNode_AL("F", 5));
		nodeList2.add(new GraphNode_AL("G", 6));
		nodeList2.add(new GraphNode_AL("H", 7));

		GraphAL graph2 = new GraphAL(nodeList2);
		graph2.addDirectedEdge(0, 2);
		graph2.addDirectedEdge(2, 4);
		graph2.addDirectedEdge(4, 7);
		graph2.addDirectedEdge(4, 5);
		graph2.addDirectedEdge(5, 6);
		graph2.addDirectedEdge(1, 2);
		graph2.addDirectedEdge(1, 3);
		graph2.addDirectedEdge(3, 5);

//		System.out.println(graph2.toString());

		// ----- topological sort -----
		System.out.println("Topological Sort");
		graph2.topologicalSort();

		// ----- single source shortest path -----
		ArrayList<GraphNode_AL> nodeList3 = new ArrayList<GraphNode_AL>();
		nodeList3.add(new GraphNode_AL("A", 0));
		nodeList3.add(new GraphNode_AL("B", 1));
		nodeList3.add(new GraphNode_AL("C", 2));
		nodeList3.add(new GraphNode_AL("D", 3));
		nodeList3.add(new GraphNode_AL("E", 4));
		nodeList3.add(new GraphNode_AL("F", 5));
		nodeList3.add(new GraphNode_AL("G", 6));

		GraphAL graph3 = new GraphAL(nodeList3);
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

class GraphNode_AL {
	public String name;
	public int index;
	public boolean isVisited = false;
	public GraphNode_AL parent;

	public ArrayList<GraphNode_AL> neighbors = new ArrayList<GraphNode_AL>();

	public GraphNode_AL(String name, int index) {
		this.name = name;
		this.index = index;
	}
}
