package drive_link;

public class nearestNumberLeft {

	// Prints smaller elements on
	// left side of every element
	static void printPrevSmaller(int[] arr, int n) {

		// Always print empty or '_' for first element
		System.out.print("_, ");

		// Start from second element
		for (int i = 1; i < n; i++) {
			// look for smaller
			// element on left of 'i'
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					System.out.print(arr[j] + ", ");
					break;
				}
			}
			if (j < 0) {
				System.out.print("_, ");
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 6, 4, 10, 2, 5 };
		int n = arr.length;
		printPrevSmaller(arr, n);
	}
}