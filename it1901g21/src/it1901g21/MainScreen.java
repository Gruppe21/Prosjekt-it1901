package it1901g21;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;


public class MainScreen extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(297, 55, 368, 349);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Add Sheep");
		btnNewButton.setBounds(38, 99, 89, 45);
		contentPane.add(btnNewButton);
		
		JButton btnDelSheep = new JButton("Del Sheep");
		btnDelSheep.setBounds(152, 99, 89, 45);
		contentPane.add(btnDelSheep);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setBounds(38, 155, 89, 45);
		contentPane.add(btnProfile);
		
		JButton btnAlarm = new JButton("Alarm");
		btnAlarm.setBackground(Color.RED);
		btnAlarm.setBounds(152, 155, 89, 45);
		contentPane.add(btnAlarm);
		
		this.setVisible(true);
	}
}
