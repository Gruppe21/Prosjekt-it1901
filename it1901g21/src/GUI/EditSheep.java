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
	private JLabel lblXpos;
	private JLabel lblYpos;
	
	private Main main;
	private SheepInfo sheepInfo;
	private int index;
	private boolean isOpen;

	/**
	 * Create the frame.
	 */
	public EditSheep(Main main, SheepInfo sheepInfo) {
		
		this.main = main;
		this.sheepInfo = sheepInfo;
		this.isOpen = false;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		health = new JTextField();
		health.setBounds(223, 118, 177, 20);
		contentPane.add(health);
		health.setColumns(10);
		
		weight = new JTextField();
		weight.setBounds(223, 151, 177, 20);
		contentPane.add(weight);
		weight.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Eartag:");
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
		this.getRootPane().setDefaultButton(btnDone);
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String rHealth = health.getText();
				String rWeight = weight.getText();

				edit(rHealth,rWeight);
			}
			
		});
		
		btnAvbryt = new JButton("Cancel");
		btnAvbryt.setBounds(12, 204, 124, 23);
		contentPane.add(btnAvbryt);
		btnAvbryt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				closeEditSheep();
				
			}
			
		});
		
		JLabel lblVekt = new JLabel("Weight (kg):");
		lblVekt.setBounds(57, 148, 124, 14);
		contentPane.add(lblVekt);
		
		lblSerialnumber = new JLabel();
		lblSerialnumber.setBounds(223, 34, 177, 14);
		contentPane.add(lblSerialnumber);
		
		lblBirthdate = new JLabel();
		lblBirthdate.setBounds(223, 65, 177, 14);
		contentPane.add(lblBirthdate);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(57, 92, 56, 16);
		contentPane.add(lblLocation);
		
		lblXpos = new JLabel();
		lblXpos.setBounds(223, 92, 94, 16);
		contentPane.add(lblXpos);
		
		lblYpos = new JLabel();
		lblYpos.setBounds(329, 92, 91, 16);
		contentPane.add(lblYpos);
		
	}
	
	/**
	 * Opens the edit-sheep-window. Remember the index!
	 * @param index the index so the window knows which sheep to edit
	 */
	public void openEditSheep(int index) {
		
		this.index = index;
		this.isOpen = true;
		this.update();
		this.setVisible(true);
	}
	
	public void closeEditSheep(){
		this.isOpen = false;
		this.setVisible(false);
	}
	
	/**
	 * Updates the edit-sheep-window with the sheep's information
	 */
	private void update() {
		
		Sheep sheep = main.getFarmer().getSheepHerd().get(index);
		
		lblSerialnumber.setText(sheep.getEarTag());
		lblBirthdate.setText(sheep.getBirthDate());
		lblXpos.setText(sheep.getXPos());
		lblYpos.setText(sheep.getYPos());
		
	}
	
	/**
	 * Updates ONLY the location text in the edit-sheep-window
	 */
	public void updateLocationInfo() {
		
		Sheep sheep = main.getFarmer().getSheepHerd().get(index);
		
		lblXpos.setText(sheep.getXPos());
		lblYpos.setText(sheep.getYPos());
	}
	
	/**
	 * Returns whether the edit-sheep-window is open or not
	 * @return true or false
	 */
	public boolean isOpen() {
		return isOpen;
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
	
	/**
	 * Edits the sheep's information
	 * @param health
	 * @param weight
	 */
	private void edit(String health, String weight){
		
		// Check for empty fields
		if (health.equals("") || weight.equals("")) {
			ErrorMessage error = new ErrorMessage("", "Please fill in every field");
			return;
		}
		
		// Check for letters in weight
		if (!isNumeric(weight)) {
			ErrorMessage error = new ErrorMessage("", "Please only use numbers for weight!");
			return;
		}
		
		/* Check for too long inputs */
		if (health.length() > 25) {
			ErrorMessage error = new ErrorMessage("", "In health description, use maximum 25 symbols.");
			return;
		}
		if (weight.length() > 4) {
			ErrorMessage error = new ErrorMessage("-.-", "Come on, not even your mother is that fat...");
			return;
		}
		
		Sheep sheep = main.getFarmer().getSheepHerd().get(index);
		int rweight = 0;
		
		try {
			rweight = Integer.parseInt(weight);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		main.updateEditSheep(sheep.getId(), health, rweight);
		
		sheepInfo.updateInfo();
		closeEditSheep();
	}
}
