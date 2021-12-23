package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class calculateAmount {
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(4);
		input.add(9);
		input.add(2);
		input.add(3);
		System.out.println(calculateAmount(input));
	}

	private static long calculateAmount(List<Integer> prices) {
		long ans=prices.get(0);
		long min=prices.get(0);
		for(int i=1;i<prices.size();i++) {
			long diff=prices.get(i)-min;
			if(diff>=0) {
				ans+=diff;
			}
			min=Math.min(min, prices.get(i));
		}	
		return ans;
	}
}
