import java.util.Arrays;
import java.util.Stack;

public class MinJumpToReachEnd {

	public static void minJump(int[] arr) {

		int[] min_jump_array = new int[arr.length];
		Arrays.fill(min_jump_array, 1, min_jump_array.length, Integer.MAX_VALUE);

		int[] jump_path_array = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {

			for (int j = 0; j < i; j++) {

				if (i <= j + arr[j]) {

					if (min_jump_array[i] > min_jump_array[j] + 1) {
						jump_path_array[i] = j;
					}

					min_jump_array[i] = Math.min(min_jump_array[i], min_jump_array[j] + 1);

				}
			}
		}

		Stack<Integer> s = new Stack<Integer>();
		int i = jump_path_array.length - 1;
		while (i >= 0) {
			s.add(i);
			if (i == 0) {
				break;
			}
			i = jump_path_array[i];
		}

		System.out.println("min jump to reach end of array : " + min_jump_array[min_jump_array.length - 1]);
		System.out.print("Jump element in Array : ");
		while(!s.isEmpty()) {
			int index = s.pop();
			System.out.print(arr[index] + " ");
		}
		return;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 1, 3, 2, 3, 4, 5, 1, 2, 8 };

		minJump(arr);
	}

}
