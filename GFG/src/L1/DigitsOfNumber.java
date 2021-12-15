package L1;

import java.util.Scanner;

public class DigitsOfNumber {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
//		digitsOfNumber(cin.nextInt());
//		reverseNumber(cin.nextInt());
		printZ(10);
	}
	private static void printZ(int size) {
		int s=size;
		for(int i=1;i<=size;) {
			if(i==1||i==size) {
				for(int j=1;j<=size;j++) {
					System.out.print("*");
				}
				System.out.println();
			}else {
				for(int j=1;j<=s-1;j++) {
					if(j==s-1) {
						System.out.print("*");
					}
					else {						
						System.out.print(" ");
					}
				}System.out.println();s--;
			}
			i++;
		}
		
	}
	private static void reverseNumber(int temp) {
		int num=temp;
		while(num!=0) {
			int rem=num%10;
			System.out.println(rem);
			num=num/10;
		}
	}
	static void digitsOfNumber(int temp) {
		int count=0;
		int num=temp;
		while(num!=0) {
			num=num/10;
			count++;
		}
		
		int div=(int) Math.pow(10, count-1);
		while(div!=0) {
			int quo=temp/div;
			System.out.println(quo);
			temp=temp%div;
			div=div/10;
		}
	}
}
	

