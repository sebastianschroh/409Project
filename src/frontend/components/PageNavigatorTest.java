package frontend.components;


import javax.swing.*;


import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import shareddata.*;
import javax.swing.border.EtchedBorder;

import backend.Listeners.*;

public class PageNavigatorTest {

	private JFrame frame;

	private User user;
	private boolean isProf;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	private JPanel panel;
	private JPanel holdPanel;
	private JScrollPane scrollPane;

	private ArrayList<Course> course = null;
	private JButton btnAddCourse;
	private JButton btnViewCourse;
	private JLabel lblWelcome;
	
	/**
	 * Create the application.
	 */
	public PageNavigatorTest(ObjectInputStream in, ObjectOutputStream out, User p) {
		this.in = in;
		this.out = out;
		if(p instanceof Professor)
		{
			user = (Professor) p;
			isProf = true;
		}
		else
		{
			user = (Student) p;
			isProf = false;
		}
		this.in = in;
		this.out = out;
		initialize();
		addActionListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.setBounds(100, 100, 945, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{941};
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
		panel_1.setBackground(Color.BLACK);
		
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
		panel.setBackground(Color.ORANGE);
		if(isProf)
		{
			btnAddCourse = new JButton("Add course");
			btnAddCourse.setForeground(Color.WHITE);
			btnAddCourse.setBackground(Color.ORANGE);
			btnAddCourse.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
			panel.add(btnAddCourse);
		}
		btnViewCourse = new JButton("View Courses");
		btnViewCourse.setForeground(Color.WHITE);
		btnViewCourse.setBackground(Color.ORANGE);
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
		holdPanel.setBackground(Color.BLACK);
		scrollPane.setViewportView(holdPanel);
		holdPanel.setLayout(new BoxLayout(holdPanel, BoxLayout.Y_AXIS));
		
		sendObject(user);
		sendObject("getcourses");
		
		course = (ArrayList<Course>) readObject();
		
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
	
	public void setName(String s)
	{
		lblWelcome.setText("Welcome: " + s);
	}
	
	public void setVisible(boolean b)
	{
		frame.setVisible(b);
	}
	
	public User getUser()
	{
		return user;
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
		this.scrollPane.setViewportView(p);
	}
	
	public JScrollPane getScrollPane()
	{
		return scrollPane;
	}
	
	public boolean isProf()
	{
		return isProf;
	}
}
