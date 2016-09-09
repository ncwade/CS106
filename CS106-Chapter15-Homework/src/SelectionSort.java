import java.util.Arrays;

public class SelectionSort {
	
	public static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	// places the elements of the given array into sorted order
	// using the selection sort algorithm
	// post: array is in sorted (nondecreasing) order
	public static void dualSelectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			// find index of smallest element
			int smallest = i;
			int largest = a.length-1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[smallest]) {
					smallest = j;
				} else if (a[j] > a[largest]) {
					largest = j;
				}
			}
			swap(a, i, smallest); // swap smallest to front
			swap(a, a.length-1, largest); // swap largest to back
		}
	}
	
	public static void main(String[] args) {
		// Exercise 19
		/*
		 * This version of the selection sort will perform at O(N),
		 * just like a normal selection sort. We still need to iterate
		 * over every index.
		 */
		int[] intArray = {0,15,4,3,8,1,133,15,2,99,10};
		System.out.println(Arrays.toString(intArray));
		dualSelectionSort(intArray);
		System.out.println(Arrays.toString(intArray));
	}
}
