package resource_hash_set;

import java.util.*;
import java.util.Iterator;

public class Exercise2 {
	static int count = 0;

	public static void main(String[] args) {
		// Create a empty hash set
		HashSet<String> h_set = new HashSet<String>();
		// use add() method to add values in the hash set
		h_set.add("Red");
		h_set.add("Green");
		h_set.add("Black");
		h_set.add("White");
		h_set.add("Pink");
		h_set.add("Yellow");

		System.out.println("Size of the Hash Set: " + h_set.size());
		// set Iterator
		Iterator<String> p = h_set.iterator();
		// Iterate the hash set
		while (p.hasNext()) {
			count++;
			System.out.println(p.next() + " " + count);
		}
		//clonning of hash set
		HashSet<String> new_h_set = new HashSet<String>();
		new_h_set = (HashSet) h_set.clone();
		System.out.println("Cloned Hash Set: " + new_h_set);
	}
}
