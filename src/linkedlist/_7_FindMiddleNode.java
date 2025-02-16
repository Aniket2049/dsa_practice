package linkedlist;

public class _7_FindMiddleNode {

	public static ListNode Solution1(LinkedList list) {
		ListNode pointer1, pointer2;
		pointer1 = pointer2 = list.head;
		int i = 0;
		while (pointer1.next != null) {
			if (i == 0) {
				pointer1 = pointer1.next;
				i = 1;
			} else if (i == 1) {
				pointer1 = pointer1.next;
				pointer2 = pointer2.next;
				i = 0;
			}
		}
		return pointer2;
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.insertAtEnd(1);
		list1.insertAtEnd(2);
		list1.insertAtEnd(3);
		list1.insertAtEnd(4);
		list1.insertAtEnd(5);

		// --- problem setup done ---

		System.out.println(Solution1(list1).data);
	}

}
