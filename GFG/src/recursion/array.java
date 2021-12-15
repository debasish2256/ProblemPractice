package recursion;

import java.util.Scanner;

public class array {
	public static void main(String[] args) throws Exception {
	    Scanner sc=new Scanner(System.in);
	    int size=sc.nextInt();
	    int[] arr=new int[size];
	    for(int i=0;i<size;i++){
	        arr[i]=sc.nextInt();
	    }
	    displayArr(arr,0);
	    }

	    public static void displayArr(int[] arr, int id){
	        if(id == arr.length){
	            return ;
	        }
	        System.out.println(arr[id]);
	        displayArr(arr,id+1);
	    }
}
