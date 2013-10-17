package it1901g21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sheep extends SQL{
	
	private PreparedStatement preparedStatement = null;
	private Connection connect = null;
	
	/**
	 * Register user with relevant information as input.
	 */
	public void addSheep(int FarmerId, int BirthMonth, int Weight, double xPos, double yPos, String Health){
		try{
			connect = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/kennew_IT1901G21", "kennew_IT1901", "imsdal");
			
			preparedStatement = connect.prepareStatement("INSERT INTO Sheep (FarmerId, BirthMonth, Weight, xPos, yPos, Health) VALUES(?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, FarmerId);
			preparedStatement.setInt(2, BirthMonth);
			preparedStatement.setInt(3, Weight);
			preparedStatement.setDouble(4, xPos);
			preparedStatement.setDouble(5, yPos);
			preparedStatement.setString(6, Health);
			preparedStatement.executeUpdate();
		}catch (SQLException ex){
			Logger lgr = Logger.getLogger(Sheep.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}finally{
			
			try{
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if (connect != null){
					connect.close();
				}
			}catch(SQLException ex){
				Logger lgr = Logger.getLogger(Sheep.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
		
	}
	
	
}