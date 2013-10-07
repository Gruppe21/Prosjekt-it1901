package it1901g21;

import java.io.File;

/**
 * Main Class.
 * Program entry point. 
 */
public class Main {
	
	/** The absolute path of the project */
	private final String PROJECTPATH;
	
	private SQL sql;
	
	/* Entry point */
    public static void main(String[] args) {
    	Main main = new Main();
    }
    
    /**
	 * Standard Main constructor
	 */
    public Main() {
    	
    	PROJECTPATH = setProjectPath().getPath() + "";
    	
    	sql = new SQL();
    	
    	System.out.println(getProjectPath());
    	
    }
    
    /**
	 * Gets the absolute path of the project, in this case "/Prosjekt-it1901"
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