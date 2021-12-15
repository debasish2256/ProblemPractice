import java.util.HashMap;
import java.util.Scanner;

public class Butterfly {

	public static void main(String[] args) {
		int n, i, j, space;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Size of Butterfly : ");
		n=sc.nextInt();
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= i; j++) {
				System.out.print("*");
			}
			space = 2 * n - 2 * i;
			for (j = 1; j <= space; j++) {
				System.out.print(" ");
			}
			for (j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		for ( i = n; i >= 1; i--) {
			for (j = 1; j <= i; j++) {
				System.out.print("*");
			}
			space = 2 * n - 2 * i;
			for (j = 1; j <= space; j++) {
				System.out.print(" ");
			}
			for (j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

}
