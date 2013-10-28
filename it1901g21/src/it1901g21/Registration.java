package it1901g21;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JTextField textField_4;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField textField_5;
	private JLabel lblPhoneNumber;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblContactPersonName;
	private JLabel lblContactPersonNumber;

	

	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(157, 47, 219, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(157, 140, 219, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(21, 50, 46, 14);
		contentPane.add(lblEmail);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(21, 81, 46, 14);
		contentPane.add(lblPassword);
		
		lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(21, 112, 86, 14);
		contentPane.add(lblConfirmPassword);
		
		textField_4 = new JTextField();
		textField_4.setBounds(157, 171, 219, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(21, 143, 51, 14);
		contentPane.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(21, 174, 51, 14);
		contentPane.add(lblLastName);
		
		textField_5 = new JTextField();
		textField_5.setBounds(157, 202, 219, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(21, 205, 69, 14);
		contentPane.add(lblPhoneNumber);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 78, 219, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(157, 109, 219, 20);
		contentPane.add(passwordField_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 233, 219, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 264, 219, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblContactPersonName = new JLabel("Contact person Name");
		lblContactPersonName.setBounds(21, 236, 104, 14);
		contentPane.add(lblContactPersonName);
		
		lblContactPersonNumber = new JLabel("Contact person Number");
		lblContactPersonNumber.setBounds(21, 267, 114, 14);
		contentPane.add(lblContactPersonNumber);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(21, 295, 133, 23);
		contentPane.add(btnCancel);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(243, 295, 133, 23);
		contentPane.add(btnDone);
		
		this.setVisible(true);
	}
}
