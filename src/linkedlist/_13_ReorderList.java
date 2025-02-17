package linkedlist;

// given a list as L1->L2->L3...->Ln-1->Ln reorder it as L1->Ln->L2->Ln-1....
public class _13_ReorderList {

	private static ListNode reverseList(ListNode head) {
		ListNode previous = null, currentNode = head;

		while (currentNode != null) {
			ListNode nextNode = currentNode.next;
			currentNode.next = previous;
			previous = currentNode;
			currentNode = nextNode;
		}
		return previous;
	}

	public static void reorderList(ListNode head) {
		if (head == null)
			return;

		ListNode slowPtr = head;
		ListNode fastPtr = head;

		// split the list in two halves and reverse the second
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		ListNode head2 = slowPtr.next;
		slowPtr.next = null;
		head2 = reverseList(head2);

		// add nodes from second into first (second will always be the smaller)
		ListNode ptr1 = head;
		ListNode ptr2 = head2;

		while (ptr2 != null) {
			ListNode nodeToBeInserted = ptr2;
			ptr2 = ptr2.next;
			nodeToBeInserted.next = ptr1.next;
			ptr1.next = nodeToBeInserted;

			ptr1 = ptr1.next.next;
		}

	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();

		for (int i = 1; i <= 5; i++) {
			list1.insertAtEnd(i);
		}

		System.out.println("Original Linked List : " + list1.toString());

		// ---------- problem setup done ------------

		System.out.println("\n--- Solution 1 ---");
		reorderList(list1.head);
		System.out.println("Modified Linked List : " + list1.toString());

	}

}
