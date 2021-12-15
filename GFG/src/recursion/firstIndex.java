package recursion;

import java.util.Scanner;

public class firstIndex {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i =0;i<size;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println(firstIndex(arr,0,sc.nextInt()));
	}

	public static int firstIndex(int[] arr, int idx, int x){
		if(idx==arr.length){
			return -1;
		}
		if(arr[idx]==x){
			return idx;
		}else{
			return firstIndex(arr,idx+1,x);
		}
	}
}
