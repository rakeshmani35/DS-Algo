package com.opentext;

/**
 * Find the pair of 'a' & 'b' become pair of 'c' & 'd'. 
 * (a,b) => (a, a+b) ==
 * (c,d) (a,b) => (a, a+b) == (c,d)
 * 
 * @author rakes
 *
 */
public class IsPossiblePair {

	// a , c = row;  b, d = column
	public static String isPossible(int a, int b, int c, int d) {

		String status = "No";
		int x = a;
		int y = b;

		int length = Math.max(c, d);

		int[][] T = new int[length + 1][length + 1];
		T[c][d] = 1;

		// base condition
		if (a == 1 && b == 1 && c >= 1 && d >= 1) {
			status = "Yes";
		} else if (a == 0 && b == 0 && c == 0 && d == 0) {
			status = "Yes";
		} else if ((a == 0 && c == 0 && b == d) || (b == 0 && d == 0 && a == c)) {
			status = "Yes";
		} else if ((a == 0 || c == 0 && b != d) || (b == 0 || d == 0 && a != c)) {
			status = "No";
		} 
		// check pair
		else {
			while (a <= length) {

				while (b <= length) {
					
					if (T[a][b] == T[c][d]) {
						status = "Yes";
						break;
					} else {
						b = a + b;
					}
				}
				if (status.equals("Yes")) {
					break;
				}
				b = y;
				a = a + b;
			}
		}

		return status;
	}

	public static void main(String[] args) {
		 //String possible = isPossible(1, 4, 0, 9); // NO

		//String possible = isPossible(1, 4, 5, 7); // NO
		
		String possible = isPossible(1, 4, 5, 9); // Yes
		System.out.println("is possible = " + possible);
	}

}
