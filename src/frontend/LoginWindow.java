package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

<<<<<<< HEAD
public class LoginWindow {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
=======
public class LoginWindow extends JFrame{
	
	public LoginWindow()
	{
		this.setTitle("Login");
		this.setLayout(new BorderLayout());
		this.setSize(800,500);
		this.setResizable(false);
		JPanel center = new JPanel();
		center.setBorder(new EmptyBorder(20,20,20,20));
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		JLabel d3l = new JLabel(new ImageIcon("C:/School/softeng_yr2/ENSF409/TermProject/409Project/Desire3Learn.png"));
		center.add(d3l);
		this.add(center, BorderLayout.CENTER);
		//center.add(Box.createVeritcalGlue());
		JPanel pane1 = new JPanel();
		pane1.setLayout(new FlowLayout());
		pane1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pane1.add(new JLabel("Username: "));
		pane1.add(new JTextField(20));
		center.add(pane1);
		center.add(Box.createHorizontalGlue());
		this.add(center, BorderLayout.CENTER);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//JFrame frame = (JFrame) e.getSource();
				int result = JOptionPane.showConfirmDialog((JFrame) e.getSource(), "Are you sure you want to exit the application?",
						"Exit Application", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION)
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>>>>>>> f82842e94348e8c45da86a9cac9441afed42c2c2
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
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
		
		JButton btnLogin = new JButton("Login");
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
	}
}
