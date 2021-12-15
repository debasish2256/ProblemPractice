package contest;

import java.util.Arrays;

public class smallestPositiveInteger {
		public static void main(String[] args) {
//			A=[1,2,3]  return 4
//			B=[-1,3]   retun 1
			System.out.println(solution(new int[] { 3, 6, 4, 7 , 2}));
		}

		private static int solution(int[] arr) {
			int smallestInt=1;
			if(arr.length==0) return smallestInt;
			Arrays.sort(arr);
			if(arr[0]>1) return smallestInt;
			if(arr[arr.length-1]<=0) return smallestInt;
			
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==smallestInt) {
					smallestInt++;
				}
			}	
			return smallestInt;
		}
}
