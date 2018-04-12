package frontend.components.BoxItems;

import java.awt.Color;
import java.awt.Font;

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
			enroll.setBackground(Color.black);
			enroll.setForeground(Color.white);
			enroll.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
			add(enroll);
		}
		if(c == 'u'){
			unenroll = new JButton("Unenroll Student");
			unenroll.addActionListener(listener);
			unenroll.setBackground(Color.black);
			unenroll.setForeground(Color.white);
			unenroll.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
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
