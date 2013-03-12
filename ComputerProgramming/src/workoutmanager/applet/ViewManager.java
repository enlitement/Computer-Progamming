package workoutmanager.applet;

import java.util.ArrayList;

/**
 * A singleton class that manages all the different AbstractView classes.
 * 
 * @author Helson
 * 
 */
public class ViewManager {

	private ArrayList<AbstractView> viewList;
	private WorkoutManagerApplet parent;
	private ViewManager viewManager;

	private ViewManager(WorkoutManagerApplet parent) {
		this.setParent(parent);
		setViewList(new ArrayList<AbstractView>());
	}
	
	/**
	 * Returns the singleton ViewManager object.
	 * @return The ViewManager
	 */
	public ViewManager get() {
		if (viewManager == null)
			viewManager = new ViewManager(parent);
		return viewManager;
	}
	
	/**
	 * Removes the foremost state in 
	 */
	public void pop() {

	}

	public WorkoutManagerApplet getParent() {
		return parent;
	}

	public void setParent(WorkoutManagerApplet parent) {
		this.parent = parent;
	}

	public ArrayList<AbstractView> getViewList() {
		return viewList;
	}

	public void setViewList(ArrayList<AbstractView> viewList) {
		this.viewList = viewList;
	}
}
