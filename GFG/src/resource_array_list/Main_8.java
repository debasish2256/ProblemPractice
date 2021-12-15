package resource_array_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_8 {

	public static void main(String[] args) {
		//creating list
		List<String> color = new ArrayList<String>();
		//adding some colors
		color.add("Red");
		color.add("Green");
		color.add("Orange");
		color.add("White");
		color.add("Black");
		System.out.println("List before sort: "+color); 
		//sorting the list
		Collections.sort(color);
		System.out.println("List after sort: "+color); 
	}

}
