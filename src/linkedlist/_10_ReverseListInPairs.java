package linkedlist;

// program to reverse a linked list in pairs. 
// ex: input : 1->2->3->4->X | output: 2->1->4->3->X
public class _10_ReverseListInPairs {

	// Iterative solution
	public static ListNode Solution1(ListNode head) {
		ListNode nextToHead = null;
		ListNode temp = null;

		while (head != null && head.next != null) {
			if (nextToHead != null) {
				nextToHead.next.next = head.next;
			}

			nextToHead = head.next;
			head.next = head.next.next;
			nextToHead.next = head;
			if (temp == null) {
				temp = nextToHead;
			}

			head = head.next;
		}

		return temp;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		for (int i = 0; i < 10; i++) {
			list.insertAtEnd(i);
		}

		System.out.println("Original Linked List : " + list.toString());

		// ---------- problem setup done ------------

		System.out.println("--- Solution1 ---");
		Utility.printList(Solution1(list.head));

	}

}
