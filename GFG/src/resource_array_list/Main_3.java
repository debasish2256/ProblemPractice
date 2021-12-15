package resource_array_list;

import java.util.ArrayList;
import java.util.List;

public class Main_3 {
	public static void main(String args[]) {
		List<String> color = new ArrayList<String>();
		color.add("Red");
		color.add("Green");
		color.add("Orange");
		color.add("White");
		color.add("Black");
		System.out.println(color);
		System.out.println("After Adding Color in index 1 and 5");
		color.add(0, "Pink");
		color.add(5, "Yellow");
		System.out.println(color);
		// Retrive the first and third element
		System.out.println("First element: " + color.get(0));
		System.out.println("Third element: " + color.get(2));
		// Update the third element with "Brown"
		color.set(3, "Brown");
		System.out.println("After Upadate of Color in index 3");
		System.out.println(color);
		// Remove the third element from the list.
		color.remove(2);
		System.out.println(color);
		// searching for red color
		System.out.println(color.contains("Red") ? "Found " : "Not Found");
	}

}
