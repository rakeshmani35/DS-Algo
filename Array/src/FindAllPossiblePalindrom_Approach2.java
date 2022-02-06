import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.techiedelight.com/find-possible-palindromic-substrings-string/
public class FindAllPossiblePalindrom_Approach2 {

	public static void intermediatePalindrom(String str, int left, int right,List<String> list) {
		
		while (left >= 0 && right < str.length() && str.charAt(left)==str.charAt(right)) {
			
			//set.add(str.substring(left, right+1));
		
			list.add(str.substring(left, right+1));
			
			left--;
			right++;
		}
	}
	
	private static void  getAllPalindrom(String str) {
		
		Set<String> set = new HashSet<String>();
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < str.length(); i++) {
			
			// for odd
			intermediatePalindrom(str, i, i, list);
			// for even
			intermediatePalindrom(str, i, i+1, list);
		}
		
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		
		//String str = "google";
		//String str = "abcbaba";
		String str = "aaaa";
		getAllPalindrom(str);
	}

}
