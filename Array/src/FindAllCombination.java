
public class FindAllCombination {

	private static StringBuilder output = new StringBuilder();
	private static  String inputstring;

	/*
	 * public FindAllCombination(final String str) { inputstring = str;
	 * System.out.println("The input string  is  : " + inputstring); }
	 */
	public FindAllCombination() {}

	public static void combine() {
		combine(0);
	}

	private static void combine(int start) {
		for (int i = start; i < inputstring.length(); ++i) {
			output.append(inputstring.charAt(i));
			System.out.println(output);
			if (i < inputstring.length())
				combine(i + 1);
			output.setLength(output.length() - 1);
		}
	}

	public static void main(String[] args) {

		inputstring = "AABC";
		
		combine();
	}

}
