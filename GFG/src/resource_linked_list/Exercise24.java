package resource_linked_list;

import java.util.*;

public class Exercise24 {
	public static void main(String[] args) {
		LinkedList<String> c1 = new LinkedList<String>();
		c1.add("Red");
		c1.add("Green");
		c1.add("Black");
		c1.add("White");
		c1.add("Pink");

		LinkedList<String> c2 = new LinkedList<String>();
		c2.add("Red");
		c2.add("Green");
		c2.add("Black");
		c2.add("Orange");

		// comparison output in linked list
		LinkedList<String> c3 = new LinkedList<String>();
		for (String e : c1)
			c3.add(c2.contains(e) ? "Yes" : "No");
		String s = c3.contains("No") ? "Not match" : "match";
		System.out.println(s + "\n" + c3);
		System.out.println("Check the above linked list is empty or not! " + c3.isEmpty());

		// Replacing 2nd element with new value
		c1.set(1, "Orange");
		System.out.println("The value of second element changed.");
		System.out.println("New linked list: " + c1);
	}
}
