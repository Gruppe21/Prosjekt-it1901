package GUI;

import it1901g21.Main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Alarm {
	
	private Main main;
	
	private JFrame frame;

	/**
	 * Initialize the contents of the frame.
	 */
	public Alarm(Main main) {
		
		this.main = main;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblPleaseEnterSheep = new JLabel("Send Email?");
		springLayout.putConstraint(SpringLayout.NORTH, lblPleaseEnterSheep, 66, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblPleaseEnterSheep, -149, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblPleaseEnterSheep);
		
		JButton btnConfirm = new JButton("Yes");
		springLayout.putConstraint(SpringLayout.NORTH, btnConfirm, 101, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnConfirm, -27, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnConfirm, -42, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("No");
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 101, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnConfirm, 87, SpringLayout.EAST, btnCancel);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 47, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCancel, 150, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnCancel);
		
		/*
		 * Action to happen when user clicks "no"
		 */
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeAlarm();
			}
		});
		
		/*
		 * Action to happen when user clicks "yes"
		 */
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		
		openAlarm();
		
	}
	
	
	/**
	 * Opens the delSheep window
	 */
	public void openAlarm() {
		frame.setVisible(true);
	}
	
	/**
	 * Closes the delSheep window
	 */
	private void closeAlarm(){
		frame.setVisible(false);
	}
}
