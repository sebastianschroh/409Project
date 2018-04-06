package frontend.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

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
		frame.setBounds(100, 100, 383, 253);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Course Creation");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setBounds(120, 10, 132, 35);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblCourseName = new JLabel("Enter Course Name:");
		lblCourseName.setBounds(35, 103, 101, 13);
		frame.getContentPane().add(lblCourseName);
		
		textField = new JTextField();
		textField.setBounds(130, 100, 186, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(120, 153, 85, 21);
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
