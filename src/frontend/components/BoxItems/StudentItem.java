package frontend.components.BoxItems;

import javax.swing.JButton;

import backend.Listeners.StudentItemListener;
import shareddata.Student;
import frontend.components.*;

public class StudentItem extends BoxItem{
	
	private StudentItemListener listener;
	private JButton enroll, unenroll;
	private Student student;
	
	public StudentItem(Student s, PageNavigatorTest p, char c){
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
	public Student getStudent(){
		return student;
	}
	
	public void setStudent(Student s){
		student = s;
	}
}
