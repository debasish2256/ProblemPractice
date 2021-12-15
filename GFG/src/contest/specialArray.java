package contest;
//Paytm
public class specialArray {
	public static void main(String[] args) {
//		Logic: take 121 <2>divide it by 2 and add 1 <3>run the loop upto 61 starting from 1 <4> In 29th iteration 29 + reverseof29(92) == 121
//		<5>Increase count and break the loop
		System.out.println(isSpecial(new String[] { "22", "121" }));
		System.out.println(isSpecial(new String[] { "12", "3" }));

	}

	public static int isSpecial(String[] inp) {
		int inpSize = inp.length;
		int arr[] = new int[inp.length];
		for (int i = 0; i < inpSize; i++) {
			arr[i] = Integer.parseInt(inp[i]);
		}

		int spclCount = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < ((arr[i] / 2) + 1); j++) {
				if (j + getReverse(j) == arr[i]) {
					spclCount++;
					break;
				}
			}
		}

		return spclCount;
	}

	public static int getReverse(int n) {
		int rem, rev = 0;
		while (n != 0) {
			rem = n % 10;
			rev = (rev * 10) + rem;
			n /= 10;
		}
		return rev;
	}

}
