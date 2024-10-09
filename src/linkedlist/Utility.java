package linkedlist;

public class Utility {
	// utility function which prints from a node
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
