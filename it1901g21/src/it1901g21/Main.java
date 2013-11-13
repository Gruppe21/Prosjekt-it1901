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
import GUI.RegiSheep;
import GUI.Registration;

/**
 * Main Class.
 * Program entry point. 
 */
public class Main {
	
	private Farmers pst;
	private Pinger pinger;
	private PasswordHash ph;
	
	/* GUI classes */
	private MainScreen mainscreen;
	private Login login;
	private Registration registration;
	private RegiSheep regiSheep;
	
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
		//this is for testing{
		String xlist[]={"63.430570"};
		String ylist[]={"10.392165"};
		//}
		PROJECTPATH = findProjectPath();
		System.out.println(getProjectPath());
		
		pst = new Farmers();
		pinger = new Pinger(this);
		ph = new PasswordHash();
		
		regiSheep = new RegiSheep(this);
		mainscreen = new MainScreen(this, regiSheep, xlist, ylist);
		registration = new Registration(this);
		login = new Login(this, pst, registration);
		
		date = new Date();
		
		try {
			pst.connect();
		}
		catch(Exception e) {
			System.out.println("Cannot connect to database!");
			e.printStackTrace();
		}
	}
	
	public void logIn(String[] info) {
		
		String em = info[0];
		String pw = info[1];
		
		if (pst.checkLogin(em, pw)){
			
			mainscreen.openMainScreen();
			this.closeLogin();
			
			// Loads the logged-in farmer into the program
			this.loadFarmer(pst.getFarmer(em));
			
			// Loads the logged-in farmer's sheep
			this.getFarmer().setSheepHerd(pst.farmersSheep(this.getFarmer().getId()));
			
			// Loads the sheep into the GUI list
			this.mainscreen.updateListSheep();
			
			System.out.println("Successfully logged in as " + this.getFarmer().getName());
			
		} else if (pw.equals("") || em.equals("")) {
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
	 * Closes the login window
	 */
	public void closeLogin(){
		login.setVisible(false);
	}
	
	public void addSheep(String sheepNumber, String birthDate, String health, int weight) {
		
		Sheep sheep = new Sheep(this.getFarmer().getId(), sheepNumber, birthDate, weight, health, "63.415884", "10.403452");
		pst.addSheep(sheep);
		this.update();
	}
	
	/**
	 * Updates the farmer object in the local program to match the farmer in the database.
	 * Also updates all GUI stuff.
	 * ALWAYS USE THIS AFTER SOMETHING CHANGES!
	 */
	public void update() {
		
		//Updates the farmer's sheep herd
		this.getFarmer().setSheepHerd(pst.farmersSheep(this.getFarmer().getId()));
		
		/* All GUI updates */
		mainscreen.updateListSheep();
		
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
	 * For testing the database
	 */
	private void databaseTest() {
		
		try {
			
			/**
			 * Oppretter ny sau, legger den til i db
			 */
			// Sheep sheep = new Sheep(2, 55, "JKL8654", 102009, 39, "Frisk",
			// "63.432473","10.349329");
			// pst.addSheep(sheep);
			// pst.deleteSheep(1);
			
		} catch (Exception e) {
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
