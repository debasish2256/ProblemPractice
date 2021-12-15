package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositiveCumulativeSum {
	public static void main(String[] args) {
		System.out.println((getPositiveCumulativeSum(new int[]{1, -2, 3, 4, -6})));
//		1, -1, 2, 6, 0
	}
	
	static List<Integer> getPositiveCumulativeSum (int[] arr) {
		List<Integer> res=new ArrayList<Integer>(arr.length);	
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum>0) {
				res.add(sum);
			}
		}
		return res;
	}
}
