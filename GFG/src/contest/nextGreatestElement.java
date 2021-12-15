package contest;

import java.util.Arrays;

public class nextGreatestElement {
	public static void main(String[] args) {
		
		System.out.println(getNextGreaterElement(new int[] {1, 2, 3, 3, 4, 4, 8, 10},4));
	}
	static int getNextGreaterElement (int[] arr, int key) {
		int low=0,high=arr.length-1;
		int res=0;
		if (low > high) {
		    return -1;
		 }
		if(arr[(low+high)/2]>key){
			high=(low+high)/2;
		}else if(arr[(low+high)/2]<key){
			low=(low+high)/2;
		}
		while(low<=high) {
			if(arr[low]>key) {
				res=Math.max(res,arr[low]);
				break;
			}else if(res==0 && low==high) {
				return arr[high];
			}
			low++;
		}
		return res;
	}
}
