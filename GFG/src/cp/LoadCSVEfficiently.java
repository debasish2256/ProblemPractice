package com.highradius.cp;

/**
 * 
 * @author debasish.mahana
 *
 */


import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import au.com.bytecode.opencsv.CSVWriter;
public class LoadCSVEfficiently {
	
	public static void main(String[] args) throws IOException, CsvException {
		
		String path=("C:\\Users\\debasish.mahana\\Downloads\\IFTDATA\\TD_YORKER_IFT.csv");
		CSVReader reader = new CSVReader(new FileReader(path));
		String [] nextLine = reader.readNext();
		int file_path = getHeaderLocation(nextLine, "file_path");
		int file_name = getHeaderLocation(nextLine, "file_name");
		int pk_inbound_file_transmission_id=getHeaderLocation(nextLine, "pk_inbound_file_transmission_id");

		Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\debasish.mahana\\Downloads\\IFTDATA\\"+(FilenameUtils.getBaseName(path).substring(FilenameUtils.getBaseName(path).indexOf("_", 0)+1,FilenameUtils.getBaseName(path).lastIndexOf("_")).toString())+"_REPORT.csv"));
		String[] extension = {"xml","pgp","zip"};
		String[] headerRecord = {"pk_id","schema_name","failed_file_name"};
	        	  	     	
	    Map<String, String> xmlMap = new HashMap<String, String>(); 
	    Map<String, String> bahotHard = new HashMap<String, String>();   

	    ArrayList<String> zip_pgpFileList = new ArrayList<String>();
		CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
        csvWriter.writeNext(headerRecord);
		long start = System.currentTimeMillis();
        while ((nextLine = reader.readNext()) != null && file_path > -1 && file_name > -1) {
        	if(FilenameUtils.getExtension(nextLine[file_name]).endsWith(extension[0].toLowerCase()) && extension[0].toLowerCase()=="xml") {
        		xmlMap.put(FilenameUtils.getBaseName(nextLine[file_path]),FilenameUtils.getName(nextLine[file_name])+"_"+nextLine[pk_inbound_file_transmission_id]+"_"+FilenameUtils.getBaseName(path).substring(FilenameUtils.getBaseName(path).indexOf("_", 0)+1,FilenameUtils.getBaseName(path).lastIndexOf("_")));   
        		bahotHard.put(FilenameUtils.getName(nextLine[file_name]).subSequence(0,FilenameUtils.getName(nextLine[file_name]).lastIndexOf(".")).toString(),getDate(nextLine[file_path])[0]);
        	} else if (FilenameUtils.getExtension(nextLine[file_path]).endsWith(extension[1].toLowerCase()) && extension[1].toLowerCase()=="pgp" || FilenameUtils.getExtension(nextLine[file_path]).endsWith(extension[1].toLowerCase()) && extension[2].toLowerCase()=="zip"){
        		zip_pgpFileList.add(nextLine[file_path]);
        	} 
        }
        
        for(String listFileName:mainLogic(xmlMap,zip_pgpFileList,bahotHard)) {
        	csvWriter.writeNext(new String[] {(FilenameUtils.getExtension(listFileName).subSequence(FilenameUtils.getExtension(listFileName).indexOf("_")+1, FilenameUtils.getExtension(listFileName).lastIndexOf("_")).toString()),
        									  (FilenameUtils.getExtension(listFileName).substring(FilenameUtils.getExtension(listFileName).lastIndexOf("_")+1).toString()),
        									  (FilenameUtils.getBaseName(listFileName)+"."+FilenameUtils.getExtension(listFileName).subSequence(0,FilenameUtils.getExtension(listFileName).indexOf("_")))});
        }
		xmlMap.clear();bahotHard.clear();;writer.close();csvWriter.close();
		System.out.println("Execution Time : "+(System.currentTimeMillis()-start)*0.001 + " Seconds");
	}
	
	
	private static ArrayList<String> mainLogic(Map<String, String> xmlMap, ArrayList<String> zip_pgpFileList, Map<String, String> bahotHard) {
		long start = System.currentTimeMillis();
		ArrayList<String> failedFileNames = new ArrayList<String>();
		for(String listFileName:zip_pgpFileList) {
			if(bahotHard.containsKey(FilenameUtils.getBaseName(listFileName).subSequence(0,FilenameUtils.getBaseName(listFileName).lastIndexOf(".")))) {
				if(!bahotHard.containsValue(getDate(listFileName)[0])){
					failedFileNames.add(xmlMap.get(FilenameUtils.getBaseName(listFileName).subSequence(0,FilenameUtils.getBaseName(listFileName).lastIndexOf("."))));
				}
			}
		}	
		xmlMap.clear();zip_pgpFileList.clear();bahotHard.clear();
		System.out.println("Compare Time : "+ (System.currentTimeMillis()-start)*0.001 + " Seconds");
		return failedFileNames;
	}

	private static String[] getDate(String desc) {
		  int count=0;
		  String[] allMatches = new String[2];
//		  Matcher m = Pattern.compile("(\\d{4}([\\-/])\\d{2}([\\-/])\\d{2})").matcher(desc);
		  Matcher m = Pattern.compile("(\\d{1,4}([.\\-/])\\d{1,2}([.\\-/])\\d{1,4}([.\\-/])\\d{1,2})").matcher(desc);
		  while (m.find()) {
		    allMatches[count] = m.group();
		    count++;
		  }
		  return allMatches;
		}

	private static int getHeaderLocation(String[] headers, String columnName) {
		   return Arrays.asList(headers).indexOf(columnName);
		}
}