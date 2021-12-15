package recursion;

import java.util.Scanner;

public class factorial {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in) ;
//		factorial(sc.nextInt());
		System.out.println(factorial(5));

	}

	private static int factorial(int num) {
		if(num==1) {
			return num;
		}
		return num*factorial(num-1);
	}
}
