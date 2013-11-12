package it1901g21;

import java.util.ArrayList;

/**
 * The Farmer class.
 * Holds a farmer.
 */
public class Farmer {
	
	private int id;
	private String mail;
	private String name;
	private String passwordHash;
	private String salt;
	private String tlf;
	private String resMail;
	private String resTlf;
	private ArrayList<Sheep> sheep;
	
	/**
	 * Standard farmer constructor
	 * @param mail the farmer's mail
	 * @param name the farmer's name
	 * @param tlf the farmers' phone number
	 * @param resMail the farmer's reserve mail
	 * @param resTlf the farmer's reserve phone
	 */
	public Farmer(int id, String mail, String name, String tlf, String resMail, String resTlf, String passwordHash, String salt) {
		this.id = id;
		this.mail = mail;
		this.name = name;
		this.tlf = tlf;
		this.resMail = resMail;
		this.resTlf = resTlf;
		this.passwordHash = passwordHash;
		this.salt = salt;
		sheep = new ArrayList<Sheep>();
	}
	
	/**
	 * Alternative farmer constructor without farmerId
	 * @param mail the farmer's mail
	 * @param name the farmer's name
	 * @param tlf the farmers' phone number
	 * @param resMail the farmer's reserve mail
	 * @param resTlf the farmer's reserve phone
	 */
	public Farmer(String mail, String name, String tlf, String resMail, String resTlf, String passwordHash, String salt) {
		this.mail = mail;
		this.name = name;
		this.tlf = tlf;
		this.resMail = resMail;
		this.resTlf = resTlf;
		this.passwordHash = passwordHash;
		this.salt = salt;
		sheep = new ArrayList<Sheep>();
	}
	
	/**
	 * Alternative farmer constructor with no parameters
	 */
	public Farmer() {
		sheep = new ArrayList<Sheep>();
	}
	
	public int getId() {
		return id;
	}
	
	public String getMail() {
		return mail;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public String getTlf() {
		return tlf;
	}
	
	public String getResMail() {
		return resMail;
	}
	
	public String getResTlf() {
		return resTlf;
	}
	
	public ArrayList<Sheep> getSheepHerd() {
		return sheep;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	
	public void setResMail(String resMail) {
		this.resMail = resMail;
	}
	
	public void setResTlf(String resTlf) {
		this.resTlf = resTlf;
	}
	
	/**
	 * Adds sheep to farmer's sheep herd
	 * @param sheep
	 */
	public void addSheep(Sheep sheep) {
		this.sheep.add(sheep);
	}
	
	/**
	 * Sets the farmer's sheep herd to given herd
	 * @param sheep ArrayList sheep
	 */
	public void setSheepHerd(ArrayList<Sheep> sheep) {
		this.sheep = sheep;
	}
	
}
