package contest;

public class spiralSort {

	static boolean isSpiralSorted(int[] arr) {

		int n=arr.length;
		int start = 0;

		int end = n - 1;

		while (start < end) {
			if (arr[start] > arr[end]) {
				return false;
			}

			start++;

			if (arr[end] > arr[start]) {
				return false;
			}

			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 2 };
		int N = arr.length;

		if (isSpiralSorted(arr) != false)
			System.out.print("yes");
		else
			System.out.print("no");
	}
}
