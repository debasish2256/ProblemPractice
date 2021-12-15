package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKeypadCombination {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println(getKPC(sc.next()));
	}
	static String[] code= {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	public static ArrayList<String> getKPC(String str) {
		if(str.length()==0) {
			ArrayList<String> empty=new ArrayList<>();
			empty.add("");
			return empty;
		}
		char firstCh=str.charAt(0);
		String ros=str.substring(1);
		ArrayList<String> rres=getKPC(ros);
		
		ArrayList<String> myRes=new ArrayList<String>();
		String codeWise=String.valueOf(code[firstCh-'0']);
		for(int i=0;i<codeWise.length();i++) {
			String singleCode=String.valueOf(codeWise.charAt(i));
			for(String s:rres) {
				myRes.add(singleCode+s);
			}
		}
		
		return myRes;
	}

}
