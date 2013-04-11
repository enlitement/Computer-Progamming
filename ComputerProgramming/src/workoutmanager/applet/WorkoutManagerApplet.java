package workoutmanager.applet;

import java.awt.Container;

import javax.swing.JApplet;

public class WorkoutManagerApplet extends JApplet{
	
	private ViewManager viewManager;
	private Container container;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() {
		// Gets the content pane where we can work with layouts
		container = getContentPane();
		// Sets the parent of the ViewManager to this JApplet
		ViewManager.setParent(this);
		// Creates the singleton class
		viewManager = ViewManager.get();
		// Adds a LoginView
		viewManager.addView(new LoginView(viewManager, container));
	}
}
