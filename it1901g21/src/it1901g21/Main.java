package it1901g21;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Main Class.
 * Program entry point. 
 */
public class Main {
	
	private Farmers pst;
	private Pinger pinger;
	private Login login;
	private Registration registration;
	
	private JFrame frame;
	private Date date;
	
	private final String PROJECTPATH;
	private String bondeid;
	
	/* Entry point, only used to initiate Main*/
	public static void main(String[] args) throws Exception {
		Main main = new Main();		
	}
	
	/**
	 * Standard Main constructor
	 */
	public Main() {
		
		PROJECTPATH = findProjectPath();
		System.out.println(getProjectPath());
		
		pst = new Farmers();
		pinger = new Pinger(this);
		login = new Login(this);
		
		date = new Date();
		frame = new JFrame();
		bondeid = "0001";
		
		databaseTest();
		map();
		//openFile("/src/it1901g21/js_test.html");
		
	}
	
	/**
	 * For testing the database
	 */
	private void databaseTest() {
		
		try {
			pst.connect();
			//pst.register("kennew@stud.ntnu.no", "Kenneth Westli", "lomper", "99118822", "ken_wes@hotmail.com", "11223344");
			//pst.deleteFarmer("Kenneth Westli");
			//pst.addSheep(1, 20, "ABC1234", 102012, 45, "Frisk", 63.430803, 10.352805);
			//pst.deleteSheep(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void setRegistrationTrue(){
		Registration registration = new Registration();
	}
	
	/**
	 * Updates and gets the current time
	 * @return current time
	 */
	public Date getCurrentTime() {
		date = new Date();
		return date;
	}
	
    /**
	 * Gets the project path.
	 * @return the path of the project.
	 */
	public String getProjectPath() {
		return PROJECTPATH;
	}
	
    /**
	 * Gets the absolute path of the project, in this case "/it1901g21"
	 * This method is only used to find the project path, and should only be ran once.
	 * @return the path of the project 
	 */
	private String findProjectPath() {
		return new String((new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getParentFile().getPath());
	}
	
	/**
	 * Opens a given file in the default application associated with its file type.
	 * @param filename the filename (include all folders from the project main directory)
	 */
	public void openFile(String filename) {
		try {
			File file = new File(getProjectPath() + filename);
			//System.out.println(file.getAbsolutePath());
			Desktop.getDesktop().open(file);
		}
		catch (IOException e) {
			System.out.println("\nWarning: Unable to open file! Check your default application!\n");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void map() {
		
		JLabel text = Map.setUpText(bondeid);
		Image image = Map.setUpMap(bondeid);
		
		// denne måten å skrive bilde til applikasjonen må naturligvis endres til valgt GUI
		JLabel lblimage = new JLabel(new ImageIcon(image));
		frame.getContentPane().add(lblimage, BorderLayout.AFTER_LAST_LINE);
		frame.getContentPane().add(text);
		frame.setSize(900, 600);
		frame.setVisible(true);
	}
	
	
}
