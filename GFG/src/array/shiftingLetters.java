package array;

public class shiftingLetters {
	public static void main(String[] args) {
		String  s = "bad";
		int[] shifts = {10,20,30};
		System.out.println(shiftingLetters(s,shifts));
	}
	
	public static String shiftingLetters(String s, int[] shifts) {
		/*String str = new String(s);	
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<=i;j++) {
				s=str.substring(0,j)+ String.valueOf((char)(str.charAt(j)+shifts[i]))+
						str.substring(j+1, s.length());
				str=s;
			}
		}
		return str;*/
		
		int MOD=26;
		int sum=0;
		char[] ch=s.toCharArray();
		for(int i=s.length()-1;i>=0;i--) {
			sum=(sum+shifts[i])%MOD;
			ch[i]=(char) ('a'+(ch[i]-'a'+ sum)%MOD);
		}		
		return new String(ch);
	}
}
