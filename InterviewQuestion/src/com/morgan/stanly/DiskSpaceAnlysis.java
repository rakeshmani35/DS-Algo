package com.morgan.stanly;

import java.util.ArrayList;
import java.util.List;

public class DiskSpaceAnlysis {

	// x= length of every segment
	public static int segment(int x, List<Integer> space) {

		// pick up min value of segment
		int min = Integer.MAX_VALUE;

		// store min space of each segment
		List<Integer> result = new ArrayList<Integer>();

		int count = 0;

		for (int i = 0; i < x; i++) {

			for (int j = i; j < space.size() && count < x; j++) {
				count++;
				min = Math.min(space.get(j), min);
			}
			// add min in listF
			result.add(min);
			// reset
			min = Integer.MAX_VALUE;
			count = 0;
		}
		
		int max = result.stream().mapToInt(v -> v).max().getAsInt();

		return max;
	}

	public static void main(String[] args) {

		int x = 3;
		List space = new ArrayList();
		space.add(2);
		space.add(5);
		space.add(4);
		space.add(6);
		space.add(8);

		segment(x, space);
	}

}
