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
		farmer = this.main.getFarmer();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 340, 263);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblFirstName = new JLabel("Name:");
		lblFirstName.setBounds(20, 31, 38, 16);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(20, 60, 41, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setBounds(20, 89, 88, 16);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblContactPersonName = new JLabel("Contact mail:");
		lblContactPersonName.setBounds(20, 118, 76, 16);
		frame.getContentPane().add(lblContactPersonName);
		
		JLabel lblContactPhone = new JLabel("Contact Phone:");
		lblContactPhone.setBounds(20, 147, 87, 16);
		frame.getContentPane().add(lblContactPhone);
		
		JLabel lblGetLastName = new JLabel();
		lblGetLastName.setBounds(73, 53, 0, 0);
		frame.getContentPane().add(lblGetLastName);
		
		txtName = new JTextField();
		txtName.setText(farmer.getName());
		txtName.setBounds(195, 28, 116, 22);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText(farmer.getMail());
		txtEmail.setBounds(195, 57, 116, 22);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setText(farmer.getTlf());
		txtPhone.setBounds(195, 86, 116, 22);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		txtContactMail = new JTextField();
		txtContactMail.setText(farmer.getResMail());
		txtContactMail.setBounds(195, 115, 116, 22);
		frame.getContentPane().add(txtContactMail);
		txtContactMail.setColumns(10);
		
		txtContactPhone = new JTextField();
		txtContactPhone.setText(farmer.getResTlf());
		txtContactPhone.setBounds(195, 144, 116, 22);
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
		
		if (contactPhone.length()>=12||phoneNumber.length()>=12){
			ErrorMessage errorMsg = new ErrorMessage("", "Phone number is too long!");
			return;
		}
		
		main.updateEditProfile(name, Email, phoneNumber, contactEmail, contactPhone, farmer.getId());
		closeEditProfile();
	}
}
