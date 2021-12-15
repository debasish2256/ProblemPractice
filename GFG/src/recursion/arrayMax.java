package recursion;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class arrayMax {
	public static void main(String[] args) throws Exception {
	       Scanner sc=new Scanner(System.in);
		   /* int size=sc.nextInt();
		    int[] arr=new int[size];
		    for(int i=0;i<size;i++){
		        arr[i]=sc.nextInt();
		    }
	        System.out.println(maxOfArray(arr,0));*/
	       
	        int count=0;
	        Stack<Character> st = new Stack<Character>();
	        Vector<Character> vt = new Vector<Character>();
		    String arr = "{e,f},{c,d},{a,b},{1,2}";
		    for(int i=0;i<arr.length();i++) {
				if(arr.charAt(i)=='{') {
					st.push(arr.charAt(i));
				}
				else if(arr.charAt(i)!='{' && arr.charAt(i)!='}') { 
					st.push(arr.charAt(i));
				}
				if(arr.charAt(i)=='}') {
					while(st.peek()!='{') {
						Character res=(st.pop());
						if(res!=',' && res!='{') {
							vt.add(res);
						}
					}
				}
			}
	       
	    }

	
	/*public static String cartisanProduct(int[] arr, int idx){
	      if(idx==arr.length-1){
	          return arr[idx];
	      }
	      int maxinsmallarray=maxOfArray(arr,idx+1);
	      if(maxinsmallarray>arr[idx]){
	          return maxinsmallarray;
	      }else{
	         return arr[idx];
	      }
	    }*/
	
	    public static int maxOfArray(int[] arr, int idx){
	      if(idx==arr.length-1){
	          return arr[idx];
	      }
	      int maxinsmallarray=maxOfArray(arr,idx+1);
	      if(maxinsmallarray>arr[idx]){
	          return maxinsmallarray;
	      }else{
	         return arr[idx];
	      }
	    }
}
