package com.management;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionManager {

	private static Connection con;
	private static Properties property = new Properties();
	public static Connection getConnection() {
	
	try {
		FileInputStream fis = new FileInputStream("db.properties");
		property.load(fis);
		String drivername = property.getProperty("drivername");
		
		Class.forName(drivername);
		
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		con = DriverManager.getConnection(url,username,password);
//		System.out.println("Database Connected.");
	}
	catch(ClassNotFoundException | SQLException | IOException e) {
		System.out.println("Database Not Connected. Connect with DataBase");
	}
	return con;
	}
}
