package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {

	ArrayList<WeightedNode_DS> nodeList = new ArrayList<WeightedNode_DS>();
	ArrayList<UndirectedEdge> edgeList = new ArrayList<UndirectedEdge>();

	public Kruskal(ArrayList<WeightedNode_DS> nodeList) {
		this.nodeList = nodeList;
	}

	public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
		UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
		WeightedNode_DS first = edge.first;
		WeightedNode_DS second = edge.second;
		first.neighbors.add(second);
		second.neighbors.add(first);
		first.weightMap.put(second, weight);
		second.weightMap.put(first, weight);
		edgeList.add(edge);
	}

	void kruskal() {
		DisjointSet.makeSet(nodeList);
		Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
			@Override
			public int compare(UndirectedEdge o1, UndirectedEdge o2) {
				return o1.weight - o2.weight;
			}
		};

		Collections.sort(edgeList, comparator);
		int cost = 0;
		for (UndirectedEdge edge : edgeList) {
			WeightedNode_DS first = edge.first;
			WeightedNode_DS second = edge.second;
			if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))) {
				DisjointSet.union(first, second);
				cost += edge.weight;
				System.out.println("Taken " + edge);
			}
		}

		System.out.println("\nTotal cost of MST: " + cost);
	}

	public static void main(String[] args) {
		ArrayList<WeightedNode_DS> nodeList = new ArrayList<WeightedNode_DS>();
		nodeList.add(new WeightedNode_DS("A"));
		nodeList.add(new WeightedNode_DS("B"));
		nodeList.add(new WeightedNode_DS("C"));
		nodeList.add(new WeightedNode_DS("D"));
		nodeList.add(new WeightedNode_DS("E"));

		Kruskal graph = new Kruskal(nodeList);
		graph.addWeightedUndirectedEdge(0, 1, 5);
		graph.addWeightedUndirectedEdge(0, 2, 13);
		graph.addWeightedUndirectedEdge(0, 4, 15);
		graph.addWeightedUndirectedEdge(1, 2, 10);
		graph.addWeightedUndirectedEdge(1, 3, 8);
		graph.addWeightedUndirectedEdge(2, 3, 6);
		graph.addWeightedUndirectedEdge(2, 4, 20);
		System.out.println("Kruskal");
		graph.kruskal();

	}

}

class UndirectedEdge {
	public WeightedNode_DS first;
	public WeightedNode_DS second;
	public int weight;

	public UndirectedEdge(WeightedNode_DS first, WeightedNode_DS second, int weight) {
		this.first = first;
		this.second = second;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge (" + first + "," + second + "), weight = " + weight;
	}
}
