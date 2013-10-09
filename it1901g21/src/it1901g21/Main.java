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
	
	/* Entry point */
	public static void main(String[] args) throws Exception {
		Main main = new Main();
	}
	
	/**
	 * Standard Main constructor
	 */
	public Main() {
		
		PROJECTPATH = setProjectPath().getPath();
		
		dao = new SQL();
		
		/* Tests the database */
		try {
			
			dao.readDataBase();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(getProjectPath());
		
	}
	
    /**
	 * Sets the absolute path of the project, in this case "/it1901g21"
	 * This method returns a File, and is only used to set the project path. 
	 */
	public File setProjectPath() {
		return new File((new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())).getParentFile().getPath());
	}
    
    /**
	 * Gets the project path.
	 * @return the path of the project.
	 */
	public String getProjectPath() {
		return PROJECTPATH;
	}
    
}