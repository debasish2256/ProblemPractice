package hackerRank;

public class NthFibanacciNumber {
	public static void main(String[] args) {
		System.out.println(findFibonacci(5));
	}

	private static int findFibonacci(int n) {
		if(n==1) {
			return 1;
		}
		double PHI = 1.6180339;
		int t = 5;
		int fn = 5;
		while (t < n) {
			fn = (int) Math.round(fn * PHI);
			t++;
		}
		return fn;
	}
}
