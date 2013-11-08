package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DelSheep {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Initialize the contents of the frame.
	 */
	public DelSheep() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblPleaseEnterSheep = new JLabel("Please enter Sheep ID:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPleaseEnterSheep, 67, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPleaseEnterSheep, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblPleaseEnterSheep);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblPleaseEnterSheep);
		springLayout.putConstraint(SpringLayout.WEST, textField, 33, SpringLayout.EAST, lblPleaseEnterSheep);
		springLayout.putConstraint(SpringLayout.EAST, textField, -56, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		springLayout.putConstraint(SpringLayout.NORTH, btnConfirm, 29, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, btnConfirm, -30, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnConfirm, -42, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 32, SpringLayout.SOUTH, lblPleaseEnterSheep);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancel, -30, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnConfirm, 111, SpringLayout.EAST, btnCancel);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 47, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCancel, 147, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeDelSheep();
			}
		});
		
		frame.setVisible(true);
	}
	private void closeDelSheep(){
		frame.setVisible(false);
	}
}
