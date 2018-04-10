package frontend.components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import shareddata.Course;

public class CourseItem extends JPanel{
	private Course course;
	private JLabel label;
	private JButton active;
	private JButton view;
	
	public CourseItem(Course c) {
		course = c;
		label = new JLabel(c.getName());
		setLayout(new FlowLayout());
		add(label);
		active = new JButton("Set Active");
		if(course.getStatus() == true)
			active.setForeground(Color.black);
		else
			active.setForeground(Color.red);
		view = new JButton("View Course");
		add(active);
		add(view);
	}
	
	public JButton getActive() {
		return active;
	}
	
	public JButton getView() {
		return view;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course c)
	{
		course = c;
	}
}
