package it1901g21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

/**
 * Class for communicating with a mySQl database
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
	 * Logs in to the SQL database
	 */
	public void logIn() {
		
		/* Checks for valid database properties */
		if (url == null) {
			System.out.println("URL to database missing!");
		}
		if (user == null) {
			System.out.println("Database user missing!");
		}
		if (password == null) {
			System.out.println("Database password missing!");
		}
		if (url == null || user == null || password == null) {
			return;
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, password);
			System.out.println("Log in complete");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Logs out of the SQL database
	 * @throws Exception
	 */
	public void logOut() throws Exception {
		
	}
	
	/**
	 * Read from the database
	 * @throws Exception
	 */
	public void readDataBase() throws Exception{
		try {			
			
		} catch (Exception e){
			throw e;
		} finally {
			close();
		}
	}
	
	private void writeMetaData(ResultSet resultSet) throws SQLException{
		//mangler kode
	}
	
	private void writeResultSet(ResultSet resultSet) throws SQLException{
		//mangler kode
	}
	
	private void close() {
		try {
			if (resultSet != null){
				resultSet.close();
			}

			if (statement != null){
				statement.close();
			}

			if (connect != null){
				connect.close();
			}
		}catch (Exception e){
			System.out.println("Error encountered!");
			e.printStackTrace();
		}
	}
}	
