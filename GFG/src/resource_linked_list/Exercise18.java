package resource_linked_list;

import java.util.LinkedList;

public class Exercise18 {
	public static void main(String[] args) {
		// create an empty linked list
		LinkedList<String> c1 = new LinkedList<String>();
		c1.add("Red");
		c1.add("Green");
		c1.add("Black");
		c1.add("White");
		c1.add("Pink");
		System.out.println("Original linked  list: " + c1);
		LinkedList<String> newc1 = new LinkedList<String>();
		newc1 = (LinkedList) c1.clone();
		System.out.println("Cloned linked list: " + newc1);
		// remove and return the first element of a linked list
		System.out.println("Removed element: " + newc1.pop());

		System.out.println("Linked list after pop operation: " + newc1);

		// Retrieve but does not remove, the first element of a linked list
		String x = newc1.peekFirst();
		System.out.println("First element in the list: " + x);
		System.out.println("Original linked list: " + newc1);

		// Retrieve but does not remove, the last element of a linked list
		String x1 = newc1.peekLast();
		System.out.println("Last element in the list: " + x1);
		System.out.println("Original linked list: " + newc1);
	}
}
