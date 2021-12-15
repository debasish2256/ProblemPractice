package L1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

///Print All Primes Till N
public class primeTillN {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		printPrimeBetween(cin.nextInt(),cin.nextInt());
	}

	private static void printPrimeBetween(int low, int high) {
		List<Integer> list = new ArrayList<>();
		for(int i=low;i<=high;i++) {
			int count=0;
			for(int div=2;div*div<=i;div++) {
				if(i%div==0) {
					count++;
					break;
				}
			}
			if(count==0) System.out.println(i);
		}
	}
}
