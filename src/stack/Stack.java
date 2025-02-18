package stack;

public class Stack {
	private int size;
	private ListNode top;

	public Stack() {
		size = 0;
		top = null;
	}

	public Stack(int firstEl) {

	}

	public void push(int data) {
		ListNode temp = new ListNode(data);
		temp.next = top;
		top = temp;
		size++;
	}

	public int pop() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		int result = top.data;
		top = top.next;
		size--;
		return result;
	}

	public int peek() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		int result = top.data;
		return result;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public String toString() {
		String result = "";

		ListNode temp = top;
		while (temp != null) {
			result = result + temp.data + " -> ";
			temp = temp.next;
		}

		return result;
	}
}
