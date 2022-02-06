package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SellingProduct {

	public static int deleteProduct(List<Integer> ids, int m) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		List<Integer> list = new ArrayList<Integer>(ids);

		for (Integer x : ids) {
			if (map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);

			}
		}
		int temp = m;
		Map<Integer, Integer> sortByValue = sortByValue(map);

		while (temp > 0) {

			for (Map.Entry<Integer, Integer> entry : sortByValue.entrySet()) {
				int value = entry.getValue();
				int key = entry.getKey();
				if (value < temp) {
					for (int i = 0; i < value; i++) {
						list.remove(new Integer(key));
					}
					temp = temp - value;
				} else if (value > temp) {
					// else {
					for (int i = 0; i < temp; i++) {
						list.remove(new Integer(key));
						temp--;
					}
				}
				if (temp == 0) {
					break;
				}
			}

		}
		Set<Integer> set = new TreeSet<Integer>(list);
		return set.size();
	}

	private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> unsortMap) {

		// 1. Convert Map to List of Map
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(unsortMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	public static void main(String[] args) {

		List<Integer> ids = Arrays.asList(1, 1, 1, 2, 3, 2, 2, 4, 4);

		int m = 4;

		int uniqueId = deleteProduct(ids, m);

		System.out.println("Min number of different IDs = " + uniqueId);
	}

}
