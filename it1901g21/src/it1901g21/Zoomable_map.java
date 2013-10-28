// DETTE ER BARE EN STOR, DUM TESTKRØLL

package it1901g21;

import java.net.*;
import java.applet.*;

public class Zoomable_map extends Applet{

    public void openURL(String inputURL) {
        try {            
            AppletContext applet = getAppletContext();    
            URL url = new URL(inputURL);    
            applet.showDocument(url, "http://localhost:8888/map.php?farmerid=10");    
        }

        catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
    }
}