package stack;

import java.util.Stack;

// program which checks if parenthesis in a string are valid
// eg: ()((){[]}) -> valid
// eg: ()((){[[}) -> invalid
public class _1_ValidPrenthesis {

	public boolean isValidParenthesis(String data) {
		if (data == null || data.length() == 0)
			return true;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == ')') {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else
					return false;
			} else if (data.charAt(i) == '}') {
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else
					return false;
			} else if (data.charAt(i) == ']') {
				if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				} else
					return false;
			} else {
				stack.push(data.charAt(i));
			}
		}

		if (stack.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String data1 = "()({()}[])";
		String data2 = "(){}[(]()";

		_1_ValidPrenthesis runner = new _1_ValidPrenthesis();
		System.out.println("");
		System.out.print("String 1 : " + data1 + " : " + runner.isValidParenthesis(data1));
		System.out.println("");
		System.out.print("String 2 : " + data2 + " : " + runner.isValidParenthesis(data2));

	}

}
