package database;

import it1901g21.Farmer;
import it1901g21.Sheep;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.SQL;


/**
 * Class specifically designed for communicating with the farmers mySQl-database
 */
public class Farmers extends SQL {
	
	/**
	 * Register farmer to the database.
	 */
	public void register(Farmer farmer, String passwordHash, String salt){
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO Farmers (Mail, Name, Phone, ReserveMail, ReservePhone, PasswordHash, Salt) VALUES(?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, farmer.getMail());
			preparedStatement.setString(2, farmer.getName());
			preparedStatement.setString(3, farmer.getTlf());
			preparedStatement.setString(4, farmer.getResMail());
			preparedStatement.setString(5, farmer.getResTlf());
			preparedStatement.setString(6, passwordHash);
			preparedStatement.setString(7, salt);
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
	public void deleteFarmer(Farmer farmer) {
		
		try {
			preparedStatement = connect.prepareStatement("DELETE FROM Farmers WHERE Mail = ?");
			preparedStatement.setString(1, farmer.getMail());
			preparedStatement.executeUpdate();
		} 
		catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Farmers.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
	
	/**
	 * Add sheep to database.
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
	public void deleteSheep(Sheep sheep){
		
		try {
			preparedStatement = connect.prepareStatement("DELETE FROM Sheep WHERE Id = ?");
			preparedStatement.setInt(1, sheep.getId());
			preparedStatement.executeUpdate();
			
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Farmers.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
	
	/**
	 * Loads the farmer from the database 
	 * @param passwordHash the farmers hashed password
	 * @return the farmer 
	 */
	public Farmer getFarmer(String passwordHash) {
		
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM Farmers WHERE PasswordHash = ?");
			preparedStatement.setString(1, passwordHash);
			resultSet = preparedStatement.executeQuery();
			
			if (!resultSet.next()) {
				System.out.println("No farmer found!");
				return null;
			}
			
			Farmer farmer = new Farmer();
			
			farmer.setMail(resultSet.getString("Mail"));
			farmer.setName(resultSet.getString("Name"));
			farmer.setPasswordHash(resultSet.getString("PasswordHash"));
			farmer.setSalt(resultSet.getString("Salt"));
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
	/**
	 * Takes email as arguemnt
	 * Checks whether the user (email) exists in the database
	 */
		public boolean userExists(String inputUser) {
		try {
			preparedStatement = connect.prepareStatement("SELECT Mail FROM Farmers WHERE Mail ='" + inputUser + "'");
			
			// når argument endres til String og "Id" til "Name", kjøres ikke de 4 neste linjene:
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("Brukeren " + inputUser + " finnes i databasen.");
				return true;
			}
			
		} catch (Exception e) {
			return false;
		}
		return false;
	}
		
	/**
	 * Takes email as argument, and fetches password from database
	 * @return the password
	 */
	public String getPassword(String inputUsername) {
		String password = null;
		
		try {
			preparedStatement = connect.prepareStatement("SELECT Password FROM Farmers WHERE Mail = "+ inputUsername + "");
			resultSet = preparedStatement.executeQuery();
			password = resultSet.getString("Password");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}
	
	/**
	 * Takes email and password as argument
	 * Checks wheter the given email/password matches the email/password in the database
	 */
/*	public boolean checkLogin(String username, String password) {
		if (userExists(username) && getPassword(username) == password) {
			return true;
		} else {
			return false;
		}
	}*/

	/**
	 * Loads all sheep of a given farmer into a ArrayList
	 * @return the list of all sheep
	 */
	public ArrayList<Sheep> farmersSheep(String farmerId) {

		ArrayList<Sheep> sheeplist = new ArrayList<Sheep>();

		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM Sheep WHERE FarmerId = "+ farmerId + "");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Sheep sheep = new Sheep();
				
				sheep.setEarTag(resultSet.getString("EarTag"));
				sheep.setBirthMonth(resultSet.getInt("BirthMonth"));
				sheep.setWeight(resultSet.getInt("Weight"));
				sheep.setHealth(resultSet.getString("Health"));
				sheep.setXPos(resultSet.getString("Xpos"));
				sheep.setYPos(resultSet.getString("Ypos"));
				
				sheeplist.add(sheep);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sheeplist;
	}
	
}
