// https://www.youtube.com/watch?v=BOt1DAvR0zI&list=PLeIMaH7i8JDjd21ZF6jlRKtChLttls7BG&index=9

public class SegregateArrayDutchNationalFlag {

	public static void segregateArray(int[] arr) {

		int low = 0;
		int high = arr.length - 1;
		int mid = 0;

		while (mid <= high) {

			switch (arr[mid]) {
			case 0:
				swap(mid, low, arr);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(mid, high, arr);
				high--;
				break;
			}
		}

	}

	private static void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void printarray(int[] arr) {

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {

		int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		segregateArray(arr);

		printarray(arr);
	}

}
