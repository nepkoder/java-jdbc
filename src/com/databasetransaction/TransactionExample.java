package com.databasetransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DatabaseOperations.ConnectionAndDisplay;

public class TransactionExample {

	// i use mysql connector for java
	// i have already employee table in database
	// transaction means unit of work
	// handle multiple database statement in one method or process in java
	// execute one or more statement together (commited or rollback)

	// by default, database connection is auto-commit system

	public static void main(String[] args) throws SQLException {

		Connection con = null;
		Statement statement = null;

		try {
			// Class.forName("com.mysql.jdbc.Driver")
			// getting db connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "sujan");

			// developer needs explicitly turn off auto-commit
			// using setAutoCommit() method
			con.setAutoCommit(false);
			
//			before transaction steps
			ConnectionAndDisplay.DisplayResult();
			System.out.println("****************************");

			// using transaction first (delete all employee where lastName is khadka)
			statement = con.createStatement();
			statement.executeUpdate("delete from employee where lastName = 'khadka' ");

			// transaction second that
			// set salary to 99999 for all employees/user
			statement.executeUpdate("update employee set salary = 99999");

			System.out.println("Ready for Transactions !!");
			System.out.println("Delete and set values");
			
//			userInput();
			
			if (userInput()) {
				con.commit();
				System.out.println("Transaction Commited");
			} else {
				con.rollback();
				System.out.println("Transaction rolled back");
			}
			
			System.out.println("After Tranaction proceed");
			System.out.println("****************************");
			ConnectionAndDisplay.DisplayResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}

	}
	// this is just helper method to confirm the transactions
	public static boolean userInput() {
		boolean status = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ready to save transaction");
		String input = scanner.nextLine();
		if(input.equals("yes")) {
			return true;
		}
		return status; // return false by default
	}

}
