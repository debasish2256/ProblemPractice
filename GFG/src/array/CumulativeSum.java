package array;

import java.util.Arrays;

public class CumulativeSum {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getCumulativeSum(new int[]{1, 2, 3, 4})));
//		1, 3, 6, 10
	}
	
	static int[] getCumulativeSum(int[] arr) {
		int res[] = new int[arr.length];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			res[i] = sum;
		}
		return res;
	}
}
