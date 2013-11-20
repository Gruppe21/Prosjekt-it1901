package GUI;

import it1901g21.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DelSheep {
	
	private Main main;
	
	private JFrame frame;
	private JTextField textField;

	/**
	 * Initialize the contents of the frame.
	 */
	public DelSheep(Main main) {
		
		this.main = main;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterSheep = new JLabel("Please enter the Sheep's ear tag:");
		lblPleaseEnterSheep.setBounds(10, 67, 192, 16);
		frame.getContentPane().add(lblPleaseEnterSheep);
		
		textField = new JTextField();
		textField.setBounds(237, 64, 115, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(237, 101, 115, 37);
		frame.getContentPane().add(btnConfirm);
		frame.getRootPane().setDefaultButton(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(47, 101, 103, 37);
		frame.getContentPane().add(btnCancel);
		
		/*
		 * Action to happen when user clicks "cancel"
		 */
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeDelSheep();
			}
		});
		
		/*
		 * Action to happen when user clicks "confirm"
		 */
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField.getText().equals("")) {
					ErrorMessage error = new ErrorMessage("", "Please enter the ear tag!");
					return;
				}
				
				String earTag = textField.getText();
				sendDeleteSheep(earTag);
				
			}
		});
		
	}
	
	
	/**
	 * Opens the delSheep window
	 */
	public void openDelSheep() {
		frame.setVisible(true);
	}
	
	/**
	 * Closes the delSheep window
	 */
	private void closeDelSheep(){
		frame.setVisible(false);
	}
	
	/**
	 * Sends the prompt to delete the sheep to Main
	 */
	private void sendDeleteSheep(String earTag) {
		
		if (main.deleteSheep(earTag)) {
			closeDelSheep();
			textField.setText(null);
		}
	}
	
}
