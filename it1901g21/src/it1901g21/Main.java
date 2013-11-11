package it1901g21;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import database.Farmers;
import database.PasswordHash;

import GUI.Login;
import GUI.Registration;

/**
 * Main Class.
 * Program entry point. 
 */
public class Main {
	
	private Farmers pst;
	private Pinger pinger;
	private Login login;
	private Registration registration;
	
	private JFrame frame;
	private Date date;
	
	private final String PROJECTPATH;
	private String bondeid;
	
	/* Entry point, only used to initiate Main*/
	public static void main(String[] args) {
		Main main = new Main();		
	}
	
	/**
	 * Standard Main constructor
	 */
	public Main() {
		
		PROJECTPATH = findProjectPath();
		System.out.println(getProjectPath());
		
		pst = new Farmers();
		pinger = new Pinger(this);
		login = new Login(this);
		
		date = new Date();
		frame = new JFrame();
		bondeid = "0001";
		
		databaseTest();
		//hashTest();
	}
	
	/**
	 * For testing the database
	 */
	private void databaseTest() {
		
		try {
		pst.connect();
			
			Farmer farmer = new Farmer("heihei@stud.ntnu.no", "Klara ku", "98636864", "neimen@gmail.com", "9348546");
			System.out.println(farmer.getName());
			//pst.deleteFarmer("Kenneth Westli");
			
			//Sheep sheep = new Sheep(2, 55, "JKL8654", 102009, 39, "Frisk", "63.432473","10.349329");
			//pst.addSheep(sheep);
			//pst.deleteSheep(1);

			//String mail = "kennew@stud.ntnu.no";
			//String pw = "lomper";
			//pst.checkLogin(mail, pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void setRegistrationTrue(){
		Registration registration = new Registration();
	}
	
	public void closeLogin(){
		
		login.setVisible(false);
		
	}
	/**
	 * Updates and gets the current time
	 * @return current time
	 */
	public Date getCurrentTime() {
		date = new Date();
		return date;
	}
	
    /**
	 * Gets the project path.
	 * @return the path of the project.
	 */
	public String getProjectPath() {
		return PROJECTPATH;
	}
	
    /**
	 * Gets the absolute path of the project, in this case "/it1901g21"
	 * This method is only used to find the project path, and should only be ran once.
	 * @return the path of the project 
	 */
	private String findProjectPath() {
		return new String((new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getParentFile().getPath());
	}
	
	/**
	 * Opens a given file in the default application associated with its file type.
	 * @param filename the filename (include all sub-folders from the project's main directory)
	 */
	public void openFile(String filename) {
		try {
			File file = new File(getProjectPath() + filename);
			//System.out.println(file.getAbsolutePath());
			Desktop.getDesktop().open(file);
		}
		catch (IOException e) {
			System.out.println("\nWarning: Unable to open file! Check your default application!\n");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A test to check if password hashing works, which it seems to do.
	 */
	public void hashTest() {		
		PasswordHash ph = new PasswordHash();
		String[] round1 = ph.createHash("littlengrepassord");
		System.out.println("Round 1, Hash: " + round1[0]);
		System.out.println("Round 1, Salt: " + round1[1]);
		
		System.out.println(ph.isValidated("littlengrepassord", round1[0], round1[1]));
		System.out.println(ph.isValidated("littlengrepassore", round1[0], round1[1]));
		
		/*
		String[] round2 = ph.isValidatedDebug("littlengrepassord", round1[1], round1[0]);
		System.out.println("Round 2, Hash: " + round2[0]);
		System.out.println("Round 2, Salt: " + round2[1]);
		*/
	}
	
}
