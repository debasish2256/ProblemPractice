package contest;

import java.util.Arrays;

public class kSubstringVowels {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(kSubstringVowels("substring",2)));
	}
	/*static int isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return 1;
		}
		return 0;
	}*/

/*	static int[] kSubstringVowels (String s, int k) {
		int n = s.length();
		int[] vowels = new int[n + 1 - k];
		int count = 0;
		for (int i = 0; i < k; i++) {
			count += isVowel(s.charAt(i));
		}
		vowels[0] = count;
		for (int i = k; i < n; i++) {
			count = count - isVowel(s.charAt(i - k)) + isVowel(s.charAt(i));
			vowels[i - k + 1] = count;
		}

		return vowels;
	}*/
	
	static int[] kSubstringVowels (String s, int k) {
		int[] ans=new int[s.length()-k+1];
		int[] res=new int[s.length()];
		int vowel=0;
		int t=1;
		for(int i =0;i<s.length();i++) {
			if(isVowel(s.charAt(i))) {
				vowel++;
			}
			res[i]=vowel;
		}
		ans[0]=res[k-1];
		for(int i=k;i<s.length();i++) {
			ans[t++]=res[i]-res[i-k];
		}

		return ans;
	
	}
	
	static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
	
	/*static int[] kSubstringVowels (String s, int k) {
		char[] str = s.trim().toCharArray();
		int stop=k;
		int[] res=new int[s.length()-k+1];
		int count=0;
        String sub="";
        for(int i=0;i<s.length();) {
        	sub=s.substring(i, k);
        	int vowels = 0;
        	for(int j = 0; j < sub.length(); j++) {
        		if (isVowel(sub.charAt(j))) 
        			vowels++;
        	}
        	res[count++]=vowels;
        	if(count==s.length()-stop+1) break;
        	i=i+1;
        	k=k+1;
        }
		return res;
		
	}*/
	
	
}
