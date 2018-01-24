package DatabaseOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.databaseconnectionsetup.SubmittingQuery;

public class UpdateData {

	public static void main(String[] args) throws SQLException {

		Connection con = ConnectionAndDisplay.SetupConnection();

		// String url = "jdbc:mysql://localhost:3306/example";
		// String user = "root";
		// String pass = "sujan";

		try {

			// Class.forName("com.mysql.jdbc.Driver");
			// con = DriverManager.getConnection(url, user, pass);

			Statement statement = con.createStatement();

			statement.executeUpdate("update employee set email = 'nepkoder@gmail.com' where firstName = 'sujan' ");

			System.out.println("after updating data");
			ConnectionAndDisplay.DisplayResult();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (con != null) {
				con.close();
			}
		}

	}
}
