package practice_450_dsa;

import java.util.*;

/*Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Have you considered cases like 27, 271 or 12, 121 ?*/

public class Tree_1 {
	public static void main(String[] args) {
		int[] a = {191, 608, 79, 111, 688, 930, 504, 878, 883, 684, 157, 670, 447, 720, 147, 728, 540, 160, 668, 897, 746, 367, 194, 425, 625, 17, 876, 625, 785, 278, 699, 141, 219, 857, 51, 611, 299, 279, 562, 64, 577 };
		System.out.println(largestNumber(a));
	}

	public static String largestNumber(final int[] A) {
		Vector<String> arr = new Vector<>();
		String s = "";
		for (int i = 0; i < A.length; i++) {
			arr.add(Integer.toString(A[i]));
		}
		Collections.sort(arr, new Comparator<String>() {
			// A comparison function which is used by
			// sort() in printLargest()
			public int compare(String X, String Y) {

				// first append Y at the end of X
				String XY = X + Y;

				// then append X at the end of Y
				String YX = Y + X;

				// Now see which of the two
				// formed numbers
				// is greater
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});
		Iterator it = arr.iterator();
		while (it.hasNext()) {
			s = s + (it.next()).toString();
		}
		if (s.startsWith("0"))
			return "0";
		return s;

	}
}
