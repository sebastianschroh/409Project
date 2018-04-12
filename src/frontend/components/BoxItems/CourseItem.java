package frontend.components.BoxItems;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;

import backend.Listeners.CourseItemListener;
import frontend.components.PageNavigatorTest;
import shareddata.*;

@SuppressWarnings("serial")
public class CourseItem extends BoxItem{
	
	private Course course;
	private JButton active, viewStudents, addStudents, viewAssignments, addAssignment, emailStudents, emailProf;
	private CourseItemListener listener;
	
	private ArrayList<Student> students;
	
	public CourseItem(Course c, PageNavigatorTest p, boolean isProf) {
		
		super(c.getName());
		
		course = c;
		p.sendObject(course);
		p.sendObject("getstudents");
		students = (ArrayList<Student>) p.readObject();
		
		listener = new CourseItemListener(this, p);
		viewAssignments= new JButton("View Assignments");
		viewAssignments.addActionListener(listener);
		viewAssignments.setBackground(Color.black);
		viewAssignments.setForeground(Color.white);
		viewAssignments.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		add(viewAssignments);
		
		if(isProf == true){
		active = new JButton("Set Active");
		active.addActionListener(listener);
		active.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		if(course.getStatus() == true)
			active.setForeground(Color.white);
		else
			active.setForeground(Color.red);
		active.setBackground(Color.black);
		
		viewStudents = new JButton("View Students");
		viewStudents.addActionListener(listener);
		viewStudents.setBackground(Color.black);
		viewStudents.setForeground(Color.white);
		viewStudents.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		addStudents = new JButton("Add Students");
		addStudents.addActionListener(listener);
		addStudents.setBackground(Color.black);
		addStudents.setForeground(Color.white);
		addStudents.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		addAssignment = new JButton("Add Assignment");
		addAssignment.addActionListener(listener);
		addAssignment.setBackground(Color.black);
		addAssignment.setForeground(Color.white);
		addAssignment.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		emailStudents = new JButton("Email Students");
		emailStudents.addActionListener(listener);
		emailStudents.setBackground(Color.black);
		emailStudents.setForeground(Color.white);
		emailStudents.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		add(emailStudents);
		add(addAssignment);
		add(active);
		add(viewStudents);
		add(addStudents);
		}
		else{
			emailProf = new JButton("Email Professor");
			emailProf.addActionListener(listener);
			emailProf.setBackground(Color.black);
			emailProf.setForeground(Color.white);
			emailProf.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
			add(emailProf);
		}

	}
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course c)
	{
		course = c;
	}
	
	public JButton getActive()
	{
		return active;
	}
	
	public JButton getViewAssignments()
	{
		return viewAssignments;
	}
	
	public JButton getViewStudents()
	{
		return viewStudents;
	}
	
	public ArrayList<Student> getStudentList()
	{
		return students;
	}

	public JButton getEmailStudents(){
		return emailStudents;
	}

}
