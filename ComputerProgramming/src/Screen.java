

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends Canvas {

	private static final long serialVersionUID = 1L;

	// Size of the window
	public static int WIDTH = 448, HEIGHT = 600;
	// Game window
	public static JFrame frame;
	// Graphics strategy
	private BufferStrategy strategy;

	public Screen() {
		setUpWindow();
		setStrategies();
	}

	/**
	 * Exits the program
	 */
	public static void exit() {
		WindowEvent wev = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	public BufferStrategy getGameBufferStrategy() {
		return strategy;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setStrategies() {
		// request the focus so key events come to us
		requestFocusInWindow();

		// create the buffering strategy which will allow AWT
		// to manage our accelerated graphics
		createBufferStrategy(2);
		strategy = getBufferStrategy();

		// Set ignore repaint so that we can determine when
		// to paint or not
		setIgnoreRepaint(true);
	}

	public void setUpWindow() {
		// Make JFrame
		frame = new JFrame("Engine");

		// get hold the content of the frame and set up the resolution of the
		// game
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setLayout(null);

		// setup our canvas size and put it into the content of the frame
		setBounds(0, 0, WIDTH, HEIGHT);
		panel.add(this);

		// Tell AWT not to bother repainting our canvas since we're
		// going to do that our self in accelerated mode
		setIgnoreRepaint(true);

		// finally make the window visible
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		// add a listener to respond to the user closing the window. If they
		// do we'd like to exit the game

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
