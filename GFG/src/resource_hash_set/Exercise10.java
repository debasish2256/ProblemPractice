package resource_hash_set;

import java.util.*;

public class Exercise10 {
	public static void main(String[] args) {
		// Create a empty hash set
		HashSet<String> h_set = new HashSet<String>();
		// use add() method to add values in the hash set
		h_set.add("Red");
		h_set.add("Green");
		h_set.add("Black");
		h_set.add("White");

		HashSet<String> h_set2 = new HashSet<String>();
		h_set2.add("Red");
		h_set2.add("Pink");
		h_set2.add("Black");
		h_set2.add("Orange");
		h_set2.add("Yellow");
		// comparison output in hash set
		HashSet<String> result_set = new HashSet<String>();
		for (String element : h_set) {
			System.out.println(h_set2.contains(element) ? "Yes" : "No");
		}
		System.out.println("Set 1 : " + h_set);
		System.out.println("Set 2 : " + h_set2);
		h_set.retainAll(h_set2);
		System.out.println("Common in both : " + h_set);

		// clear() method removes all the elements from a hash set
		// and the set becomes empty.
		h_set.clear();

		// Display original hash set content again
		System.out.println("HashSet content: " + h_set);

	}
}
