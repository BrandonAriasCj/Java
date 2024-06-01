package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class practica01 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					practica01 frame = new practica01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public practica01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(88, 27, 115, 26);
		contentPane.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_0 = new JMenuItem("Opcion01");
		mnNewMenu.add(mntmNewMenuItem_0);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Opcion02");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Opcion03");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Opcion04");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("Opcion a");
		rdbtnmntmNewRadioItem.setBounds(101, 154, 133, 26);
		contentPane.add(rdbtnmntmNewRadioItem);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("Opcion b");
		rdbtnmntmNewRadioItem_1.setBounds(101, 177, 133, 26);
		contentPane.add(rdbtnmntmNewRadioItem_1);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_2 = new JRadioButtonMenuItem("Opcion c");
		rdbtnmntmNewRadioItem_2.setBounds(101, 203, 133, 26);
		contentPane.add(rdbtnmntmNewRadioItem_2);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("fasdfsdf");
		chckbxmntmNewCheckItem.setBounds(249, 177, 135, 26);
		contentPane.add(chckbxmntmNewCheckItem);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_1 = new JCheckBoxMenuItem("asdfasdf");
		chckbxmntmNewCheckItem_1.setBounds(244, 203, 135, 26);
		contentPane.add(chckbxmntmNewCheckItem_1);
		

	}
}
