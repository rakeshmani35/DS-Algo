package com.united.health;

public class DivisiblityOfString {

	public static int findSmallestDivisor(String s, String t) {

		int slength = s.length();
		int tlength = t.length();
		int result = 0;

		if (slength % tlength == 0) {

			int k = 0;

			String str1 = t.substring(0, tlength / 2);
			str1 += str1;
			int range = 0;
			if (t.contains(str1)) {
				range = tlength / 2;
			} else {
				range = tlength;
			}

			while (k < range) {
				String str = t.substring(0, k + 1);
				k++;

				int length = str.length();
				int sl = slength / length;
				int tl = tlength / length;

				int i = 0, j = 0;
				String temp1 = "";
				String temp2 = "";
				while (i < tl) {
					temp1 += str;
					i++;
				}

				if (t.contains(temp1)) {
					while (j < sl) {
						temp2 += str;
						j++;
					}
				}

				if (s.contains(temp2)) {
					result = str.length();
				}
			}

		} else {
			result = -1;
		}
		return result;
	}

	public static void main(String[] args) {

		// String s = "bcdbcdbcdbcd";
		// String t = "bcdbcd";

		String s = "lrbbblrbbb";
		String t = "lrbbb";

		int result = findSmallestDivisor(s, t);

		System.out.println("result = " + result);
	}

}
