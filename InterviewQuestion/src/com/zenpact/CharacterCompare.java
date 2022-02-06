package com.zenpact;

import java.util.ArrayList;
import java.util.List;

public class CharacterCompare {

	public static void main(String[] args) {
		char ch1 = 'A';
		char ch2 = 'B';
		char ch3 = 'A';

		System.out.println("(ch1 == ch2) : " + (ch1 == ch2));
		System.out.println("(ch1 < ch2) : " + (ch1 < ch2));
		System.out.println("(ch3 == ch1) : " + (ch3 == ch1));

		System.out.println("ASCII value of ch1 : " + ch1 + " = " + (int) ch1);
		System.out.println("ASCII value of ch2 : " + ch2 + " = " + (int) ch2);
		System.out.println("ASCII value of ch3 : " + ch3 + " = " + (int) ch3);
		
		
		
		List list = new ArrayList();
		
		list.stream().forEach(System.out::println);

	}

}
