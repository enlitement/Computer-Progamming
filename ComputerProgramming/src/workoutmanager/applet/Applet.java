package workoutmanager.applet;

import java.awt.Container;

import javax.swing.JApplet;

public class Applet extends JApplet{
	
	private LoginView loginView;
	private Container container;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() {
		container = getContentPane();
		loginView = new LoginView(container);
	}

}
