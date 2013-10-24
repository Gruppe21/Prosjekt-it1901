package it1901g21;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(114, 81, 238, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(114, 112, 238, 20);
		contentPane.add(passwordField);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(40, 84, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(40, 115, 70, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(114, 143, 238, 23);
		contentPane.add(btnLogin);
		
		JButton btnNewUser = new JButton("New user");
		btnNewUser.setBounds(114, 177, 112, 23);
		contentPane.add(btnNewUser);
		
		JButton btnForgotPass = new JButton("Forgot Pass");
		btnForgotPass.setBounds(240, 177, 112, 23);
		contentPane.add(btnForgotPass);
		
		this.setVisible(true);
	}
}
