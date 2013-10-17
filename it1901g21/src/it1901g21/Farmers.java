package it1901g21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Farmers extends SQL{
	
	private PreparedStatement preparedStatement = null;
	private Connection connect = null;
	
	/**
	 * Register user with relevant information as input.
	 */
	public void register(String mail, String navn, String pass, String tlf, String resmail, String restlf){
		try{
			connect = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/kennew_IT1901G21", "kennew_IT1901", "imsdal");
			
			preparedStatement = connect.prepareStatement("INSERT INTO Farmers (Mail, Name, Password, Phone, ReserveMail, ReservePhone) VALUES(?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, mail);
			preparedStatement.setString(2, navn);
			preparedStatement.setString(3, pass);
			preparedStatement.setString(4, tlf);
			preparedStatement.setString(5, resmail);
			preparedStatement.setString(6, restlf);
			preparedStatement.executeUpdate();
		}catch (SQLException ex){
			Logger lgr = Logger.getLogger(Farmers.class.getName());
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
				Logger lgr = Logger.getLogger(Farmers.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
		
	}
	
	
}