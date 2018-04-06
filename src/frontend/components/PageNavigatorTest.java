package frontend.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.CardLayout;
import javax.swing.SwingConstants;

import frontend.Client;
import frontend.LoginWindow;
import shareddata.LoginInfo;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class PageNavigatorTest {

	private JFrame frame;
	private JButton btnJustDoesNothing;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String name;
	/**
	 * Create the application.
	 */
	public PageNavigatorTest(ObjectInputStream in, ObjectOutputStream out) {
		initialize();
		addActionListeners();
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
		gridBagLayout.rowHeights = new int[]{51, 71, 472, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDesirelearn = new JLabel("Desire3Learn");
		lblDesirelearn.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDesirelearn.setForeground(Color.ORANGE);
		lblDesirelearn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(lblDesirelearn, BorderLayout.WEST);
		
		JLabel lblWelcome = new JLabel("Welcome:" + name);
		lblWelcome.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(lblWelcome, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
		
		btnJustDoesNothing = new JButton("Just does nothing");
		panel.add(btnJustDoesNothing);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		frame.setVisible(true);
		
	}
	
	public void setName(String s){
		name = s;
	}
	public void setVisible(boolean b)
	{
		frame.setVisible(b);
	}
	public void addActionListeners()
	{
		btnJustDoesNothing.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg1)
			{
				System.out.println("Does nothing");
			}
			
		});
	}


}
