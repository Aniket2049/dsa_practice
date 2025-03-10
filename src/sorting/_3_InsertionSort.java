package sorting;

import java.util.Arrays;
import java.util.Random;

// https://www.youtube.com/watch?v=0lOnnd50cGI
public class _3_InsertionSort {

	public static void main(String[] args) {
		int[] arr = new int[10];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}
		System.out.println("Before : " + Arrays.toString(arr));

		//-----------------------------------------

		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int currentVal = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > currentVal) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = currentVal;
		}

		//-----------------------------------------

		System.out.println("After : " + Arrays.toString(arr));

	}

}
