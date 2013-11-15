package database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import GUI.ErrorMessage;


/**
 * General class for communicating with a mySQl database
 */
public class SQL {
	
	protected Connection connect;
	protected Statement statement;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;
	
	protected Properties properties;
    protected FileInputStream in;
	
	protected String url;
	protected String user;
	protected String password;
	
	public SQL() {
		
		connect = null;
		statement = null;
		preparedStatement = null;
		resultSet = null;
		properties = new Properties();
		
		try {
			in = new FileInputStream("database.properties");
			properties.load(in);
			
			url = properties.getProperty("db.url");
			user = properties.getProperty("db.user");
			password = properties.getProperty("db.password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Connects to the SQL database
	 * @return returns true if connection is successful
	 */
	public boolean connect() {
		
		/* Checks for valid database properties */
		Boolean missing = false;
		if (url == null) {
			System.out.println("URL to database missing!");
			missing = true;
		}
		if (user == null) {
			System.out.println("Database user missing!");
			missing = true;
		}
		if (password == null) {
			System.out.println("Database password missing!");
			missing = true;
		}
		if (missing) {
			return false;
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, password);
			System.out.println("Connection to database has been established.");
		}
		catch (SQLException e) {
			System.out.println("Cannot connect to the database! Check your connection!");
			ErrorMessage error = new ErrorMessage("Connection timed out", "Cannot connect to database! Check your connection!");
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Closes connection to the database
	 */
	private void disconnect() {
		try {
			if (resultSet != null)
				resultSet.close();

			if (statement != null)
				statement.close();
			
			if (preparedStatement != null)
				preparedStatement.close();

			if (connect != null)
				connect.close();
			
		}catch (Exception e){
			System.out.println("Error encountered!");
			e.printStackTrace();
		}
	}
}	
