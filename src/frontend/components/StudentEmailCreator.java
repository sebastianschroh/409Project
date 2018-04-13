package frontend.components;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import backend.Listeners.*;
import frontend.components.BoxItems.*;

public class StudentEmailCreator {


	private JFrame frame;
	private JTextArea subjectArea;
	private JTextArea messageArea;
	private JButton sendButton;
	private PageNavigatorTest p;
	private CourseItem c;
	/**
	 * Create the application.
	 */
	public StudentEmailCreator(PageNavigatorTest p, CourseItem c) {
		this.p = p;
		this.c = c;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setBounds(10, 16, 40, 14);
		panel.add(lblSubject);
		
		subjectArea = new JTextArea();
		subjectArea.setBounds(60, 11, 364, 22);
		panel.add(subjectArea);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setBounds(4, 57, 46, 14);
		panel.add(lblMessage);
		
		messageArea = new JTextArea();
		messageArea.setBounds(60, 55, 364, 176);
		panel.add(messageArea);
		
		sendButton= new JButton("Send");
		sendButton.addActionListener(new CreateEmailListener(this.p, this.c, this));
		sendButton.setBounds(195, 238, 89, 23);
		panel.add(sendButton);
	}
	
	public String getSubject(){
		return subjectArea.getText();
	}
	public String getMessage(){
		return messageArea.getText();
	}
	public JFrame getFrame(){
		return frame;
	}

	public JButton getButton(){
		return sendButton;
	}

}
