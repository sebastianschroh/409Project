package frontend.components.BoxItems;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BoxItem extends JPanel{
	private JLabel label;
	
	public BoxItem(String s){
		setLayout(new FlowLayout());
		label = new JLabel(s);
		label.setForeground(Color.white);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		add(label);
		this.setPreferredSize(new Dimension(941,100));
		this.setMinimumSize(new Dimension(941,100));
		this.setMaximumSize(new Dimension(941,100));
		this.setBackground(Color.black);
	}
}
