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
	public void register(Farmer farmer){
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO Farmers (Mail, Name, Phone, ReserveMail, ReservePhone, PasswordHash, Salt) VALUES(?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, farmer.getMail());
			preparedStatement.setString(2, farmer.getName());
			preparedStatement.setString(3, farmer.getTlf());
			preparedStatement.setString(4, farmer.getResMail());
			preparedStatement.setString(5, farmer.getResTlf());
			preparedStatement.setString(6, farmer.getPasswordHash());
			preparedStatement.setString(7, farmer.getSalt());
			preparedStatement.executeUpdate();
			
			//statement.executeQuery("INSERT INTO Farmers (Mail, Name, Phone, ReserveMail, ReservePhone, PasswordHash, Salt) VALUES(" + farmer.getMail() + "," + farmer.getName() + "," + farmer.getTlf() + "," + farmer.getResMail() + "," + farmer.getResTlf() + "," + farmer.getPasswordHash() + "," + farmer.getSalt() + ")");
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
	 * @param mail the farmer's mail
	 * @return the farmer 
	 */
	public Farmer getFarmer(String mail) {
		
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM Farmers WHERE Mail = ?");
			preparedStatement.setString(1, mail);
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
			farmer.setTlf(resultSet.getString("Phone"));
			farmer.setResMail(resultSet.getString("ReserveMail"));
			farmer.setResTlf(resultSet.getString("ReservePhone"));
			
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
			
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
			
		} catch (Exception e) {
			return false;
		}
		return false;
	}
		
	public String getHash(String inputUsername) {
		String pwhash = null;
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM Farmers WHERE Mail = '"+ inputUsername + "'");
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()){
				pwhash = resultSet.getString("PasswordHash");
			}
			
		} catch (Exception e) {
			System.out.println("Exception getHash");
		}
		return pwhash;
	}
	
	public String getSalt(String inputUsername) {
		String pwsalt = null;
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM Farmers WHERE Mail = '"+ inputUsername + "'");
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()){
				pwsalt = resultSet.getString("Salt");
			}
			
		} catch (Exception e) {
			System.out.println("Exception getSalt");
		}
		return pwsalt;
	}
	
	/**
	 * Takes email and password as argument
	 * Checks wheter the given email/password matches the email/password in the database
	 */
	public boolean checkLogin(String username, String password) {
		PasswordHash ph = new PasswordHash();
		
		if (userExists(username) && ph.isValidated(password, getHash(username), getSalt(username))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Loads all sheep of a given farmer into a ArrayList
	 * @return the list of all sheep
	 */
	public ArrayList<Sheep> farmersSheep(int farmerId) {

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
