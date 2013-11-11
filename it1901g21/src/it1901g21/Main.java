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

import GUI.ErrorMessage;
import GUI.Login;
import GUI.MainScreen;
import GUI.Registration;

/**
 * Main Class.
 * Program entry point. 
 */
public class Main {
	
	private Farmers pst;
	private Pinger pinger;
	private PasswordHash ph;
	private Login login;
	private Registration registration;
	private MainScreen mainscreen;
	
	private Date date;
	
	private final String PROJECTPATH;
	private Farmer farmer;
	
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
		ph = new PasswordHash();
		
		login = new Login(this, pst);
		mainscreen = new MainScreen(this);
		
		date = new Date();
		
		databaseTest();
		//hashTest();
	}
	
	/**
	 * For testing the database
	 */
	private void databaseTest() {
		
		try {
		pst.connect();
			
			/**
			 * Oppretter ny bruker, legger den til i db
			 */
			// Farmer farmer = new Farmer("heihei@stud.ntnu.no", "Klara ku",
			// "98636864", "neimen@gmail.com", "9348546");
			// pst.deleteFarmer("Kenneth Westli");

			/**
			 * Oppretter ny sau, legger den til i db
			 */
			// Sheep sheep = new Sheep(2, 55, "JKL8654", 102009, 39, "Frisk",
			// "63.432473","10.349329");
			// pst.addSheep(sheep);
			// pst.deleteSheep(1);

			/**
			 * Sjekker om oppgitt brukernavn og passord er riktig.
			 */
			// String mail = "kennew@stud.ntnu.no";
			// String pw = "lomper";
			// pst.checkLogin(mail, pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void logIn(String[] info) {
		
		String li = info[0];
		String pw = info[1];
		
		if (pst.checkLogin(li, pw)){
			
			mainscreen.setVisible();
			this.closeLogin();
			
			this.loadFarmer(pst.getFarmer(li));
			System.out.println("Successfully logged in as " + this.getFarmer().getName());
			
		} else if (pw.equals("") || li.equals("")) {
			ErrorMessage errormsg = new ErrorMessage("","Please enter your email and password.");
		} else {
			ErrorMessage errormsg = new ErrorMessage("Login failed","Your email or password were incorrect. Please try again.");
		}
		
	}
	
	/**
	 * Registers a new farmer, and saves it in the database.
	 * Works with password hashing.
	 * @param password the chosen password
	 */
	public void newFarmer(String firstName, String lastName, String mail, String tlf, String resMail, String resTlf, String password) {
		
		String[] passwordHash = ph.createHash(password);
		Farmer farmer = new Farmer(mail, firstName + " " + lastName, tlf, resMail, resTlf, passwordHash[0], passwordHash[1]);
		pst.register(farmer);
	}
	
	/**
	 * Loads the farmer into the program
	 * @param farmer
	 */
	public void loadFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	
	/**
	 * Returns the farmer.
	 */
	public Farmer getFarmer() {
		return this.farmer;
	}
	
	/**
	 * Opens the registration window
	 */
	public void setRegistrationTrue(){
		registration.openRegistration();
	}
	
	/**
	 * Closes the login window
	 */
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
