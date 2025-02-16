package linkedlist;

// program to reverse a linked list
public class _5_ReverseAList {

	// take three pointers previous, current, next
	// start with prev as null and current at head
	// in a loop assign next as currents next (in loop), set currents next to
	// previous, set previous as current, set current as next. return prev
	public static void Solution1(LinkedList list) {
		ListNode previous = null;
		ListNode current = list.head;

		while (current != null) {
			ListNode next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		list.head = previous;
		System.out.println("\n --- Solution 1 ---");
		System.out.println("Modified Linked List : " + list.toString());

	}

	// Recursive solution
	public static ListNode Solution2(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode newHead = Solution2(head.next);
		head.next.next = head;

		head.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		for (int i = 0; i < 10; i++) {
			list.insertAtEnd(i);
		}

		System.out.println("Original Linked List : " + list.toString());

		// ---------- problem setup done ------------

		Solution1(list);

		System.out.println("\n --- Solution 2 ---");
		list.head = Solution2(list.head);
		System.out.println("Modified Linked List : " + list.toString());

	}

}
