package frontend.components;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class CourseCreator {

	private JFrame frame;
	private JTextField textField;
	private JButton btnCreate;

	/**
	 * Create the application.
	 */
	public CourseCreator() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 464, 256);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Course Creation");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblTitle.setBounds(145, 22, 172, 35);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblCourseName = new JLabel("Enter Course Name:");
		lblCourseName.setForeground(Color.WHITE);
		lblCourseName.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCourseName.setBounds(35, 103, 167, 13);
		frame.getContentPane().add(lblCourseName);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		textField.setBounds(179, 101, 198, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnCreate = new JButton("Create");
		btnCreate.setBackground(Color.BLACK);
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnCreate.setBounds(162, 154, 85, 21);
		frame.getContentPane().add(btnCreate);
		
	}
	
	public JButton getButton()
	{
		return btnCreate;
	}
	
	public String getTextfieldText()
	{
		return textField.getText();
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
}
