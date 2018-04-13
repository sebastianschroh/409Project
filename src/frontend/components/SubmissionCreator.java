package frontend.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SubmissionCreator {

	private JFrame frame;
	private JTextField title;
	private JTextField path;
	private JButton btnSubmit;
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblSubmission = new JLabel("Submission");
		lblSubmission.setForeground(Color.WHITE);
		lblSubmission.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblSubmission.setBounds(164, 40, 83, 14);
		frame.getContentPane().add(lblSubmission);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTitle.setBounds(77, 117, 41, 14);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblPath = new JLabel("Path:");
		lblPath.setForeground(Color.WHITE);
		lblPath.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPath.setBounds(85, 155, 33, 14);
		frame.getContentPane().add(lblPath);
		
		title = new JTextField();
		title.setBounds(128, 116, 197, 20);
		frame.getContentPane().add(title);
		title.setColumns(10);
		
		path = new JTextField();
		path.setBounds(128, 154, 197, 20);
		frame.getContentPane().add(path);
		path.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnSubmit.setBounds(158, 210, 89, 23);
		frame.getContentPane().add(btnSubmit);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	public JButton getButton()
	{
		return btnSubmit;
	}
	
	public String getTitle()
	{
		return title.getText();
	}
	
	public String getPath()
	{
		return path.getText();
	}
}
