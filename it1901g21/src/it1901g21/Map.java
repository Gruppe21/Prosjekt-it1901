package it1901g21;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Map extends JFrame {
	
	// eksempelkoordinater, disse skal naturligvis hentes fra databasen ut ifra bondeid som sendes til setUpMap/setUpText
	static String[][] farmersSheepCoordinates = new String[][] {
			{ "63.415884", "10.403452" }, 
			{ "63.417497", "10.408589" },
			{ "63.414809", "10.410305" } };

	public static Image setUpMap(String bondeid) {

		String sheepUrl = null;
		
		for (int j = 0; j < farmersSheepCoordinates.length; j++) {
			sheepUrl = sheepUrl+"&markers=color:blue%7Clabel:1%7C"+farmersSheepCoordinates[j][0]+","+farmersSheepCoordinates[j][1];
		}
		
		String farmersMap = ("http://maps.googleapis.com/maps/api/staticmap?"+"center=63.414732,10.407778&zoom=14&size=600x450&maptype=roadmap"+sheepUrl+"&sensor=false");
		Image image = null;
		
		try {
			URL url = new URL(farmersMap);
			image = ImageIO.read(url);
		} catch (IOException e) {
		}
		
		return image;
	}
	
	public static JLabel setUpText(String bondeid) {
		JLabel moves = new JLabel("Her er bonde #" +bondeid+ " sine sauer");
		return moves;
	}

}
