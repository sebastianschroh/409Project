package frontend.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

public class SubmissionCreator {

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public SubmissionCreator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisisble(true);
	}

}
