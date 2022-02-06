// https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/

package com.searching.question;

public class AnagramSubstringSearch {

	static final int MAX = 256;

	public static void search(String pat, String text) {

		int P = pat.length();
		int T = text.length();

		//char[] countP = new char[MAX];
		//char[] countTW = new char[MAX];
		
		int[] countP = new int[MAX];
		int[] countTW = new int[MAX];

		for (int i = 0; i < P; i++) {
			(countP[pat.charAt(i)])++;
			(countTW[text.charAt(i)])++;
		}

		// Traverse through remaining characters of pattern
		for (int i = P; i < T; i++) {

			// Compare counts of current window
			// of text with counts of pattern[]
			if (compare(countP, countTW)) {
				System.out.println("Found at Index " + (i - P));
			}
			// Add current character to current window
			(countTW[text.charAt(i)])++;

			// Remove the first character of previous window
			countTW[text.charAt(i - P)]--;
		}
		// Check for the last window in text
		if (compare(countP, countTW)) {
			System.out.println("Found at Index " + (T - P));
		}
		
		return;
	}

	static boolean compare(char arr1[], char arr2[]) {
		for (int i = 0; i < MAX; i++)
			if (arr1[i] != arr2[i])
				return false;
		return true;
	}
	
	static boolean compare(int arr1[], int arr2[]) {
		for (int i = 0; i < MAX; i++)
			if (arr1[i] != arr2[i])
				return false;
		return true;
	}

	public static void main(String[] args) {

		String text = "BACDGABCDA";
		String pat = "ABCD";

		search(pat, text);
	}

}
