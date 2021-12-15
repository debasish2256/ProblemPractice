package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class getSubsequence {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
//		System.out.println(gss(sc.nextLine()));
//		abc
		System.out.println(gss("abcd"));

	}

	public static ArrayList<String> gss(String str) {
		if(str.length()==0) {
			ArrayList<String> empty=new ArrayList<>();
			empty.add("");
			return empty;
		}
		char first=str.charAt(0);//a
		String change=str.substring(1);//bc
		ArrayList<String> res=gss(change);

		ArrayList<String> myres=new ArrayList<>();
		for(String s:res) {
			myres.add(""+s);
		}
        for(String s:res) {
			myres.add(first+s);
		}
		return myres;
	}
}
