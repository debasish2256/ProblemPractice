package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSubjectMarkNeedToPass {
	public static void main(String[] args) {
		List<Integer> answered = new ArrayList<>();
		answered.add(24);
		answered.add(27);
		answered.add(0);

		List<Integer> needed = new ArrayList<>();
		needed.add(51);
		needed.add(52);
		needed.add(100);

		int q = 200;
		System.out.println(maxSubjectsNumber(answered, needed, q));
	}

	private static int maxSubjectsNumber(List<Integer> answered, List<Integer> needed, int q) {
		List<Integer> pass = new ArrayList<>();
		for (int i = 0; i < answered.size(); i++) {
			pass.add(needed.get(i) - answered.get(i));
		}
		Collections.sort(pass);
		int count = 0;
		int sum=0;
		for (int i = 0; i < pass.size(); i++) {
			sum+=pass.get(i);
			if (sum<=q)
			{
				count++;
			}
		}
		return count;
	}

}
