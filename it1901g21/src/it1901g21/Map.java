package it1901g21;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Map extends JFrame {

	static JFrame frame = new JFrame("SHOW ME WHERE THEM SHEEP AT");

	static String[][] farmersSheepCoordinates = new String[][] {
			{ "63.415884", "10.403452" }, 
			{ "63.417497", "10.408589" },
			{ "63.414809", "10.410305" } };

	public static void main(String[] args) {
		setUpMap();
		setUpText();
		frame.setSize(900, 600);
		frame.setVisible(true);
	}

	public static void setUpMap() {

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

		JLabel lblimage = new JLabel(new ImageIcon(image));
		frame.getContentPane().add(lblimage, BorderLayout.AFTER_LAST_LINE);
	}
	
	public static void setUpText() {
		JLabel moves = new JLabel("Her er bonde #847362 sine sauer");
		frame.getContentPane().add(moves);
	}

}
