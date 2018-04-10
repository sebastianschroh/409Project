package frontend.components.BoxItems;

import javax.swing.JButton;

import backend.Listeners.StudentItemListener;
import shareddata.Student;

public class StudentItem extends BoxItem{
	
	private StudentItemListener listener;
	private JButton enroll, unenroll;
	private Student student;
	
	public StudentItem(Student s, char c){
		super(s.getFirstName());
		student = s;
		listener = new StudentItemListener();
		if(c == 'e'){
			enroll = new JButton("Enroll Student");
			enroll.addActionListener(listener);
			add(enroll);
		}
		if(c == 'u'){
			unenroll = new JButton("Unenroll Student");
			unenroll.addActionListener(listener);
			add(unenroll);
		}
		
	}

}
