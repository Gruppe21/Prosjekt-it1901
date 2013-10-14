package it1901g21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prepared extends SQL{
	
	private PreparedStatement preparedStatement = null;
	private Connection connect = null;
	
	public void register(String mail, String navn, String pass, int tlf, String resmail, int restlf){
		try{
			preparedStatement = connect.prepareStatement("INSERT INTO bonde (epost, navn, passord, telefon, reserve_epost, reserve_telefon) VALUES(mail, navn, pass, tlf, resmail, restlf)");
			preparedStatement.executeUpdate();
		}catch (SQLException ex){
			Logger lgr = Logger.getLogger(Prepared.class.getName());
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
				Logger lgr = Logger.getLogger(Prepared.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
		
	}
	
	
	
}