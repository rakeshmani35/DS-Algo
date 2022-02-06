package com.dp;

/**
 * find the minimum number of drops(experiment) needed to find a floor from
 * which it is safe to drop an egg without breaking it.
 * 
 * There some important points to remember:
 * 
 * 1) When an egg does not break from a given floor, then it will not break for
 * any lower floor also.
 * 
 * 2) If an egg breaks from a given floor, then it will break for all upper
 * floors.
 * 
 * 3) When an egg breaks, it must be discarded, otherwise, we can use it again.
 * 
 * 
 * @author rakes
 *
 */
// https://www.youtube.com/watch?v=hRy9kNHdg64&t=196s
// https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
public class EggDrop {

	public static int eggDrop_recurr(int egg, int floor) {

		// break condition: If there are no floors, then no trials needed. OR if there
		// is one floor, one trial needed.
		if (floor == 1 || floor == 0)
			return floor;

		// break condition: We need k trials for one egg and k floors
		if (egg == 1)
			return floor;

		int min = Integer.MAX_VALUE;
		int x, res;

		// Consider all droppings from 1st floor to kth floor and return the minimum of
		// these values plus 1.
		for (x = 1; x <= floor; x++) {
			res = Math.max(eggDrop_recurr(egg - 1, x - 1), eggDrop_recurr(egg, floor - x));
			if (res < min)
				min = res;
		}

		return min + 1;
	}

	// find min number of experiment where egg does not break
	public static int eggDrop_DP(int egg, int floor) {

		int[][] eggFloor = new int[egg + 1][floor + 1];

		int i; // for row
		int j; // for column
		int result = 0;

		// base condition for 0th and 1st column
		// floor = (0,1) , i egg
		for (i = 0; i <= egg; i++) {
			eggFloor[i][0] = 0;
			eggFloor[i][1] = 1;
		}
		// base condition for 1st row
		// 1 egg, j floor
		for (j = 0; j <= floor; j++) {
			eggFloor[1][j] = j;
		}

		for (i = 2; i <= egg; i++) { // row 2nd afterwards
			for (j = 2; j <= floor; j++) { // column 2nd afterwards
				eggFloor[i][j] = Integer.MAX_VALUE;
				for (int x = 1; x <= j; x++) { // traverse column
					result = 1 + Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);

					if (result < eggFloor[i][j]) {
						eggFloor[i][j] = result;
					}
				}
			}
		}

		return eggFloor[egg][floor];
	}

	public static void main(String[] args) {

		int egg = 2;
		int floor = 7;
		int drops = eggDrop_DP(egg, floor);

		System.out.println("Iterativ Approach : Minimum number of trials in worst" + " case with " + egg + "  eggs and "
				+ floor + " floors is = " + drops);

		int eggDrop_recurr = eggDrop_recurr(egg, floor);
		System.out.println("Recursive Approach : Minimum number of trials in worst" + " case with " + egg
				+ "  eggs and " + floor + " floors is = " + eggDrop_recurr);
	}

}
