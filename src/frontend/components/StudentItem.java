package frontend.components;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import shareddata.Student;

public class StudentItem extends JPanel {
	private Student student;
	private boolean enrolled;
	private JButton enrollmentButton;
	/**
	 * Create the panel.
	 */
	public StudentItem(Student s) {
		student = s;
		enrollmentButton = new JButton("Enroll");
		enrollmentButton.setHorizontalAlignment(SwingConstants.RIGHT);
		add(enrollmentButton);
	}
	
	public void changeEnrollStatus(){
		if(enrolled == true)
			enrolled = false;
		else
			enrolled = true;
	}
}
