package it1901g21;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;


public class RegiSheep extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnAvbryt;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public RegiSheep() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(191, 31, 209, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 62, 209, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 93, 209, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(191, 124, 209, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sauenummer:");
		lblNewLabel.setBounds(57, 34, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHelse = new JLabel("Helse:");
		lblHelse.setBounds(57, 65, 124, 14);
		contentPane.add(lblHelse);
		
		JLabel lblAlder = new JLabel("Alder:");
		lblAlder.setBounds(57, 96, 124, 14);
		contentPane.add(lblAlder);
		
		JLabel lblNvarendePosision = new JLabel("N\u00E5varende Posision:");
		lblNvarendePosision.setBounds(57, 127, 124, 14);
		contentPane.add(lblNvarendePosision);
		
		btnNewButton = new JButton("Ferdig");
		btnNewButton.setBounds(300, 206, 124, 23);
		contentPane.add(btnNewButton);
		
		btnAvbryt = new JButton("Avbryt");
		btnAvbryt.setBounds(10, 206, 124, 23);
		contentPane.add(btnAvbryt);
		
		JLabel lblVekt = new JLabel("Vekt:");
		lblVekt.setBounds(57, 158, 124, 14);
		contentPane.add(lblVekt);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(191, 155, 209, 20);
		contentPane.add(textField_4);
		
		this.setVisible(true);
		
	}
}
