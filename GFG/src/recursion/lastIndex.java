package recursion;

import java.util.Scanner;

public class lastIndex {
	 public static void main(String[] args) throws Exception {
			Scanner sc=new Scanner(System.in);
			int size=sc.nextInt();
			int arr[]=new int[size];
			for(int i =0;i<size;i++){
				arr[i]=sc.nextInt();
			}
			System.out.println(lastIndex(arr,0,sc.nextInt()));
		}

		public static int lastIndex(int[] arr, int idx, int x){
			if(idx==arr.length){
				return -1;
			}
			int lisa=lastIndex(arr,idx+1,x);
	        if(lisa==-1){
	            if(arr[idx]==x){
	                return idx;
	            }else{
	                return -1;
	            }
	        }else{
	            return lisa;
	        }
		}
}
