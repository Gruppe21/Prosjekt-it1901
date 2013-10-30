package it1901g21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Farmers extends SQL {
	
	public Farmers() {
		super();
	}
	
	/**
	 * Register user with relevant information as input.
	 */
	public void register(String mail, String navn, String pass, String tlf, String resmail, String restlf){
		
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO Farmers (Mail, Name, Password, Phone, ReserveMail, ReservePhone) VALUES(?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, mail);
			preparedStatement.setString(2, navn);
			preparedStatement.setString(3, pass);
			preparedStatement.setString(4, tlf);
			preparedStatement.setString(5, resmail);
			preparedStatement.setString(6, restlf);
			preparedStatement.executeUpdate();
		} catch (SQLException ex){
			Logger lgr = Logger.getLogger(Farmers.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			
			try {
				if (preparedStatement != null){
					preparedStatement.close();
				}
				if (connect != null){
					connect.close();
				}
			} catch (SQLException ex){
				Logger lgr = Logger.getLogger(Farmers.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}	
	}
	
	/**
	 * Removes farmer from database,
	 * currently deleting all instances if more instances of the same farmer is present.
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
		} finally {
			
			try {
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if (connect != null){
					connect.close();
				}
			} catch (SQLException ex){
				Logger lgr = Logger.getLogger(Farmers.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}	
	}
	
	/**
	 * Add sheep to chosen farmer's herd.
	 */
	public void addSheep(int FarmerId, int Id, String Eartag, int BirthMonth, int Weight, String Health, double xPos, double yPos){
		
		try {	
			preparedStatement = connect.prepareStatement("INSERT INTO Sheep (FarmerId, Id, Eartag, BirthMonth, Weight, Health, Xpos, Ypos) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, FarmerId);
			preparedStatement.setInt(2, Id);
			preparedStatement.setString(3, Eartag);
			preparedStatement.setInt(4, BirthMonth);
			preparedStatement.setInt(5, Weight);
			preparedStatement.setString(6, Health);
			preparedStatement.setDouble(7, xPos);
			preparedStatement.setDouble(8, yPos);
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Farmers.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			
			try {
				if (preparedStatement != null){
					preparedStatement.close();
				}
				if (connect != null){
					connect.close();
				}
			} catch (SQLException ex){
				Logger lgr = Logger.getLogger(Farmers.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
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
		} finally {
			
			try {
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if (connect != null){
					connect.close();
				}
			} catch (SQLException ex){
				Logger lgr = Logger.getLogger(Farmers.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
		
	}
	
}