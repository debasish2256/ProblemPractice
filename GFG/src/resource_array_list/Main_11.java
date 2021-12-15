package resource_array_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main_11 {

	public static void main(String[] args) {
		// creating list
		List<String> color = new ArrayList<String>();
		// adding some colors
		color.add("Red");
		color.add("Green");
		color.add("Orange");
		color.add("White");
		color.add("Black");
		for(String i:color)	System.out.println(i);
		//reversing a list
		Collections.reverse(color);
		// iterator
		Iterator<String> itr = color.iterator();
		while (itr.hasNext()) {
			System.out.print("\n"+itr.next());
		}

	}

}
