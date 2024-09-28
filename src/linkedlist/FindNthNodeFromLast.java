package linkedlist;

import java.util.Random;

// program to find nth node from last of a linked list
public class FindNthNodeFromLast {
	
	public static int counterForRecursiveSolution = 0;

	// Double Scan solution: 
	// 1. Find length of list 
	// 2. Iterate and stop at lengthOfList-n node
	public static void Solution1(LinkedList list, int n) {
		System.out.println("\n------ SOLUTION 1 ------");
		int lengthOfList = 0;
		ListNode temp = list.head;
		while (temp != null) {
			lengthOfList += 1;
			temp = temp.next;
		}
		// int n = lengthOfList - 5;
		int indexNeeded = lengthOfList - n;
		temp = list.head;
		for (int i = 0; i < indexNeeded; i++) {
			temp = temp.next;
		}
		System.out.println("Node: " + temp.data);
	}

	// Single Scan solution: use two pointers, the lagging one starts moving
	// only after leading one has iterated over n nodes, leading iterates till
	// end of list and lagging one is at solution
	public static void Solution2(LinkedList list, int n) {
		System.out.println("\n------ SOLUTION 2 ------");
		ListNode leader = list.head;
		ListNode lagger = list.head;
		int countdownForLagger = n;
		while (leader.next != null) {
			leader = leader.next;
			countdownForLagger--;
			if (countdownForLagger <= 0) {
				lagger = lagger.next;
			}
		}

		System.out.println("Node: " + lagger.data);

	}

	// Recursive solution
	public static void Solution3(ListNode head, int n) {
		if (head != null) {
			Solution3(head.next, n);
			counterForRecursiveSolution++;
			if (n == counterForRecursiveSolution) {
				System.out.println("Node: " + head.data);
			}
		}
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int low = 10;
		int high = 20;
		int lengthOfList = rand.nextInt(high - low) + low;
		int n = lengthOfList - rand.nextInt(10 - 1) + 1;

		LinkedList list = new LinkedList();
		for (int i = 0; i < lengthOfList; i++) {
			list.insertAtStart(rand.nextInt(100));
		}

		System.out.println("Original Linked List : " + list.toString());
		System.out.println("N : " + n);

		// ---------- problem setup done ------------

		// Solution 1
		Solution1(list, n);

		// Solution 2
		Solution2(list, n);
		
		// Solution 3
		Solution2(list, n);

	}

}
