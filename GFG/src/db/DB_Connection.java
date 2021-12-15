package com.highradius.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.highradius.utils.StringUtils;
public class DB_Connection {
	String schema;
	public Connection getConnection() throws ClassNotFoundException{
		Connection connection=null;
		try {
			System.out.println("Establishing Database Connection...");
			if(StringUtils.isNotBlank(schema)) {
				connection = DriverManager.getConnection("jdbc:mysql://172.27.128.54:3306/"+schema,"devuser", "devuser123");
			}else {
				connection = DriverManager.getConnection("jdbc:mysql://172.27.128.54:3306/smirnoff","devuser", "devuser123");
			}
		} catch (SQLException e) {
			System.err.println("Connection Error : "+e);
		}
		System.out.println("Database Connection Established... Successfully...");
		return connection;
	}
}