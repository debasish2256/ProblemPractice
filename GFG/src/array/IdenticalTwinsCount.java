package array;

import java.util.Arrays;
import java.util.HashSet;

public class IdenticalTwinsCount {
	public static void main(String[] args) {
		int[] test=new int[] {1,2,3,4,5,6};
//		System.out.println(Arrays.toString(multi(test)));
		System.out.println(getIdenticalTwinsCount(new int[] {1, 2, 2, 3, 2, 1}));
		
		
//		[[1, 1], [2, 2], [2, 2], [2, 2]] : 4
	}
	
	
	
	
	
	
	
	
	
	
	
	
	static int[] multi(int[] test) {
		int res[]=new int[test.length];
		for(int i=0;i<test.length;i++) {
			int multi=1;
			for(int j=0;j<test.length;j++) {
				if(i==j) {
					multi*=1;
				}else {
					multi*=test[j];   
				}
			}        			
			res[i]=multi;
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	static int getIdenticalTwinsCount (int[] arr) {
		int count=0;
		for(int i=0;i<arr.length;i++) {			
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					count++;
				}
			}
		}
		return count;
	}
}
