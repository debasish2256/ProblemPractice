package com.highradius.cp;

import java.util.*;

/*Asked in:  
Amazon
Goldman Sachs
Microsoft
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.*/

public class array_Largest_Number {
	public static void main(String[] args) {
		int[] a={3, 30, 34, 5, 9};
//		int[] a= { 0, 0, 0, 0, 0};
		System.out.println(largestNumber(a));
	}
	public static String largestNumber(final int[] A) {
		Vector<String> arr=new Vector<>();
		String s="";
		for( int i = 0; i < A.length ; i++)
		{
			arr.add(Integer.toString(A[i]));
		}
		Collections.sort(arr, new Comparator<String>()
		{
			// sort() in printLargest()
			public int compare(String X, String Y)
			{

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
			s=s+ (it.next()).toString();
		}
		if(s.startsWith("0"))
			return s="0";
		return s;
		
	}
}
