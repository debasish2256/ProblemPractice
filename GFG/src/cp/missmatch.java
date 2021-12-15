package com.highradius.cp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import com.highradius.util.StringConstants;

public class missmatch {
	static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) throws ParseException {
		String previousTime = "2021-05-13 11:25:00";
		String agentCurrentTime = "2021-06-13 11:26:60";
		List<String> vowels = new ArrayList<>();
//		System.out.println(minutesDifference(previousTime, agentCurrentTime));
		vowels.add("A.txt"); 
		vowels.add("E.txt"); 
		vowels.add("U.csv");
		vowels.add(".csv");
		
		System.out.println(fileNameBuilder(vowels,"_DEC"));
		
		
		
		
	}
	
	protected static List<String> fileNameBuilder(List<String> inputFile, String appendString) {
		List<String> resultString = new ArrayList<>();
		if (inputFile != null && StringUtils.isNotBlank(appendString)) {
			try {
				for (String fileName : inputFile) {
					if (StringUtils.isNotBlank(fileName) && fileName.lastIndexOf(StringConstants.DOT) > 0) {
						resultString.add((FilenameUtils.getBaseName(fileName) + appendString + StringConstants.DOT + FilenameUtils.getExtension(fileName)));
					}
				}
			} catch (Exception e) {
				System.err.println(e);
			}
			return resultString;
		}
		return null;
	}
	
	protected static int minutesDifference(String start_date, String end_date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
			Date d1 = sdf.parse(start_date);
			Date d2 = sdf.parse(end_date);
			long difference_In_Time = d2.getTime() - d1.getTime();
			return (int)((difference_In_Time / (1000 * 60)));
		}
		catch (ParseException e) {
			System.err.println("Exception occured in minutesDifference method::"+e);
		}
		return -1;
	}

	/*
	 * protected static int minutesDifference(String input_time, String
	 * current_time) { SimpleDateFormat sdf = new
	 * SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); try { Date d1 =
	 * sdf.parse(input_time); Date d2 = sdf.parse(current_time); return
	 * (int)Math.abs((TimeUnit.MILLISECONDS.toMinutes(d1.getTime() - d2.getTime()) %
	 * 60)); } catch (ParseException e) {
	 * System.err.println("Exception occured in minutesDifference method::"+e); }
	 * return 0; }
	 */

	/**
	 * @method fileNameBuilder
	 * @param List
	 *            o file to be process
	 * @param string
	 *            to be append
	 * @returns @list @format baseFileName+appendString+.+extension
	 * @returns @list @else baseFileName+appendString
	 *//*
		 * static List<String> fileNameBuilder(List<String> inputFile, String
		 * appendString) { List<String> resultString = new ArrayList<>(); if (inputFile
		 * != null && !appendString.isEmpty()) { for (int i = 0; i < inputFile.size();
		 * i++) { if (!inputFile.get(i).equals("") && !inputFile.get(i).equals("null")
		 * && !inputFile.get(i).equals(" ") && !inputFile.get(i).equals("*.*")
		 * &&!inputFile.get(i).equals(".")) {
		 * resultString.add(((inputFile.get(i).length() > 0) &&
		 * (inputFile.get(i).lastIndexOf(StringConstants.DOT)) > 0) ?
		 * (FilenameUtils.getBaseName(inputFile.get(i)) + appendString +
		 * StringConstants.DOT + FilenameUtils.getExtension(inputFile.get(i))) :
		 * (inputFile.get(i) + appendString)); } } } return resultString; }
		 */

}
