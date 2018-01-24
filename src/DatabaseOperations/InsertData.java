package DatabaseOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.databaseconnectionsetup.SubmittingQuery;

public class InsertData {

	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionAndDisplay.SetupConnection();

		// String url = "jdbc:mysql://localhost:3306/example";
		// String user = "root";
		// String pass = "sujan";

		try {

			// Class.forName("com.mysql.jdbc.Driver");
			// con = DriverManager.getConnection(url, user, pass);
			// System.out.priantln("Successfully connection");
			Statement statement = con.createStatement();
//			String query = "Select *from employee";

			int newEntryQuery = statement.executeUpdate(
					"Insert into employee(id,firstName,lastName,email,salary,department) values(9,'sita','shrestha','sitanew1234@yahoo.com',444244,'electronics')");
			// occur error due to primary key (id) in employee table
			// don't run twice !!
			// ResultSet resultSet = statement.executeQuery(query);
			System.out.println("after inserting data");

			ConnectionAndDisplay.DisplayResult();
			// while (resultSet.next()) {
			// System.out.println(resultSet.getString("id"));
			// System.out.println(resultSet.getString("firstName") + " " +
			// resultSet.getString("lastName"));
			// }

		} catch (SQLException e) {
			e.printStackTrace();

		}
		
		finally {
			con.close();
		}

	}
}
