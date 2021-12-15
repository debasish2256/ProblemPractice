package contest;

import java.util.HashSet;
import java.util.Set;

//Paytm
public class serenaAndFlowers {

	public static void main(String[] args) {
		System.out.println(uniqueFlowersPickedBySerena(new int[] {1,1,2,1,5 }, 3));
//		System.out.println(uniqueFlowersPickedBySerena(new int[] { 2,1,2,1,3,1,4,5,6,1 }, 7));
	}

	private static int uniqueFlowersPickedBySerena(int arr[], int walk) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < walk; i++) {
				set.add(arr[i]);
		}
		return set.size();
	}
}
