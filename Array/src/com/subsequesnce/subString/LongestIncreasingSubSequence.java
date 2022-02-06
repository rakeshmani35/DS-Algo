package com.subsequesnce.subString;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

	public static void lis(int[] arr) {

		int[] lis = new int[arr.length];
		Arrays.fill(lis, 1);

		int[] subarr = new int[arr.length];

		for (int i = 1; i < subarr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);

					if (lis[j] + 1 >= lis[i]) {
						subarr[i] = j;
					}
					
				}
			}
		}
		findSubArray(arr, subarr);
		return;
	}

	public static void findSubArray(int[] arr, int[] subarr) {
		int subarrSize = subarr.length-1;
		int index = 0;
		int end=0;
		for ( int i = subarrSize; i >= 0; i++) {
			
			System.out.print(arr[i]+" ");
			index = subarr[i];
			i = index-1;
			
			if (i<0 && end==0) {
				end++;
			}else if(end>0){
				return;
			}
			
		}
		
	}
	
	public static void main(String[] args) {

		int[] arr = { 0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15 };

		int[] arr1 = { 3, 4, -1, 0, 6, 2, 3 };

		lis(arr1);

	}

}
