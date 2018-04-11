package frontend.components.BoxItems;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import backend.Listeners.CourseItemListener;
import shareddata.Course;

public class CourseItem extends BoxItem{
	private Course course;
	private JButton active, viewStudents, addStudents, viewAssignments, addAssignment, emailStudents, emailProf;
	private CourseItemListener listener;
	
	public CourseItem(Course c, boolean isProf) {
		
		super(c.getName());
		course = c;
		listener = new CourseItemListener(null, null);
		viewAssignments= new JButton("View Assignments");
		viewAssignments.addActionListener(listener);
		add(viewAssignments);
		
		if(isProf == true){
		active = new JButton("Set Active");
		active.addActionListener(listener);
		if(course.getStatus() == true)
			active.setForeground(Color.black);
		else
			active.setForeground(Color.red);
		viewStudents = new JButton("View Students");
		viewStudents.addActionListener(listener);
		addStudents = new JButton("Add Students");
		addStudents.addActionListener(listener);
		addAssignment = new JButton("Add Assignment");
		addAssignment.addActionListener(listener);
		emailStudents = new JButton("Email Students");
		emailStudents.addActionListener(listener);
		add(emailStudents);
		add(addAssignment);
		add(active);
		add(viewStudents);
		add(addStudents);
		}
		else{
			emailProf = new JButton("Email Professor");
			emailProf.addActionListener(listener);
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
}
