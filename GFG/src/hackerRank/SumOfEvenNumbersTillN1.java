package hackerRank;

public class SumOfEvenNumbersTillN1 {
	public static void main(String[] args) {
		System.out.println(sumOfEvenNubers(2));
	}

	private static int sumOfEvenNubers(int n) {
		int sum = 0;

		for (int i = 0; i <= n;) {
			sum += i;
			i = i + 2;
		}
		return sum;
	}
}
