package L1;

import java.util.Scanner;

public class countDigits {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		System.out.println(countDigits(cin.nextInt()));
	}

	private static int countDigits(int num) {
		int count = 0;
		int temp = num;
		while (temp != 0) {
			temp = temp / 10;
			count++;
		}

		return count;
	}
}
