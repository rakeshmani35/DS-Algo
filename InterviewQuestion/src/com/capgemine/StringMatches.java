package com.capgemine;

/*
 * AbC Abc true
 * 
 * AbC ABC true
 * 
 * ABC AbC false
 * 
 * ABC ABC true
 */
public class StringMatches {

	public static void match(String str1, String str2) {

		boolean result = false;

		for (int i = 0; i < str2.length(); i++) {

			for (int j = i; j < str1.length(); j++) {

				char c1 = str1.charAt(j);
				char c2 = str2.charAt(i);

				if (!isUpperCase(c1)) {

					Character.toUpperCase(c1);
					Character.toUpperCase(c2);

					if (c2 == c1) {
						result = true;
						break;
					}
				} else {
					if (c2 == c1) {
						result = true;
						break;
					} else {
						result = false;
					}
				}

			}
			if (result == false) {
				break;
			}
		}

		System.out.println(str1 + " is matched with " + str2 + " : " + result);
	}

	private static boolean isUpperCase(char ch) {

		if (ch >= 'A' && ch <= 'Z') {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		// String str = "AaDdHh";
		// for (char c : str.toCharArray()) {
		// System.out.println(c + " is uppercase : " + isUpperCase(c));
		// }

		String s1 = "AbC AbC ABC ABC ABDC";
		String s2 = "AbC ABC AbC ABC ABC";

		String[] str1 = s1.split(" ");
		String[] str2 = s2.split(" ");

		for (int i = 0; i < str1.length; i++) {

			match(str1[i], str2[i]);
		}

	}

}
