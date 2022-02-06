// https://www.youtube.com/watch?v=x3HDo6H90Y0
// https://www.geeksforgeeks.org/quick-sort/

public class KthLargestInArray {

	// https://www.youtube.com/watch?v=x3HDo6H90Y0
	public static void kthLargest(int[] arr, int k) {
		
		if (arr.length >= k) {
			
			for (int i = 0; i < arr.length; i++) {
				
				for (int j = i+1; j < arr.length; j++) {
					if (arr[i] < arr[j]) { // Descending order
						
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						
					}
				}
				if (i==k-1) {
					System.out.println(k+"th largest element in array : "+arr[i]);
					break;
				}
			}
		}
		
	}
	
	// https://www.geeksforgeeks.org/quick-sort/
	public static void kthLargestByQuickSort(int[] arr) {
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5, 8, 12, 7, 6, 2, 4};
		int k = 4;

		kthLargest(arr, k);
	}

}
