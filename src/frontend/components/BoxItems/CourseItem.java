package frontend.components.BoxItems;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import backend.Listeners.CourseItemListener;
import frontend.components.PageNavigatorTest;
import shareddata.Course;

@SuppressWarnings("serial")
public class CourseItem extends BoxItem{
	
	private Course course;
	private JButton active, viewStudents, addStudents, viewAssignments, addAssignment, emailStudents, emailProf;
	private CourseItemListener listener;
	
	public CourseItem(Course c, PageNavigatorTest p, boolean isProf) {
		
		super(c.getName());
		course = c;
		listener = new CourseItemListener(this, p);
		viewAssignments= new JButton("View Assignments");
		viewAssignments.addActionListener(listener);
		viewAssignments.setBackground(Color.black);
		viewAssignments.setForeground(Color.white);
		add(viewAssignments);
		
		if(isProf == true){
		active = new JButton("Set Active");
		active.addActionListener(listener);
		if(course.getStatus() == true)
			active.setForeground(Color.white);
		else
			active.setForeground(Color.red);
		active.setBackground(Color.black);
		
		viewStudents = new JButton("View Students");
		viewStudents.addActionListener(listener);
		viewStudents.setBackground(Color.black);
		viewStudents.setForeground(Color.white);
		
		addStudents = new JButton("Add Students");
		addStudents.addActionListener(listener);
		addStudents.setBackground(Color.black);
		addStudents.setForeground(Color.white);
		
		addAssignment = new JButton("Add Assignment");
		addAssignment.addActionListener(listener);
		addAssignment.setBackground(Color.black);
		addAssignment.setForeground(Color.white);
		
		emailStudents = new JButton("Email Students");
		emailStudents.addActionListener(listener);
		emailStudents.setBackground(Color.black);
		emailStudents.setForeground(Color.white);
		
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

}
