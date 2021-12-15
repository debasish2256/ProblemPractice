package practice_450_dsa;

public class maximum_and_minimum_array {
	static class MinMax {
		int min;
		int max;
	}

	public static void main(String args[]) {
		int arr[] = { 1000, 11, 445, 1, 330, 3000 };
		int arr_size = arr.length;
		MinMax minmax = getMinMax(arr, arr_size);
		System.out.printf("Minimum element is %d", minmax.min);
		System.out.printf("\nMaximum element is %d", minmax.max);
	}

	private static MinMax getMinMax(int[] arr, int arr_size) {
		MinMax min_max = new MinMax();
		if (arr_size == 1)
			min_max.min = arr[0];
			min_max.max = arr[0];
		if (arr[0] < arr[1]) {
			min_max.min = arr[0];
			min_max.max = arr[1];
		} else if (arr[0] > arr[1]) {
			min_max.min = arr[1];
			min_max.max = arr[0];
		}
		for (int i = 2; i < arr_size; i++) {
			if (arr[i] > min_max.max)
				min_max.max = arr[i];
			else if (arr[i] < min_max.min)
				min_max.min = arr[i];
		}
		return min_max;
	}
}
