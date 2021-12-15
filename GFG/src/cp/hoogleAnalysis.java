package com.highradius.cp;
/*
 * @author debasish.mahana
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class hoogleAnalysis {
	static String repos = "";
	static String search = "DMSResources.getProperty";
	static String filePath = "";
	static boolean ignoreCase = false;

	public static void main(String[] args) throws Exception {
		try {
			hoogleAnalysis.call_me(repos, search, ignoreCase, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void call_me(String repos, String search, boolean ignoreCase, String filePath) throws Exception {
		//DateTimeFormatter today = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		/*String url ="https://hoogle.highradius.com/api/v1/search?stats=fosho&repos="+((repos != "" || repos != null) ? repos :"")+"&rng=%3A20&q="+search+"&files="
						+((filePath!= "" || filePath != null) ? filePath :"")+"&i="+((ignoreCase != true) ?"nope":"fosho");*/
		/*String url="https://next.json-generator.com/api/json/get/NyJWVteKc";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0")*/;
        
		DateTimeFormatter fileDate = DateTimeFormatter.ofPattern("dd-MM_hh-mm");
		FileWriter csvWriter = new FileWriter("C:\\Users\\debasish.mahana\\Desktop\\AnalysisJob\\Analysis_" + fileDate.format(now) + ".csv");
		String[] header = { "Project Name","Class Name Uniquely Matched" ,"Class Name", "Line Number", "Line Contains"};
		for (int i = 0; i < header.length; i++) {
			csvWriter.append(header[i] + ",");
		}
		
		/*String inputLine;
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
        } in .close();*/
        
		/*Fetch Json Locally */
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\debasish.mahana\\Desktop\\AnalysisJob\\sys.json"));
		JSONObject myResponse = new JSONObject(obj.toString());
		
        int count = 1;

//		JSONObject myResponse = new JSONObject(response.toString());
		JSONObject recs = myResponse.getJSONObject(("Results").toString());
		Iterator x = recs.keys();
		
		while (x.hasNext()) {
			for (int k = 0; k < recs.length(); k++) {
				String key =((repos.length()>0) ? repos : (String) x.next());
				System.out.println("#####################################################################################################################################################################");
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Project : "+key+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("#####################################################################################################################################################################");
				JSONObject ses = recs.getJSONObject(key);
				JSONArray match = ses.getJSONArray("Matches");
				for (int i = 0; i < match.length(); ++i) {					JSONObject rec = match.getJSONObject(i);					JSONArray sess = rec.getJSONArray("Matches");
					System.out.println("----------------------------------------------------------------------------------------------");					System.out.println("| Class Name :  " +rec.getString("Filename")+" |\n----------------------------------------------------------------------------------------------");
					System.out.println("| Total Matches :  " +sess.length()+" |\n---------------------");					for (int j = 0; j < sess.length(); ++j) {						JSONObject sesm = sess.getJSONObject(j);						System.out.println("Line Number :  " +sesm.getInt("LineNumber"));						System.out.println("Line Contains :  " +sesm.getString("Line").trim());
						try {
							csvWriter.append("\n"+key+","+match.length()+","+rec.getString("Filename")+","+sesm.getInt("LineNumber")+","+sesm.getString("Line").trim());
						} catch (Exception e) {
							System.err.print(e);
						}
						count++;
					}									}
				if (count == 1) {
					System.out.println("No File Found in "+key+" Projects..... Search Later...");
					}
				if((repos.length()>0))
					break;
			}
			System.out.println("Total File Written : "+count);
			if((repos.length()>0))
				break;
		}
		csvWriter.flush();
		csvWriter.close();
	}
}
