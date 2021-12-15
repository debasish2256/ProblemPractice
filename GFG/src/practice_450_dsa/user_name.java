package practice_450_dsa;


import java.util.*;

public class user_name {
	
	public static void main(String[] args) {
		System.out.println(getUserName(null,null));
	}
	public static String getUserName (String firstName, String lastName) {
		if(lastName==null)	return (capitaliseFirstLetter(firstName));
		if(firstName==null) return (capitaliseFirstLetter(lastName));
		if(firstName==null && lastName==null) return null;
		return capitaliseFirstLetter(lastName).concat(", ").concat(capitaliseFirstLetter(firstName));
        // return the user name as LastName, FirstName e.g. Smith, John
    }
    
    
    public static String capitaliseFirstLetter (String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
            
        char[] chars = s.toCharArray();
        
        chars[0] = Character.toUpperCase(chars[0]);
        
        return String.valueOf(chars);
    }
}