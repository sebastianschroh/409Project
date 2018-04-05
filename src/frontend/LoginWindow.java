package frontend;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;

public class LoginWindow {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblPasswordError;
	private JButton btnLogin;
	private boolean correctInfo;

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
		initializeActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 497, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(30, 140, 62, 13);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(30, 163, 62, 13);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(102, 137, 179, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLogin.setBounds(291, 136, 125, 40);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(102, 160, 179, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel lblDesirelearn = new JLabel("Desire3Learn");
		lblDesirelearn.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDesirelearn.setForeground(Color.ORANGE);
		lblDesirelearn.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblDesirelearn.setBounds(102, 31, 237, 40);
		frame.getContentPane().add(lblDesirelearn);
		
		lblPasswordError = new JLabel("");
		lblPasswordError.setBounds(102, 195, 314, 13);
		frame.getContentPane().add(lblPasswordError);
		
		frame.setVisible(true);
	}
	
	private void initializeActionListeners() {
		
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg1) {
				
				lblPasswordError.setText("Password or username is incorrect!");
			}
			});
		}
	}

