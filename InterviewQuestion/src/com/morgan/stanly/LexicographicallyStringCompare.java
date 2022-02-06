package com.morgan.stanly;

public class LexicographicallyStringCompare {

	public static void main(String[] args) {

		System.out.println(".compareTo(baca) = " + ("".compareTo("baca")));       // -4  compare with length
		System.out.println("baca.compareTo(aca) = " + ("baca".compareTo("aca"))); // 1   compare with ASCII value
		System.out.println("baca.compareTo(ca) = " + ("baca".compareTo("ca")));   // -1
		System.out.println("ca.compareTo(a) = " + ("ca".compareTo("a")));         // 2
		
		// ASCII (Or Unicode or decimal): a=97, A=65
		System.out.println("a.compareTo(A) = " + ("a".compareTo("A")));          // 32
		System.out.println("A.compareTo(a) = " + ("A".compareTo("a")));          // -32
		System.out.println("97.compareTo(65) = " + ("97".compareTo("65")));      // 3
		
		System.out.println("abc.compareTo(Abc) = " + ("abc".compareTo("Abc")));  // 32
		System.out.println("ab.compareTo(ba) = " + ("ab".compareTo("ba")));      // -1
		
		
		System.out.println("abc.charAt(0) = " + "abc".charAt(0));                // a
		System.out.println("(int)abc.charAt(0) = " + (int)"abc".charAt(0));      // 97
		System.out.println("'a' = " + 'a');     // a
		System.out.println("'a' - 'b' = " + ('a' - 'b'));     // 97-98 = -1
		
		System.out.println("'a' == 97 = " + ('a' == 97));     // 97==97 = true
		//System.out.println("'a' == '97' = " + ('a' == '97'));     // '97' is Invalid character constant
		
		System.out.println(" empty length = " + ("".length()));     // 0
		
		
	}

}
