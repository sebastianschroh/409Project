package frontend.components;

import java.util.ArrayList;

import javax.swing.JFrame;

import shareddata.Assignment;

public class AssignmentView extends JFrame{
	
	private ArrayList<Assignment> list;
	
	public AssignmentView(ArrayList<Assignment> arr) {
		list = arr;
		
	}
}
