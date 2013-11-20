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
	
	private Farmer farmer;
	private Main main;
	private Profile profile;
	
	private JFrame frame;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtContactMail;
	private JTextField txtContactPhone;

	/**
	 * Create the application.
	 */
	public EditProfile(Main main, Profile profile) {
		this.main = main;
		farmer = this.main.getFarmer();
		this.profile = profile;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 340, 263);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 31, 38, 16);
		frame.getContentPane().add(lblName);
		
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
		txtName.setText(farmer.getName());
		txtName.setBounds(133, 28, 178, 22);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText(farmer.getMail());
		txtEmail.setBounds(133, 57, 178, 22);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setText(farmer.getTlf());
		txtPhone.setBounds(133, 86, 178, 22);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		txtContactMail = new JTextField();
		txtContactMail.setText(farmer.getResMail());
		txtContactMail.setBounds(133, 115, 178, 22);
		frame.getContentPane().add(txtContactMail);
		txtContactMail.setColumns(10);
		
		txtContactPhone = new JTextField();
		txtContactPhone.setText(farmer.getResTlf());
		txtContactPhone.setBounds(133, 144, 178, 22);
		frame.getContentPane().add(txtContactPhone);
		txtContactPhone.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(21, 179, 97, 25);
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
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String rName = txtName.getText();
				String rEmail = txtEmail.getText();
				String rPhone = txtPhone.getText();
				String rContactMail = txtContactMail.getText();
				String rContactPhone = txtContactPhone.getText();

				edit(rName,rEmail,rPhone,rContactMail,rContactPhone);
				
			}
			
		});
		
		frame.setVisible(true);
	}


	/**
	 * Close window method
	 */
	private void closeEditProfile(){
		frame.setVisible(false);
	}
	
	/**
	 * Send update request to SQL for profile editing.
	 * @param name
	 * @param Email
	 * @param phoneNumber
	 * @param contactEmail
	 * @param contactPhone
	 */
	private void edit(String name, String Email, String phoneNumber, 
		String contactEmail, String contactPhone){
		
		if (name.length()>=25){
			ErrorMessage errorMsg = new ErrorMessage("", "Name is too long!");
			return;
		}
		
		if (Email.length()>=55||contactEmail.length()>=55){
			ErrorMessage errorMsg = new ErrorMessage("", "E-mail is too long!");
			return;
		}
		
		if (contactPhone.length()>12||phoneNumber.length()>12){
			ErrorMessage errorMsg = new ErrorMessage("", "Phone number is too long!");
			return;
		}
		
		if (!isNumeric(contactPhone)) {
			ErrorMessage error = new ErrorMessage("", "Please only use numbers for Phone number(s)!");
			return;
		}
		
		if (!isNumeric(phoneNumber)) {
			ErrorMessage error = new ErrorMessage("", "Please only use numbers for Phone number(s)!");
			return;
		}
		
		// Sends the edit request to main
		main.updateEditProfile(name, Email, phoneNumber, contactEmail, contactPhone, farmer.getId());
		
		// Updates the personal information instantaneously
		profile.updateInfo();
		
		// Closes the edit-profile window
		closeEditProfile();
	}
	
	private boolean isNumeric(String string) {
		for (char c : string.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}


}
