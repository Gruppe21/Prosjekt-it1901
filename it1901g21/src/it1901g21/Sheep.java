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
	
	/**
	 * Stardand sheep constructor
	 * @param farmerId the farmer's ID
	 * @param id the sheep's ID
	 * @param earTag the sheep's ear tag
	 * @param birthMonth the sheep's month of birth
	 * @param weight the sheep's weight in kg
	 * @param health the sheep's health status
	 * @param xPos the x-position of the sheep
	 * @param yPos the y-position of the sheep
	 */
	public Sheep(int farmerId, int id, String earTag, int birthMonth, int weight, String health, String xPos, String yPos) {
		this.farmerId = farmerId;
		this.id = id;
		this.earTag = earTag;
		this.birthMonth = birthMonth;
		this.weight = weight;
		this.health = health;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	/**
	 * Alternative sheep constructor with no parameters
	 */
	public Sheep() {
		
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
	
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
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