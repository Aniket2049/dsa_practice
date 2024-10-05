package linkedlist;

// program to display a linked list in reverse
public class PrintReverseList {

	public static void Solution1(ListNode head) {
		if (head == null)
			return;

		Solution1(head.next);
		System.out.println(head.data);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		for (int i = 0; i < 10; i++) {
			list.insertAtEnd(i);
		}

		System.out.println("Original Linked List : " + list.toString());

		// ---------- problem setup done ------------

		Solution1(list.head);

	}

}
