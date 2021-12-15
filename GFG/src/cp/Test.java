package com.highradius.cp;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.util.Base64Converter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;
public class Test {
    public static void main(String[] args) {
        try {
        	String repos = "";
        	String search = "dataSourceKeySmirnOff";
        	System.out.println(search.lastIndexOf("dataSourceKey"));
        	System.out.println(search.lastIndexOf("dataSourceKey",0));
//        	System.out.println(search.subSequence("dataSourceKey".length(),search.length()));
        	String filePath = "";
        	boolean ignoreCase = false;
//            String ip = "74.125.45.100";
//            String key = "9d64fcfdfacc213csfsfc7ddsf4ef911dfe97b55e4fdsf696be3532bf8302876c09ebad06b";
//            String url = "http://api.ipinfodb.com/v3/ip-city/?key=" + key + "&ip=" + ip + "&format=json";
        	String credentials = "debasish.mahana" + ":" + "Apr@2021";
        	String url ="https://hoogle.highradius.com";
        	String encoding = Base64Converter(credentials.getBytes("UTF-8"));
//        	URLConnection uc = url.openConnection();
        	/*String url ="https://hoogle.highradius.com/api/v1/search?stats=fosho&repos="+((repos != "" || repos != null) ? repos :"")+"&rng=%3A20&q="+search+"&files="
					+((filePath!= "" || filePath != null) ? filePath :"")+"&i="+((ignoreCase != true) ?"nope":"fosho");*/
        	URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Authorization", String.format("Basic %s", encoding));
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            JSONObject myResponse = new JSONObject(response.toString());
            System.out.println(myResponse.toString());
    		
        } catch (Exception e) {
           System.err.println("Error Occured in main : "+e);
        }
    }

	private static String Base64Converter(byte[] bytes) {
		// TODO Auto-generated method stub
		return null;
	}
}