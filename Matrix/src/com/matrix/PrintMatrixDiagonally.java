package com.matrix;

// https://www.youtube.com/watch?v=T8ErAYobcbc&list=PLeIMaH7i8JDim_JbrI07PxNdWqrmrq5RK
// https://www.ideserve.co.in/learn/print-matrix-diagonally
public class PrintMatrixDiagonally {

	public static void printDigonally(int[][] matrix) {

		int m = matrix.length; // row = 4
		int n = matrix[0].length; // column = 5

		int i = 0;
		int j = 0;
		for (int k = 0; k < m; k++) { // for row

			i = k; // for row
			j = 0; // for column

			while (i >= 0) {
				System.out.print(matrix[i][j] + " ");
				i--;
				j++;
			}
			System.out.println();
		}

		for (int k = 1; k < n; k++) { // for column

			i = m - 1;
			j = k;

			while (j <= n - 1) {
				System.out.print(matrix[i][j] + " ");
				i--;
				j++;
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		// row = 4, column = 5
		int[][] x = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };

		printDigonally(x);
	}

}
