package linkedlist;

// https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
// https://leetcode.com/problems/palindrome-linked-list/description/
public class _12_DetectPalindromicList {

	public static void main(String[] args) {
		// Linked list : 1->2->3->2->1
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);

		boolean result = isPalindrome(head);

		if (result)
			System.out.println("true");
		else
			System.out.println("false");

	}

	// Function to reverse a linked list
	public static ListNode reverseLinkedList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	// Function to check if two lists are identical
	static boolean isIdentical(ListNode n1, ListNode n2) {
		while (n1 != null && n2 != null) {
			if (n1.data != n2.data)
				return false;
			n1 = n1.next;
			n2 = n2.next;
		}
		return true;
	}

	// Function to check whether the list is palindrome
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode head2 = reverseLinkedList(slow.next);
		slow.next = null;

		boolean answer = isIdentical(head, head2);

		head2 = reverseLinkedList(head2);
		slow.next = head2;

		return answer;
	}

	// -------------------------------------------------------------------------

	// Recursive Function to check whether
	// the list is palindrome
	static boolean isPalindromeRecur(ListNode end, ListNode[] start) {

		// base case
		if (end == null)
			return true;

		// Recursively check the right side.
		boolean right = isPalindromeRecur(end.next, start);

		// Compare the start and end nodes.
		boolean ans = right && start[0].data == end.data;

		// Update the start node
		start[0] = start[0].next;

		return ans;
	}

	// Function to check whether the list is palindrome
	static boolean isPalindromeRecursive(ListNode head) {

		// Set starting node to head
		ListNode[] start = new ListNode[] { head };

		// Recursively check the ll and return
		return isPalindromeRecur(head, start);
	}

}
