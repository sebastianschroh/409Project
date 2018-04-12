package frontend.components;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

public class StudentEmailCreator {

	private JFrame frame;
	private JTextField subjectField;
	private JTextField messageField;
	private JButton send;

	/**
	 * Create the application.
	 */
	public StudentEmailCreator() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 464, 256);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Email Students");
		lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblTitle.setBounds(145, 22, 172, 35);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblSubject = new JLabel("Subject: ");
		lblSubject.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		lblSubject.setBounds(35, 103, 167, 13);
		frame.getContentPane().add(lblSubject);
		
		subjectField = new JTextField();
		subjectField.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		subjectField.setBounds(147, 100, 198, 19);
		frame.getContentPane().add(subjectField);
		subjectField.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message: ");
		lblMessage.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		lblMessage.setBounds(35, 103, 167, 13);
		frame.getContentPane().add(lblMessage);
		
		messageField = new JTextField();
		messageField.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		subjectField.setBounds(147, 100, 198, 19);
		frame.getContentPane().add(messageField);
		messageField.setColumns(10);
		
		send = new JButton("Send");
		send.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		send.setBounds(162, 154, 85, 21);
		frame.getContentPane().add(send);
		
	}
	
	public JButton getButton()
	{
		return send;
	}
	
	public String getSubject()
	{
		return subjectField.getText();
	}
	
	public String getMessage(){
		return messageField.getText();
	}
	public JFrame getFrame()
	{
		return frame;
	}
}
