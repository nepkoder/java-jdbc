package com.databaseconfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFromFile {

	public static void main(String[] args) throws SQLException {

		// reading database connection from properties file
		// first creating properties file (connection.properties)
		
		Connection connection = null;

		try {
			// loading properties file
			Properties properties = new Properties();

			properties.load(new FileInputStream("connection.properties"));

			// reading properties content
			String thisURL = properties.getProperty("databaseURL");
			String thisUser = properties.getProperty("user");
			String thisPass = properties.getProperty("pass");

			// now, create connection for database
			connection = DriverManager.getConnection(thisURL, thisUser, thisPass);

			System.out.println("Database connection successful");
			System.out.println("-------------------------------");
			// System.out.println("reading database connection from a properties file");

		} catch (IOException e) {
			System.out.println("OOps! Database Configuration file load problem");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database connection error");
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

}
