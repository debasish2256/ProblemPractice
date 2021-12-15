package array;

import org.omg.CORBA.INTERNAL;

/*Maximum difference between two elements such that larger element appears after the smaller number
 
Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number. 


Input : arr = {2, 3, 10, 6, 4, 8, 1}
Output : 8
Explanation : The maximum difference is between 10 and 2.

Input : arr = {7, 9, 5, 6, 3, 2}
Output : 2
Explanation : The maximum difference is between 9 and 7.*/
public class maxDifferenceBetweenTwoElements {
	public static void main(String[] args)
	{
		maxDifferenceBetweenTwoElements maxdif = new maxDifferenceBetweenTwoElements();
		int arr[] = {7, 9, 5, 6, 3, 2};
//		System.out.println("Maximum difference is " + maxdif.maxDiffWithBruteForce(arr));
		System.out.println("Maximum difference is " + maxdif.maxDiffWithOptimal(arr));

	}
	//brute-force: O(n2)
	private int maxDiffWithBruteForce(int[] arr) {
		int maxDiff=Integer.MIN_VALUE;
		int size=arr.length;
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				if(arr[i]<arr[j]) {
					maxDiff=Math.max(maxDiff, arr[j]-arr[i]);
				}
			}
		}
		return maxDiff;
	}
	
	//iterative  : O(n)
	private int maxDiffWithOptimal(int[] arr) {
		int maxDiff=arr[1]-arr[0];
		int minElement=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]-minElement>maxDiff) {
				maxDiff=arr[i]-minElement;
			}
			if(arr[i]<minElement) {
				minElement=arr[i];
			}		
		}
		return maxDiff;
	}
	
	
}
