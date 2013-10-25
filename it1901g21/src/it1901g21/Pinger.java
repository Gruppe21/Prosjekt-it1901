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
	int updateFrequency;
	
	public Pinger(Main main) {
		
		this.main = main; 
		update = new Update(main, this);
		timer = new Timer("Update");
		updateFrequency = 3000; // 1 hour is 3600000 ms
		
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
	/*	for (each sheep in farmer's database) {
			generateCoordinates(x, y);
			write new coordinates to the sheep in the database
		}
	*/
	}
	
	/**
	 * Version 1, there should be a newer version to use.
	 * Generates new coordinates based on the current coordinates
	 * @param currentX the current X-coordinate
	 * @param currentY the current Y-coordinate
	 * @return the new coordiantes
	 */
	public String[] generateCoordinatesOld(String currentX, String currentY) {
		
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
	
	/**
	 * Version 2.
	 * Generates new coordinates based on the current coordinates
	 * @param currentX the current X-coordinate
	 * @param currentY the current Y-coordinate
	 * @return the new coordiantes
	 */
	public String[] generateCoordinates(String currentX, String currentY) {
		
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
		
		/* Only used for debugging.
		 * Sets number of decimals for a double. Still not working correctly, last 0 is omitted. 
		double xInt2 = Math.floor(xInt * 1000000) / 1000000;
		double yInt2 = Math.floor(yInt * 1000000) / 1000000;
		System.out.println("X: " + xInt2 + ",  Y: " + yInt2); */
		
		/* Converts the new coordinates to String and formats */  
		String x = df.format(xInt);
		String y = df.format(yInt);
		
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
		// Sheep update
		pinger.newSheepCoordinates();
		coordinateTest = pinger.generateCoordinates("63.415884", "10.403452");
		
		printTimeUpdate();
		count ++;
	}
	
	/**
	 * Prints the timer update to the console, along with relevant information.
	 * Used for testing purposes only.
	 */
	private void printTimeUpdate() {
		
		System.out.println("Ping number " + count + ".  Date: " + main.getCurrentTime());
		System.out.println("X: " + coordinateTest[0] + "  Y: " + coordinateTest[1]);
	}
}