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
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterSheep = new JLabel("Send Email?");
		lblPleaseEnterSheep.setBounds(156, 74, 70, 16);
		frame.getContentPane().add(lblPleaseEnterSheep);
		
		JButton btnConfirm = new JButton("Yes");
		btnConfirm.setBounds(237, 101, 115, 37);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("No");
		btnCancel.setBounds(47, 101, 103, 37);
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
