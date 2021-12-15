package contest;

import java.util.Stack;

public class commentRemoval {
	
	public static void main(String[] args) {
		String str="#include int main(int *argc,char **argv)\r\n" + 
				"{ // First line of code\\n \r\n" + 
				"printf(\"Hello World!!! \"); return 0; "
				+ "/*For Testing Purpose*/}";
		System.out.println(removeComments(str));
	}
	
	//Approach 2
	private static String removeComments(String code) {
		StringBuilder result = new StringBuilder();

		Stack<String> stk = new Stack<String>();

		for(int i=0; i<code.length(); i++){

			if(i+1< code.length() && code.charAt(i) == '/' && code.charAt(i+1) == '*')
				stk.push("/*");

			else if(i+1< code.length() && code.charAt(i) == '/' && code.charAt(i+1) == '/')
				stk.push("//");

			else if(i-1 >=0 && code.charAt(i) == '*' && code.charAt(i-1) == '/')
				continue;

			else if(i-1 >=0 && code.charAt(i) == '/' && code.charAt(i-1) == '/')
				continue;

			else if(i+1 < code.length() && code.charAt(i) == '*' && code.charAt(i+1) == '/'){
				stk.pop();

				i++;
			}    

			else if(i < code.length() && i == code.indexOf("\\n")){
				//System.out.println("gh");
				stk.pop();
				i++;
			}    

			else if(stk.size() == 0)
				result.append(code.charAt(i));

			else
				continue;


		}

		return result.toString();
	}
	
	//Aproach 1
	static String removeComments_1(String code) 
    { 
        int begin;
        int end;
        while(code.contains("//")) {
            begin = code.indexOf("//");
            end = code.indexOf("\\n", begin);
            code = code.replace(code.substring(begin, end+2), "");
        }
        while(code.contains("/*")) {
            begin = code.indexOf("/*");
            end = code.indexOf("*/", begin);
            code = code.replace(code.substring(begin, end+2), "");
        }
        return code;
    }
	
	
}
