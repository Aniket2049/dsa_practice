package sorting;

import java.util.Arrays;
import java.util.Random;

public class _2_SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[10];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(0, 99);
		}
		System.out.println("Before : " + Arrays.toString(arr));

		//-----------------------------------------

		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {

			// Find the minimum element in unsorted array
			int indexOfMinimum = i;

			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[indexOfMinimum])
					indexOfMinimum = j;
			}

			// Swap the found minimum element with the first
			// element
			int temp = arr[indexOfMinimum];
			arr[indexOfMinimum] = arr[i];
			arr[i] = temp;
		}

		//-----------------------------------------

		System.out.println("After : " + Arrays.toString(arr));

	}

}
