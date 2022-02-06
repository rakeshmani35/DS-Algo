import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindAllPermutationsOfString {

	public static Set<String> findAllPermutation(String str) {
		Set<String> set = new HashSet<String>();

		// base condition
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			set.add("");
			return set;
		}

		char first = str.charAt(0);// first character
		String remaining = str.substring(1);// Full string without first character
		Set<String> words = findAllPermutation(remaining);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				String s = charInsert(newString, first, i);
				set.add(s);
			}
		}

		return set;
	}
	
  public static Set<String> allCombination(String str){
	  Set<String> set = new HashSet();
	  
	  String newString = "";
	  String[] s = str.split("");
	  for (int i = 0; i < s.length; i++) {
		  newString += s[i];
		Set<String> findAllPermutation = findAllPermutation(newString);
		set.addAll(findAllPermutation);
	}
	  
	  return set;
  }

	public static Set<String> findAllPermutationOfGivenLength(String str, int k) {
		Set<String> set = new HashSet<String>();

		// base condition
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			set.add("");
			return set;
		}

		char first = str.charAt(0);// first character
		String remaining = str.substring(1);// Full string without first character
		Set<String> words = findAllPermutation(remaining);

		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				String s = charInsert(newString, first, i);
				set.add(s);
			}
		}
		return set;
	}

	public static String charInsert(String str, char c, int index) {
		String start = str.substring(0, index);
		String end = str.substring(index);
		return start + c + end;
	}

	public static void main(String[] args) {

		String str = "ABC";
		Set<String> allPermutation = findAllPermutation(str);
		System.out.println("all permutations = " + allPermutation);
		Set<String> allCombination = allCombination(str);
		System.out.println("all combination of "+ str + " is = " + allCombination);

		//int k = 2;
		//Set<String> perm = findAllPermutationOfGivenLength(str, k);
		//System.out.println("all permutations of given length " + k + " is = " + perm);

	}

}
