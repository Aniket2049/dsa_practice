package recursion;

import java.util.Arrays;

// https://www.youtube.com/watch?v=8ue8A38hm3g

public class StringsOfNBits {

	int[] arr;

	public StringsOfNBits(int size) {
		arr = new int[size];
	}

	public void printBinaryStrings(int n) {
		if (n <= 0) {
			System.out.println(Arrays.toString(arr));
		} else {
			arr[n - 1] = 0;
			printBinaryStrings(n - 1);
			arr[n - 1] = 1;
			printBinaryStrings(n - 1);
		}
	}

	public static void main(String[] args) {
		int n = 4;
		StringsOfNBits obj = new StringsOfNBits(n);
		obj.printBinaryStrings(n);

	}

}
