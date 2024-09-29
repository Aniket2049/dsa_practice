package linkedlist;

// program to insert in a sorted loop
public class InsertInASortedList {

	// take two pointers starting from head, one leads other follows
	// following one jumps to leaders position
	// leading one traverses until its data value is less than new data
	// insert new node between follower and leader
	public static void Solution1(LinkedList list, int data) {
		ListNode temp = list.head;
		ListNode preTemp = list.head;
		ListNode newNode = new ListNode(data);

		if (list.head == null) {
			list.insertAtStart(data);
			return;
		}

		while (temp.data <= newNode.data && temp != null) {
			preTemp = temp;
			temp = temp.next;
		}

		preTemp.next = newNode;
		newNode.next = temp;

		System.out.println("Modified Linked List : " + list.toString());

	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		int itemToInsert = 5;

		for (int i = 0; i < 10; i++) {
			if (i != itemToInsert)
				list.insertAtEnd(i);
		}

		System.out.println("Original Linked List : " + list.toString());

		// ---------- problem setup done ------------

		Solution1(list, itemToInsert);
	}

}
