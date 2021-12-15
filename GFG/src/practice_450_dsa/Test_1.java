package practice_450_dsa;

public class Test_1 {
	/*public static boolean isContainsWords(String inputString, String[] items) {
	    boolean found = true;
	    for (String item : items) {
	        if (!inputString.contains(item)) {
	            found = false;
	            break;
	        }
	    }
	    return found;
	}*/
	public static boolean isContainsWords(String inputString, String[] items) {
		boolean found = true;
	    for (String word : items) {
	        if (inputString.indexOf(word) == -1) {
	            found = false;
	            break;
	        }
	    }
	    return found;
	}
	public static void main(String args[]) {
		String resultString = "hello there, Debasish";
		String[] keyWords = {"hello", "Baeldung"};
		System.out.println(isContainsWords(resultString, keyWords) ? "All Keyword Matced" : "No Match");
	}
}
