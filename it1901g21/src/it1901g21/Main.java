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

import GUI.DelSheep;
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
	private Farmer farmer;
	
	/* GUI classes */
	private MainScreen mainscreen;
	private Login login;
	private Registration registration;
	private RegiSheep regiSheep;
	private DelSheep delSheep;
	
	private SendMail sendMail;
	private Date date;
	
	private final String PROJECTPATH;
	private boolean loggedIn;
	private boolean connected;
	
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
		loggedIn = false;
		connected = false;
		
		pst = new Farmers();
		pinger = new Pinger(this);
		ph = new PasswordHash();
		
		regiSheep = new RegiSheep(this);
		delSheep = new DelSheep(this);
		mainscreen = new MainScreen(this, regiSheep, delSheep, xlist, ylist);
		registration = new Registration(this);
		login = new Login(this, pst, registration);
		
		
		date = new Date();
		
		// Creates connection to database
		if (pst.connect()) {
			connected = true;
			login.setConnected();
		}
		else {
			login.setDisconnected();
		}
		
	}
	
	/**
	 * Method run when user logs in to the system
	 * @param info the mail and the password
	 */
	public void logIn(String[] info) {
		
		String em = info[0];
		String pw = info[1];
		
		if (pst.checkLogin(em, pw)){
			
			// Loads the logged-in farmer into the program
			this.loadFarmer(pst.getFarmer(em));
			
			// Loads the logged-in farmer's sheep
			this.getFarmer().setSheepHerd(pst.farmersSheep(this.getFarmer()));
			
			// Loads the sheep into the GUI list
			this.mainscreen.updateListSheep();
			
			// Opens GUI window
			mainscreen.openMainScreen();
			this.closeLogin();
			
			loggedIn = true;
			System.out.println("Successfully logged in as " + this.getFarmer().getName());
			
		}
		else if (pw.equals("") || em.equals("")) {
			ErrorMessage errormsg = new ErrorMessage("", "Please enter your email and password.");
		}
		else {
			ErrorMessage errormsg = new ErrorMessage("Login failed", "Your email or password were incorrect. Please try again.");
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
		update(true);
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
	
	/**
	 * Adds the sheep to logged-in farmer's herd
	 * @param sheepNumber
	 * @param birthDate
	 * @param health
	 * @param weight
	 */
	public void addSheep(String sheepNumber, String birthDate, String health, int weight) {
		
		Sheep sheep = new Sheep(this.getFarmer().getId(), sheepNumber, birthDate, weight, health, "63.415884", "10.403452");
		pst.addSheep(sheep);
		this.update(true);
	}
	
	/**
	 * Deletes the sheep from logged-in farmer's herd
	 * @param eartag the sheep's ear tag
	 * @return whether sheep is found and deleted from farmer's herd
	 */
	public boolean deleteSheep(String earTag) {
		
		boolean foundSheep = false;
		for (Sheep sheep : this.getFarmer().getSheepHerd()) {
			
			if (sheep.getEarTag().equals(earTag)) {	
				foundSheep = true;
				pst.deleteSheep(sheep);
				break;
			}
		}
		
		if (!foundSheep) {
			ErrorMessage error = new ErrorMessage("", "No such sheep found in farmer's herd!");
			return false;
		}
		
		this.update(true);
		return true;
	}
	
	/**
	 * Sends the request to update the sheep's position to the database handler
	 */
	public void updateSheepPos(int id, String[] coordinates) {
		pst.updateSheepPos(id, coordinates);
		this.update(false);
	}
	
	/**
	 * Sends the request to update the sheep's health and weight
	 * @param id
	 * @param health
	 * @param weight
	 */
	public void updateEditSheep(int id, String health, int weight) {
		pst.editSheep(id, health, weight);
		this.update(false);
	}
	
	public void updateEditProfile(String name, String Email, String phoneNumber, 
		String contactEmail, String contactPhone, int id) {
		
		// Updates the farmer locally
		farmer.setName(name);
		farmer.setMail(Email);
		farmer.setTlf(phoneNumber);
		farmer.setResMail(contactEmail);
		farmer.setResTlf(contactPhone);
		
		// Updates the farmer in the database
		pst.editFarmer(name, Email, phoneNumber, contactEmail, contactPhone, id);
		
		this.update(false);
	}
	
	/**
	 * Updates the farmer object in the local program to match the farmer in the database.
	 * Also updates all GUI stuff.
	 * ALWAYS USE THIS AFTER SOMETHING CHANGES!
	 * @param updateList set this to true if the list of sheep should be updated (it should not be updated by a ping)
	 */
	public void update(boolean updateList) {
		
		// Updates the farmer's sheep herd
		this.getFarmer().setSheepHerd(pst.farmersSheep(this.getFarmer()));
		
		// GUI: Map update
		mainscreen.updateMap();
		
		// GUI: Updates the list of sheep if requested
		if (updateList)
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
	 * Checks if a farmer is logged in
	 * @return true or false
	 */
	public boolean isLoggedIn() {
		if (loggedIn)
			return true;
		return false;
	}
	
	/**
	 * Checks if program is connected to database
	 * @return true or false
	 */
	public boolean isConnected() {
		if (connected)
			return true;
		return false;
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
	
	public void mailAlert(String farmer_mail, String farmer_name, 
			String timestamp, int sheepId, String sheepX, String sheepY){
		
		sendMail = new SendMail(farmer_mail, farmer_name, timestamp, sheepId, sheepX, sheepY);
		
	}
	
}
