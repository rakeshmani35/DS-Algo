package com.dp;

public class NStairs {

	// Recursive DP function to find total ways to reach the n'th stair from the
	// bottom
	// when a person is allowed to climb either 1 or 2 or 3 stairs at a time
	public static int totalWays(int n, int[] lookup) {
		// base case
		if (n < 0) {
			return 0;
		}

		// base case: there is one way to cover it with no steps
		if (n == 0) {
			return 1;
		}

		// if the subproblem is not seen before
		if (lookup[n] == 0) {
			// combine results of taking 1 step or 2 steps or 3 steps at a time
			lookup[n] = totalWays(n - 1, lookup) 
					    + totalWays(n - 2, lookup) ;
		}

		// return the subproblem solution
		return lookup[n];
	}

	public static void main(String[] args) {
		int n = 4;

		// create an array of size `n+1` for storing solution to the subproblems
		// and initialize it by 0
		int[] lookup = new int[n + 1];

		System.out.printf("Total ways to reach the %d'th stair are %d", n, totalWays(n, lookup));

	}

}
