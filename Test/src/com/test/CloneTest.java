package com.test;

import java.util.HashMap;
import java.util.Map;

public class CloneTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("A", "B");
		
		
		Object clone = map.clone();
		
		Object clone2 = map.clone();
		
		System.out.println("hashcode clone = "+clone.hashCode());
		System.out.println("hashcode clone2 = "+clone2.hashCode());
	}

}
