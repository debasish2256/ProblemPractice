package hashing;

import java.util.HashMap;
import java.util.Map;

/*Input :  votes[] = {"john", "johnny", "jackie", 
        "johnny", "john", "jackie", 
        "jamie", "jamie", "john",
        "johnny", "jamie", "johnny", 
        "john"};
Output : John
We have four Candidates with name as 'John', 
'Johnny', 'jamie', 'jackie'. The candidates
John and Johny get maximum votes. Since John
is alphabetically smaller, we print it.*/


public class electionVotes {

	 public static void main(String[] args)
	    {
	       String[] votes = { "john", "johnny", "jackie",
	                         "johnny", "john", "jackie",
	                         "jamie", "jamie", "john",
	                         "johnny", "jamie", "johnny",
	                         "john" };
	 
	       System.out.println(findWinner(votes));
	    }

	 private static String findWinner(String[] votes) {
		 //store the name with frequency
		 Map<String ,Integer> map=new HashMap<>();
		 for(String str:votes) {
			 if(map.keySet().contains(str)) {
				 map.put(str, map.get(str)+1);
			 }else {
				 map.put(str, 1);
			 }
		 }
		 
		 int maxValueInMap = 0;
		 String winner = "";
		 for (Map.Entry<String,Integer> entry : map.entrySet())
		 {
			 String key  = entry.getKey();
			 Integer val = entry.getValue();
			 if(val>maxValueInMap) {
				 maxValueInMap= val;
				 winner=key;
			 }
			// If there is a tie, pick lexicographically
	        // smaller.			 
			 else if(val==maxValueInMap && winner.compareTo(key) > 0){
				 winner = key;
			 }
		 }
		 return winner;
	 }
	
	
}
