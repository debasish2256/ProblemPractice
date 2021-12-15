package twoDArray;

import java.util.Scanner;

public class twoDArray {
	public static void main(String[] args) {
		Scanner sc =new Scanner (System.in);
		int n=sc.nextInt();
		int size=sc.nextInt();
		int num[][]=new int[n][size];
		for(int i=0;i<n;i++) {
			for(int j=0;j<size;j++) {
				num[i][j]=sc.nextInt();
			}
		}
		
		printTwoDArray(num);
	}

	private static void printTwoDArray(int[][] num) {
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<num[i].length;j++) {
				System.out.print(num[i][j]+" ");
			}
			System.out.println();
		}
	}
}
