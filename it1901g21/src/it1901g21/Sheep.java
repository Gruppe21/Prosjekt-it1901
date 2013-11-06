package it1901g21;

/**
 * The Sheep class.
 * Holds a sheep.
 */
public class Sheep {
	
	private int farmerId;
	private int id;
	private String earTag;
	private int birthMonth;
	private int weight;
	private String health;
	private String xPos;
	private String yPos;
	
	public int getFarmerId() {
		return farmerId;
	}
	
	public int getId() {
		return id;
	}
	
	public String getEarTag() {
		return earTag;
	}
	
	public int getBirthMonth() {
		return birthMonth;
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
	
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setEarTag(String earTag) {
		this.earTag = earTag;
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
		this.yPos = xPos;
	}
	
}