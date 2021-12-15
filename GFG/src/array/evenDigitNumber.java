package array;

import java.util.ArrayList;
import java.util.List;

public class evenDigitNumber {
	public static void main(String[] args) {
		System.out.println( getEvenDigitNumbers(new int[] {3, 11, 4 ,200}));
//				op: 42, 5775, 34, 45, 3556
	}
	
	
	
	static List<Integer> getEvenDigitNumbers (int[] arr) {
		ArrayList<Integer> res=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			int count=1;
			int n=arr[i];
			while(n/10 !=0){
			count++;
			n/=10;
			}
			if(count%2==0) {res.add(arr[i]);}
		}
		return res;
	}
}
