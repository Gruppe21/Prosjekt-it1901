package GUI;

import it1901g21.Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Alarm {
	
	private Main main;
	
	private JFrame frame;
	private JLabel sending;

	private void mailsender(String farmer_mail, String farmer_name, String timestamp, String sheepId, String sheepX, String sheepY){
		main.mailAlert(farmer_mail, farmer_name, timestamp, sheepId, sheepX, sheepY);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public Alarm(final Main main) {
		
		this.main = main;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterSheep = new JLabel("Send Email?");
		lblPleaseEnterSheep.setBounds(156, 74, 70, 16);
		frame.getContentPane().add(lblPleaseEnterSheep);
		
		sending = new JLabel();
		sending.setBounds(47, 142, 200, 30);
		sending.setForeground(new Color(18, 100, 9));
		frame.getContentPane().add(sending);
		
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
				
				Random rng = new Random();
				int rngint = rng.nextInt(main.getFarmer().getSheepHerd().size());
				
				mailsender(main.getFarmer().getMail(), 
						main.getFarmer().getName(), 
						main.getCurrentTime().toString(), 
						main.getFarmer().getSheepHerd().get(rngint).getEarTag(), 
						main.getFarmer().getSheepHerd().get(rngint).getXPos(), 
						main.getFarmer().getSheepHerd().get(rngint).getYPos());
				
				mailsender(main.getFarmer().getResMail(), 
						main.getFarmer().getName(), 
						main.getCurrentTime().toString(), 
						main.getFarmer().getSheepHerd().get(rngint).getEarTag(), 
						main.getFarmer().getSheepHerd().get(rngint).getXPos(), 
						main.getFarmer().getSheepHerd().get(rngint).getYPos());
				
				closeAlarm();
				
			}
		});
		
		openAlarm();
		
	}
	
	private void setSendingText(String text) {
		sending.setText(text);
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
