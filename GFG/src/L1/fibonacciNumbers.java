package L1;

import java.util.Arrays;
import java.util.Scanner;

public class fibonacciNumbers {
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
//		findFib(cin.nextInt());
		int size=cin.nextInt();
	    int[] array=new int[size];
		for(int i=0;i<size;i++) {
			array[i]=cin.nextInt();
		}
		maxmin2(array);
	}

	private static void maxmin2(int[] array) {
		  Arrays.sort(array);
		  System.out.println(array[2]+" "+array[array.length-2]);
	}

	private static void findFib(int num) {
		int a=0;
		int b=1;
		for(int i=0;i<num;i++) {
			System.out.println(a);
			int c=a+b;
			a=b;
			b=c;
		}
	}
}
