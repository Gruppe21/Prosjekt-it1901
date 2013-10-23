package it1901g21;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Class for controlling the ping
 */
public class Pinger {
	
	Main main;
	Update update;
	Timer timer;
	int updateFrequency;
	
	public Pinger(Main main) {
		
		this.main = main; 
		update = new Update(main);
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
	
}

/**
 * The update class
 */
class Update extends TimerTask {
	
	Main main; 
	int count;
	
	public Update(Main main) {
		this.main = main;
		count = 1;
	}
	
	@Override
	public void run() {
		// Collect and send sheep info
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