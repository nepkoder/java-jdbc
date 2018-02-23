package com.databaseconnectionsetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubmittingQuery {

	public static void main(String[] args) throws SQLException {

		Connection con = null;

		final String myUrl = "jdbc:mysql://localhost:3306/example";
		String user = "root";
		String pass = "sujan";

		try {
			// adding mysql driver for connection
			Class.forName("com.mysql.jdbc.Driver");
			// setting up connection for database
			con = DriverManager.getConnection(myUrl, user, pass);
			System.out.println("connection successful");
			// create statement
			Statement stm = con.createStatement();
			// execute statement query
			String myQquery = "SELECT *From employee";
			ResultSet rs = stm.executeQuery(myQquery);

			// display result on console
			// getting employee details - id,firstName,lastName,email,salary,department
			System.out.println("Employee Details: ");
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + "\t Full Name: " + rs.getString("firstName") + " "
						+ rs.getString("lastName") + "\nEmail: " + rs.getString("email") + "\nSalary: "
						+ rs.getInt("salary") + "\nPosition: " + rs.getString("department"));
				System.out.println("------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database connection failed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Database driver not found");
		}

		finally {
			if (con != null) {
				con.close();
			}
		}

	}
}
