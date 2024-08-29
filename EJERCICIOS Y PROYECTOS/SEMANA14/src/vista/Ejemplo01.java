package vista;
import datos.Proceso;
import datos.Alumno;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.util.Collection;

public class Ejemplo01 extends JFrame {
	
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblListado;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo01 frame = new Ejemplo01();
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
	public Ejemplo01() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tblListado = new JTable();
		tblListado.setBounds(93, 50, 496, 235);
		
		
		JButton btnListado = new JButton("Listar");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Collection<Alumno> x = Proceso.listado();
				 DefaultTableModel modelo = (DefaultTableModel)tblListado.getModel();
				 modelo.setRowCount(0);
				 for(Alumno alumno:x) {
					 modelo.addRow(new Object[] {
							 alumno.getCodigo(),
							 alumno.getApellidos(),
							 alumno.getNombres(),
							 alumno.getEspecialidad(),
							 alumno.getPension()
					 });

				 }
				 System.out.println("pasa por luego del for");
				 modelo.fireTableDataChanged();

			}
			
		});
		
		btnListado.setBounds(291, 339, 85, 21);
		contentPane.add(tblListado);
		contentPane.add(btnListado);
		

	}
}
