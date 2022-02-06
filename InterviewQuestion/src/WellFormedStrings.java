import java.util.Arrays;

// https://algorithms.tutorialhorizon.com/find-all-the-well-ordered-permutations-of-a-given-string/

public class WellFormedStrings {

	// Logic:
	// 1. Get the input sequence
	// 2. Find out all the permutations of a String
	// 3. Before printing if the permutation is well formed.

	public static void wellFormedString(String S) {
		char[] A = S.toCharArray();
		permutation(A, 0);
	}

	private static void permutation(char[] A, int left) {

		if (left == A.length) {
			if (isWellFormed(A)) {
				System.out.println(Arrays.toString(A));
			}
			return ;
		}
		
		for (int i = left; i < A.length; i++) {

			swap(A, i, left);
			permutation(A, left + 1);
			swap(A, i, left);  // backtrack
		}
	}

	private static boolean isWellFormed(char[] A) {

		boolean wellFormed = true;
		for (int i = 0; i < A.length - 1; i++) {
			if (Character.toLowerCase(A[i]) > Character.toLowerCase(A[i + 1])) {
				wellFormed = false;
				break;
			}
		}

		return wellFormed;
	}

	private static void swap(char[] A, int i, int j) {
		char temp = A[i];
		A[i] = A[j];
		A[j] = temp;

	}

	public static void main(String[] args) {

		String S = "Interview";
		System.out.println("Given String - " + S);
		
		wellFormedString(S);
	}

}
