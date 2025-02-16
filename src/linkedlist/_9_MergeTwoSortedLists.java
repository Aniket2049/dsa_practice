package linkedlist;

// program to merge two sorted lists into one sorted
public class _9_MergeTwoSortedLists {

	// take two head pointers and compare values. push next node into third one
	// according to sort logic. at end check if either of list still has
	// elements, if they do append to third list
	public static ListNode Solution1(ListNode head1, ListNode head2) {
		ListNode head = new ListNode(0);
		ListNode current = head;

		while (head1 != null && head2 != null) {
			if (head1.data <= head2.data) {
				current.next = head1;
				head1 = head1.next;
				current = current.next;
			} else {
				current.next = head2;
				head2 = head2.next;
				current = current.next;
			}
		}

		if (head1 != null)
			current.next = head1;
		else if (head2 != null)
			current.next = head2;

		return head.next;
	}

	// Recursive Solution
	public static ListNode Solution2(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		ListNode head = null;

		if (head1.data <= head2.data) {
			head = head1;
			head.next = Solution2(head1.next, head2);
		} else {
			head = head2;
			head.next = Solution2(head1, head2.next);
		}

		return head;

	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				list1.insertAtEnd(i);
			else
				list2.insertAtEnd(i);
		}

		System.out.println("Original Linked List : " + list1.toString());
		System.out.println("Original Linked List : " + list2.toString());

		// ---------- problem setup done ------------

		System.out.println("\n--- Solution 1 ---");
		Utility.printList(Solution1(list1.head, list2.head));
		
		System.out.println("\n--- Solution 1 ---");
		Utility.printList(Solution2(list1.head, list2.head));

	}

}
