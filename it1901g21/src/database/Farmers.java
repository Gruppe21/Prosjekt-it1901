package database;

import it1901g21.Farmer;
import it1901g21.Sheep;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.SQL;


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
			preparedStatement.setString(3, "placeholder");
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
	 * Loads the farmer from the database 
	 * @return the farmer 
	 */
	public Farmer getFarmer() {
		
		try {
			// Fix the user / password stuff
			preparedStatement = connect.prepareStatement("SELECT * FROM Farmers WHERE username ");
			resultSet = preparedStatement.executeQuery();
			
			Farmer farmer = new Farmer();
			
			farmer.setMail(resultSet.getString("Mail"));
			farmer.setName(resultSet.getString("Name"));
			farmer.setTlf(resultSet.getString("Tlf"));
			farmer.setResMail(resultSet.getString("ResMail"));
			farmer.setResTlf(resultSet.getString("ResTlf"));
			
			return farmer;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}