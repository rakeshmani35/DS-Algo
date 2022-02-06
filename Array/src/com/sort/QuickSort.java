package com.sort;

public class QuickSort {

	private static int partition(int arr[], int low, int high) {

		//int pivot = arr[high];
		int pivot = arr[(low + high)/2];

		while (low <= high) {

			while (arr[low] < pivot) {
				low++;
			}

			while (arr[high] > pivot) {
				high--;
			}
			if (low <= high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;

				low++;
				high--;
			}
		}
		return low;
	}

	public static void sort(int arr[], int low, int high) {
		    if(low < high) {
			int partition = partition(arr, low, high);
			
			sort(arr, low, partition-1);
			
				sort(arr, partition, high);
			}
		
		
		
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		int[] arr = { 10, 80, 30, 90, 40, 50, 70 };
		//int[] arr = { 15, 9, 7, 13, 12, 16, 4, 18,11 };
		
		int low = 0;
		int high = arr.length - 1;

		sort(arr, low, high);
		System.out.println("sorted array");
		printArray(arr);

	}

}
