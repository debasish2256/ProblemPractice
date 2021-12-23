package hackerRank;

public class AllPrimeNumbers {
	public static void main(String[] args) {
		printPrimeNumbers(9);
	}

	private static void printPrimeNumbers(int n) {
		for (int num = 2; num <= n; num++) {
			int count = 0;
			for (int i = 2; i * i <= num; i++) {
				if (num % i == 0) {
					count++;
					break;
				}
			}

			if (count == 0)
				System.out.println(num);
		}

	}
}
