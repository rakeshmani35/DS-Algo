package com.subsequesnce.subString;

public class LargestSumContigousSubArray {

	public void maxSumSubarray(int[] arr) {

		int max_so_far = arr[0];
		int max_end_here = 0;

		int start_index = 0;
		int end_index = 0;
		int search_for_start = 0;

		for (int i = 0; i < arr.length; i++) {

			max_end_here = max_end_here + arr[i];

			if (max_so_far < max_end_here) {
				max_so_far = max_end_here;
				start_index = search_for_start;
				end_index = i;
			}
			if (max_end_here < 0) {
				max_end_here = 0;
				search_for_start = i + 1;
			}
		}

		System.out.println("Largest Sum of Contigous Sub-Array = " + max_so_far);
		printArray(arr, start_index, end_index);
		return;
	}

	private void printArray(int[] arr, int start, int end) {
		System.out.println("printing subarray for largest sum : ");
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {

		int[] arr = { 4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2 };
		LargestSumContigousSubArray sum = new LargestSumContigousSubArray();
		sum.maxSumSubarray(arr);
	}

}
