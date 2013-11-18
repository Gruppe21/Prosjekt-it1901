package GUI;

import it1901g21.Farmer;
import it1901g21.Main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Profile {
	
	private Main main;
	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Profile(Main main) {
		this.main = main;
		Farmer farmer = this.main.getFarmer();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 259);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblFirstName = new JLabel("Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 31, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 6, SpringLayout.SOUTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, lblFirstName);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPhoneNumber, 6, SpringLayout.SOUTH, lblEmail);
		springLayout.putConstraint(SpringLayout.WEST, lblPhoneNumber, 0, SpringLayout.WEST, lblFirstName);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblContactPersonName = new JLabel("Contact mail:");
		springLayout.putConstraint(SpringLayout.NORTH, lblContactPersonName, 6, SpringLayout.SOUTH, lblPhoneNumber);
		springLayout.putConstraint(SpringLayout.WEST, lblContactPersonName, 0, SpringLayout.WEST, lblFirstName);
		frame.getContentPane().add(lblContactPersonName);
		
		JLabel lblContactPhone = new JLabel("Contact Phone:");
		springLayout.putConstraint(SpringLayout.NORTH, lblContactPhone, 6, SpringLayout.SOUTH, lblContactPersonName);
		springLayout.putConstraint(SpringLayout.WEST, lblContactPhone, 0, SpringLayout.WEST, lblFirstName);
		frame.getContentPane().add(lblContactPhone);
		
		JButton btnDone = new JButton("Done");
		springLayout.putConstraint(SpringLayout.SOUTH, btnDone, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnDone);
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeProfile();
			}
		});
		
		JLabel lblname = new JLabel(farmer.getName());
		springLayout.putConstraint(SpringLayout.EAST, btnDone, 0, SpringLayout.EAST, lblname);
		springLayout.putConstraint(SpringLayout.NORTH, lblname, 0, SpringLayout.NORTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblname, 6, SpringLayout.EAST, lblFirstName);
		springLayout.putConstraint(SpringLayout.SOUTH, lblname, 0, SpringLayout.SOUTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.EAST, lblname, -28, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblname);
		
		JLabel lblGetLastName = new JLabel();
		springLayout.putConstraint(SpringLayout.NORTH, lblGetLastName, 6, SpringLayout.SOUTH, lblname);
		springLayout.putConstraint(SpringLayout.WEST, lblGetLastName, 73, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblGetLastName);
		
		JLabel lvlGetEmail = new JLabel(farmer.getMail());
		springLayout.putConstraint(SpringLayout.NORTH, lvlGetEmail, 0, SpringLayout.NORTH, lblEmail);
		springLayout.putConstraint(SpringLayout.WEST, lvlGetEmail, 6, SpringLayout.EAST, lblEmail);
		frame.getContentPane().add(lvlGetEmail);
		
		JLabel lblGetTlf = new JLabel(farmer.getTlf());
		springLayout.putConstraint(SpringLayout.NORTH, lblGetTlf, 0, SpringLayout.NORTH, lblPhoneNumber);
		springLayout.putConstraint(SpringLayout.WEST, lblGetTlf, 8, SpringLayout.EAST, lblPhoneNumber);
		frame.getContentPane().add(lblGetTlf);
		
		JLabel lblgetContactname = new JLabel(farmer.getResMail());
		springLayout.putConstraint(SpringLayout.NORTH, lblgetContactname, 6, SpringLayout.SOUTH, lblPhoneNumber);
		springLayout.putConstraint(SpringLayout.WEST, lblgetContactname, 6, SpringLayout.EAST, lblContactPersonName);
		frame.getContentPane().add(lblgetContactname);
		
		JLabel lblgetContactPhone = new JLabel(farmer.getResTlf());
		springLayout.putConstraint(SpringLayout.NORTH, lblgetContactPhone, 0, SpringLayout.NORTH, lblContactPhone);
		springLayout.putConstraint(SpringLayout.WEST, lblgetContactPhone, 6, SpringLayout.EAST, lblContactPhone);
		frame.getContentPane().add(lblgetContactPhone);
		
		JButton btnEdit = new JButton("Edit");
		springLayout.putConstraint(SpringLayout.NORTH, btnEdit, 0, SpringLayout.NORTH, btnDone);
		springLayout.putConstraint(SpringLayout.EAST, btnEdit, 0, SpringLayout.EAST, lblContactPersonName);
		frame.getContentPane().add(btnEdit);
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditProfile editprofile = new EditProfile(getMain());
			}
		});
		
		frame.setVisible(true);
	}


	/**
	 * Close window method
	 */
	private void closeProfile(){
		frame.setVisible(false);
	}
	
	private Main getMain() {
		return main;
	}
}
