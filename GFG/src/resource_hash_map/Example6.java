package resource_hash_map;

import java.util.*;
import java.util.Map.Entry;

public class Example6 {
	public static void main(String args[]) {
		HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
		hash_map.put(1, "Red");
		hash_map.put(2, "Green");
		hash_map.put(3, "Black");
		hash_map.put(4, "White");
		hash_map.put(5, "Blue");
		// print the map
		System.out.println("The Original map: " + hash_map);
		HashMap<Integer, String> new_hash_map = new HashMap<Integer, String>();
		new_hash_map = (HashMap<Integer, String>) hash_map.clone();
		System.out.println("Cloned map: " + new_hash_map);
		//checking for exists
		System.out.println(hash_map.containsValue("Green"));
		
		//searching with value
		String s="Black";
		for(Map.Entry<Integer, String> x:hash_map.entrySet()) {
			if(x.getValue() == s) {
				System.out.println("Key Value is : "+x.getKey());
			}
				
		}
		
	}
}
