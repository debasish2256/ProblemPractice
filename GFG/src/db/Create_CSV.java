package com.highradius.db;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.opencsv.CSVWriter;

public class Create_CSV {
	final static String location="C:\\Users\\debasish.mahana\\Desktop\\DB_Eng\\";
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String schema="smirnoff";
		String query="select * from test_deba";
		String path=location+schema+"_"+query.substring(query.lastIndexOf(" ")+1)+".csv";
//		createCSVfromDB(query,path,schema);
		insert_CSV.insert_data(path);
	}
	
	static void createCSVfromDB(String query,String path,String schema) throws IOException, ClassNotFoundException  {
		CSVWriter writer = new CSVWriter(new FileWriter(path));
		Boolean includeHeaders = true;
		Statement statement = null;
		ResultSet myResultSet = null;
		try {
			long start = System.currentTimeMillis();
			Connection connection = null;
			DB_Connection obj_DB_Connection=new DB_Connection();
			obj_DB_Connection.schema=schema;
			connection = obj_DB_Connection.getConnection();
			System.out.println("Fetching Results...");
			if (connection != null) {
				statement = connection.createStatement();
				myResultSet = statement.executeQuery(query);
				writer.writeAll(myResultSet, includeHeaders);
			}
			System.out.println("Fetched And Saved Succesfully in : "+(System.currentTimeMillis()-start)*0.001 + " Seconds");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		writer.close();
	}
}