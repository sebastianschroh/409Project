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
	private ArrayList<String> emails;
	
	private ArrayList<Assignment> assignments;
	private PageNavigatorTest p;
	
	@SuppressWarnings("unchecked")
	public CourseItem(Course c, PageNavigatorTest p, boolean isProf) {
		
		super(c.getName());
		this.p = p;
		course = c;

		setEnrolledStudents();
		
		p.sendObject(course);
		p.sendObject("getassignments");
		
		assignments = (ArrayList<Assignment>) p.readObject();
		
		p.sendObject(course);
		p.sendObject("getEmails");
		
		emails = (ArrayList<String>) p.readObject();
		listener = new CourseItemListener(this, p);
		viewAssignments= new JButton("View Assignments");
		viewAssignments.addActionListener(listener);
		viewAssignments.setBackground(Color.black);
		viewAssignments.setForeground(Color.white);
		viewAssignments.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		add(viewAssignments);
		
		if(isProf == true){
		active = new JButton("Set Active");
		active.addActionListener(listener);
		active.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		if(course.getStatus() == true)
			active.setForeground(Color.white);
		else
			active.setForeground(Color.red);
		active.setBackground(Color.black);
		
		viewStudents = new JButton("View Students");
		viewStudents.addActionListener(listener);
		viewStudents.setBackground(Color.black);
		viewStudents.setForeground(Color.white);
		viewStudents.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		addStudents = new JButton("Add Students");
		addStudents.addActionListener(listener);
		addStudents.setBackground(Color.black);
		addStudents.setForeground(Color.white);
		addStudents.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		addAssignment = new JButton("Add Assignment");
		addAssignment.addActionListener(listener);
		addAssignment.setBackground(Color.black);
		addAssignment.setForeground(Color.white);
		addAssignment.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		emailStudents = new JButton("Email Students");
		emailStudents.addActionListener(listener);
		emailStudents.setBackground(Color.black);
		emailStudents.setForeground(Color.white);
		emailStudents.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
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
			emailProf.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			add(emailProf);
		}
		
		p.sendObject(course);
		p.sendObject("getstudents");
		
		students = (ArrayList<Student>) p.readObject();
	}
	public Course getCourse() {
		return course;
	}
	
	public void setUnenrolledStudents()
	{
		p.sendObject(course);
		p.sendObject("unenrolledStudents");
		students = (ArrayList<Student>)p.readObject();
		
	}
	
	public void setEnrolledStudents()
	{
		p.sendObject(course);
		p.sendObject("getstudents");
		students = (ArrayList<Student>)p.readObject();
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
	
	public JButton getAddStudents()
	{
		return addStudents;
	}
	
	public ArrayList<Student> getStudentList()
	{
		return students;
	}
	
	public void setStudentList(ArrayList<Student> s)
	{
		students = s;
	}
	
	public ArrayList<Assignment> getAssignmentList()
	{
		return assignments;
	}
	
	public void setAssignmentList(ArrayList<Assignment> a)
	{
		assignments = a;
	}

	public JButton getEmailStudents(){
		return emailStudents;
	}
	
	public ArrayList<String> getEmails(){
		return emails;
	}

}
