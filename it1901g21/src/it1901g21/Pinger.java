package it1901g21;

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
		updateFrequency = 2000; // 1 hour is 3600000 ms
		
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
	 * Generates new coordinates based on the current coordinates
	 * @param currentX the current X-coordinate
	 * @param currentY the current Y-coordinate
	 * @return the new coordiantes
	 */
	public String[] generateCoordinates(String currentX, String currentY) {
		return new String[] {"X", "Y"};
	}
	
}

/**
 * The update class
 */
class Update extends TimerTask {
	
	Main main; 
	Pinger pinger;
	int count;
	
	public Update(Main main, Pinger pinger) {
		this.main = main;
		this.pinger = pinger;
		count = 1;
	}
	
	@Override
	public void run() {
		// Sheep update
		pinger.newSheepCoordinates();
		
		printTimeUpdate();
		count ++;
	}
	
	/**
	 * Prints the timer update to the console, along with relevant information.
	 * Used for testing purposes only.
	 */
	private void printTimeUpdate() {
		System.out.println("Ping number " + count + ".  Date: " + main.getCurrentTime());
	}
}