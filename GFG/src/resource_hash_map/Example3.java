package resource_hash_map;

import java.util.*;

public class Example3 {
	public static void main(String args[]) {
		// create two hash maps
		HashMap<Integer, String> hash_map1 = new HashMap<Integer, String>();
		HashMap<Integer, String> hash_map2 = new HashMap<Integer, String>();
		// populate hash maps
		hash_map1.put(1, "Red");
		hash_map1.put(2, "Green");
		hash_map1.put(3, "Black");
		System.out.println("\nValues in first map: " + hash_map1);
		hash_map2.put(4, "White");
		hash_map2.put(5, "Blue");
		hash_map2.put(6, "Orange");
		System.out.println("\nValues in second map: " + hash_map2);
		// if key same value will be replaced
		//putAll used for copy one hashmap to otherhashmap
		// put all values in secondmap
		hash_map2.putAll(hash_map1);
		System.out.println("\nNow values in second map: " + hash_map2);
		// Removing all the elements from the linked map
		hash_map1.clear();
		System.out.println("\nValues in first map: " + hash_map1);
		// check if map is empty
		// check the result
		System.out.println("Is hash map 1 empty: " + hash_map1.isEmpty());
	}
}
