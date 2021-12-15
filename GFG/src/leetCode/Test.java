package leetCode;

import java.util.ArrayList;

/*
For n = 2, k = 3
input strings: 'abc' 'qwe'
output strings: 'aq', 'aw', 'ae', 'bq', 'bw', 'be', 'cq', 'cw', 'ce'
*/


public class Test {
	
	public static void main(String[] args) {
		String[] s= {"abc" ,"qwe"};
		solution(s,2,3);
	}

	private static void solution(String[] text,int n,int k) {
		char[] s=text[0].toCharArray();
		char[] t=text[1].toCharArray();
		for(int i=0;i<s.length;i++) {
			for(int j=0;j<t.length;j++) {
				System.out.print(s[i]+""+t[j]+",\t");
			}
		}
	}
	
}
