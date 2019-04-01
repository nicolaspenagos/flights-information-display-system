package customsThreads;

import userinterface.Controller;

public class GUIUpdateRunnable implements Runnable{
	private Controller gui;
	
	public GUIUpdateRunnable(Controller gui) {
		this.gui = gui;
	}
	@Override
	public void run() {
		gui.update();
		
	}

}
