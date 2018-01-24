package DatabaseOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.databaseconnectionsetup.SubmittingQuery;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class UsingPreparedStatement {

	public static void main(String[] args) {

		Connection con = ConnectionAndDisplay.SetupConnection();

		// PreparedStatement preparedStatement = null;
		//
		// final String url = "jdbc:mysql://localhost:3306/example";
		// String user = "root";
		// String pass = "sujan";

		try {

			// Class.forName("com.mysql.jdbc.Driver");
			// con = DriverManager.getConnection(url, user, pass);
			// String myQuery = "Select firstName, lastName from employee where salary > ?";

			PreparedStatement preparedStatement = con
					.prepareStatement("Select firstName, lastName from employee where salary > ?");

			preparedStatement.setInt(1, 30000);

			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println("Salary greater than 30000");
			ConnectionAndDisplay.DisplayResult();
			System.out.println("reuse of statement again");

			preparedStatement.setInt(1, 100000);
			System.out.println("Salary greater than 100000");

			ConnectionAndDisplay.DisplayResult();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
