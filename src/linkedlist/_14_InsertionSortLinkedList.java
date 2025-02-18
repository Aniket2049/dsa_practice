package linkedlist;

import java.util.Random;

// insertion sort for linked lists
// https://www.youtube.com/watch?v=Kk6mXAzqX3Y
// https://leetcode.com/problems/insertion-sort-list/
// https://leetcode.com/problems/insertion-sort-list/solutions/6090333/easy-to-understand-insertion-sort-implementation-98-48-beat/
public class _14_InsertionSortLinkedList {

	public static ListNode insertionSortList(ListNode head) {
		// Edge case: If the list is empty or has only one node, it's already sorted
		if (head == null || head.next == null)
			return head;

		// Dummy node before the head to handle edge cases and simplify insertion logic
		ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
		ListNode prev = dummy; // Start prev at dummy

		// Traverse through the list
		while (head != null) {
			// If current node's value is greater than or equal to prev node's value
			if (head.data >= prev.data) {
				prev = prev.next; // Move prev forward in the list
				head = head.next; // Move head to the next node
			} else {
				// Otherwise, we need to insert this node in the sorted part
				ListNode temp = head.next; // Save next node in temp
				sort(dummy, head); // Insert head into the sorted list
				prev.next = temp; // Update prev's next pointer to skip over the current head
				head = temp; // Move head forward to the next unsorted node
			}
		}
		// Return the sorted list starting from dummy's next node
		return dummy.next;
	}

	private static void sort(ListNode dummy, ListNode node) {
		// Find the right place to insert the node in the sorted part
		while (dummy.next != null && dummy.next.data < node.data) {
			dummy = dummy.next; // Move dummy forward to find the correct insertion point
		}
		// Insert the node after dummy
		node.next = dummy.next; // The node's next pointer should point to the node after dummy
		dummy.next = node; // Update dummy's next to point to the current node
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();

		Random rand = new Random();
		for (int i = 1; i <= 10; i++) {
			list1.insertAtEnd(rand.nextInt(100));
		}

		System.out.println("Original Linked List : " + list1.toString());

		// ---------- problem setup done ------------

		System.out.println("\n--- Solution 1 ---");
		ListNode new2 = insertionSortList(list1.head);
		System.out.println(" ");
		while (new2 != null) {
			System.out.print(new2.data + " ");
			new2 = new2.next;
		}

	}

}
