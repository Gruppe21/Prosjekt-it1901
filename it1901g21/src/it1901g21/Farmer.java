package it1901g21;

import java.util.ArrayList;

/**
 * The Farmer class.
 * Holds a farmer.
 */
public class Farmer {
	
	private String mail;
	private String name;
	private String password;
	private String tlf;
	private String resMail;
	private String resTlf;
	private ArrayList<Sheep> sheep;
	
	/**
	 * Standard farmer constructor
	 * @param mail the farmer's mail
	 * @param name the farmer's name
	 * @param password the farmer's password
	 * @param tlf the farmers' phone number
	 * @param resMail the farmer's reserve mail
	 * @param resTlf the farmer's reserve phone
	 */
	public Farmer(String mail, String name, String password, String tlf, String resMail, String resTlf) {
		this.mail = mail;
		this.name = name;
		this.password = password;
		this.tlf = tlf;
		this.resMail = resMail;
		this.resTlf = resTlf;
		sheep = new ArrayList<Sheep>();
	}
	
	/**
	 * Alternative farmer constructor with no parameters
	 */
	public Farmer() {
		sheep = new ArrayList<Sheep>();
	}
	
	public String getMail() {
		return mail;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
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
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
}
