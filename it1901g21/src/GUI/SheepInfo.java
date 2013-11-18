package GUI;
import it1901g21.Farmer;
import it1901g21.Sheep;

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
import javax.swing.JScrollPane;
import javax.swing.JList;


public class SheepInfo extends JFrame {
	
	private JPanel contentPane;
	private JButton btnDone;
	private JLabel lblSerialnumber;
	private JLabel lblBirthdate;
	private Main main;

	/**
	 * Create the frame.
	 */
	public SheepInfo(Main main, final Sheep sheep) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sheep number:");
		lblNewLabel.setBounds(57, 34, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHelse = new JLabel("Birth Date (yyyy.mm.dd):");
		lblHelse.setBounds(57, 65, 159, 14);
		contentPane.add(lblHelse);
		
		JLabel lblAlder = new JLabel("Health:");
		lblAlder.setBounds(57, 92, 124, 14);
		contentPane.add(lblAlder);
		
		btnDone = new JButton("Done");
		btnDone.setBounds(296, 433, 124, 23);
		contentPane.add(btnDone);
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeSheepInfo();
			}
		});
		
		JLabel lblVekt = new JLabel("Weight (kg):");
		lblVekt.setBounds(57, 119, 124, 14);
		contentPane.add(lblVekt);
		
		lblSerialnumber = new JLabel(sheep.getEarTag());
		lblSerialnumber.setBounds(223, 34, 177, 14);
		contentPane.add(lblSerialnumber);
		
		lblBirthdate = new JLabel(sheep.getBirthDate());
		lblBirthdate.setBounds(223, 65, 177, 14);
		contentPane.add(lblBirthdate);
		
		JLabel lblHealth = new JLabel(sheep.getHealth());
		lblHealth.setBounds(223, 91, 177, 14);
		contentPane.add(lblHealth);
		
		JLabel lblWeight = new JLabel(String.valueOf(sheep.getWeigth()));
		lblWeight.setBounds(223, 118, 177, 14);
		contentPane.add(lblWeight);
		
		JLabel lblLastKnownLoactions = new JLabel("Last known loactions:");
		lblLastKnownLoactions.setBounds(57, 146, 177, 16);
		contentPane.add(lblLastKnownLoactions);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(12, 433, 136, 23);
		contentPane.add(btnEdit);
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditSheep editsheep = new EditSheep(getMain(),sheep);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 176, 322, 244);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		openSheepInfo();
	}
	
	/**
	 * Opens the sheep info
	 */
	public void openSheepInfo() {
		this.setVisible(true);
	}
	
	/**
	 * Closes the sheep info
	 */
	
	public void closeSheepInfo() {
		this.setVisible(false);
	}
	
	private Main getMain() {
		return main;
	}
}
