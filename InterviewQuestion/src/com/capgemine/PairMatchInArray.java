package com.capgemine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatchInArray {

	public static void pair(int[] arr) {

		List<Integer> list = new ArrayList<Integer>();
		for (int i : arr) {
			list.add(i);
		}
			

		Arrays.parallelSort(arr);

		List<String> pair = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < arr.length; i++) {
			int x = arr[i];

			for (int j = i + 1; j < arr.length; j++) {

				int y = arr[j];

		
				//int binarySearch = Arrays.binarySearch(arr, x + y);
				//if (Arrays.binarySearch(arr, x + y) > 0) { 
				
				if (list.contains(x + y)) {
					String str = "(" + x + "," + y + ")";
					String str1 = "(" + x + "," + y + ")"+" count";
					pair.add(str);
					if (map.containsKey(str1)) {
						int a = map.get(str1);
						map.put(str1, a + 1);
					} else {
						map.put(str1, 1);
					}

				}
			}
		}

		System.out.println(pair);
		System.out.println(map);
	}

	public static void main(String[] args) {

		int[] arr = { 1,  2, 3, 4, 5, 2 };

		pair(arr);

	}

}
