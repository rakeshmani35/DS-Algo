package com.infix.postfix.prefix;

import java.util.Stack;

public class ConvertInfixToPostfix {

	public static String infixToPostfix(String infix) {

		String result = "";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);

			// check if char is operator
			if (precedence(c) > 0) {
				if (precedence(c) == 3) {
					stack.push(c);
				} else {
					while (stack.isEmpty() == false && precedence(stack.peek()) >= precedence(c)) {
						result += stack.pop();
					}
					stack.push(c);
				}

			} else if (c == ')') {
				char x = stack.pop();
				while (x != '(') {
					result += x;
					x = stack.pop();
				}
			} else if (c == '(') {
				stack.push(c);
			} else {
				// character is neither operator nor (
				result += c;
			}
		}
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
	}

	public static int precedence(char c) {

		switch (c) {
		case '+':
		case '-':
			return 1; // lower precedence
		case '*':
		case '/':
			return 2; // // Middle precedence
		case '^':
			return 3; // highest precedence
		}
		return -1;
	}

	public static void main(String[] args) {

		String infix = "K+L-M*N+(O^P)*W/U/V*T+Q^J^A";
		String postfix = infixToPostfix(infix);
		System.out.println("postfix of infix : " + infix + " is = " + postfix);

	}

}
