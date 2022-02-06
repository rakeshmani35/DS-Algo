package com.subsequence;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=qO4YOsakh_M&list=PLCZJSEiJwWZ7kd4wXxIkFiU6mYXsCwYOC&index=10
/**
 * 3 Approach:
 * 
 * 1. Recursive
 * 
 * 2. Memoization(Top Down) DP
 * 
 * 3. Tabular (Bottom up) DP
 * 
 * @author rakes
 *
 */
public class LongestCommonSubSequence {

	// 1. Recursive Approach
	public static int LCS_Recursive(String s1, String s2, int m, int n) {

		// break condition
		if (m == 0 || n == 0) {
			return 0;
		}

		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return LCS_Recursive(s1, s2, m - 1, n - 1) + 1;
		} else {
			int left = LCS_Recursive(s1, s2, m - 1, n);
			int right = LCS_Recursive(s1, s2, m, n - 1);
			return Math.max(left, right);
		}
	}

	// 2. Memoization (Top Down) Approach
	public static int LCS_TopDown(String s1, String s2, int m, int n, Map<String, Integer> lookup) {

		if (m == 0 | n == 0) {
			return 0;
		}

		String key = m + "|" + n;

		if (!lookup.containsKey(key)) {

			if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
				lookup.put(key, LCS_TopDown(s1, s2, m - 1, n - 1, lookup) + 1);
			} else {

				int left = LCS_TopDown(s1, s2, m - 1, n, lookup);
				int right = LCS_TopDown(s1, s2, m, n - 1, lookup);
				lookup.put(key, Math.max(left, right));
			}
		}
		return lookup.get(key);
	}

	// 3. Tabulation (Bottom up) Approach
	public static int LCS_BottomUp(String s1, String s2, int m, int n) {

		// used to store result
		String result = "";

		// loockup table
		int[][] dp = new int[m + 1][n + 1];

		// base condition: 0th column is '0'
		for (int i = 0; i <= m; i++) {
			dp[i][0] = 0;
		}

		// base condition: 0th row is '0'
		for (int j = 0; j <= n; j++) {
			dp[0][j] = 0;
		}

		for (int i = 1; i <= m; i++) {

			for (int j = 1; j <= n; j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					result += String.valueOf(s1.charAt(i - 1));
				} else {
					//dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]); // OR
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {

		String s1 = "abcbda";
		String s2 = "bdcaba";

		int m = s1.length();
		int n = s2.length();

		int lcs_Recursive = LCS_Recursive(s1, s2, m, n);
		System.out.println("LCS recursive = " + lcs_Recursive);

		Map<String, Integer> lookup = new HashMap<String, Integer>();
		int lcs_TopDown = LCS_TopDown(s1, s2, m, n, lookup);
		System.out.println("LCS Topdown = " + lcs_TopDown);

		int LCS_BottomUp = LCS_BottomUp(s1, s2, m, n);
		System.out.println("LCS bottomUp = " + LCS_BottomUp);
	}

}
