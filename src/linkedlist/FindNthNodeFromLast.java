package linkedlist;

import java.util.Random;

// program to find nth node from last of a linked list
public class FindNthNodeFromLast {

	public static void main(String[] args) {
		Random rand = new Random();
		int low = 10;
		int high = 20;
		int lengthOfList = rand.nextInt(high - low) + low;

		LinkedList list = new LinkedList();
		for (int i = 0; i < lengthOfList; i++) {
			list.insertAtStart(rand.nextInt(100));
		}

		System.out.println(list.toString());

		// ---------- problem setup done ------------

		int lengthOfListFound = 0;
		ListNode temp = list.head;
		while (temp != null) {
			lengthOfListFound += 1;
			temp = temp.next;
		}
		int n = lengthOfList - 5;
		int indexNeeded = lengthOfListFound - n;
		temp = list.head;
		for (int i = 0; i < indexNeeded; i++) {
			temp = temp.next;
		}
		System.out.println("Node: " + temp.data);

	}

}
