package userinterface;

import customsThreads.GUIUpdateControllThread;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Airport;

public class Controller {
	
	private Airport airport;
	
    @FXML
    private Label date;
    
    @FXML
    public void initialize() {
    	airport = new Airport(); 
    	date.setText(airport.getStringHour());
    	
    	GUIUpdateControllThread guiThread = new GUIUpdateControllThread(this); 
    	guiThread.setDaemon(true);
    	guiThread.start();
    }
    
    public void update() {
    	airport.updateCurrentTime();
    	date.setText(airport.getStringHour());
   
    }

}
