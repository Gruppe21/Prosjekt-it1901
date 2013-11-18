package it1901g21;

public class Localization {
	
	private int sheepId;
	private int i;
	private String time;
	private String xPos;
	private String yPos;
	
	public Localization(int sheepId, String time, String xPos, String yPos) {
		this.sheepId = sheepId;
		this.time = time;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public Localization() {
		
	}
	
	public int getSheepId() {
		return sheepId;
	}
	
	public int getIndex() {
		return i;
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
	
	public void setIndex(int i) {
		this.i = i;
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
