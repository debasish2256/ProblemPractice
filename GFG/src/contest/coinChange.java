package contest;
//TC O(n*target)
public class coinChange {
	public static void main(String[] args) {
		System.out.println(numberOfCombinations(new int[] {5, 2, 4},13));
	}
	static int numberOfCombinations(int[] arr, int target) {
		int table[]=new int[target+1];
		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[] values
		// after the index greater than or equal to the value of the
		// picked coin
		for(int i=0; i<arr.length; i++)
			for(int j=arr[i]; j<=target; j++)
				table[j] += table[j-arr[i]];

		return table[target];
	}
}
