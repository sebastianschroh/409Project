package frontend.components;


import javax.swing.*;

import backend.AddCourseListener;

import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import frontend.Client;
import frontend.LoginWindow;
import frontend.pages.Page;
import shareddata.Course;
import shareddata.LoginInfo;
import shareddata.Professor;

public class PageNavigatorTest {

	private JFrame frame;
	private JLabel lblWelcome;
	private Professor professor;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String name;
	private JPanel panel;
	private JPanel panel_2;
	private JButton btnAddCourse;
	private JButton btnSearchStudent;
	private ArrayList<Course> course = null;
	private JButton btnRefresh;
	/**
	 * Create the application.
	 */
	public PageNavigatorTest(ObjectInputStream in, ObjectOutputStream out, Professor p) {
		this.in = in;
		this.out = out;
		professor = p;
		this.in = in;
		this.out = out;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 665);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{19, 737, 0};
		gridBagLayout.rowHeights = new int[]{51, -75, 472, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setBackground(Color.white);
		
		JLabel lblDesirelearn = new JLabel("Desire3Learn");
		lblDesirelearn.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDesirelearn.setForeground(Color.ORANGE);
		lblDesirelearn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(lblDesirelearn, BorderLayout.WEST);
		
		lblWelcome = new JLabel("Welcome:");
		lblWelcome.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(lblWelcome, BorderLayout.EAST);
		
		panel = new JPanel();
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
		panel.setBackground(Color.black);
		btnSearchStudent = new JButton("Search Student");
		panel.add(btnSearchStudent);
		
		btnAddCourse = new JButton("Add course");
		panel.add(btnAddCourse);

		btnAddCourse.addActionListener(new AddCourseListener(this));

		btnRefresh = new JButton("Refresh");
		panel.add(btnRefresh);
		
		btnRefresh.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				panel_2.removeAll();

				for(int i = 0; i < course.size(); i++)
				{
					final CourseItem temp = new CourseItem(course.get(i));
					temp.getActive().addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent arg1) {
							JButton button = (JButton)arg1.getSource();
							sendObject(temp.getCourse());
							sendObject("setCourseActivity");
							Course c = null;
							try {
								c = (Course) in.readObject();
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							if(c.getStatus() == true)
							{
								button.setForeground(Color.black);
							}
							else
							{
								button.setForeground(Color.red);
							}
						}
					});
					
					temp.getView().addActionListener(new ActionListener(){
						
						public void actionPerformed(ActionEvent arg1){
							Page page = new Page(temp.getCourse().getName());
						}
					});
					panel_2.add(temp);
				}
				panel_2.revalidate();
				panel_2.repaint();
			}

			});

				
		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		sendObject(professor);

		sendObject("getcourses");
		course = null;
		try {
			course = (ArrayList<Course>) in.readObject();
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (IOException e) {
					e.printStackTrace();
		}
		for(int i = 0; i < course.size(); i ++) {
		final CourseItem courseItem = new CourseItem(course.get(i));
		courseItem.getActive().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg1) {
				JButton button = (JButton)arg1.getSource();
				sendObject(courseItem.getCourse());
				sendObject("setCourseActivity");
				Course c = null;
				try {
					c = (Course) in.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(c.getStatus() == true)
				{
					button.setForeground(Color.black);
				}
				else
				{
					button.setForeground(Color.red);
				}
			}
		});
		
		courseItem.getView().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg1){
				Page page = new Page(courseItem.getCourse().getName());
			}
		});
		panel_2.add(courseItem);
		}
		frame.setVisible(true);
		
	}
	
	public void sendObject(Object s)
	{
		try {
		out.writeObject(s);
		out.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void setName(String s)
	{
		lblWelcome.setText("Welcome: " + s);
	}
	
	public void setVisible(boolean b)
	{
		frame.setVisible(b);
	}
	
	public Professor getProfessor()
	{
		return professor;
	}
	
	public Object readObject()
	{
		Object obj = null;
		try {
			obj = in.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public ArrayList<Course> getCourseList()
	{
		return this.course;
	}

}
