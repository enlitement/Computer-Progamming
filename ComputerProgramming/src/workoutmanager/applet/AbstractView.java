package workoutmanager.applet;

import java.awt.Container;

import javax.swing.JPanel;

public abstract class AbstractView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container;
	
	public AbstractView(Container container) {
		this.container = container;
	}
	
	/**
	 * Returns the container for the JApplet.
	 * @return
	 */
	public Container getContainer() {
		return container;
	}
	
	/**
	 * Sets the container for this view.
	 * @param container The java.awt.Container for the JApplet.
	 */
	public void setContainer(Container container) {
		this.container = container;
	}
	
}
