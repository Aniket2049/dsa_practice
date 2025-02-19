package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

// reverse first k elements of a queue
public class _2_ReverseFirstKelementsOfQueue {

	public Queue<Integer> reverseFirstK(Queue<Integer> q, int K) {
		Stack<Integer> stk = new Stack<Integer>();

		for (int i = 0; i < K; i++) {
			stk.push(q.poll());
		}

		while (!stk.isEmpty()) {
			q.add(stk.pop());
		}

		for (int i = 0; i < q.size() - K; i++) {
			q.add(q.poll());
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

		q = new _2_ReverseFirstKelementsOfQueue().reverseFirstK(q, 3);

		System.out.println("\nAfter");
		for (Object item : q) {
			System.out.print(item.toString() + " -> ");
		}

	}

}
