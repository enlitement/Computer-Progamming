package workoutmanager.applet;

import java.awt.Container;

public class MainView extends AbstractView{
	
	private MainPanel panel;
	public MainView(ViewManager manager, Container parent) {
		super(manager, parent);
		panel = new MainPanel();
		add(panel);
		System.out.println("constructed");
		parent.repaint();
	}

}
