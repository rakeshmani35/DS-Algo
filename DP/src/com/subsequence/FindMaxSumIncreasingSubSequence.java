package com.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// https://www.youtube.com/watch?v=80_2xFu47Is&list=PLCZJSEiJwWZ7kd4wXxIkFiU6mYXsCwYOC&index=2
public class FindMaxSumIncreasingSubSequence {

	public static void maxSum(int[] arr) {

		int[] dp = new int[arr.length]; // final ans: [1, 6, 5, 13, 25, 24]
		// store index to find the element
		int[] temp = new int[arr.length]; // [0, 0, 0, 1, 3, 3]

		System.arraycopy(arr, 0, dp, 0, arr.length);

		for (int i = 1; i < dp.length; i++) {

			int x = dp[i];

			for (int j = 0; j < i; j++) {

				int y = dp[j];
				// int sum = dp[j] + dp[i]; // or use instead of (x+y)

				if (arr[j] < arr[i] && (x + y > dp[i])) {
					dp[i] = x + y;
					temp[i] = j;
				}

			}
		}

		findElement(arr, dp, temp);
		return;
	}

	public static void findElement(int[] arr, int[] dp, int[] temp) {

		int max = Arrays.stream(dp).max().getAsInt();
		int indexOf = IntStream.range(0, dp.length).filter(p -> max == dp[p]).findFirst().getAsInt();
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(arr[indexOf]);
		
		int x = temp[indexOf];
		
		
		return ;

	}

	public static void main(String[] args) {

		int[] arr = { 1, 5, 4, 7, 12, 11 };

		maxSum(arr);
	}

}
