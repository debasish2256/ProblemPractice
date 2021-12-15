package contest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class factorialOfLargeNumber {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial_2(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}


class Solution {
	//Appproach 1
    static ArrayList<Integer> factorial_1(int N){
        ArrayList<Integer>al=new ArrayList<>();
        BigInteger f = new BigInteger("1"); 
  
        for (int i = 2; i <= N; i++)
            f = f.multiply(BigInteger.valueOf(i));
            
        String str=f.toString();
        
        for(int i=0;i<str.length();i++)
        {
            al.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        return al;
    }
    //Approach2
	public ArrayList<Integer> factorial_2(int n) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		
		for (int i = 2; i <= n; i++) {
			int remainder = 0;
			for (int j = 0; j < al.size(); j++) {
				int product = al.get(j) * i + remainder;
				al.set(j,product % 10);
				remainder = product / 10;
			}
			while (remainder > 0) {
				al.add(remainder % 10);
				remainder = remainder / 10;
			}
		}
		
		Collections.reverse(al);
		return al;
		}
}
