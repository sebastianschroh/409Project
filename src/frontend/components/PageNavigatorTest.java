package frontend.components;


import javax.swing.*;

import backend.Listeners.AddCourseListener;
import backend.Listeners.ViewCourseListener;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import shareddata.*;
import javax.swing.border.EtchedBorder;

public class PageNavigatorTest {

	private JFrame frame;
	private JLabel lblWelcome;
	private Professor professor;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private JPanel panel;
	private JPanel holdPanel;
	private JButton btnAddCourse;
	private ArrayList<Course> course = null;
	private JButton btnViewCourse;
	private JScrollPane scrollPane;
	private Component horizontalStrut;
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
		addActionListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 640, 665);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{618};
		gridBagLayout.rowHeights = new int[]{72, 31, 472, 0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
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
		lblDesirelearn.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		panel_1.add(lblDesirelearn, BorderLayout.WEST);
		
		lblWelcome = new JLabel("Welcome:");
		lblWelcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		lblWelcome.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(lblWelcome, BorderLayout.EAST);
		
		panel = new JPanel();
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
		panel.setBackground(Color.black);
		
		btnAddCourse = new JButton("Add course");
		btnAddCourse.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		panel.add(btnAddCourse);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(100, 0));
		panel.add(horizontalStrut);
		btnViewCourse = new JButton("View Courses");
		btnViewCourse.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		panel.add(btnViewCourse);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		

				
		holdPanel = new JPanel();
		scrollPane.setViewportView(holdPanel);
		holdPanel.setLayout(new BoxLayout(holdPanel, BoxLayout.Y_AXIS));
		
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
		frame.setVisible(true);
		
	}
	
	public void addActionListener()
	{
		btnAddCourse.addActionListener(new AddCourseListener(this));
		
		btnViewCourse.addActionListener(new ViewCourseListener(this));
		
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
	
	public JPanel getHoldPanel()
	{
		return holdPanel;
	}
	
	public void setHoldPanel(JPanel p)
	{
		this.holdPanel = p;
	}
	
	public JScrollPane getScrollPane()
	{
		return scrollPane;
	}
}
