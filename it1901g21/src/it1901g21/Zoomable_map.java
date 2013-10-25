// DETTE ER BARE EN STOR, DUM TESTKRØLL

package it1901g21;

import java.net.*;
import java.applet.*;

public class Zoomable_map extends Applet{

    public void openURL(String inputURL) {
        try {            
            AppletContext applet = getAppletContext();    
            URL url = new URL(inputURL);    
            applet.showDocument(url, "file:///c:/Users/Wien/git/Prosjekt-it1901/it1901g21/src/it1901g21/map.html");    
        }

        catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
    }
}