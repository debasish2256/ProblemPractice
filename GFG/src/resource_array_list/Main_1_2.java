package resource_array_list;

import java.util.ArrayList;
import java.util.List;

public class Main_1_2 {
	public static void main(String[] args) {
		//creating list
		int point = 0;
		List<String> color = new ArrayList<String>();
		//adding some colors
		color.add("Red");
		color.add("Green");
		color.add("Orange");
		color.add(".");
		color.add("White");
		color.add("Black");
		System.out.println(color);
		//iterataion and index
//		for (String i : color)
//			System.out.println(i+" "+color.indexOf(i));
		for (String i : color)
			point=color.indexOf(".");
			color.set(point,"@");
			System.out.println(color.subList(0,point+1)+" highradius.com");
	}
}