package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it1901g21.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import it1901g21.Farmer;
import it1901g21.Sheep;


public class EditSheep extends JFrame {
	
	private JPanel contentPane;
	private JTextField health;
	private JTextField weight;
	private JButton btnDone;
	private JButton btnAvbryt;
	private JLabel lblSerialnumber;
	private JLabel lblBirthdate;

	/**
	 * Create the frame.
	 */
	public EditSheep(Main main, final Sheep sheep) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		health = new JTextField();
		health.setBounds(223, 118, 177, 20);
		contentPane.add(health);
		health.setColumns(10);
		
		weight = new JTextField();
		weight.setBounds(223, 151, 177, 20);
		contentPane.add(weight);
		weight.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sheep number:");
		lblNewLabel.setBounds(57, 34, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHelse = new JLabel("Birth Date (yyyy.mm.dd):");
		lblHelse.setBounds(57, 65, 159, 14);
		contentPane.add(lblHelse);
		
		JLabel lblAlder = new JLabel("Health:");
		lblAlder.setBounds(57, 121, 124, 14);
		contentPane.add(lblAlder);
		
		btnDone = new JButton("Done");
		btnDone.setBounds(296, 204, 124, 23);
		contentPane.add(btnDone);
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String rHealth = health.getText();
				String rweightS = weight.getText();
				
				int rweight = Integer.parseInt(rweightS);
				
				sheep.setHealth(rHealth);
				sheep.setWeight(rweight);
				
				closeEditSheep();
				
				//SheepInfo.closeSheepInfo();
				
			}
			
		});
		
		btnAvbryt = new JButton("Cancel");
		btnAvbryt.setBounds(12, 204, 124, 23);
		contentPane.add(btnAvbryt);
		
		JLabel lblVekt = new JLabel("Weight (kg):");
		lblVekt.setBounds(57, 148, 124, 14);
		contentPane.add(lblVekt);
		
		lblSerialnumber = new JLabel(sheep.getEarTag());
		lblSerialnumber.setBounds(223, 34, 177, 14);
		contentPane.add(lblSerialnumber);
		
		lblBirthdate = new JLabel(sheep.getBirthDate());
		lblBirthdate.setBounds(223, 65, 177, 14);
		contentPane.add(lblBirthdate);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(57, 92, 56, 16);
		contentPane.add(lblLocation);
		
		JLabel lblXpos = new JLabel(sheep.getXPos());
		lblXpos.setBounds(223, 92, 94, 16);
		contentPane.add(lblXpos);
		
		JLabel lblYpos = new JLabel(sheep.getYPos());
		lblYpos.setBounds(329, 92, 91, 16);
		contentPane.add(lblYpos);
		
		this.setVisible(true);
		
	}
	
	private void closeEditSheep(){
		this.setVisible(false);
	}
}
