package GUI;
import it1901g21.Main;
import it1901g21.Sheep;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JScrollPane;


public class MainScreen extends JFrame {
	
	private Main main;
	private RegiSheep regiSheep;
	private DelSheep delSheep;
	private Alarm alarm;
	private SheepInfo sheepinfo;
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultListModel listmodel;
	private JLabel map;
	
	/**
	 * Create the frame.
	 */
	public MainScreen(Main main, RegiSheep regiSheep, DelSheep delSheep, SheepInfo sheepInfo, String[] xlist,String[] ylist) {
		
		this.main = main;
		this.regiSheep = regiSheep;
		this.delSheep = delSheep;
		this.sheepinfo = sheepInfo;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		
		/**
		 * Add Mini-map
		 */
		map = new JLabel();
		map.setBounds(38, 190, 243, 221);
		contentPane.add(map);
		
		/**
		 * Add Sheep button
		 */
		JButton btnAddSheep = new JButton("Add Sheep");
		btnAddSheep.setBounds(38, 74, 120, 45);
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
		btnDelSheep.setBounds(168, 74, 113, 45);
		contentPane.add(btnDelSheep);
		
		btnDelSheep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDelSheepWindow();
			}	
		});
		
		/**
		 *  Profile button
		 */
		JButton btnProfile = new JButton("Profile");
		btnProfile.setBounds(38, 132, 120, 45);
		contentPane.add(btnProfile);
		
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile profile = new Profile(getMain());
			}
		});
		
		/**
		 * Alarm button
		 */
		JButton btnAlarm = new JButton("Alarm test");
		btnAlarm.setBackground(Color.RED);
		btnAlarm.setBounds(168, 132, 113, 45);
		contentPane.add(btnAlarm);
		
		btnAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alarm alarm = new Alarm(getMain());
			}
		});
		
		/**
		 * Open bigger map button
		 */
		JButton btnMap = new JButton("Open bigger version of map");
		btnMap.setBackground(Color.RED);
		btnMap.setBounds(38, 424, 243, 25);
		contentPane.add(btnMap);
		
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Desktop.isDesktopSupported())
				{
				  try {
					Desktop.getDesktop().browse(new URI("http://localhost:8888/map.php?farmerid=119"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		
		/**
		 * Create list
		 */
		scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 74, 306, 358);
		contentPane.add(scrollPane);
		
		listmodel = new DefaultListModel();
		JList list = new JList(listmodel);
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		/**
		 * Double click listener for list
		 */
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt){
				JList list = (JList)evt.getSource();
				if (evt.getClickCount() == 2){
					int index = list.locationToIndex(evt.getPoint());
					openSheepInfo(index);
				}
			}
		});
		
	}
	
	/**
	 * Opens the main-screen window
	 */
	public void openMainScreen() {
		this.setVisible(true);
	}
	
	public void openSheepInfo(int index) {
		sheepinfo.openSheepInfo();
		sheepinfo.seeSheep(getMain().getFarmer().getSheepHerd().get(index));
	}
	
	/**
	 * Updates the list of sheep
	 */
	public void updateListSheep() {
		
		listmodel.clear();
		for (Sheep sheep : this.main.getFarmer().getSheepHerd()) {
			listmodel.addElement(sheep.getEarTag());
		}
	}
	
	/**
	 * updates map markers
	 */
	
	public void updateMap(){
		
		
		ArrayList<String> xlist = new ArrayList<String>();
		ArrayList<String> ylist = new ArrayList<String>();
		
		for (int i = 0; i < this.main.getFarmer().getSheepHerd().size(); i++){
			xlist.add(this.main.getFarmer().getSheepHerd().get(i).getXPos());
			ylist.add(this.main.getFarmer().getSheepHerd().get(i).getYPos());
		}
		
		//deactivate map
		
		/*if (xlist.size()>=0){
			map.setIcon(null);
			map.setText("Map deactivated! more info on console!");
			//System.out.println("Map deactivated, see line 193-198 in MainScreen.java");
			return;
		}*/
		
		if (xlist.size()==0){
			map.setIcon(null);
			map.setText("No Sheep Registered!");
			return;
		}
		
		String waypoints = "";
		
		for (int i = 0; i < xlist.size(); i++) {
			int pos = i+1;
			waypoints = waypoints + "&markers=color:blue%7Clabel:"+pos+"%7C" + xlist.get(i) + "," + ylist.get(i);
		}
		Random random = new Random();
		
		try {
            String imageUrl = "http://maps.google.com/maps/api/staticmap?center="+ xlist.get(random.nextInt(xlist.size())) +","+ ylist.get(random.nextInt(ylist.size())) +"&zoom=13&size=243x221&maptype=satellite"+waypoints+"&sensor=false";
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
            //e.printStackTrace();
            map.setIcon(null);
			map.setText("Map not available!");
			return;
        }
		
		
		
		map.setIcon(new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(243, 221,java.awt.Image.SCALE_SMOOTH)));
		
	
	}
	
	private void openRegiSheepWindow() {
		regiSheep.openRegiSheep();
	}
	
	private void openDelSheepWindow() {
		delSheep.openDelSheep();
	}
	
	private Main getMain() {
		return main;
	}
	
	public SheepInfo getSheepInfo() {
		return sheepinfo;
	}
}
