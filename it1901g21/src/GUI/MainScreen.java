package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;


public class MainScreen extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Add Sheep button
		 */
		
		JButton btnAddSheep = new JButton("Add Sheep");
		btnAddSheep.setBounds(38, 99, 120, 45);
		contentPane.add(btnAddSheep);
		
		btnAddSheep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegiSheep addSheep = new RegiSheep();
			}
		});
		
		/**
		 * Delete Sheep button
		 */
		JButton btnDelSheep = new JButton("Del Sheep");
		btnDelSheep.setBounds(168, 99, 113, 45);
		contentPane.add(btnDelSheep);
		
		btnDelSheep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelSheep delsheep = new DelSheep();
			}	
		});
		
		/**
		 *  Profile button
		 */
		JButton btnProfile = new JButton("Profile");
		btnProfile.setBounds(38, 155, 120, 45);
		contentPane.add(btnProfile);
		
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile profile = new Profile();
			}
		});
		
		/**
		 * Alarm button
		 */
		
		JButton btnAlarm = new JButton("Alarm");
		btnAlarm.setBackground(Color.RED);
		btnAlarm.setBounds(168, 155, 113, 45);
		contentPane.add(btnAlarm);
		
		/**
		 * Create and populate List
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 74, 306, 358);
		contentPane.add(scrollPane);
		
		DefaultListModel listmodel = new DefaultListModel();
		/**
		 * test code to fill list..
		 */
		for (int x = 0; x < 10; x += 1) {
			listmodel.addElement("herp");
			listmodel.addElement("derp");
			listmodel.addElement("bla");
			listmodel.addElement("bla");
			listmodel.addElement("bla");
			listmodel.addElement("bla");
		}
		
		JList list = new JList(listmodel);
		scrollPane.setViewportView(list);
		
		this.setVisible(true);
	}
}
