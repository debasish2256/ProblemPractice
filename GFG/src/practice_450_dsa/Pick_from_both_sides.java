package practice_450_dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pick_from_both_sides {

	public static int solve(int[] A1, int B) {
		ArrayList<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < A1.length; i++)
            A.add(new Integer(A1[i]));	
        int n = A.size();
		
		return 0;
	}

	public static void main(String[] args) {
		int A[] = { 5, -2, 3, 1, 2 };
		int B = 3;
		System.out.println(solve(A, B));
	}

}
