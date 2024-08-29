package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import datos.ManteAutor;
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

public class GestionAutor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tblReporte;
	private JTextField txtRegistrarCodigo;
	private JTextField txtRegistrarApellido;
	private JTextField txtRegistrarnombre;
	private JTextField txtRegistrarPais;
	private JTextField txtAutorActualizarBuscar;
	private JTextField txtAutorActualizarNombre;
	private JTextField txtAutorActualizarApellido;
	private JTextField txtAutorActualizarPais;
	private JTextField txtAutorEliminar;
	private JTextField txtAutorCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionAutor dialog = new GestionAutor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionAutor() {
		setBounds(100, 100, 870, 684);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 12));
			tabbedPane.setBounds(23, 61, 401, 534);
			contentPanel.add(tabbedPane);
			{
				JPanel paneActualizar = new JPanel();
				tabbedPane.addTab("Actualizar", null, paneActualizar, null);
				paneActualizar.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("Ingrese el codigo del autor:");
				lblNewLabel_1.setBounds(10, 14, 136, 14);
				paneActualizar.add(lblNewLabel_1);
				
				txtAutorActualizarBuscar = new JTextField();
				txtAutorActualizarBuscar.setBounds(156, 11, 70, 20);
				paneActualizar.add(txtAutorActualizarBuscar);
				txtAutorActualizarBuscar.setColumns(10);
				
				JButton btnAutorActualizarBuscar = new JButton("Buscar");
				btnAutorActualizarBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManteAutor m=new ManteAutor();
						m.vaciarTabla(tblReporte);
						Connection conn = m.conectar();
						int id_cod = Integer.parseInt(txtAutorActualizarBuscar.getText());
						ResultSet datos=m.buscar_autor(id_cod);
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
					                tblReporte.setValueAt(datos.getString(4), fila, 3);
					                txtAutorActualizarNombre.setText(datos.getString(2));
					                txtAutorActualizarApellido.setText(datos.getString(3));
					                txtAutorActualizarPais.setText(datos.getString(4));
					                fila++;
					             }
					       }catch(SQLException e5) {
						}
					}
				});
				btnAutorActualizarBuscar.setBounds(85, 62, 89, 23);
				paneActualizar.add(btnAutorActualizarBuscar);
				
				JLabel lblNewLabel_1_1 = new JLabel("Nombre");
				lblNewLabel_1_1.setBounds(21, 101, 48, 14);
				paneActualizar.add(lblNewLabel_1_1);
				
				JLabel lblNewLabel_1_2 = new JLabel("Apellido");
				lblNewLabel_1_2.setBounds(21, 189, 48, 14);
				paneActualizar.add(lblNewLabel_1_2);
				
				JLabel lblNewLabel_1_3 = new JLabel("Pais");
				lblNewLabel_1_3.setBounds(21, 138, 48, 14);
				paneActualizar.add(lblNewLabel_1_3);
				
				txtAutorActualizarNombre = new JTextField();
				txtAutorActualizarNombre.setColumns(10);
				txtAutorActualizarNombre.setBounds(66, 95, 136, 20);
				paneActualizar.add(txtAutorActualizarNombre);
				
				txtAutorActualizarApellido = new JTextField();
				txtAutorActualizarApellido.setColumns(10);
				txtAutorActualizarApellido.setBounds(61, 187, 154, 20);
				paneActualizar.add(txtAutorActualizarApellido);
				
				txtAutorActualizarPais = new JTextField();
				txtAutorActualizarPais.setColumns(10);
				txtAutorActualizarPais.setBounds(66, 132, 136, 20);
				paneActualizar.add(txtAutorActualizarPais);
				
				JButton btnAutorActualizarGuargar = new JButton("Actualizar");
				btnAutorActualizarGuargar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManteAutor m=new ManteAutor();
						Connection conn=m.conectar();
						int id_cod=Integer.parseInt(txtAutorActualizarBuscar.getText());
						String nom=txtAutorActualizarNombre.getText().toString();
						String ape=txtAutorActualizarApellido.getText().toString();
						String pai=txtAutorActualizarPais.getText().toString();
						boolean exitoActualizacion = m.actualizar_autor(id_cod, nom, ape, pai);
						if (exitoActualizacion) {
		                    JOptionPane.showMessageDialog(null, "Actualización exitosa del autor");
		                    m.vaciarTabla(tblReporte);
		                    limpiar();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Error al actualizar el autor");
		                }
					}
				});
				btnAutorActualizarGuargar.setBounds(27, 236, 89, 23);
				paneActualizar.add(btnAutorActualizarGuargar);
			}
			{
				JPanel paneRegistrar = new JPanel();
				tabbedPane.addTab("Registrar", null, paneRegistrar, null);
				paneRegistrar.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Nombre");
					lblNewLabel.setBounds(10, 115, 48, 14);
					paneRegistrar.add(lblNewLabel);
				}
				{
					JLabel lblNewLabel = new JLabel("Codigo");
					lblNewLabel.setBounds(10, 11, 48, 14);
					paneRegistrar.add(lblNewLabel);
				}
				{
					JLabel lblApellido = new JLabel("Apellido");
					lblApellido.setBounds(10, 47, 48, 14);
					paneRegistrar.add(lblApellido);
				}
				{
					JLabel lblPais = new JLabel("Pais");
					lblPais.setBounds(10, 162, 48, 14);
					paneRegistrar.add(lblPais);
				}
				{
					txtRegistrarCodigo = new JTextField();
					txtRegistrarCodigo.setBounds(58, 8, 77, 20);
					paneRegistrar.add(txtRegistrarCodigo);
					txtRegistrarCodigo.setColumns(10);
				}
				{
					txtRegistrarApellido = new JTextField();
					txtRegistrarApellido.setColumns(10);
					txtRegistrarApellido.setBounds(58, 44, 213, 20);
					paneRegistrar.add(txtRegistrarApellido);
				}
				{
					txtRegistrarnombre = new JTextField();
					txtRegistrarnombre.setColumns(10);
					txtRegistrarnombre.setBounds(58, 113, 186, 20);
					paneRegistrar.add(txtRegistrarnombre);
				}
				{
					txtRegistrarPais = new JTextField();
					txtRegistrarPais.setColumns(10);
					txtRegistrarPais.setBounds(52, 160, 83, 20);
					paneRegistrar.add(txtRegistrarPais);
				}
				{
					JButton btnRegistrar = new JButton("Registrar");
					btnRegistrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ManteAutor m=new ManteAutor();
							Connection conn=m.conectar();
							int id_cod=Integer.parseInt(txtRegistrarCodigo.getText());
							String nom=txtRegistrarnombre.getText().toString();
							String ape=txtRegistrarApellido.getText().toString();
							String pai=txtRegistrarPais.getText().toString();
							boolean exitoRegistro = m.registrarAutor(id_cod, nom, ape, pai);
							if (exitoRegistro) {
			                    JOptionPane.showMessageDialog(null, "Registro exitoso del autor");
			                    m.vaciarTabla(tblReporte);
							ResultSet datos=m.consulta_autor();
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
									tblReporte.setValueAt(datos.getString(4), fila, 3);
									fila++;
								}
							}catch(SQLException e5) {
							}
							limpiar();
			                } else {
			                    JOptionPane.showMessageDialog(null, "Error al registrar el autor");
			                }
						}
					});
					btnRegistrar.setBounds(22, 222, 89, 23);
					paneRegistrar.add(btnRegistrar);
				}
			}
			{
				JPanel paneEliminar = new JPanel();
				tabbedPane.addTab("Eliminar", null, paneEliminar, null);
				paneEliminar.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("Ingrese el codigo del autor:");
				lblNewLabel_1.setBounds(23, 38, 135, 14);
				paneEliminar.add(lblNewLabel_1);
				
				txtAutorEliminar = new JTextField();
				txtAutorEliminar.setBounds(180, 35, 96, 20);
				txtAutorEliminar.setColumns(10);
				paneEliminar.add(txtAutorEliminar);
				
				JButton btnAutorEliminar = new JButton("Eliminar");
				btnAutorEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManteAutor m=new ManteAutor();
						Connection conn=m.conectar();
						int id_cod=Integer.parseInt(txtAutorEliminar.getText());
						boolean exitoEliminar = m.eliminar_autor(id_cod);
						if (exitoEliminar) {
		                    JOptionPane.showMessageDialog(null, "Eliminación exitosa del autor");
		                    m.vaciarTabla(tblReporte);
		                    limpiar();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Error al eliminar el autor");
		                }
					}
				});
				btnAutorEliminar.setBounds(299, 34, 84, 23);
				paneEliminar.add(btnAutorEliminar);
			}
			
			JPanel panelReporte = new JPanel();
			tabbedPane.addTab("Reporte", null, panelReporte, null);
			panelReporte.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Buscar por codigo del autor:");
			lblNewLabel_1.setBounds(10, 30, 159, 14);
			panelReporte.add(lblNewLabel_1);
			
			txtAutorCodigo = new JTextField();
			txtAutorCodigo.setBounds(148, 27, 134, 20);
			txtAutorCodigo.setColumns(10);
			panelReporte.add(txtAutorCodigo);
			
			JButton btnAutorReporteBuscar = new JButton("Buscar");
			btnAutorReporteBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManteAutor m=new ManteAutor();
					m.vaciarTabla(tblReporte);
					Connection conn = m.conectar();
					int id_cod = Integer.parseInt(txtAutorCodigo.getText());
					ResultSet datos=m.buscar_autor(id_cod);
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
				                tblReporte.setValueAt(datos.getString(4), fila, 3);
				                fila++;
				             }
				       }catch(SQLException e5) {
					}
				}
			});
			btnAutorReporteBuscar.setBounds(292, 26, 85, 23);
			panelReporte.add(btnAutorReporteBuscar);
			
			JButton btnAutorReporteTodos = new JButton("Ver todos los autores");
			btnAutorReporteTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManteAutor m=new ManteAutor();
					Connection conn=m.conectar();
					ResultSet datos=m.consulta_autor();
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
							tblReporte.setValueAt(datos.getString(4), fila, 3);
							fila++;
						}
					}catch(SQLException e5) {
					}
				}
			});
			btnAutorReporteTodos.setBounds(108, 78, 176, 23);
			panelReporte.add(btnAutorReporteTodos);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(468, 106, 320, 336);
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
				"ID_AUTOR", "NOMBRE", "APELLIDO", "PAIS"
			}
		));
		
		JLabel lblNewLabel_2 = new JLabel("MANTENIMIENTO AUTOR");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_2.setBounds(61, 22, 335, 28);
		contentPanel.add(lblNewLabel_2);
	}
	public void limpiar() {
		txtRegistrarCodigo.setText(null);
		txtRegistrarnombre.setText(null);
		txtRegistrarApellido.setText(null);
		txtRegistrarPais.setText(null);
		txtAutorActualizarBuscar.setText(null);
		txtAutorActualizarNombre.setText(null);
		txtAutorActualizarApellido.setText(null);
		txtAutorActualizarPais.setText(null);
	}
}
