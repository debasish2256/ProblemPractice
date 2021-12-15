package com.highradius.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
public class insert_CSV {
	
	public static void insert_data(String location) throws ClassNotFoundException {
		String schema="smirnoff";
		String selectQuery="SELECT * FROM test_deba";
		String sql = "INSERT IGNORE INTO test_deba(id, file_name) VALUES (?, ?)";

		Map<Integer,ArrayList<ResultSet>> map=new HashMap<Integer, ArrayList<ResultSet>>();
		ArrayList<test_data> students=readCSV(location);
		DB_Connection obj_DB_Connection=new DB_Connection();
		obj_DB_Connection.schema=schema;
		PreparedStatement statement = null;
		Connection con = obj_DB_Connection.getConnection();

		try {
			statement = con.prepareStatement(sql);
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery(selectQuery);
			ArrayList<ResultSet> resdata=new ArrayList<ResultSet>();
			while(res.next()) {
				map.put(res.getInt("Id"), resdata);
			}
			for (test_data record : students) {

				if(!map.containsKey(record.getId())) {
					statement.setInt(1, record.getId());
					statement.setString(2, record.getFile_name());
					statement.addBatch();
				}
			}
			System.out.println(students.size()+" Data Insertion Success......");
			statement.executeBatch();
			con.commit();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<test_data> readCSV(String csvFilePath) {
		ArrayList<test_data> result=new ArrayList<test_data>();
		try {
			BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
			CSVParser records = CSVParser.parse(lineReader, CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			for (CSVRecord record : records) {
				test_data data = new test_data();
				data.setId(Integer.parseInt(record.get(0)));
				data.setFile_name(record.get(1));
				result.add(data);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
