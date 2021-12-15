package resource_linked_list;

import java.util.Iterator;
import java.util.LinkedList;

public class Exercise1 {
	public static void main(String[] args) {
		// create an empty linked list
		LinkedList<String> list = new LinkedList<String>();
		// use add() method to add values in the linked list
		list.add("Red");
		list.add("Green");
		list.add("Black");
		list.add("White");
		list.add("Pink");
		list.add("Yellow");

		// print the list
		System.out.println("The linked list: " + list);
		// iteration
		for (String l : list)
			System.out.println("The Iteration of list: " + l);
		
		// set Iterator at specified index
		Iterator<String> p = list.listIterator(2);

		// print list from second position
		System.out.println("Elements From Second List:");
		while (p.hasNext()) {
			System.out.println(p.next());
		}
		//for reverse order
		Iterator<String> it =  list.descendingIterator();
		
		// Print list elements in reverse order
	     System.out.println("Elements in Reverse Order:");
	     while (it.hasNext()) {
	        System.out.println(it.next());
	     }
	}
}
