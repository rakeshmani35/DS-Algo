package com.bny.melon;

public class MainMethodOverrideTest {

	public static void main(String[] args) {
		System.out.println("static main method");

	}

	public static String main(String[] args, int x) {
		System.out.println("123");
		return "Hello";
	}

	public static void main(int x, String[] args) {
		System.out.println("456");
	}
}
