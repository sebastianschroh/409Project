package frontend.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import backend.Listeners.CourseItemListener;
import shareddata.Course;

@SuppressWarnings("serial")
public class CourseItem extends JPanel{
	
	
	private Course course;
	private JLabel label;
	private JButton active;
	private JButton view;
	
	public CourseItem(Course c, PageNavigatorTest p) {
		course = c;
		label = new JLabel(c.getName());
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		setLayout(new FlowLayout());
		add(label);
		active = new JButton("Set Active");
		active.setBackground(Color.black);
		if(course.getStatus() == true)
			active.setForeground(Color.white);
		else
			active.setForeground(Color.red);
		view = new JButton("View Course");
		view.setBackground(Color.black);
		view.setForeground(Color.white);
		active.addActionListener(new CourseItemListener(this, p));
		active.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		view.addActionListener(new CourseItemListener(this, p));
		view.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		this.setMaximumSize(new Dimension(600,100));
		this.setMinimumSize(new Dimension(600,100));
		this.setPreferredSize(new Dimension(600,100));
		this.setBackground(Color.white);
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
