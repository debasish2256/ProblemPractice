package array;

import java.util.TreeSet;

public class insertionSort {
	public static void main(String[] args) {
		insertionSort(new int[] {5 ,4 ,2, 5 ,3 ,1});
	}
	static void insertionSort (int[] arr) {
		TreeSet<Integer> res=new TreeSet<>();
		for(int i=0;i<arr.length;i++) {
			res.add(arr[i]);
		}
	      Integer[] myArray = new Integer[res.size()];
	      res.toArray(myArray);

	      for(int i=0; i<myArray.length; i++){
	         System.out.print(myArray[i]+" ");
	      }	
	   }
}
