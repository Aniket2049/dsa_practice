package graph;

import java.util.ArrayList;
import java.util.List;

// https://www.tutorialspoint.com/data_structures_algorithms/topological_sorting.htm
public class TopologicalSort {

	static final int MAX_VERTICES = 6;
	static int[][] adj = { { 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 } };
	static int[] visited = new int[MAX_VERTICES];
	static List<Integer> topologicalOrder = new ArrayList<>();

	static void DFS(int vertex) {
		visited[vertex] = 1;
		for (int v = 0; v < MAX_VERTICES; v++) {
			if (adj[vertex][v] == 1 && visited[v] == 0) {
				DFS(v);
			}
		}
		topologicalOrder.add(vertex);
	}

	static void topologicalSort() {
		for (int v = 0; v < MAX_VERTICES; v++) {
			if (visited[v] == 0) {
				DFS(v);
			}
		}
	}

	static void printTopologicalOrder() {
		System.out.print("Topological Order: ");
		for (int i = topologicalOrder.size() - 1; i >= 0; i--) {
			System.out.print(topologicalOrder.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		topologicalSort();
		printTopologicalOrder();

	}

}
