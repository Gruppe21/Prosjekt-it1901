package it1901g21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class specifically designed for communicating with the farmers mySQl database
 */
public class Farmers extends SQL {
	
	/**
	 * Register user with relevant information as input.
	 */
	public void register(Farmer farmer){
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO Farmers (Mail, Name, Password, Phone, ReserveMail, ReservePhone) VALUES(?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, farmer.getMail());
			preparedStatement.setString(2, farmer.getName());
			preparedStatement.setString(3, farmer.getPassword());
			preparedStatement.setString(4, farmer.getTlf());
			preparedStatement.setString(5, farmer.getResMail());
			preparedStatement.setString(6, farmer.getResTlf());
			preparedStatement.executeUpdate();
		} 
		catch (SQLException ex){
			Logger lgr = Logger.getLogger(Farmers.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
	
	/**
	 * Removes farmer from database,
	 * currently deleting all farmers if more farmer of the same name is present.
	 */
	public void deleteFarmer(String name) {
		
		try {
			preparedStatement = connect.prepareStatement("DELETE FROM Farmers WHERE Name = ?");
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Farmers.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
	
	/**
	 * Add sheep to chosen farmer's herd.
	 */
	public void addSheep(Sheep sheep){		
		try {	
			preparedStatement = connect.prepareStatement("INSERT INTO Sheep (FarmerId, Id, Eartag, BirthMonth, Weight, Health, Xpos, Ypos) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, sheep.getFarmerId());
			preparedStatement.setInt(2, sheep.getId());
			preparedStatement.setString(3, sheep.getEarTag());
			preparedStatement.setInt(4, sheep.getBirthMonth());
			preparedStatement.setInt(5, sheep.getWeigth());
			preparedStatement.setString(6, sheep.getHealth());
			preparedStatement.setString(7, sheep.getXPos());
			preparedStatement.setString(8, sheep.getYPos());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Farmers.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
	
	/**
	 * Removes sheep from chosen farmer's herd.
	 */
	public void deleteSheep(int Id){
		
		try {
			preparedStatement = connect.prepareStatement("DELETE FROM Sheep WHERE Id = ?");
			preparedStatement.setInt(1, Id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Farmers.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
	
	/**
	 * Loads all the farmers from the database
	 */
	public ArrayList<Farmer> getFarmers() {
		
		ArrayList<Farmer> farmers = new ArrayList<Farmer>();
		
		try {
			
			preparedStatement = connect.prepareStatement("SELECT * FROM Farmers");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Farmer farmer = new Farmer();
				
				farmer.setMail(resultSet.getString(1));
				farmer.setName(resultSet.getString(2));
				farmer.setPassword(resultSet.getString(3));
				farmer.setTlf(resultSet.getString(4));
				farmer.setResMail(resultSet.getString(5));
				farmer.setResTlf(resultSet.getString(6));
				
				farmers.add(farmer);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return farmers;
		
	}
	
}