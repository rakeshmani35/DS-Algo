
public class LongestPalindromInString {

	public static String intermediatePalindrom(String str, int left, int right) {

		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}

		return str.substring(left + 1, right);
	}

	public static String longestPalindrom(String str) {

		String longestPalindrom = "";
		int length = 0;
		for (int i = 0; i < str.length(); i++) {

			// for odd case
			String longest = intermediatePalindrom(str, i, i);
			if (longest.length() > length) {
				length = longest.length();
				longestPalindrom = longest;
			}

			// for even case
			longest = intermediatePalindrom(str, i, i + 1);
			if (longest.length() > length) {
				length = longest.length();
				longestPalindrom = longest;
			}
		}

		return longestPalindrom;
	}

	public static void main(String[] args) {

		String str = "google";
		String longestPalindrom = longestPalindrom(str);
		System.out.println("longest palindrom = " + longestPalindrom);

	}

}
