package array;

import java.util.Arrays;

public class mergeTwoSortedArrays {
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(mergeSortedArrays(new int[] {1, 2, 3, 4, 4},new int[] {2, 4, 5, 5})));
		//	op:1, 2, 2, 3, 4, 4, 4, 5
//		Merge Sorted Subarrays
//		merge(new int[] {1, 3, 5, 7, 9, 11, 0, 4, 6, 8},5);
//		o/p:0, 1, 3, 4, 5, 6, 7, 8, 9, 11
	}
	
	static void merge (int[] arr, int endIndex) {
		
	}
	
	static int[] mergeSortedArrays(int[] A, int[] B) {
		int count=0;
		int res[]=new int[A.length+B.length];
		for(int i=0;i<A.length;i++) {
			res[count++]=A[i];
		}
		for(int i=0;i<B.length;i++) {
			res[count++]=B[i];
		}
		Arrays.sort(res);
		return res;
	}
}
