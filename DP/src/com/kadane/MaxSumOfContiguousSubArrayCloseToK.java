package com.kadane;

import java.util.TreeSet;

public class MaxSumOfContiguousSubArrayCloseToK {

	public static int getLargestSumCloseToK(int[] arr, int k) {
		int sum = 0;
		TreeSet<Integer> set = new TreeSet<Integer>();
		int result = Integer.MIN_VALUE;
		set.add(0);

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];

			Integer ceiling = set.ceiling(sum - k);
			if (ceiling != null) {
				result = Math.max(result, sum - ceiling);
			}

			set.add(sum);
		}

		return result;
	}

	public static void main(String[] args) {

		int[] arr = { 4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2 };
		int k = 0;
		int largestSumCloseToK = getLargestSumCloseToK(arr, k);
		System.out.println(largestSumCloseToK);
	}

}
