package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

// reverse contents of a queue
public class _1_ReverseAQueue {

	public Queue<Integer> reverseQueue(Queue<Integer> q) {
		Stack<Integer> stk = new Stack<Integer>();

		while (!q.isEmpty()) {
			stk.push(q.poll());
		}

		while (!stk.isEmpty()) {
			q.add(stk.pop());
		}

		return q;
	}

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			q.add(rand.nextInt(100));
		}

		System.out.println("Before");
		for (Object item : q) {
			System.out.print(item.toString() + " -> ");
		}

		q = new _1_ReverseAQueue().reverseQueue(q);

		System.out.println("\nAfter");
		for (Object item : q) {
			System.out.print(item.toString() + " -> ");
		}

	}

}
