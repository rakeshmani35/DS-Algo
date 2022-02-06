package com.twilio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://mkyong.com/java8/java-8-how-to-sort-a-map/
// https://www.javaprogramto.com/2021/06/java-8-stream-group-by-count.html
public class ProductSort {

	public static List<Integer> sort(List<Integer> items) {

		List<Integer> result = new LinkedList<Integer>();
		
		Map<Integer, Long> unsortedMap = items.parallelStream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<Integer, Long> SortedMap1 = items.parallelStream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		System.out.println("SortedMap1 = " + SortedMap1);

// alternative way
		// The method sorted(Comparator<? super Map.Entry<Integer,Long>>) in the type
		// Stream<Map.Entry<Integer,Long>> is not applicable for the arguments
		// (Comparator<Map.Entry<Integer,Integer>>)
		Map<Integer, Long> SortedMap2 = new LinkedHashMap<>();
		
		items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.<Integer, Long>comparingByValue())
				.forEachOrdered(x -> SortedMap2.put(x.getKey(), x.getValue()));

		
		SortedMap1.forEach((k,v) -> 
		{for (int i = 0; i < v; i++) {
			result.add(k.intValue());
			
		}});
     
		return result;

	}

	public static void main(String[] args) {

		Integer[] x = { 3, 4, 5, 6, 5, 4, 4 };

		List<Integer> items = new ArrayList(Arrays.asList(x));

		List<Integer> sort = sort(items);
		System.out.println(sort);

	}

}
