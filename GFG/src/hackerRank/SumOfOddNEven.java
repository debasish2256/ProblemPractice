package hackerRank;

public class SumOfOddNEven {
	public static void main(String[] args) {
		findSumOfOddNEven(552245);
	}

	private static void findSumOfOddNEven(int n) {
		String str=String.valueOf(n);
		int evenSum=0,oddSum=0;
		for(int i=0;i<str.length();i++) {
			if(Integer.parseInt(String.valueOf(str.charAt(i)))%2==0) {
				evenSum+=Integer.parseInt(String.valueOf(str.charAt(i)));
			}else {
				oddSum+=Integer.parseInt(String.valueOf(str.charAt(i)));
			}	
		}	
		System.out.println(evenSum+" "+oddSum);
	}
}
