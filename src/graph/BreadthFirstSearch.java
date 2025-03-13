package graph;

import java.util.LinkedList;
import java.util.Queue;

// https://www.tutorialspoint.com/data_structures_algorithms/breadth_first_traversal.htm
// https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
public class BreadthFirstSearch {

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);    // S - A
		graph.addEdge(0, 2);    // S - B
		graph.addEdge(0, 3);    // S - C
		graph.addEdge(1, 4);    // A - D
		graph.addEdge(2, 4);    // B - D
		graph.addEdge(3, 4);    // C - D
		System.out.print("Depth First Search: ");
		graph.breadthFirstSearch();
	}

	private static class Graph {
		private int[][] adjMatrix;
		private boolean[] visited;
		private int totalVertices;

		public Graph(int v) {
			this.totalVertices = v;
			this.adjMatrix = new int[v][v];
			this.visited = new boolean[v];
		}

		public void addEdge(int start, int end) {
			adjMatrix[start][end] = 1;
			adjMatrix[end][start] = 1;
		}

		public void breadthFirstSearch() {
			Queue<Integer> queue = new LinkedList<Integer>();
			this.visited = new boolean[totalVertices];
			queue.add(0);

			while (!queue.isEmpty()) {
				int nextNode = queue.remove();
				if (!visited[nextNode]) {
					visited[nextNode] = true;
					System.out.print(nextNode + " ");

					for (int i = 0; i < totalVertices; i++) {
						if (adjMatrix[nextNode][i] == 1 && !visited[i]) {
							queue.add(i);
						}
					}
				}
			}

		}
	}

}
