package resource_hash_map;

//create a set view of the mappings contained in a map
import java.util.*;

public class Exercise9 {
	public static void main(String args[]) {
		HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
		hash_map.put(1, "Red");
		hash_map.put(2, "Green");
		hash_map.put(3, "Black");
		hash_map.put(4, "White");
		hash_map.put(5, "Blue");
		
		// create set view for the map
		Set set = hash_map.entrySet();

		// get keyset value from map
		Set keyset = hash_map.keySet();

		// check key set values
		System.out.println("Key set values are: " + keyset);

		// check set values
		System.out.println("Set values: " + set);
		// get value of key 3
		System.out.println("Value for key 3 is: " + hash_map.get(3));

		// checking collection view of the map
		System.out.println("Collection view is: " + hash_map.values());
	}
}
