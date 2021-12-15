package resource_array_list;

import java.util.ArrayList;

public class Exercise19 {
	public static void main(String[] args) {
		ArrayList<String> c1 = new ArrayList<String>();
		c1.add("Red");
		c1.add("Green");
		c1.add("Black");
		c1.add("White");
		c1.add("Pink");
		System.out.println("Original array list: " + c1);
		System.out.println("Let trim to size the above array: ");
		c1.trimToSize();
		System.out.println(c1);
		// replace 2nd color
		c1.set(1, "Yellow");
		// System.out.println("After Replacing:"+c1);
		System.out.println("Replace second element with 'Yellow'.");
		// print using index as i
		int num = c1.size();
		for (int i = 0; i < num; i++)
			System.out.println(c1.get(i));
	}
}
