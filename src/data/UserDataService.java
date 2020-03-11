package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Database;
import beans.User;

public class UserDataService {
	
	private Database connection = null;

	//Makes the database constructor
	public UserDataService(Database connection) {
		this.connection = connection;
	}

	/**
	 * Makes a create user class that will add a user to the database
	 * @param user
	 * @return
	 */
	public boolean createUser(User user) 
	{
		Connection conn = null;
		//tries connecting to the database and entering the users data into a database table, 
		//but prints an error message if it fails to connect or insert the data.
		try {
			//get database connection
			conn = DriverManager.getConnection(connection.getUrl(), connection.getUser(), connection.getPass());
			String sql = "INSERT INTO milestone.tbl_users(firstname, lastname, phonenumber, username, password, email) VALUES (?, ?, ?, ?, ?, ?)";

			//prepare sql statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getPhoneNumber());
			stmt.setString(4, user.getUsername());
			stmt.setString(5, user.getPassword());
			stmt.setString(6, user.getEmail());
			
			if(stmt.executeUpdate() > 0)
			{
				return true;
			}
			else
			{
				return false;
			}

		} 
		//Prints an error message if fails to connect or enter data.
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean findUser(User user) 
	{
		Connection conn = null;
		//tries connecting to the database and entering the users data into a database table, 
		//but prints an error message if it fails to connect or insert the data.
		try {
			//get database connection
			conn = DriverManager.getConnection(connection.getUrl(), connection.getUser(), connection.getPass());
			String sql = "SELECT * FROM milestone.tbl_users WHERE username = ? AND password = ?";

			//prepare sql statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			
			ResultSet rs = stmt.executeQuery();
			
			if(!rs.isBeforeFirst())
			{
				return false;
			}
			else
			{
				return true;
			}
		} 
		//Prints an error message if fails to connect or enter data.
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
}
