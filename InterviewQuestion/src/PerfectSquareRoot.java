import java.util.ArrayList;
import java.util.List;

/*
 * '%' = remainder
 * 
 * '/' = quotient 
 * 
 * dividend ÷ divisor = quotient
 * 
 */
// https://www.geeksforgeeks.org/check-if-a-number-is-perfect-square-without-finding-square-root/
public class PerfectSquareRoot {

	public static void checkSqrtInList(List<Integer> list) {

		int sum = 0;
		for (Integer x : list) {
			if (isPerfecrSquareroot(x)) {
				sum += sqrt(x);
			}
		}
		System.out.println("total sum of square root of list = " + sum);
	}

	public static boolean isPerfecrSquareroot(int a) {

		for (int i = 1; i * i <= a; i++) {
			if (a % i == 0 && a / i == i) {
				return true;
			}
		}

		return false;
	}

	public static int sqrt(int a) {
		int i;
		for (i = 1; i * i <= a; i++) {
			if (a % i == 0 && a / i == i) {
				break;
			}
		}
		return i;
	}

	public static void checksqrt(int[] arr) {

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (j * j == arr[i]) {
					sum += j;
				}
			}
		}
		System.out.println("total sum of square root of array = " + sum);
	}
	
	public static void checkMinSqrt(int[] arr) {
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (j * j == arr[i] && j < min) {
					min = j;
				}
			}
		}
		
		System.out.println("min of square root of array = " + min);
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(9);
		list.add(8);
		list.add(4);
		list.add(16);
		list.add(9);
		list.add(25);
		list.add(81);
		list.add(17);
		list.add(29);

		//checkSqrtInList(list);
		
		int[] arr = {10,9,8,4,16,9,25,81,17,29};
		checksqrt(arr);
		checkMinSqrt(arr);
	}

}
