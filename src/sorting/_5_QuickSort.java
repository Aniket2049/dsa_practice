package sorting;

import java.util.Arrays;
import java.util.Random;

// https://www.youtube.com/watch?v=h8eyY7dIiN4
// https://www.geeksforgeeks.org/quick-sort-algorithm/?ref=header_ind
public class _5_QuickSort {

	private static void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}

	private static void quicksort(int[] array, int lowIndex, int highIndex) {

		if (lowIndex >= highIndex) {
			return;
		}

		int pivot = array[highIndex];

		int midPoint = partition(array, lowIndex, highIndex, pivot);

		quicksort(array, lowIndex, midPoint - 1);
		quicksort(array, midPoint + 1, highIndex);

	}

	private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
		int leftPointer = lowIndex;
		int rightPointer = highIndex - 1;

		while (leftPointer < rightPointer) {

			// Walk from the left until we find a number greater than the pivot, or hit the right pointer.
			while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}

			// Walk from the right until we find a number less than the pivot, or hit the left pointer.
			while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}

			swap(array, leftPointer, rightPointer);
		}

		// This is different from what the video has, and fixes an issue where the last value could potentially be out of order. 
		if (array[leftPointer] > array[highIndex]) {
			swap(array, leftPointer, highIndex);
		} else {
			leftPointer = highIndex;
		}

		return leftPointer;
	}

	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[10];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}
		System.out.println("Before : " + Arrays.toString(arr));

		//-----------------------------------------

		quicksort(arr);

		//-----------------------------------------

		System.out.println("After : " + Arrays.toString(arr));

	}

}
