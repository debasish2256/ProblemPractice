package L1;

//Java Program to find the
//Cartesian Product of Two Sets
import java.io.*;
import java.util.*;

class cartisianProduct {
	
	/*{(a,b),(c,d),(e,f)....n}
	(ac,ad,bc,bd)*(e,f)
(ace,acf,ade,adf,bce,bcf,bdf,bde)*/
	
	
	
	
	static String findCart(String arr1[], String arr2[],String arr3[]) {
		String res="";
		for (int i = 0; i < arr1.length; i++)
			for (int j = 0; j < arr2.length; j++)
			     for(int k=0;k<arr3.length;k++)
			    	 res += "{" + arr1[i] + ", " + arr2[j] +  ", " + arr3[k] +"}, ";
		return res;
	}

	// Driver code
	public static void main(String[] args) {

		// first set
		String arr1[] = {"e", "f"};

		// second set
		String arr2[] = { "c", "d"};
		
		String arr3[]= { "a","b" };
//		if()
		
		
		
		System.out.println(findCart(arr1, arr2,arr3));
//		System.out.println();
	}
}
