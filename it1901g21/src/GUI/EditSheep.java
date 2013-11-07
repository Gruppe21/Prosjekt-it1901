package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;


public class EditSheep extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnAvbryt;
	private JLabel lblSerialnumber;
	private JLabel lblBirthdate;

	/**
	 * Create the frame.
	 */
	public EditSheep() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 93, 209, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(191, 124, 209, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sheep number");
		lblNewLabel.setBounds(57, 34, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHelse = new JLabel("Birth Date yyyy.mm.dd:");
		lblHelse.setBounds(57, 65, 124, 14);
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
		
		JLabel lblVekt = new JLabel("Weight:");
		lblVekt.setBounds(57, 127, 124, 14);
		contentPane.add(lblVekt);
		
		lblSerialnumber = new JLabel("SerialNumber");
		lblSerialnumber.setBounds(191, 34, 209, 14);
		contentPane.add(lblSerialnumber);
		
		lblBirthdate = new JLabel("BirthDate");
		lblBirthdate.setBounds(191, 65, 209, 14);
		contentPane.add(lblBirthdate);
		
		this.setVisible(true);
		
	}
}
