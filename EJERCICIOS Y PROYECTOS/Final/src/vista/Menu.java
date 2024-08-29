package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestionLibro = new JButton("LIBROS");
		btnGestionLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionLibro g1 = new GestionLibro();
				g1.setVisible(true);
			}
		});
		btnGestionLibro.setBounds(130, 93, 154, 46);
		contentPane.add(btnGestionLibro);
		
		
		JButton btnGestionAutor = new JButton("AUTORES");
		btnGestionAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionAutor g2 = new GestionAutor();
				g2.setVisible(true);
			}
		});
		btnGestionAutor.setBounds(130, 149, 154, 46);
		contentPane.add(btnGestionAutor);
		


		JButton btnGestionEditorial = new JButton("EDITORIALES");
		btnGestionEditorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionEditorial g3 = new GestionEditorial();
				g3.setVisible(true);			}
		});
		btnGestionEditorial.setBounds(130, 208, 154, 53);
		contentPane.add(btnGestionEditorial);
		
		JLabel lblNewLabel_2 = new JLabel("LIBRERIA");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_2.setBounds(48, 35, 335, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\libreriapng.png"));
		lblNewLabel.setBounds(-116, -49, 606, 450);
		contentPane.add(lblNewLabel);
	}
}
