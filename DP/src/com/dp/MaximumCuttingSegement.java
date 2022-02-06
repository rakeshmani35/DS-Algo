package com.dp;

import java.util.Arrays;

// https://www.youtube.com/watch?v=SU54j2_GgWM&list=PLCZJSEiJwWZ7kd4wXxIkFiU6mYXsCwYOC&index=3
public class MaximumCuttingSegement {

	// n= road Length, x,y,z = diff segement length
	public static int maxSegement(int n, int x, int y, int z) {

		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);

		// base case
		dp[0] = 0;

		for (int i = 0; i <= n; i++) {

			if (dp[i] != -1) {

				if (i + x <= n) { // i+2 <=6
					dp[i + x] = Math.max(dp[i + x], dp[i] + 1);
				}
				if (i + y <= n) { // i+4 <=6
					dp[i + y] = Math.max(dp[i + y], dp[i] + 1);
				}
				if (i + z <= n) { // i+3 <=6
					dp[i + z] = Math.max(dp[i + z], dp[i] + 1);
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {

		int n = 6;
		int x = 2;
		int y = 4;
		int z = 3;
		int maxSegement = maxSegement(n, x, y, z);
		System.out.println("cutting rod in max segement = " + maxSegement);
	}

}
