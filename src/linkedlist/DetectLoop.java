package linkedlist;

import java.util.Random;

// program to detect if there is a loop in linked list
public class DetectLoop {

	// Use two pointers, slow and fast both starting at head
	// fast moves two nodes, slow moves one node at a time
	// if they meet while traversing -> loop exists
	public static void Solution1(LinkedList list) {
		ListNode fastPointer = list.head;
		ListNode slowPointer = list.head;
		boolean isLoop = false;

		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;

			if (fastPointer == slowPointer) {
				isLoop = true;
				break;
			}
		}

		System.out.println("Loop : " + (isLoop ? "YES" : "NO"));

	}

	public static void main(String[] args) {
		Random rand = new Random();
		int low = 5;
		int high = 10;
		int lengthOfList = rand.nextInt(high - low) + low;
		boolean isLoopNodeDetected = false;

		LinkedList list = new LinkedList();
		ListNode loopLinkedNode = null;
		for (int i = 0; i < lengthOfList; i++) {
			list.insertAtStart(rand.nextInt(100));

			if (!isLoopNodeDetected && Math.random() < 0.5) {
				isLoopNodeDetected = true;
				loopLinkedNode = list.head;
			}
		}

		ListNode temp = list.head;
		while (loopLinkedNode != null && temp.next != null) {
			temp = temp.next;
		}
		temp.next = loopLinkedNode;

		// ---------- problem setup done ------------

		System.out.println(" --- Solution 1 ---");
		Solution1(list);
	}

}
