package com.highradius.supportportal.action;

import java.util.Vector;

public class string_array {
	//samsung
	public static int quikr(int a, int b) {
		int count = 0;
		String res=Integer.toBinaryString(a*b);
		for(int i=0;i<res.length();i++) {
			if (res.charAt(i) == '1')
				count++;
		}
		return count;
	}
	
	//mckngee
	public static String mckngee(String sw) {
		String s=sw.toLowerCase();
		StringBuilder sb=new StringBuilder();
		sb.append(s.charAt(0));
		sb.append(s.charAt(1));
		for(int i=2;i < s.length();i++) {
			if(s.charAt(i)!=s.charAt(i-1)||s.charAt(i)!=s.charAt(i-2)) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	
	private static int digitSum(int num) {
		int sum = 0;
		while (num != 0) {
			sum += (num % 10);
			num /= 10;
		}
		return sum;
	}
	
	//Microsoft
	public static int solution(int[] a) {
		Vector<Integer> v = new Vector<Integer>(a.length);
		for(int i=0;i<a.length;) {
			for(int j=i+1;j<a.length;j++)
				if(digitSum(a[i])==digitSum(a[j])) {
					v.add(a[i]+a[j]);
				}
			if (v.size() > 1) {
				for (int k = 0; k < v.size(); k++) {
					if (v.get(k) < v.get(k + 1)) {
						v.remove(v.get(k));
					} else {
						v.remove(v.get(k + 1));
					}
				}
			}
			i++;
		}
		if(v.size() >0)
			return v.get(0);
		return -1;
	}
		 
	//qualcomm
	//^v><
	private static int qualcomm(String str1) {
		int size=str1.length();
		Vector<Integer> v = new Vector<Integer>(size);
		String str=str1.toLowerCase();
		int c1=0,c2=0,c3=0,c4=0;
		for(int i=0;i<str.length();i++) {
			if (str.charAt(i) == '^')
				c1++;
			if (str.charAt(i) == 'v')
				c2++;
			if (str.charAt(i) == '>')
				c3++;
			if (str.charAt(i) == '<')
				c4++;	
		}
		v.add(size-c1);v.add(size-c2);v.add(size-c3);v.add(size-c4);
		v.sort(null);
		if(v.size() >0)
			return v.get(0);
		return -1;
	}
	
	public static void main(String[] args) {
//		System.out.println(solution(3,7));
		int[] a= {51,71,17,42};
		int[] b= {42,33,60};
		int[] c= {51,32,43};
//		System.out.println(solution(a));
//		System.out.println(solution(b));
//		System.out.println(solution(c));
		System.out.println(qualcomm("<<^^VV"));
	}
}
