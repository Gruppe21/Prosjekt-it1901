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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(223, 118, 177, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(223, 151, 177, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sheep number:");
		lblNewLabel.setBounds(57, 34, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHelse = new JLabel("Birth Date (yyyy.mm.dd):");
		lblHelse.setBounds(57, 65, 159, 14);
		contentPane.add(lblHelse);
		
		JLabel lblAlder = new JLabel("Health:");
		lblAlder.setBounds(57, 121, 124, 14);
		contentPane.add(lblAlder);
		
		btnNewButton = new JButton("Done");
		btnNewButton.setBounds(296, 204, 124, 23);
		contentPane.add(btnNewButton);
		
		btnAvbryt = new JButton("Cancel");
		btnAvbryt.setBounds(12, 204, 124, 23);
		contentPane.add(btnAvbryt);
		
		JLabel lblVekt = new JLabel("Weight (kg):");
		lblVekt.setBounds(57, 148, 124, 14);
		contentPane.add(lblVekt);
		
		lblSerialnumber = new JLabel("SerialNumber");
		lblSerialnumber.setBounds(223, 34, 177, 14);
		contentPane.add(lblSerialnumber);
		
		lblBirthdate = new JLabel("BirthDate");
		lblBirthdate.setBounds(223, 65, 177, 14);
		contentPane.add(lblBirthdate);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(57, 92, 56, 16);
		contentPane.add(lblLocation);
		
		JLabel lblXpos = new JLabel("xpos");
		lblXpos.setBounds(223, 92, 56, 16);
		contentPane.add(lblXpos);
		
		JLabel lblYpos = new JLabel("ypos");
		lblYpos.setBounds(291, 92, 56, 16);
		contentPane.add(lblYpos);
		
		this.setVisible(true);
		
	}
}
