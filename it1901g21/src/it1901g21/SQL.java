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
	
	private Connection connect;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public SQL() {
		
		connect = null;
		statement = null;
		preparedStatement = null;
		resultSet = null;
		
	}
	
	public void readDataBase() throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/kennew_IT1901G21", "kennew_IT1901", "imsdal");
			statement = connect.createStatement();
			//resultSet = statement.executeQuery("select * from BONDE.EMAIL");
			//writeResultSet(resultSet);
			//Mangler kode
			
			
			
			
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
