package it1901g21;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class for controlling the updates
 */
public class Pinger {
	
	Main main;
	Update update;
	Timer timer;
	Farmer farmer;
	int updateFrequency;
	
	public Pinger(Main main) {
		
		this.main = main;
		this.farmer = main.getFarmer();
		update = new Update(main, this);
		timer = new Timer("Update");
		updateFrequency = 10000; // 1 hour is 3600000 ms
		
		startPinger();
		
	}
	
	/**
	 * Starts the continuous updates from the pinger at the update frequency
	 */
	public void startPinger() {
		timer.scheduleAtFixedRate(update, 0, updateFrequency);
	}
	
	/**
	 * Updates the coordinates for all sheep
	 */
	public void newSheepCoordinates() {
		
		if (main.getFarmer().getSheepHerd().isEmpty()) {
			return;
		}
		
		for (Sheep sheep : main.getFarmer().getSheepHerd()) {	
			
			// Generate new coordinates based on the old
			String[] newCoordinates = generateCoordinatesV1(sheep.getXPos(), sheep.getYPos());
			
			// Set the sheep at the new coordinates
			sheep.setXPos(newCoordinates[0]);
			sheep.setYPos(newCoordinates[1]);
			
			// Adds the coordinates to the sheep's location list
			sheep.setLastLoc(newCoordinates);
			
			// Sends the request to update database further
			main.updateSheepPos(sheep.getId(), newCoordinates);
		}
	}
	
	/**
	 * Version 2.
	 * Generates new coordinates based on the current coordinates
	 * @param currentX the current X-coordinate
	 * @param currentY the current Y-coordinate
	 * @return the new coordinates
	 */
	public String[] generateCoordinatesV2(String currentX, String currentY) {
		
		/* Sets all prerequisites */
		DecimalFormat df = new DecimalFormat("##0.000000");
		double min = -0.010000;
		double max = 0.010000;
		
		/* Converts to double */
		double xInt = Double.parseDouble(currentX);
		double yInt = Double.parseDouble(currentY);
		
		/* Generates move distance */
		double xR = min + (Math.random() * (max - min));
		double yR = min + (Math.random() * (max - min));
		
		/* Adds distance to current coordinates */
		xInt += xR;
		yInt += yR;
		
		/* Converts the new coordinates to String and formats */  
		String x = df.format(xInt);
		String y = df.format(yInt);
		
		return new String[] {x, y};
	}
	
	/**
	 * Version 1
	 * Generates new coordinates based on the current coordinates
	 * @param currentX the current X-coordinate
	 * @param currentY the current Y-coordinate
	 * @return the new coordinates
	 */
	public String[] generateCoordinatesV1(String currentX, String currentY) {
		
		int min = 1000;
		int max = 9000;
		
		String x = currentX.substring(0, currentX.length() - 4);
		String y = currentY.substring(0, currentY.length() - 4);
		
		int xR = min + (int)(Math.random() * max);
		int yR = min + (int)(Math.random() * max);
		
		x += Integer.toString(xR);
		y += Integer.toString(yR);
		
		return new String[] {x, y};
	}
}

/**
 * The update class
 */
class Update extends TimerTask {
	
	Main main; 
	Pinger pinger;
	int count;
	String[] coordinateTest;
	
	public Update(Main main, Pinger pinger) {
		this.main = main;
		this.pinger = pinger;
		count = 1;
	}
	
	@Override
	public void run() {
		
		// If farmer is logged-in
		if (main.isLoggedIn()) {
			
			// Requests the coordinates of all sheep to be updated
			pinger.newSheepCoordinates();
		}
		
		printTimeUpdate();
		count ++;
	}
	
	/**
	 * Prints the timer update to the console, along with relevant information.
	 * Used for testing purposes only.
	 */
	private void printTimeUpdate() {
		
		System.out.println("Ping number " + count + ".  Date: " + main.getCurrentTime());
		
		Farmer farmer = main.getFarmer();
		if(farmer != null)
			System.out.println("Farmer currently logged in: " + farmer.getName());
		else
			System.out.println("No farmer is logged in. Please re-farm later!");
	}
}