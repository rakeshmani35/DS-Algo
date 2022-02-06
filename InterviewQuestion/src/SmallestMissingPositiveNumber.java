
public class SmallestMissingPositiveNumber {

	public static void smallestPositiveNumber(int[] arr) {
		
		int k = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0 && arr[i] <= arr.length) {
				k++;
			}
		}
		
		int[] a = new int[k]; // create another array
		// if element found in range, mark 'a' array as 1
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0 && arr[i] <= arr.length) {
				for (int j = 0; j <= arr.length; j++) {
					if (j == arr[i] && j <= a.length) {
					       a[j-1] = 1;
					}
				}

			}
		}
		// iterate array to find missing element
		int m;
		for (m = 0; m < a.length; m++) {
			if (a[m] == 0) {
				System.out.println("missing element = "+(m+1));
				break;
			}
		}
		
		if (m == a.length) {
			System.out.println("no missing element ");
		}
		return ;
	}
	
	public static void main(String[] args) {
		int[] arr = {-3,-56,5,2,4,1};
		smallestPositiveNumber(arr);

	}

}
