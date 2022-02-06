import java.util.Stack;

public class FindValidParantheses {

	public static boolean isValidParantases(String input) {

		Stack<Character> s = new Stack<Character>();

		for (int i = 0; i < input.length(); i++) {

			char charAt = input.charAt(i);
			if (charAt == '{') {
				s.push('}');
			}
			if (charAt == '[') {
				s.push(']');
			}
			if (charAt == '(') {
				s.push(')');
			} else if (charAt == '}' || charAt == ']' || charAt == ')') {
				if (s.isEmpty() || s.pop() != charAt) {
					return false;
				}
			}
		}

		return s.isEmpty();
	}

	public static void main(String[] args) {

		String input = "{{]";
		System.out.println("is input {{] valid: " + isValidParantases(input));

		input = "()()([]({}))[]";
		System.out.println("is input ()()([]({}))[] valid: " + isValidParantases(input));

		input = "()({])";
		System.out.println("is input ()({]) valid: " + isValidParantases(input));

		input = "[]{}()";
		System.out.println("is input []{}() valid: " + isValidParantases(input));

		input = "[(}{)]";
		System.out.println("is input [(}{)] valid: " + isValidParantases(input));
	}

}
