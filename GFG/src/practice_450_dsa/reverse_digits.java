package practice_450_dsa;

import java.util.Scanner;

public class reverse_digits {
	public static void main(String[] args) {
		 int num = -123;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no. For Reverse :");
//		int num = sc.nextInt();
		System.out.println("Reverse of no. is " + reversDigits(num));
	}

	private static int reversDigits(int x) {
        int rev = 0;
        while (x != 0) {
        	int pop=x % 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
            x /= 10;
        }
        return rev;
    }
	/*private static int reversDigits(int num) {
		int result = 0;
		while (num > 0) {
			result = result * 10 + num % 10;
			num = num / 10;
		}
		return result;
	}*/

}
