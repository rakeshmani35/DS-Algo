package com.test;

public class Test {

	public static String print(int[] arr) {

		String str;

		int count = 1;
		int temp = 0;
		int i = 0;
		int j  = 0;
		int k = 0;
		// {1,1,1,2,2,3,3,3,4,4,4,4,1};
		for (i = 0; i < arr.length; i++) {

			int x = arr[i];
			int count1 = 0;

			for ( j = k; j < arr.length; j++) {
				if (x == arr[j]) {
					count1++;
				} else {
					break;
				}
				
			}
			k = j;
			
			if (count1 > count) {
				count = count1;
				temp = x;
			}
			count1 = 0;
		}
		str = "(count = " + count + ", element = " + temp + ")";
		return str;
	}

	public static void main(String[] args) {

		/*
		 * int[] arr = { 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 1 };
		 * 
		 * String print = print(arr); System.out.println(print);
		 */
       
	}

}
