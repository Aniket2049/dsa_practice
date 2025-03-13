package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import graph.GraphAM.GraphNode;

public class GraphAL {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public GraphAL(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i);
		GraphNode second = nodeList.get(j);
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
	void bfsVisit(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");
			for (GraphNode neighbor : currentNode.neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}

	void bfs() {
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
			for (GraphNode neighbor : currentNode.neighbors) {
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

	static class GraphNode {
		public String name;
		public int index;
		public boolean isVisited = false;

		public ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();

		public GraphNode(String name, int index) {
			this.name = name;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		ArrayList<GraphNode> nodeList = new ArrayList<GraphAL.GraphNode>();
		nodeList.add(new GraphNode("A", 0));
		nodeList.add(new GraphNode("B", 1));
		nodeList.add(new GraphNode("C", 2));
		nodeList.add(new GraphNode("D", 3));
		nodeList.add(new GraphNode("E", 4));

		GraphAL graph = new GraphAL(nodeList);
		graph.addUndirectedEdge(0, 1);
		graph.addUndirectedEdge(0, 2);
		graph.addUndirectedEdge(0, 3);
		graph.addUndirectedEdge(1, 4);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(3, 4);

		System.out.println(graph.toString());
		System.out.println("\nBFS Visit");
		graph.bfs();
		System.out.println("\n\nDFS Visit");
		graph.bfs();
	}
}
