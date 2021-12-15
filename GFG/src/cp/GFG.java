package com.highradius.cp;

//Java Program to Find the difference
//between Two Time Periods

//Importing the Date Class from the util package
import java.util.*;

//Importing the SimpleDateFormat
//Class from the text package
import java.text.*;

public class GFG {

	public static void main(String[] args) throws Exception
	{

		// Dates to be parsed
		String time1 = "2021-06-12 10:25:00";
		String time2 = "2021-06-13 11:26:60";

		// Creating a SimpleDateFormat object
		// to parse time in the format HH:MM:SS
		SimpleDateFormat simpleDateFormat
			= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// Parsing the Time Period
		Date date1 = simpleDateFormat.parse(time1);
		Date date2 = simpleDateFormat.parse(time2);

		// Calculating the difference in milliseconds
		long differenceInMilliSeconds
			= Math.abs(date2.getTime() - date1.getTime());

		// Calculating the difference in Hours
		long differenceInHours
			= (differenceInMilliSeconds / (60 * 60 * 1000))
			% 24;

		// Calculating the difference in Minutes
		long differenceInMinutes
			= (differenceInMilliSeconds / (60 * 1000));

		// Calculating the difference in Seconds
		long differenceInSeconds
			= (differenceInMilliSeconds / 1000) % 60;

		// Printing the answer
		System.out.println(
			"Difference is " + differenceInHours + " hours "
			+ differenceInMinutes + " minutes "
			+ differenceInSeconds + " Seconds. ");
	}
}
