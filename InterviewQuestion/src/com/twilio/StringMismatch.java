package com.twilio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringMismatch {

	public static List<String> mismatch(String s, String t) {

		String result = "";

		String[] split1 = s.split(" ");
		String[] split2 = t.split(" ");

		int k = 0;

		for (String x : split2) {

			for (int i = k; i < split1.length; i++) {
				String y = split1[i];

				if (!x.equals(y)) {
					result += y + " ";
				} else {
					k++;
					break;
				}
				k++;
			}

		}

		List<String> list = Stream.of(result.split(" ")).collect(Collectors.toList());

		return list;
	}

	public static void main(String[] args) {

		String s = "Python is an easy to learn powerful programming language It has efficient high-level data structures and a simple but effective approach to objectoriented programming Python elegant syntax and dynamic typing";

		String t = "programming Python elegant syntax and dynamic typing";

		List<String> mismatch = mismatch(s, t);

		System.out.println(mismatch);
	}

}
