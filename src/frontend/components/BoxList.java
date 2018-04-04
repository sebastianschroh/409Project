package frontend.components;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class BoxList extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollBox;
	private JPanel boxList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoxList frame = new BoxList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BoxList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollBox = new JScrollPane();
		contentPane.add(scrollBox, BorderLayout.CENTER);
		
		boxList = 
				new JPanel();
		scrollBox.setViewportView(boxList);
	}
	
	public <T extends Box> void addItem(T boxItem){
		boxList.add(boxItem);
	}
	
	public <T extends Box> void setItems(ArrayList<T> boxItems){
		for(int i = 0; i < boxItems.size(); i ++)
			boxList.add(boxItems.get(i));
	}

}
