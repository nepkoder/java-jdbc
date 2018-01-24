package DatabaseOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.databaseconnectionsetup.SubmittingQuery;

public class DeleteData {

	public static void main(String[] args) throws SQLException {
	
		Connection con = ConnectionAndDisplay.SetupConnection();
//		Connection con = null;
		
//		String url = "jdbc:mysql://localhost:3306/example";
//		String user = "root";
//		String pass = "sujan";

		try {

//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection(url, user, pass);

			Statement statement = con.createStatement();
			
			String mysql = "DELETE from employee where firstName='sita' ";
			
			int rowAffected = statement.executeUpdate(mysql);
			
//			ResultSet resultSet = statement.executeQuery(mysql);
			
			System.out.println("after deleting data:");
			ConnectionAndDisplay.DisplayResult();
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				con.close();
			}
		}
	}

}
