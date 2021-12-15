package contest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class removeAdjacent {
	/*"aaabbcdd", target = 2
	 Output: "aaac"*/
	public static void main(String[] args) {
		System.out.println(remove("aaabbcdd",2));
	}

	private static String remove(String string, int remove) {
		
		Map<String,Integer> map=new HashMap<>();
		
		for(int i=0;i<string.length();i++) {
			int count=1;			
			if(!map.containsKey(String.valueOf(string.charAt(i)))) {
				map.put(String.valueOf(string.charAt(i)), count++);
			}else {
				map.put(String.valueOf(string.charAt(i)), map.get(String.valueOf(string.charAt(i)))+1);
			}			
		}
		String s="";
		for (Entry<String, Integer> data : map.entrySet()) {
			if(data.getValue()!=remove) {
				for(int i=0;i<data.getValue();i++) {
					s+=data.getKey();
				}
			}
		}
		return s;
	}
	
	
}
