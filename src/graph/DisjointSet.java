package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class DisjointSet {

	private ArrayList<WeightedNode_DS> nodeList = new ArrayList<>();

	public static void makeSet(ArrayList<WeightedNode_DS> nodeList) {
		for (WeightedNode_DS node : nodeList) {
			DisjointSet set = new DisjointSet();
			set.nodeList.add(node);
			node.set = set;
		}
	}

	public static DisjointSet findSet(WeightedNode_DS node) {
		return node.set;
	}

	public static DisjointSet union(WeightedNode_DS node1, WeightedNode_DS node2) {
		if (node1.set.equals(node2.set)) {
			return null;
		} else {
			DisjointSet set1 = node1.set;
			DisjointSet set2 = node2.set;

			if (set1.nodeList.size() > set2.nodeList.size()) {
				ArrayList<WeightedNode_DS> nodeSet2 = set2.nodeList;
				for (WeightedNode_DS node : nodeSet2) {
					node.set = set1;
					set1.nodeList.add(node);
				}
				return set1;
			} else {
				ArrayList<WeightedNode_DS> nodeSet1 = set1.nodeList;
				for (WeightedNode_DS node : nodeSet1) {
					node.set = set2;
					set2.nodeList.add(node);
				}
				return set2;
			}
		}
	}

	public void printAllNodesofThisSet() {
		System.out.println("Printing all nodes of the set: ");
		for (WeightedNode_DS node : nodeList) {
			System.out.print(node + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayList<WeightedNode_DS> nodeList = new ArrayList<WeightedNode_DS>();
		nodeList.add(new WeightedNode_DS("A"));
		nodeList.add(new WeightedNode_DS("B"));
		nodeList.add(new WeightedNode_DS("C"));
		nodeList.add(new WeightedNode_DS("D"));

		DisjointSet.makeSet(nodeList);
		WeightedNode_DS firstNode = nodeList.get(0);
		WeightedNode_DS secondNode = nodeList.get(1);
		DisjointSet output = DisjointSet.findSet(secondNode);
		output.printAllNodesofThisSet();

		DisjointSet.union(firstNode, secondNode);
		output = DisjointSet.findSet(secondNode);
		output.printAllNodesofThisSet();
	}

}

class WeightedNode_DS implements Comparable<WeightedNode_DS> {
	public String name;
	public ArrayList<WeightedNode_DS> neighbors = new ArrayList<WeightedNode_DS>();
	public HashMap<WeightedNode_DS, Integer> weightMap = new HashMap<>();
	public boolean isVisited = false;
	public WeightedNode_DS parent;
	public int distance;
	public int index;
	public DisjointSet set;

	public WeightedNode_DS(String name, int index) {
		this.name = name;
		distance = Integer.MAX_VALUE;
		this.index = index;
	}

	public WeightedNode_DS(String name) {
		this.name = name;
		distance = Integer.MAX_VALUE;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(WeightedNode_DS o) {
		return this.distance - o.distance;
	}

}
