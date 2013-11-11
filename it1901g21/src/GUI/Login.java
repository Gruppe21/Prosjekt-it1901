package GUI;
import it1901g21.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import database.Farmers;



public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Main main;
	private Registration registration;
	private MainScreen mainscreen;
	private Farmers pst;
	
	/**
	 * Create the frame.
	 */
	public Login(final Main main, final Farmers pst) {
		
		this.main = main;
		this.pst = pst;
		registration = new Registration(main);

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
		
		
		// Login button
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(114, 143, 238, 23);
		contentPane.add(btnLogin);
		this.getRootPane().setDefaultButton(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pw = new String(passwordField.getPassword());
				String li = textField.getText();
				
				sendLogIn(new String[] {li, pw});
			}
		});
		
		// New user button
		JButton btnNewUser = new JButton("New user");
		btnNewUser.setBounds(114, 177, 112, 23);
		contentPane.add(btnNewUser);
		
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registration.openRegistration();
				
			}
		});
		
		// Forgot pass button 
		JButton btnForgotPass = new JButton("Forgot Pass");
		btnForgotPass.setBounds(240, 177, 112, 23);
		contentPane.add(btnForgotPass);
		
		btnForgotPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		this.setVisible(true);
	}
	
	/**
	 * Tells the Main class to log in.
	 */
	public void sendLogIn(String[] info) {
		main.logIn(info);
	}
	
}
