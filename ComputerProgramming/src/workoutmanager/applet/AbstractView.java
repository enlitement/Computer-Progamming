package workoutmanager.applet;

import java.awt.Container;

import javax.swing.JPanel;

public abstract class AbstractView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container parent;
	private ViewManager manager;
	
	public AbstractView(ViewManager manager, Container parent) {
		this.parent = parent;
		this.setManager(manager);
	}
	
	/**
	 * Returns the container for the JApplet.
	 * @return
	 */
	public Container getParent() {
		return this.parent;
	}
	
	/**
	 * Sets the container for this view.
	 * @param container The java.awt.Container for the JApplet.
	 */
	public void setParent(Container parent) {
		this.parent = parent;
	}
	
	/**
	 * Removes this View from the view stack and repaints the screen.
	 */
	public void remove() {
		ViewManager.get().removeView(this);
	}

	public ViewManager getManager() {
		return manager;
	}

	public void setManager(ViewManager manager) {
		this.manager = manager;
	}
	
}
