// https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/

package com.searching.question;

public class AnagramCheckForTwoString {

	static int MAX = 256;

	public static void isAnagram(String text1, String text2) {

		int[] count1 = new int[MAX];
		int[] count2 = new int[MAX];

		if (text1.length() != text2.length()) {
			System.out.println(text1 + " and " + text2 + " : are not anagram");
		} else {
			for (int i = 0; i < text1.length(); i++) {
				(count1[text1.charAt(i)])++;
				(count2[text2.charAt(i)])++;
			}
			if (compare(count1, count2)) {
				System.out.println(text1 + " and " + text2 + " : are  anagram");
			} else {
				System.out.println(text1 + " and " + text2 + " : are not anagram");
			}
		}
	}

	public static boolean compare(int[] count1, int[] count2) {

		for (int i = 0; i < MAX; i++) {
			if (count1[i] != count2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		String text1 = "geeksforgeeks";
		String text2 = "forgeeksgeeks";

		isAnagram(text1, text2);

	}

}
