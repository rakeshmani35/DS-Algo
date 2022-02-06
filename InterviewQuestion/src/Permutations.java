import java.util.HashSet;
import java.util.Set;

// https://www.journaldev.com/526/java-program-to-find-all-permutations-of-a-string
// https://algorithms.tutorialhorizon.com/print-all-the-permutations-of-a-string/
// https://www.javatpoint.com/program-to-find-all-permutations-of-a-string

public class Permutations {

	// https://www.javatpoint.com/program-to-find-all-permutations-of-a-string
	public static void generatePermutation(String str, int start, int end) {

		if (start == end - 1) {
			System.out.println(str);
		} else {

			for (int j = start; j < end; j++) {

				// Swapping the string by fixing a character
				str = swap(str, start, j);

				// Recursively calling function generatePermutation() for rest of the characters
				generatePermutation(str, start + 1, end);

				// Backtracking and swapping the characters again.
				str = swap(str, start, j); // backtrack
			}
		}
	}

	// swapping the characters at position 'i' with character at position 'j'
	public static String swap(String s, int i, int j) {

		char[] charArray = s.toCharArray();
		char ch;
		ch = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = ch;
		return String.valueOf(charArray);
	}

	// https://www.journaldev.com/526/java-program-to-find-all-permutations-of-a-string
	public static Set<String> permutationFinder(String str) {

		Set<String> set = new HashSet<String>();
		//List<String> set = new ArrayList<String>(); // list giving duplicates

		if (str == null) {
			return null;
		}
		if (str.length() == 0) {
			set.add("");
			return set;
		}

		char firstChar = str.charAt(0);
		String remaining = str.substring(1);

		Set<String> words = permutationFinder(remaining);
		for (String strNew : words) {

			for (int i = 0; i <= strNew.length(); i++) {
				set.add(insertChar(strNew, firstChar, i));
			}
		}

		return set;
	}

	public static String insertChar(String str, char ch, int i) {

		String first = str.substring(0, i);
		String last = str.substring(i);

		return first + ch + last;
	}

	public static void main(String[] args) {

		String str = "AAC";
		int len = str.length();
		//generatePermutation(str, 0, len);
		
		System.out.println("\nPermutations for " + str + " are: \n" + permutationFinder(str));

	}

}
