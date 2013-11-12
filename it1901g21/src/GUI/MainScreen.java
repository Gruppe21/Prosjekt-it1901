package GUI;
import it1901g21.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.JScrollPane;


public class MainScreen extends JFrame {
	
	private Main main;
	private RegiSheep regiSheep;
	
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public MainScreen(Main main, RegiSheep regiSheep) {
		
		this.main = main;
		this.regiSheep = regiSheep;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * Creates static img of map
		 */
		String xlist[]={};
		String ylist[]={};
		
		String waypoints = "";
		
		for (int i = 0; i < xlist.length; i++) {
			waypoints = waypoints + "&markers=color:blue%7Clabel:S%7C" + xlist[i] + "," + ylist[i];
		}
		
		try {
            String imageUrl = "http://maps.google.com/maps/api/staticmap?center=Trondheim&zoom=13&size=243x221&maptype=satellite"+waypoints+"&sensor=false";
            String destinationFile = "image.jpg";
            String str = destinationFile;
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

		JLabel map = new JLabel(new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(243, 221,java.awt.Image.SCALE_SMOOTH)));
		map.setBounds(38, 211, 243, 221);
		contentPane.add(map);
		
		/**
		 * Add Sheep button
		 */
		
		JButton btnAddSheep = new JButton("Add Sheep");
		btnAddSheep.setBounds(38, 99, 120, 45);
		contentPane.add(btnAddSheep);
		
		btnAddSheep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openRegiSheepWindow();
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
				Profile profile = new Profile(getMain());
			}
		});
		
		/**
		 * Alarm button
		 */
		
		JButton btnAlarm = new JButton("Alarm");
		btnAlarm.setBackground(Color.RED);
		btnAlarm.setBounds(168, 155, 113, 45);
		contentPane.add(btnAlarm);
		
	}
	
	/**
	 * Opens the main-screen window
	 */
	public void openMainScreen() {
		this.setVisible(true);
	}
	public void addListSheep() {
		
		DefaultListModel listmodel = new DefaultListModel();
		
		JList list = new JList(listmodel);
		
		/**
		 * Create and populate List
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 74, 306, 358);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(list);
		
		for (int i = 0; i < this.main.getFarmer().getSheepHerd().size(); i++){
			listmodel.addElement(this.main.getFarmer().getSheepHerd().get(i).getEarTag());	
		}
	}	
	private void openRegiSheepWindow() {
		regiSheep.openRegiSheep();
	}
	
	private Main getMain() {
		return main;
	}
}
