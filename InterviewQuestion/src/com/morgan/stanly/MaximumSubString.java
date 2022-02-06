package com.morgan.stanly;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/lexicographical-maximum-substring-string/
public class MaximumSubString {

	public static String maxSubstring(String s) {

		List<String> list = new ArrayList<String>();

		int j = 0;
		String str = null;
		for (int i = 0; i < s.length(); i++) {

			str = String.valueOf(s.charAt(i));
			list.add(str);
			j = i + 1;

			while (j < s.length()) {
				str += s.substring(j, j + 1);
				list.add(str);
				j++;
			}
		}

		return s;

	}

	public static String LexicographicalMaxString(String str) {
		// loop to find the max leicographic substring in the substring array
		String mx = "";
		for (int i = 0; i < str.length(); ++i) {
			if (mx.compareTo(str.substring(i)) <= 0) {
				mx = str.substring(i);
			}
		}

		return mx;
	}

	public static void main(String[] args) {

		 //String s = "banana";
		String s = "baca";
		//maxSubstring(s);
		
		String str = LexicographicalMaxString(s);
		System.out.println(str);
	}

}
