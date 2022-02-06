package com.opentext;

public class ReplaceCharBy1 {

	public static void replace(String[] s) {
		String str = "";
		int count = 0;

		for (int i = 0; i < s.length; i++) {

			String[] temp = s[i].split(" ");

			for (int j = 0; j < temp.length; j++) {
				count = 0;
				String s1 = temp[j];

				int len = s1.length();
				int k = 0;
				while (k < len) {

					if (s1.charAt(k) == 't') {
						count++;
						str += count;
					} else {
						str += s1.charAt(k);
					}
					k++;
				}

				str += " ";
			}

		}

		System.out.print(str);
	}

	public static void main(String[] args) {
		 String[] s= {"opentext internship program"};
		 replace(s);
	}

}
