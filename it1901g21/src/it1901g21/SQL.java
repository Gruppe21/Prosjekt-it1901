package it1901g21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Class for communicating with the mySQl database
 */
public class SQL {
	
	protected Connection connect;
	protected Statement statement;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;
	
	protected String url;
	protected String user;
	protected String password;
	
	public SQL() {
		
		connect = null;
		statement = null;
		preparedStatement = null;
		resultSet = null;
		
	}
	
	/**
	 * Logs in to the SQL database
	 * @param user the username
	 * @param password the password
	 */
	public void logIn(String user, String password) {
		
		this.user = user;
		this.password = password;
		
		/* Checks if url is set */
		if (url == null) {
			System.out.println("URL to database not set yet!");
			return;
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, this.user, this.password);
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
	 * Sets the url to the SQL database
	 * @param url the database to access
	 */
	public void setDatabaseURL(String url) {
		this.url = url;
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
