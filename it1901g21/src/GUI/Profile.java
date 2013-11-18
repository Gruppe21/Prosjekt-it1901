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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("Name:");
		lblFirstName.setBounds(10, 31, 38, 16);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 53, 41, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setBounds(10, 75, 88, 16);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblContactPersonName = new JLabel("Contact mail:");
		lblContactPersonName.setBounds(10, 97, 76, 16);
		frame.getContentPane().add(lblContactPersonName);
		
		JLabel lblContactPhone = new JLabel("Contact Phone:");
		lblContactPhone.setBounds(10, 119, 87, 16);
		frame.getContentPane().add(lblContactPhone);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(205, 189, 61, 25);
		frame.getContentPane().add(btnDone);
		frame.getRootPane().setDefaultButton(btnDone);
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeProfile();
			}
		});
		
		JLabel lblname = new JLabel(farmer.getName());
		lblname.setBounds(54, 31, 212, 16);
		frame.getContentPane().add(lblname);
		
		JLabel lblGetLastName = new JLabel();
		lblGetLastName.setBounds(73, 53, 0, 0);
		frame.getContentPane().add(lblGetLastName);
		
		JLabel lvlGetEmail = new JLabel(farmer.getMail());
		lvlGetEmail.setBounds(57, 53, 65, 16);
		frame.getContentPane().add(lvlGetEmail);
		
		JLabel lblGetTlf = new JLabel(farmer.getTlf());
		lblGetTlf.setBounds(106, 75, 65, 16);
		frame.getContentPane().add(lblGetTlf);
		
		JLabel lblgetContactname = new JLabel(farmer.getResMail());
		lblgetContactname.setBounds(92, 97, 65, 16);
		frame.getContentPane().add(lblgetContactname);
		
		JLabel lblgetContactPhone = new JLabel(farmer.getResTlf());
		lblgetContactPhone.setBounds(103, 119, 65, 16);
		frame.getContentPane().add(lblgetContactPhone);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(25, 189, 61, 25);
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
