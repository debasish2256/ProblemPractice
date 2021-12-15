package com.highradius.cp;

public class leetCode {
	public static void main(String[] args) {
		System.out.println(divide(-2147483648,-1));
	}
	
	
	/*Divide Two Integers
	Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

	Return the quotient after dividing dividend by divisor.

	The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

	Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
	*/
	public static long divide(long dividend, long divisor) {
		long sign = ((dividend < 0)^(divisor < 0)) ? -1 : 1;
		long quotient = 0 ,temp= 0;
		Double s=90.87;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		for (int i = 31; i >= 0; --i)
		{
			Number m=(Integer)((Number)s).intValue();
			
			if (temp + (divisor << i) <= dividend)
			{
				temp += divisor << i;
				quotient |= 1L << i;
			}
		}
		return sign*quotient;
	}
	
	
	
	
	
	/*//user name Problem		System.out.println(getUserName("debasish","mahana"));*/
	public static String getUserName (String firstName, String lastName) {
		if(lastName==null)	return (capitaliseFirstLetter(firstName));
		if(firstName==null) return (capitaliseFirstLetter(lastName));
		if(firstName==null && lastName==null) return null;
		return capitaliseFirstLetter(lastName).concat(", ").concat(capitaliseFirstLetter(firstName));
    }
   
    public static String capitaliseFirstLetter (String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
            
        char[] chars = s.toCharArray();
        
        chars[0] = Character.toUpperCase(chars[0]);
        
        return String.valueOf(chars);
    }
}
