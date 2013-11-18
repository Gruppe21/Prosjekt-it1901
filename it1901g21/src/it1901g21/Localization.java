package it1901g21;

public class Localization {
	
	private int sheepId;
	private int locId;
	private String time;
	private String xPos;
	private String yPos;
	
	/**
	 * Standard localisation constructor
	 * @param sheepId the sheep localised
	 * @param time time of the localisation
	 * @param xPos x-position
	 * @param yPos y-position
	 */
	public Localization(int sheepId, String time, String xPos, String yPos) {
		this.sheepId = sheepId;
		this.time = time;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	/**
	 * Alternative localisation constructor with no parameters
	 */
	public Localization() {
		
	}
	
	public int getSheepId() {
		return sheepId;
	}
	
	public int getLocId() {
		return locId;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getX() {
		return xPos;
	}
	
	public String getY() {
		return yPos;
	}
	
	public void setSheepId(int id) {
		this.sheepId = id;
	}
	
	public void setLocId(int id) {
		this.locId = id;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setX(String xPos) {
		this.xPos = xPos;
	}
	
	public void setY(String yPos) {
		this.yPos = yPos;
	}
	
}
