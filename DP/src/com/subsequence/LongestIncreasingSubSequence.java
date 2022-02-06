package com.subsequence;

import java.util.Arrays;

// https://www.youtube.com/watch?v=q5IWS6jLBjo&list=PLCZJSEiJwWZ7kd4wXxIkFiU6mYXsCwYOC&index=9
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
public class LongestIncreasingSubSequence {

	// 1. Recursive Approach
	public static int LIS_Recursive(int[] arr, int i, int n, int prev) {

		// base case : break condition
		if (i == n) {
			return 0;
		}

		// case1: exclude current element and process the remaining element
		int x = LIS_Recursive(arr, i + 1, n, prev);

		// case2: include current element, if it is greater then previous element in LIS
		int y = 0;
		if (arr[i] > prev) {
			y = 1 + LIS_Recursive(arr, i + 1, n, arr[i]);
		}

		return x;
	}

	// 3. Tabulation (Bottom up) Approach
	public static void LIS_TopDown(int[] arr) {

		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);

		int[] result = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {

			for (int j = 0; j < i; j++) {

				if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					result[i] = j;
				}

				// OR
				// if (arr[j] < arr[i]) {
				// dp[i] = Math.max(dp[i], dp[j] + 1);
				// result[i] = j;
				// }
			}
		}
		return;
	}

	public static void main(String[] args) {

		int[] arr = { 5, 8, 3, 7, 9, 1 };
		LIS_TopDown(arr);

		int startIndex = 0;
		int arrLen = arr.length;
		int prev = Integer.MIN_VALUE;

		LIS_Recursive(arr, startIndex, arrLen, prev);
	}

}
