package dev.greene.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	

	public static Connection createConnection() {
		
		
		try {
		//	Properties props = new Properties();
		//	File file = new File("C:/Users/oskar/Desktop/1909java/AMWatch/src/main/resources/connection.properties");
		//	FileInputStream in = new FileInputStream(file.getAbsolutePath());
		//	props.load(in);
			try {
				Class.forName("org.mariadb.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			//String conInfo = props.getProperty("conn");

			Connection conn = DriverManager.getConnection("jdbc:mariadb://gnb.cr2qttzvwrif.us-east-1.rds.amazonaws.com:3306/Ankh-MorporkWatch?user=admin&password=password");
			
			
			return conn;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
