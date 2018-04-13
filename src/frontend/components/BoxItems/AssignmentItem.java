package frontend.components.BoxItems;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import backend.Listeners.AssignmentItemListener;
import frontend.components.PageNavigatorTest;
import shareddata.*;

@SuppressWarnings("serial")
public class AssignmentItem extends BoxItem{
	
	private JButton viewSubmissions, setActive, submit, viewGrade;
	private JLabel studentGrade;
	private AssignmentItemListener listener;
	private Assignment assignment;
	
	private ArrayList<Submission> submissions;
	
	@SuppressWarnings("unchecked")
	public AssignmentItem(Assignment a, PageNavigatorTest p, CourseItem c){
		super(a.getTitle());
		listener = new AssignmentItemListener(this,c,p);
		assignment = a;
		
		p.sendObject(a);
		p.sendObject("getsubmissions");
		
		submissions = (ArrayList<Submission>) p.readObject();
		
		if(p.isProf()){
		viewSubmissions = new JButton("View Submissions");
		viewSubmissions.addActionListener(listener);
		viewSubmissions.setBackground(Color.black);
		viewSubmissions.setForeground(Color.white);
		viewSubmissions.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		setActive = new JButton("Set Active");
		setActive.addActionListener(listener);
		setActive.setBackground(Color.black);
		if(assignment.getStatus() == true)
			setActive.setForeground(Color.white);
		else
			setActive.setForeground(Color.red);
		setActive.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		add(viewSubmissions);
		add(setActive);
		}
		else{
			submit = new JButton("Upload Submission");
			submit.addActionListener(listener);
			submit.setBackground(Color.black);
			submit.setForeground(Color.white);
			submit.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			
			viewGrade = new JButton("View Grade");
			viewGrade.addActionListener(listener);
			viewGrade.setBackground(Color.black);
			viewGrade.setForeground(Color.white);
			viewGrade.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			
			studentGrade = new JLabel("Click to view");
			studentGrade.setForeground(Color.white);
			studentGrade.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			
			add(submit);
			add(viewGrade);
			add(studentGrade);
		}
	}
	
	public Assignment getAssignment(){
		return assignment;
	}
	
	public void setAssignment(Assignment a){
		assignment = a;
	}
	
	public JButton getSetActive()
	{
		return setActive;
	}
	
	public JButton getViewSubmissions()
	{
		return viewSubmissions;
	}
	
	public JButton getSubmit()
	{
		return submit;
	}
	public JButton getViewGrade()
	{
		return viewGrade;
	}
	public void setStudentGrade(String s)
	{
		studentGrade.setText(s);
	}
	public JLabel getStudentGrade()
	{
		return studentGrade;
	}
	public ArrayList<Submission> getSubmissions()
	{
		return submissions;
	}
}

