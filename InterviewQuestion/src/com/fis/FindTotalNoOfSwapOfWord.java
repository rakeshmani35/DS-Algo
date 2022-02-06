package com.fis;

public class FindTotalNoOfSwapOfWord {

	public static int findSwapCount(String input1, int input2, int input3) {

		int l1 = input1.length();
		String temp = input1;
		String str1 = null;
		String str2 = null;
		String str = input1;

		int index1 = l1-input2;
		int index2 = l1-input3;
		int count = 0;
		if (input2 < l1 && input3 < l1) {

			while (true) {

				String s1 = str.substring(index1);
				str1 = s1 + str.substring(0, index1);
				System.out.println("str1 = " + str1);
				count++;
				if (temp.equals(str1)) {
					return count;
				}

				String s2 = str1.substring(index2);
				str2 = s2 + str1.substring(0, index2);
				System.out.println("str2 = " + str2);
				count++;
				if (temp.equals(str2)) {
					return count;
				}
				str = str2;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		String input1 = "abcde";
		int input2 = 1;
		int input3 = 2;

		int findSwapCount = findSwapCount(input1, input2, input3);
		System.out.println("total no of count for swap => "+findSwapCount);

	}

}
