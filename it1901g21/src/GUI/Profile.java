package GUI;

import it1901g21.Farmer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Profile {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Profile() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 259);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblFirstName = new JLabel("First name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 31, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 6, SpringLayout.SOUTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 0, SpringLayout.WEST, lblFirstName);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("E-mail");
		springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 6, SpringLayout.SOUTH, lblLastName);
		springLayout.putConstraint(SpringLayout.WEST, lblEmail, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPhoneNumber, 6, SpringLayout.SOUTH, lblEmail);
		springLayout.putConstraint(SpringLayout.WEST, lblPhoneNumber, 0, SpringLayout.WEST, lblFirstName);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblContactPersonName = new JLabel("Contact person name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblContactPersonName, 6, SpringLayout.SOUTH, lblPhoneNumber);
		springLayout.putConstraint(SpringLayout.WEST, lblContactPersonName, 0, SpringLayout.WEST, lblFirstName);
		frame.getContentPane().add(lblContactPersonName);
		
		JLabel lblContactPhone = new JLabel("Contact Phone:");
		springLayout.putConstraint(SpringLayout.NORTH, lblContactPhone, 6, SpringLayout.SOUTH, lblContactPersonName);
		springLayout.putConstraint(SpringLayout.WEST, lblContactPhone, 0, SpringLayout.WEST, lblFirstName);
		frame.getContentPane().add(lblContactPhone);
		
		JButton btnDone = new JButton("Done");
		springLayout.putConstraint(SpringLayout.SOUTH, btnDone, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnDone, -113, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnDone);
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeProfile();
			}
		});
		
		JLabel lblname = new JLabel(Farmer.class.getName());
		springLayout.putConstraint(SpringLayout.NORTH, lblname, 0, SpringLayout.NORTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblname, 6, SpringLayout.EAST, lblFirstName);
		frame.getContentPane().add(lblname);
		
		frame.setVisible(true);
	}


	/**
	 * Close window method
	 */
	private void closeProfile(){
		frame.setVisible(false);
	}
}
