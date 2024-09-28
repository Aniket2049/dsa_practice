package linkedlist;

public class LinkedList {
	public int length;
	public ListNode head;

	public LinkedList() {
		this.length = 0;
	}

	public void insertAtStart(int data) {
		ListNode node = new ListNode(data);

		if (head == null)
			head = node;
		else {
			node.next = head;
			this.head = node;
		}
		length++;
	}

	public void insertAtEnd(int data) {
		ListNode node = new ListNode(data);

		if (head == null)
			head = node;
		else {
			ListNode last;
			last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = node;
		}
		length++;
	}

	public void insertAt(int data, int position) {
		if (position <= 0)
			position = 0;
		if (position >= this.length)
			position = 0;

		if (head == null) {
			ListNode node = new ListNode(data);
			head = node;
		} else {
			ListNode temp = head;
			for (int i = 0; i < position; i++) {
				temp = temp.next;
			}

			ListNode node = new ListNode(data);
			node.next = temp.next;
			temp.next = node;
		}
		length++;
	}

	public ListNode removeFromStart() {
		ListNode node = head;
		if (node != null) {
			head = node.next;
			node.next = null;
		}
		length--;
		return node;
	}

	public ListNode removeFromEnd() {
		if (head == null) {
			return null;
		}

		ListNode temp = head;
		ListNode preTemp = head;
		while (temp.next != null) {
			preTemp = temp;
			temp = temp.next;
		}

		preTemp.next = null;
		length--;
		return temp;
	}

	public ListNode removeAt(int position) {
		ListNode tempnode;
		if (position <= 0)
			position = 0;
		if (position >= length)
			position = length;

		if (head == null)
			return null;

		ListNode node = head;
		for (int i = 0; i < position; i++) {
			node = node.next;
		}
		tempnode = node.next;
		node.next = node.next.next;
		length--;
		return tempnode;
	}

	public String toString() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}

		result = result + head.data;
		ListNode temp = head.next;
		while (temp != null) {
			result = result + "," + temp.data;
			temp = temp.next;
		}
		return result + "]";
	}
}
