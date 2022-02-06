import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindMissingNumbers {

	public static void findNumbers(int[] arr) {
		Arrays.parallelSort(arr);

		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

		int start = arr[0];
		int end = arr[arr.length - 1];

		for (int i = start; i < end; i++) {

			if (!list.contains(i)) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) {

		int[] arr = { 2, 5, 8, 10, 15 };
		findNumbers(arr);
	}
}

// output: 3 4 6 7 9 11 12 13 14 