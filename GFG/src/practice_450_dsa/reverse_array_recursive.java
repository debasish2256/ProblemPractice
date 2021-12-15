package practice_450_dsa;

public class reverse_array_recursive {
	static void printArray(int arr[], int size) {
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

	/* Driver function to check for above functions */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		rvereseArray(arr, 0, 5);
		System.out.println("Reversed array is ");
		printArray(arr, 6);
	}

	private static void rvereseArray(int[] arr, int start, int end) {
		if (start > end)
			return;
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		rvereseArray(arr, start + 1, end - 1);
	}
}
