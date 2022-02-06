package com.opentext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * reverse the word which has count of 't' is either 1 or 3
 * 
 * @author rakes
 *
 */
public class ReverseWords {

	public static String print(String input) {

		String result = "";
		String[] strArr = input.split(" ");

		for (String str : strArr) {

			List<String> list = Arrays.asList(str.split(""));

			int frequency = Collections.frequency(list, "t");
			if (frequency == 1 || frequency == 3) {
				Collections.reverse(list);

				result += str + " ";
			}

		}
		return result;
	}

	public static void main(String[] args) {

		// approach 1
		/*
		 * String input = "taste the thunder";
		 * 
		 * String result = print(input); for (int i = 0; i < args.length; i++) {
		 * System.out.println(result.charAt(i)); }
		 */

		// approach 2
		if (args.length > 0) {

		}
		String result = "";
		String[] strArr = args;

		for (String str : strArr) {

			List<String> list = Arrays.asList(str.split(""));

			int frequency = Collections.frequency(list, "t");
			if (frequency == 1 || frequency == 3) {
				Collections.reverse(list);

				result += str + " ";
			}

		}

		int length = result.length();
		for (int i = length - 1; i <= 0; i--) {
			System.out.println(result.charAt(i));
		}

	}

}
