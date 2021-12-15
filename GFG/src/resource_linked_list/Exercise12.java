package resource_linked_list;

//removing from a specified location
import java.util.*;

public class Exercise12 {
	public static void main(String[] args) {
		// create an empty linked list
		LinkedList<String> l_list = new LinkedList<String>();
		// use add() method to add values in the linked list
		l_list.add("Red");
		l_list.add("Green");
		l_list.add("Black");
		l_list.add("Pink");
		l_list.add("orange");

		// print the list
		System.out.println("The Original linked list: " + l_list);

		// Remove the element in third position from the said linked list
		l_list.remove(2);
		System.out.println("The New linked list: " + l_list);

		// Remove the first element
		Object firstElement = l_list.removeFirst();
		System.out.println("Element removed: " + firstElement);

		// Remove the last element
		Object lastElement = l_list.removeLast();
		System.out.println("Element removed: "+ lastElement);
		
		//Swapping 1st(index 0) element(Green) with the 2nd(index 1) element (Pink)
		System.out.println("The New linked list before swap: " + l_list);
	    Collections.swap(l_list, 0, 1);
	    System.out.println("The New linked list after swap: " + l_list);
	}
}
