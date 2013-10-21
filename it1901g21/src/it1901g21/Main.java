package it1901g21;

import java.io.File;
import it1901g21.SQL;

/**
 * Main Class.
 * Program entry point. 
 */
public class Main {
	
	/** The absolute path of the project */
	private final String PROJECTPATH;
	
	private SQL dao;
	private Farmers pst;
	
	/* Entry point, only used to initiate Main */
	public static void main(String[] args) throws Exception {
		Main main = new Main();
	}
	
	/**
	 * Standard Main constructor
	 */
	public Main() {
		
		PROJECTPATH = findProjectPath();
		
		dao = new SQL();
		pst = new Farmers();
				
		/* Tests the database */
		try {
			
			pst.register("kennew@stud.ntnu.no", "Kenneth Westli", "lomper", "99118822", "ken_wes@hotmail.com", "11223344");
			pst.addSheep(1, 102012, 45, 50.34234, 53.51233, "Frisk");
			
			dao.setDatabaseURL("jdbc:mysql://mysql.stud.ntnu.no/kennew_IT1901G21");
			dao.logIn("kennew_IT1901", "imsdal");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(getProjectPath());
		
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
	 * Gets the project path.
	 * @return the path of the project.
	 */
	public String getProjectPath() {
		return PROJECTPATH;
	}
    
}
