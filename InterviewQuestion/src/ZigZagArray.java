// https://www.youtube.com/watch?v=bgx1eAgBgaQ&list=PLeIMaH7i8JDjd21ZF6jlRKtChLttls7BG&index=19

public class ZigZagArray {

	public static void zigzag(int[] arr) {
		int i = 0;

		int flag = 0;
		while (i < arr.length - 1) {

			if (flag ==0) { // i < i+!
				
			} 
			//flag = !flag;
			 if (flag==1) { // i > i+1
				
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

		int[] arr = { 5, 10, 8, 12, 6, 9, 4 };
		zigzag(arr);

		int[] arr1 = { 3, 4, 6, 2, 1, 8, 9 };
	}

}
