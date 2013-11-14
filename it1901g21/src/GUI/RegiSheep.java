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
import javax.swing.JLabel;
import javax.swing.JButton;


public class RegiSheep extends JFrame {
	
	Main main;
	
	private JPanel contentPane;
	private JTextField EarTag_textField;
	private JTextField BirthDate_textField;
	private JTextField Health_textField;
	private JTextField Weight_textField;
	private JButton btnNewButton;
	private JButton btnAvbryt;
	
	/**
	 * Create the frame.
	 */
	public RegiSheep(Main main) {
		
		this.main = main;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		EarTag_textField = new JTextField();
		EarTag_textField.setBounds(191, 31, 209, 20);
		contentPane.add(EarTag_textField);
		EarTag_textField.setColumns(10);
		
		BirthDate_textField = new JTextField();
		BirthDate_textField.setBounds(191, 62, 209, 20);
		contentPane.add(BirthDate_textField);
		BirthDate_textField.setColumns(10);
		
		Health_textField = new JTextField();
		Health_textField.setBounds(191, 93, 209, 20);
		contentPane.add(Health_textField);
		Health_textField.setColumns(10);
		
		Weight_textField = new JTextField();
		Weight_textField.setBounds(191, 124, 209, 20);
		contentPane.add(Weight_textField);
		Weight_textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ear tag ID");
		lblNewLabel.setBounds(57, 34, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHelse = new JLabel("Birth Date yyyy.mm.dd:");
		lblHelse.setBounds(57, 65, 135, 14);
		contentPane.add(lblHelse);
		
		JLabel lblAlder = new JLabel("Health:");
		lblAlder.setBounds(57, 96, 124, 14);
		contentPane.add(lblAlder);
		
		btnNewButton = new JButton("Done");
		btnNewButton.setBounds(300, 171, 124, 23);
		contentPane.add(btnNewButton);
		
		btnAvbryt = new JButton("Cancel");
		btnAvbryt.setBounds(10, 171, 124, 23);
		contentPane.add(btnAvbryt);
		
		/*
		 * Action to happen when user click "Done"
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (EarTag_textField.getText().equals("") || BirthDate_textField.getText().equals("") || Health_textField.getText().equals("") || Weight_textField.getText().equals("")) {
					ErrorMessage error = new ErrorMessage("", "Please fill in every field");
					return;
				}
				
				if (!isNumeric(Weight_textField.getText())) {
					ErrorMessage error = new ErrorMessage("", "Please only use numbers for weight!");
					return;
				}
				
				String sheepNumber = EarTag_textField.getText();
				String birthDate = BirthDate_textField.getText();
				String health = Health_textField.getText();
				String weight = Weight_textField.getText();
				
				sendAddSheep(sheepNumber, birthDate, health, weight);
				
				// Resets all the text fields
				EarTag_textField.setText(null);
				BirthDate_textField.setText(null);
				Health_textField.setText(null);
				Weight_textField.setText(null);
			}
		});
		
		/*
		 * Action to happen when user clicks "Cancel"
		 */
		btnAvbryt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeRegiSheep();
			}
		});
		
		JLabel lblVekt = new JLabel("Weight:");
		lblVekt.setBounds(57, 127, 124, 14);
		contentPane.add(lblVekt);	
		
	}
	
	/**
	 * Sends the prompt to create the new sheep to Main
	 */
	private void sendAddSheep(String sheepNumber, String birthDate, String health, String weight) {
		
		int weight_int = 0;
		
		try {
			weight_int = Integer.parseInt(weight);
		}
		catch (Exception e) {
			System.out.println("Invalid weight");
			e.printStackTrace();
			return;
		}
		
		closeRegiSheep();
		main.addSheep(sheepNumber, birthDate, health, weight_int);
	}
	
	/**
	 * Method to open window
	 */
	public void openRegiSheep() {
		this.setVisible(true);
	}
	
	/**
	 * Method to close window
	 */
	public void closeRegiSheep(){
		this.setVisible(false);
	}
	
	/**
	 * Checks if string is numeric
	 * @param string the string to check
	 * @return true or false
	 */
	private boolean isNumeric(String string) {
		for (char c : string.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}
	
}
