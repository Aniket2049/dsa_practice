package queue;

public class Queue {
	private int length;
	private ListNode front, rear;

	public Queue() {
		length = 0;
		front = rear = null;
	}

	public void enQueue(int data) {
		ListNode newNode = new ListNode(data);
		if (isEmpty()) {
			front = newNode;
		} else {
			rear.next = newNode;
		}
		rear = newNode;
		length++;
	}

	public int deQueue() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		int result = front.data;
		front = front.next;
		length--;
		if (isEmpty()) {
			rear = null;
			length = 0;
		}

		return result;

	}

	public int first() {
		return front.data;
	}

	public int size() {
		return length;
	}

	private boolean isEmpty() {
		return length == 0;
	}

	public String toString() {
		ListNode temp = front;
		StringBuilder sb = new StringBuilder();

		while (temp != null) {
			sb.append(temp.data + " -> ");
			temp = temp.next;
		}

		return sb.toString();
	}
}
