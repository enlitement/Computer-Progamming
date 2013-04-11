package workoutmanager.applet;

import java.util.Stack;

/**
 * A singleton class that manages all the different AbstractView classes.
 * 
 * @author Helson
 * 
 */
public class ViewManager {

	private Stack<AbstractView> viewStack;
	private static WorkoutManagerApplet parent;
	private static ViewManager viewManager;

	private ViewManager(WorkoutManagerApplet parent) {
		setParent(parent);
		setViewStack(new Stack<AbstractView>());
	}

	/**
	 * Returns the singleton ViewManager object.
	 * 
	 * @return The ViewManager
	 */
	public static ViewManager get() {
		if (viewManager == null)
			viewManager = new ViewManager(parent);
		return viewManager;
	}

	/**
	 * Adds a View to the view ArrayList.
	 * 
	 * @param view
	 */
	public void addView(AbstractView view) {
		viewStack.push(view);
		parent.getContentPane().add(view);
		parent.repaint();
	}

	public void removeView(AbstractView view) {
		viewStack.remove(view);
		parent.getContentPane().remove(view);
		parent.repaint();
	}
	/**
	 * Removes the foremost state in the viewList and refreshes the window.
	 */
	public void pop() {
		parent.getContentPane().remove(viewStack.peek());
		viewStack.pop();
		parent.repaint();
	}

	/**
	 * Returns the WorkoutManagerApplet
	 * 
	 * @return parent WorkoutManagerApplet
	 */
	public WorkoutManagerApplet getParent() {
		return parent;
	}

	public static void setParent(WorkoutManagerApplet parent) {
		ViewManager.parent = parent;
	}

	public Stack<AbstractView> getViewStack() {
		return viewStack;
	}
	
	public void setViewStack(Stack<AbstractView> viewStack) {
		this.viewStack = viewStack;
	}
}
