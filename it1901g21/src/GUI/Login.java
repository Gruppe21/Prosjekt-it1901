package GUI;
import it1901g21.Main;

import java.awt.BorderLayout;
import java.awt.Color;
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
	private JLabel connection;
	private Main main;
	private Registration registration;
	private Farmers pst;
	
	/**
	 * Create the frame.
	 */
	public Login(Main main, Farmers pst, Registration registration) {
		
		this.main = main;
		this.pst = pst;
		this.registration = registration;

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
		
		connection = new JLabel("Connecting...");
		connection.setBounds(15, 227, 180, 14);
		contentPane.add(connection);
		
		
		// Login button
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(240, 143, 112, 23);
		contentPane.add(btnLogin);
		this.getRootPane().setDefaultButton(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pw = new String(passwordField.getPassword());
				String em = textField.getText();
				
				sendLogIn(new String[] {em, pw});
			}
		});
		
		// New user button
		JButton btnNewUser = new JButton("New user");
		btnNewUser.setBounds(114, 143, 112, 23);
		contentPane.add(btnNewUser);
		
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerNewUser();
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
	
	/**
	 * Sends the request to open the registration window
	 */
	public void registerNewUser() {
		if (!main.isConnected()) {
			ErrorMessage error = new ErrorMessage("", "Cannot register user without connection!");
			return;
		}
		registration.openRegistration();
	}
	
	/**
	 * Sets the connection text to connected
	 */
	public void setConnected() {
		connection.setText("Connected");
		connection.setForeground(new Color(10,150,80));
	}
	
	/**
	 * Sets the connection text to disconnected
	 */
	public void setDisconnected() {
		connection.setText("No connection availible");
		connection.setForeground(Color.RED);
	}
	
}
