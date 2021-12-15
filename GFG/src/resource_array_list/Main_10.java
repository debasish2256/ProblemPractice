package resource_array_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main_10 {

	public static void main(String[] args) {
		// creating list
		List<String> color = new ArrayList<String>();
		// adding some colors
		color.add("Red");
		color.add("Green");
		color.add("Orange");
		color.add("White");
		color.add("Black");
		//iterator
		Iterator<String> itr = color.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("List before shuffling:\n" + color);
		Collections.shuffle(color);
		System.out.println("List after shuffling:\n" + color);
	}

}
