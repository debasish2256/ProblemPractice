package com.highradius.cp;
/*
 * @author debasish.mahana
 */

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONObject; 
public class CoWinVaccineChecker {
	static String date =null;
	static String pincode="723121";
	static int age=48;
	public static void main(String[] args) throws Exception{
		try {
			CoWinVaccineChecker.call_me(pincode,date,age);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void call_me(String pincode,String date,int age) throws Exception {
		DateTimeFormatter today = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode="+pincode+"&date="+((date!= null) ? today.format(today.parse(date)):today.format(now));
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		DateTimeFormatter fileDate = DateTimeFormatter.ofPattern("dd-MM_hh-mm");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		FileWriter csvWriter = new FileWriter("C:\\Users\\debasish.mahana\\Desktop\\AnalysisJob\\CoWin_"+fileDate.format(now)+".csv");
		String[] header = { "Available On","Pincode", "Vaccine Type", "Available","Center Name","Fees"};
		for (int i = 0; i < header.length; i++) {
			csvWriter.append(header[i] + ",");
		}
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}

		in.close();

		JSONObject myResponse = new JSONObject(response.toString());

		//		System.out.println(myResponse.toString());

		JSONArray recs = myResponse.getJSONArray("centers");
		int count = 1;
		for (int i = 0; i < recs.length(); ++i) {
			JSONObject rec = recs.getJSONObject(i);
			JSONArray sess = rec.getJSONArray("sessions");
			for (int j = 0; j < sess.length(); ++j) {
				JSONObject ses = sess.getJSONObject(j);
				if(ses.getInt("available_capacity") >= 1 && ses.getInt("min_age_limit") <= age) {
					System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<For Age : "+age+"  |\tCenter Id : "+rec.getInt("center_id")+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					System.out.println("\t\t\t\t\t\tAvailable On : " + ses.getString("date") 
					+ "\n\t\t\t\t\t\tPincode : " + rec.getInt("pincode")
					+ "\n\t\t\t\t\t\tVaccine Type : " + ses.getString("vaccine") 
					+ "\n\t\t\t\t\t\tAvailable : " + ses.getInt("available_capacity") 
					+ "\n\t\t\t\t\t\tCenter Name : " + rec.getString("address") 
					+ "\n\t\t\t\t\t\tFees : " + rec.getString("fee_type") 
					+ "\n\t\t\t\t\t\tDistrict : " + rec.getString("district_name")
					+ "\n\t\t\t\t\t\tBlock Name : " + rec.getString("block_name") 
					+ "\n\t\t\t\t\t\tFrom : " + Integer.parseInt(rec.getString("from").substring(0, 2)) + " AM" + " To " + (Integer) (Integer.parseInt(rec.getString("to").substring(0, 2)) - 12) + " PM");
					try {
						csvWriter.append("\n"+ses.getString("date")+","+rec.getInt("pincode")+","+ses.getString("vaccine")+","+ses.getInt("available_capacity")+","+rec.getString("address")+","+rec.getString("fee_type"));
					} catch (Exception e) {
						System.err.print(e);
					}
					count++;
				}
			}
		}
		if(count==1)
			System.out.println("Not Yet Opened or Vaccine Un-Available In "+pincode+" For "+age+"+ Candidates..... Search Later...");
		csvWriter.flush();csvWriter.close();
	}
}