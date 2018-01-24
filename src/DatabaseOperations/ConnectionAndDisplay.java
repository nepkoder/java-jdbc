package DatabaseOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionAndDisplay {

	public static Connection SetupConnection() {
		Connection con = null;

		String url = "jdbc:mysql://localhost:3306/example";
		String user = "root";
		String pass = "sujan";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pass);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Database connection failed");
		}
		return con;

	}

	public static void DisplayResult() {

		Connection connection = SetupConnection();
		try {

			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select *from employee");
			System.out.println("Employee Details: ");
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + "\t Full Name: " + rs.getString("firstName") + " "
						+ rs.getString("lastName") + "\nEmail: " + rs.getString("email") + "\nSalary: "
						+ rs.getInt("salary") + "\nPosition: " + rs.getString("department"));
				System.out.println("------------------\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
