package sorting;

import java.util.Arrays;
import java.util.Random;

public class _1_BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[10];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(0, 99);
		}
		System.out.println("Before : " + Arrays.toString(arr));

		//-----------------------------------------
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		//-----------------------------------------

		System.out.println("After : " + Arrays.toString(arr));

	}

}
