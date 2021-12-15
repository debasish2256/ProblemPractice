package recursion;

import java.util.Scanner;

public class print_increasing {
	public static void main(String[] args) throws Exception {
		Scanner sc =new Scanner(System.in);
//		printIncreasing(sc.nextInt());
		printIncreasing(5);
	}

	public static void printIncreasing(int n){
		if(n==0){
			return;
		}
		System.out.println(n);
		printIncreasing(n-1);
		System.out.println(n);

	}
}
