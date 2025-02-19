package stack;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
// https://algo.monster/liteproblems/1047
public class _4_RemoveAllAdjacentDuplicatesInString {

	public String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (Character c : s.toCharArray()) {
			if (stack.size() > 0 && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Character c : stack)
			sb.append(c);

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new _4_RemoveAllAdjacentDuplicatesInString().removeDuplicates("abbaca"));
		System.out.println(new _4_RemoveAllAdjacentDuplicatesInString().removeDuplicates("azxxzy"));

	}

}
