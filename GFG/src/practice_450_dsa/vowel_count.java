package practice_450_dsa;

import java.util.*;  
class vowel_count { 
	static boolean isVowel(char ch) 
	{ 
		ch = Character.toUpperCase(ch); 
		return (ch=='A' || ch=='E' || ch=='I' || 
						ch=='O' || ch=='U'); 
	} 
	static int countVowels(String str) 
	{ 
		int count = 0; 
		for (int i = 0; i < str.length(); i++) 
			if (isVowel(str.charAt(i))) 
				++count; 
		return count; 
	} 
	public static void main(String args[]) 
	{ 
		Scanner sc= new Scanner(System.in); 
        String str= sc.nextLine();  
		System.out.println(countVowels(str)); 
	} 
} 

