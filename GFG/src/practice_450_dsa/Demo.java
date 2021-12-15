package practice_450_dsa;

import java.util.*;

class Demo
{
	
	static int solution(int A, int B) {
	    char[] firstNumberChars = getChars(A);
	    char[] secondNumberChars = getChars(B);

	    int firstNumberLength = firstNumberChars.length;
	    int secondNumberLength = secondNumberChars.length;
	    int highestLength = Math.max(firstNumberLength, secondNumberLength);

	    StringBuilder decimalZip = new StringBuilder();
	    for (int i = 0; i < highestLength; i++) {
	        if (i < firstNumberLength)
	            decimalZip.append(firstNumberChars[i]);
	        if (i < secondNumberLength)
	            decimalZip.append(secondNumberChars[i]);
	    }

	    int maxValue = 100000000;
	    int answer = Integer.parseInt(String.valueOf(decimalZip));
	    if (answer > maxValue)
	        return -1;
	    return answer;
	}

	private static char[] getChars(int n) {
	    return String.valueOf(n).toCharArray();
	}
  public static void main(String args[])
  {
	  
	 System.out.println( solution(34,74));
  }
}
//	  int sum=0;
//	  int num=3;
//	  if(num == 0)
//	  {
//	         System.out.println(sum); 
//	  }
//	  else
//	  {
//	   sum = num+(num-1);
//	  } 
//	         System.out.println(sum); 
//	    } 
//	  }
    /*// Creating Hashtable
    Hashtable<String,Integer> hashtable = new Hashtable<String,Integer>();
    // Adding elements
    hashtable.put("a",100);
    hashtable.put("b",200);
    hashtable.put("c",300);
    hashtable.put("d",400);
    // Traversing Hashtable
    for(Map.Entry<String, Integer> m : hashtable.entrySet()) {
      System.out.println(m.getKey()+" "+m.getValue());
    }   */
  