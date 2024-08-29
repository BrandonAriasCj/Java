package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.ManteLibro;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GestionLibro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tblReporte;
	private JTextField txtLibroActualizarBuscar;
	private JTextField txtLibroActualizarTitulo;
	private JTextField txtLibroActualizarISBN;
	private JTextField txtLibroActualizarPrecio;
	private JTextField txtLibroEliminar;
	private JTextField txtLibroCodigo;
	private JTextField txtLibroActualizarEditorial;
	private JTextField txtLibroActualizarAutor;
	private JTextField txtRegistrarCodigo;
	private JTextField txtRegistrarTitulo;
	private JTextField txtRegistrarISBN;
	private JTextField txtRegistrarEditorial;
	private JTextField txtRegistrarPrecio;
	private JTextField txtRegistrarAutor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionLibro dialog = new GestionLibro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionLibro() {
		setBounds(100, 100, 983, 753);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 12));
			tabbedPane.setBounds(23, 61, 409, 605);
			contentPanel.add(tabbedPane);
			{
				JPanel paneRegistrar = new JPanel();
				tabbedPane.addTab("Registrar", null, paneRegistrar, null);
				paneRegistrar.setLayout(null);
				
				JLabel lblCodeLibro = new JLabel("Ingrese el codigo del libro:");
				lblCodeLibro.setBounds(29, 13, 136, 14);
				paneRegistrar.add(lblCodeLibro);
				
				txtRegistrarCodigo = new JTextField();
				txtRegistrarCodigo.setColumns(10);
				txtRegistrarCodigo.setBounds(175, 10, 70, 20);
				paneRegistrar.add(txtRegistrarCodigo);
				
				JLabel lblTituloLibro = new JLabel("Titulo:");
				lblTituloLibro.setBounds(29, 40, 48, 14);
				paneRegistrar.add(lblTituloLibro);
				
				txtRegistrarTitulo = new JTextField();
				txtRegistrarTitulo.setColumns(10);
				txtRegistrarTitulo.setBounds(74, 38, 171, 20);
				paneRegistrar.add(txtRegistrarTitulo);
				
				JLabel lblISBNLibro = new JLabel("ISBN:");
				lblISBNLibro.setBounds(29, 66, 48, 14);
				paneRegistrar.add(lblISBNLibro);
				
				txtRegistrarISBN = new JTextField();
				txtRegistrarISBN.setColumns(10);
				txtRegistrarISBN.setBounds(87, 64, 96, 20);
				paneRegistrar.add(txtRegistrarISBN);
				
				txtRegistrarEditorial = new JTextField();
				txtRegistrarEditorial.setColumns(10);
				txtRegistrarEditorial.setBounds(99, 156, 96, 19);
				paneRegistrar.add(txtRegistrarEditorial);
				
				JLabel lblPrecioLibro = new JLabel("Precio:");
				lblPrecioLibro.setBounds(29, 90, 48, 14);
				paneRegistrar.add(lblPrecioLibro);
				
				txtRegistrarPrecio = new JTextField();
				txtRegistrarPrecio.setColumns(10);
				txtRegistrarPrecio.setBounds(85, 88, 98, 20);
				paneRegistrar.add(txtRegistrarPrecio);
				
				JLabel lblAutorLibro = new JLabel("ID Autor:");
				lblAutorLibro.setBounds(29, 135, 45, 13);
				paneRegistrar.add(lblAutorLibro);
				
				txtRegistrarAutor = new JTextField();
				txtRegistrarAutor.setColumns(10);
				txtRegistrarAutor.setBounds(99, 129, 96, 19);
				paneRegistrar.add(txtRegistrarAutor);
				
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManteLibro m=new ManteLibro();
						Connection conn=m.conectar();

						int id_cod=Integer.parseInt(txtRegistrarCodigo.getText());
						String tit=txtRegistrarTitulo.getText().toString();
						String isbn=txtRegistrarISBN.getText().toString();
					    double prc = Double.parseDouble(txtRegistrarPrecio.getText());
					    int aut = Integer.parseInt(txtRegistrarAutor.getText());
						String edi=txtRegistrarEditorial.getText().toString();
						boolean exitoRegistro = m.registrar_libro(id_cod, tit, isbn, prc, aut, edi);
						if (exitoRegistro) {
		                    JOptionPane.showMessageDialog(null, "Registro exitoso del libro");
		                    m.vaciarTabla(tblReporte);
						ResultSet datos=m.consulta_libro();
						int fila = 0;
						try {
							DefaultTableModel model = (DefaultTableModel) tblReporte.getModel();
							while(datos.next()) {
								if (fila >= model.getRowCount()) {
			                        model.addRow(new Object[model.getColumnCount()]);
			                    }
				                tblReporte.setValueAt(datos.getInt(1), fila, 0);
				                tblReporte.setValueAt(datos.getString(2), fila, 1);
				                tblReporte.setValueAt(datos.getString(3), fila, 2);
				                tblReporte.setValueAt(datos.getDouble(4), fila, 3);
				                tblReporte.setValueAt(datos.getInt(5), fila, 4);
				                tblReporte.setValueAt(datos.getString(6), fila, 5);
								fila++;
							}
						}catch(SQLException e5) {
						}
						limpiar();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Error al registrar el libro");
		                }
					}
				});
				btnRegistrar.setBounds(134, 219, 85, 21);
				paneRegistrar.add(btnRegistrar);
				
				JLabel lblEditorialLibro = new JLabel("ID editorial:");
				lblEditorialLibro.setBounds(29, 159, 60, 13);
				paneRegistrar.add(lblEditorialLibro);
			}
			{
				JPanel paneEliminar = new JPanel();
				tabbedPane.addTab("Eliminar", null, paneEliminar, null);
				paneEliminar.setLayout(null);
				
				JLabel lblCodLibroEliminar = new JLabel("Ingrese el codigo del libro:");
				lblCodLibroEliminar.setBounds(23, 38, 135, 14);
				paneEliminar.add(lblCodLibroEliminar);
				
				txtLibroEliminar = new JTextField();
				txtLibroEliminar.setBounds(180, 35, 96, 20);
				txtLibroEliminar.setColumns(10);
				paneEliminar.add(txtLibroEliminar);
				
				JButton btnLibroEliminar = new JButton("Eliminar");
				btnLibroEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManteLibro m=new ManteLibro();
						Connection conn=m.conectar();
						int id_cod=Integer.parseInt(txtLibroEliminar.getText());
						boolean exitoEliminar = m.eliminar_libro(id_cod);
						if (exitoEliminar) {
		                    JOptionPane.showMessageDialog(null, "Eliminación exitosa del libro");
		                    m.vaciarTabla(tblReporte);
		                    limpiar();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Error al actualizar el libro");
		                }
					}
				});
				btnLibroEliminar.setBounds(299, 34, 84, 23);
				paneEliminar.add(btnLibroEliminar);
			}
			{
				JPanel paneActualizar = new JPanel();
				tabbedPane.addTab("Actualizar", null, paneActualizar, null);
				paneActualizar.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("Ingrese el codigo del libro:");
				lblNewLabel_1.setBounds(10, 14, 136, 14);
				paneActualizar.add(lblNewLabel_1);
				
				txtLibroActualizarBuscar = new JTextField();
				txtLibroActualizarBuscar.setBounds(156, 11, 70, 20);
				paneActualizar.add(txtLibroActualizarBuscar);
				txtLibroActualizarBuscar.setColumns(10);
				
				JButton btnLibroActualizarBuscar = new JButton("Buscar");
				btnLibroActualizarBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManteLibro m=new ManteLibro();
						m.vaciarTabla(tblReporte);
						Connection conn = m.conectar();
						int id_cod = Integer.parseInt(txtLibroActualizarBuscar.getText());
						ResultSet datos=m.buscar_libro(id_cod);
						int fila = 0;
						try {
							 DefaultTableModel model = (DefaultTableModel) tblReporte.getModel();
					            while (datos.next()) {
					                if (fila >= model.getRowCount()) {
					                    model.addRow(new Object[model.getColumnCount()]);
					                }
					                tblReporte.setValueAt(datos.getInt(1), fila, 0);
					                tblReporte.setValueAt(datos.getString(2), fila, 1);
					                tblReporte.setValueAt(datos.getString(3), fila, 2);
					                tblReporte.setValueAt(datos.getDouble(4), fila, 3);
					                tblReporte.setValueAt(datos.getInt(5), fila, 4);
					                tblReporte.setValueAt(datos.getString(6), fila, 5);
					                txtLibroActualizarTitulo.setText(datos.getString(2));
					                txtLibroActualizarISBN.setText(datos.getString(3));
					                txtLibroActualizarPrecio.setText(String.valueOf(datos.getDouble(4)));
					                txtLibroActualizarAutor.setText(String.valueOf(datos.getInt(5)));
					                txtLibroActualizarEditorial.setText(datos.getString(6));
					                fila++;
					             }
					       }catch(SQLException e5) {
						}
					}
				});
				btnLibroActualizarBuscar.setBounds(269, 10, 89, 23);
				paneActualizar.add(btnLibroActualizarBuscar);
				
				JLabel lblNewLabel_1_1 = new JLabel("Titulo:");
				lblNewLabel_1_1.setBounds(10, 41, 48, 14);
				paneActualizar.add(lblNewLabel_1_1);
				
				JLabel lblNewLabel_1_2 = new JLabel("ISBN:");
				lblNewLabel_1_2.setBounds(10, 67, 48, 14);
				paneActualizar.add(lblNewLabel_1_2);
				
				JLabel lblNewLabel_1_3 = new JLabel("Precio:");
				lblNewLabel_1_3.setBounds(10, 91, 48, 14);
				paneActualizar.add(lblNewLabel_1_3);
				
				txtLibroActualizarTitulo = new JTextField();
				txtLibroActualizarTitulo.setColumns(10);
				txtLibroActualizarTitulo.setBounds(55, 39, 171, 20);
				paneActualizar.add(txtLibroActualizarTitulo);
				
				txtLibroActualizarISBN = new JTextField();
				txtLibroActualizarISBN.setColumns(10);
				txtLibroActualizarISBN.setBounds(68, 65, 96, 20);
				paneActualizar.add(txtLibroActualizarISBN);
				
				txtLibroActualizarPrecio = new JTextField();
				txtLibroActualizarPrecio.setColumns(10);
				txtLibroActualizarPrecio.setBounds(66, 89, 98, 20);
				paneActualizar.add(txtLibroActualizarPrecio);
				
				JButton btnLibroActualizarGuardar = new JButton("Actualizar");
				btnLibroActualizarGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManteLibro m=new ManteLibro();
						Connection conn=m.conectar();
						int id_cod=Integer.parseInt(txtLibroActualizarBuscar.getText());
						String tit=txtLibroActualizarTitulo.getText().toString();
						String isbn=txtLibroActualizarISBN.getText().toString();
					    double prc = Double.parseDouble(txtLibroActualizarPrecio.getText());
					    int aut = Integer.parseInt(txtLibroActualizarAutor.getText());
						String edi=txtLibroActualizarEditorial.getText().toString();
						boolean exitoActualizacion = m.actualizarLibro(id_cod, tit, isbn, prc, aut, edi);
						if (exitoActualizacion) {
		                    JOptionPane.showMessageDialog(null, "Actualización exitosa del libro");
		                    m.vaciarTabla(tblReporte);
		                    limpiar();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Error al actualizar el libro");
		                }
					}
				});
				btnLibroActualizarGuardar.setBounds(137, 209, 89, 23);
				paneActualizar.add(btnLibroActualizarGuardar);
				
				txtLibroActualizarEditorial = new JTextField();
				txtLibroActualizarEditorial.setBounds(88, 131, 96, 19);
				paneActualizar.add(txtLibroActualizarEditorial);
				txtLibroActualizarEditorial.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("ID editorial:");
				lblNewLabel_3.setBounds(10, 134, 60, 13);
				paneActualizar.add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("ID libro:");
				lblNewLabel_4.setBounds(20, 158, 45, 13);
				paneActualizar.add(lblNewLabel_4);
				
				txtLibroActualizarAutor = new JTextField();
				txtLibroActualizarAutor.setBounds(88, 155, 96, 19);
				paneActualizar.add(txtLibroActualizarAutor);
				txtLibroActualizarAutor.setColumns(10);
			}
			
			JPanel panelReporte = new JPanel();
			tabbedPane.addTab("Reporte", null, panelReporte, null);
			panelReporte.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Buscar por codigo del libro:");
			lblNewLabel_1.setBounds(10, 30, 159, 14);
			panelReporte.add(lblNewLabel_1);
			
			txtLibroCodigo = new JTextField();
			txtLibroCodigo.setBounds(148, 27, 134, 20);
			txtLibroCodigo.setColumns(10);
			panelReporte.add(txtLibroCodigo);
			
			JButton btnLibroReporteBuscar = new JButton("Buscar");
			btnLibroReporteBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManteLibro m=new ManteLibro();
					m.vaciarTabla(tblReporte);
					Connection conn = m.conectar();
					int id_cod = Integer.parseInt(txtLibroCodigo.getText());
					ResultSet datos=m.buscar_libro(id_cod);
					int fila = 0;
					try {
						 DefaultTableModel model = (DefaultTableModel) tblReporte.getModel();
				            while (datos.next()) {
				                if (fila >= model.getRowCount()) {
				                    model.addRow(new Object[model.getColumnCount()]);
				                }
				                tblReporte.setValueAt(datos.getInt(1), fila, 0);
				                tblReporte.setValueAt(datos.getString(2), fila, 1);
				                tblReporte.setValueAt(datos.getString(3), fila, 2);
				                tblReporte.setValueAt(datos.getDouble(4), fila, 3);
				                tblReporte.setValueAt(datos.getInt(5), fila, 4);
				                tblReporte.setValueAt(datos.getString(6), fila, 5);
				                fila++;
				             }
						}catch(SQLException e5) {
							
				       }
					}
			});
			btnLibroReporteBuscar.setBounds(292, 26, 85, 23);
			panelReporte.add(btnLibroReporteBuscar);
			
			JButton btnLibroReporteTodos = new JButton("Ver todos los libros");
			btnLibroReporteTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManteLibro m=new ManteLibro();
					Connection conn=m.conectar();
					ResultSet datos=m.consulta_libro();
					int fila = 0;
					try {
						DefaultTableModel model = (DefaultTableModel) tblReporte.getModel();
						while(datos.next()) {
							if (fila >= model.getRowCount()) {
		                        model.addRow(new Object[model.getColumnCount()]);
		                    }
			                tblReporte.setValueAt(datos.getInt(1), fila, 0);
			                tblReporte.setValueAt(datos.getString(2), fila, 1);
			                tblReporte.setValueAt(datos.getString(3), fila, 2);
			                tblReporte.setValueAt(datos.getDouble(4), fila, 3);
			                tblReporte.setValueAt(datos.getInt(5), fila, 4);
			                tblReporte.setValueAt(datos.getString(6), fila, 5);
							fila++;
						}
					}catch(SQLException e5) {
						System.out.println("Error en la la operacion");
					}
				}
			});
			btnLibroReporteTodos.setBounds(108, 78, 176, 23);
			panelReporte.add(btnLibroReporteTodos);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(481, 106, 417, 561);
		contentPanel.add(scrollPane);
		
		tblReporte = new JTable();
		scrollPane.setViewportView(tblReporte);
		tblReporte.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID_LIBRO", "TITULO", "ISBN", "PRECIO","COD_AUTOR","COD_EDITORIAL"
			}
		));
		
		JLabel lblNewLabel_2 = new JLabel("MANTENIMIENTO LIBRO");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_2.setBounds(61, 22, 335, 28);
		contentPanel.add(lblNewLabel_2);
	}
	public void limpiar() {
		txtRegistrarCodigo.setText(null);
		txtRegistrarTitulo.setText(null);
		txtRegistrarISBN.setText(null);
		txtRegistrarPrecio.setText(null);
		txtRegistrarAutor.setText(null);
		txtRegistrarEditorial.setText(null);
		txtLibroActualizarBuscar.setText(null);
		txtLibroActualizarTitulo.setText(null);
		txtLibroActualizarISBN.setText(null);
		txtLibroActualizarPrecio.setText(null);
		txtLibroActualizarAutor.setText(null);
		txtLibroActualizarEditorial.setText(null);
	}
}

