package customsThreads;

import javafx.application.Platform;
import userinterface.Controller;;

public class GUIUpdateControllThread extends Thread{
	private final static long UPDATE_SLEEP_TIME = 5;
	private Controller gui; 
	
	public GUIUpdateControllThread(Controller gui) {
		this.gui = gui;
	}
	
	public void run() {
		while(true) {
			GUIUpdateRunnable gUR = new GUIUpdateRunnable(gui);
			Platform.runLater(gUR);
			
			try {
				sleep(UPDATE_SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
