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
import javax.swing.JTextField;

public class EditProfile {
	
	private Main main;
	private JFrame frame;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtContactMail;
	private JTextField txtContactPhone;

	/**
	 * Create the application.
	 */
	public EditProfile(Main main) {
		this.main = main;
		Farmer farmer = this.main.getFarmer();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 340, 263);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblFirstName = new JLabel("Name:");
		lblFirstName.setBounds(10, 31, 38, 16);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 60, 41, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setBounds(10, 89, 88, 16);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblContactPersonName = new JLabel("Contact mail:");
		lblContactPersonName.setBounds(10, 118, 76, 16);
		frame.getContentPane().add(lblContactPersonName);
		
		JLabel lblContactPhone = new JLabel("Contact Phone:");
		lblContactPhone.setBounds(11, 147, 87, 16);
		frame.getContentPane().add(lblContactPhone);
		
		JLabel lblGetLastName = new JLabel();
		lblGetLastName.setBounds(73, 53, 0, 0);
		frame.getContentPane().add(lblGetLastName);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(195, 28, 116, 22);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("E-mail");
		txtEmail.setBounds(195, 57, 116, 22);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setText("Phone");
		txtPhone.setBounds(195, 86, 116, 22);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		txtContactMail = new JTextField();
		txtContactMail.setText("Contact mail");
		txtContactMail.setBounds(195, 115, 116, 22);
		frame.getContentPane().add(txtContactMail);
		txtContactMail.setColumns(10);
		
		txtContactPhone = new JTextField();
		txtContactPhone.setText("Contact Phone");
		txtContactPhone.setBounds(195, 144, 116, 22);
		frame.getContentPane().add(txtContactPhone);
		txtContactPhone.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 178, 97, 25);
		frame.getContentPane().add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeEditProfile();
			}
		});
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(214, 179, 97, 25);
		frame.getContentPane().add(btnDone);
		frame.getRootPane().setDefaultButton(btnDone);
		
		
		frame.setVisible(true);
	}


	/**
	 * Close window method
	 */
	private void closeEditProfile(){
		frame.setVisible(false);
	}
}
