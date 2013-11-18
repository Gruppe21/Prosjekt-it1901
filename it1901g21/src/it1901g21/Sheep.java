package it1901g21;

import java.util.ArrayList;

/**
 * The Sheep class.
 * Holds a sheep.
 */
public class Sheep {
	
	private int farmerId;
	private int id;
	private String earTag;
	private String birthDate;
	private int weight;
	private String health;
	private String xPos;
	private String yPos;
	private ArrayList<String[]> loc;
	
	/**
	 * Standard sheep constructor
	 * @param farmerId the farmer's ID
	 * @param id the sheep's ID
	 * @param earTag the sheep's ear tag
	 * @param birthMonth the sheep's month of birth
	 * @param weight the sheep's weight in kg
	 * @param health the sheep's health status
	 * @param xPos the x-position of the sheep
	 * @param yPos the y-position of the sheep
	 */
	public Sheep(int farmerId, String earTag, String birthDate, int weight, String health, String xPos, String yPos) {
		this.farmerId = farmerId;
		this.earTag = earTag;
		this.birthDate = birthDate;
		this.weight = weight;
		this.health = health;
		this.xPos = xPos;
		this.yPos = yPos;
		this.loc = new ArrayList<String[]>();
	}
	
	/**
	 * Alternative sheep constructor with no parameters
	 */
	public Sheep() {
		this.loc = new ArrayList<String[]>();
	}
	
	public int getFarmerId() {
		return farmerId;
	}
	
	public int getId() {
		return id;
	}
	
	public String getEarTag() {
		return earTag;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public int getWeigth() {
		return weight;
	}
	
	public String getHealth() {
		return health;
	}
	
	public String getXPos() {
		return xPos;
	}
	
	public String getYPos() {
		return yPos;
	}
	
	public ArrayList<String[]> getLoc() {
		return loc;
	}
	
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setEarTag(String earTag) {
		this.earTag = earTag;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void setHealth(String health) {
		this.health = health;
	}
	
	public void setXPos(String xPos) {
		this.xPos = xPos;
	}
	
	public void setYPos(String yPos) {
		this.yPos = yPos;
	}
	
	/**
	 * Adds coordinates to the last known location list
	 * @param coordinates x-position in String[0], y-position in String[1]
	 */
	public void setLastLoc(String[] coordinates) {
		
		if (this.loc.size() >= 20) {
			this.loc.remove(0);
		}
		System.out.println("adds");
		this.loc.add(coordinates);
	}
	
}