import java.util.HashSet;
import java.util.Set;

// this is not given proper result
public class FindAllPossiblePalindrom_Approach1 {

	public static String intermediatePalindrom(String str, int left, int right) {

		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}

		return str.substring(left + 1, right);
	}

	public static Set<String> allPalindrom(String str) {
		
        Set<String> set = new HashSet<String>();
        
		for (int i = 0; i < str.length(); i++) {

			// for odd
			String palindrom = intermediatePalindrom(str, i, i);
			if (palindrom.length()>0) {
				set.add(palindrom);
			}
			
			// for even
			palindrom = intermediatePalindrom(str, i, i + 1);
			if (palindrom.length()>0) {
				set.add(palindrom);
			}
		}
		
		return set;
	}

	public static void main(String[] args) {

		String str = "google";
		Set<String> allPalindrom = allPalindrom(str);
		System.out.println(allPalindrom);

	}

}
