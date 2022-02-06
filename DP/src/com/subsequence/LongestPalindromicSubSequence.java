package com.subsequence;

/**
 * input str = abcad
 * 
 * output: aba or aca
 * 
 * @author rakes
 *
 */
// https://www.youtube.com/watch?v=ERwwysleOKs&list=PLCZJSEiJwWZ7kd4wXxIkFiU6mYXsCwYOC&index=4

public class LongestPalindromicSubSequence {

	public static int palindromicSubsequence(String str) {

		int length = str.length();

		int[][] dp = new int[length][length];

		for (int i = 0; i < length; i++) {
			dp[i][i] = 1;
		}

		for (int len = 2; len <= length; len++) {

			for (int i = 0; i < length - len + 1; i++) {
				int j = i + len - 1;
				if (str.charAt(i) == str.charAt(j)) {
					int prev = 0;
					if (len != 2) {
						prev = dp[i + 1][j - 1];
					}
					dp[i][j] = 2 + prev;
				} else {
					dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][length - 1];
	}

	private static int max(int x, int y) {
		return (x > y) ? x : y;
	}

	public static void main(String[] args) {

		String str = "abcad";

		int l = palindromicSubsequence(str);
		System.out.println(l);
	}

}
