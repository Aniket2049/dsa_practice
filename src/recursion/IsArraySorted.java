package recursion;

// alternate solution that checks from 0th index https://stackoverflow.com/a/72067746
// https://www.geeksforgeeks.org/program-check-array-sorted-not-iterative-recursive/
// https://www.youtube.com/watch?v=Yu74lMoCuI4
public class IsArraySorted {

	public boolean isArraySorted(int[] arr, int size) {
		if (size == 0 || size == 1) {
			return true;
		}

		if (arr[size - 1] < arr[size - 2])
			return false;

		return isArraySorted(arr, size - 1);

	}

	public static void main(String[] args) {
		IsArraySorted obj = new IsArraySorted();
		int[] data  = new int[] { 6, 2, 3, 5 };
		System.out.println(obj.isArraySorted(data, data.length));

	}

}
