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
	private JButton active, viewSubmissions, viewStudents, addStudents, viewAssignments, addAssignment, emailStudents;
	private CourseItemListener listener;
	
	public CourseItem(Course c, boolean isProf) {
		super(c.getName());
		course = c;
		listener = new CourseItemListener(null, null);
		if(isProf == true){
		active = new JButton("Set Active");
		active.addActionListener(listener);
		if(course.getStatus() == true)
			active.setForeground(Color.black);
		else
			active.setForeground(Color.red);
		viewSubmissions = new JButton("View Submissions");
		viewSubmissions.addActionListener(listener);
		viewStudents = new JButton("View Students");
		viewStudents.addActionListener(listener);
		addStudents = new JButton("Add Students");
		addStudents.addActionListener(listener);
		add(active);
		add(viewStudents);
		add(viewSubmissions);
		add(addStudents);
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
