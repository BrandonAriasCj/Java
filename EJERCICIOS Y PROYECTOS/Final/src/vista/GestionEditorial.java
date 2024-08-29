package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import datos.ManteEditorial;
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

public class GestionEditorial extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTable tblReporte;
    private JTextField txtRegistrarCodigo;
    private JTextField txtRegistrarEmail;
    private JTextField txtRegistrarNombre;
    private JTextField txtRegistrarTelefono;
    private JTextField txtEditorialActualizarBuscar;
    private JTextField txtEditorialActualizarNombre;
    private JTextField txtEditorialActualizarEmail;
    private JTextField txtEditorialActualizarTelefono;
    private JTextField txtEditorialEliminar;
    private JTextField txtEditorialCodigo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            GestionEditorial dialog = new GestionEditorial();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public GestionEditorial() {
        setBounds(100, 100, 960, 757);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
            tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 12));
            tabbedPane.setBounds(23, 61, 409, 510);
            contentPanel.add(tabbedPane);
            {
                JPanel paneActualizar = new JPanel();
                tabbedPane.addTab("Actualizar", null, paneActualizar, null);
                paneActualizar.setLayout(null);

                JLabel lblNewLabel_1 = new JLabel("Ingrese el codigo de la editorial");
                lblNewLabel_1.setBounds(10, 14, 154, 14);
                paneActualizar.add(lblNewLabel_1);

                txtEditorialActualizarBuscar = new JTextField();
                txtEditorialActualizarBuscar.setBounds(167, 12, 104, 20);
                paneActualizar.add(txtEditorialActualizarBuscar);
                txtEditorialActualizarBuscar.setColumns(10);

                JButton btnEditorialActualizarBuscar = new JButton("Buscar");
                btnEditorialActualizarBuscar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ManteEditorial m = new ManteEditorial();
                        m.vaciarTabla(tblReporte);
                        Connection conn = m.conectar();
                        String id_cod = txtEditorialActualizarBuscar.getText().toString();
                        ResultSet datos = m.buscar_editorial(id_cod);
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
                                txtEditorialActualizarNombre.setText(datos.getString(2));
                                txtEditorialActualizarEmail.setText(datos.getString(3));
                                txtEditorialActualizarTelefono.setText(datos.getString(4));
                                fila++;
                            }
                        } catch (SQLException e5) {
                        }
                    }
                });
                btnEditorialActualizarBuscar.setBounds(290, 10, 89, 23);
                paneActualizar.add(btnEditorialActualizarBuscar);

                JLabel lblNewLabel_1_1 = new JLabel("Nombre");
                lblNewLabel_1_1.setBounds(10, 45, 48, 14);
                paneActualizar.add(lblNewLabel_1_1);

                JLabel lblNewLabel_1_2 = new JLabel("Email:");
                lblNewLabel_1_2.setBounds(10, 124, 48, 14);
                paneActualizar.add(lblNewLabel_1_2);

                JLabel lblNewLabel_1_3 = new JLabel("Telefono:");
                lblNewLabel_1_3.setBounds(10, 78, 48, 14);
                paneActualizar.add(lblNewLabel_1_3);

                txtEditorialActualizarNombre = new JTextField();
                txtEditorialActualizarNombre.setColumns(10);
                txtEditorialActualizarNombre.setBounds(55, 39, 136, 20);
                paneActualizar.add(txtEditorialActualizarNombre);

                txtEditorialActualizarEmail = new JTextField();
                txtEditorialActualizarEmail.setColumns(10);
                txtEditorialActualizarEmail.setBounds(50, 122, 154, 20);
                paneActualizar.add(txtEditorialActualizarEmail);

                txtEditorialActualizarTelefono = new JTextField();
                txtEditorialActualizarTelefono.setColumns(10);
                txtEditorialActualizarTelefono.setBounds(55, 76, 136, 20);
                paneActualizar.add(txtEditorialActualizarTelefono);

                JButton btnEditorialActualizarGuardar = new JButton("Actualizar");
                btnEditorialActualizarGuardar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ManteEditorial m = new ManteEditorial();
                        Connection conn = m.conectar();
                        String id_cod = txtEditorialActualizarBuscar.getText().toString();
                        String nombre = txtEditorialActualizarNombre.getText().toString();
                        String email = txtEditorialActualizarEmail.getText().toString();
                        String tel = txtEditorialActualizarTelefono.getText().toString();
                        boolean exitoActualizar = m.actualizar_editorial(id_cod, nombre, email, tel);
                        if (exitoActualizar) {
                            JOptionPane.showMessageDialog(null, "Actualización exitosa de la editorial");
                            m.vaciarTabla(tblReporte);
                            ResultSet datos = m.consultar_editoriales();
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
                            } catch (SQLException e5) {
                            }
                            limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al actualizar la editorial");
                        }
                    }
                });
                btnEditorialActualizarGuardar.setBounds(114, 196, 114, 23);
                paneActualizar.add(btnEditorialActualizarGuardar);
            }
            {
                JPanel paneRegistrar = new JPanel();
                tabbedPane.addTab("Registrar", null, paneRegistrar, null);
                paneRegistrar.setLayout(null);
                {
                    JLabel lblNombre = new JLabel("Nombre");
                    lblNombre.setBounds(10, 105, 48, 14);
                    paneRegistrar.add(lblNombre);
                }
                {
                    JLabel lblCodigo = new JLabel("Codigo");
                    lblCodigo.setBounds(10, 11, 48, 14);
                    paneRegistrar.add(lblCodigo);
                }
                {
                    JLabel lblEmail = new JLabel("Email");
                    lblEmail.setBounds(10, 47, 48, 14);
                    paneRegistrar.add(lblEmail);
                }
                {
                    JLabel lblTelefono = new JLabel("Telefono");
                    lblTelefono.setBounds(10, 157, 48, 14);
                    paneRegistrar.add(lblTelefono);
                }
                {
                    txtRegistrarCodigo = new JTextField();
                    txtRegistrarCodigo.setBounds(58, 8, 77, 20);
                    paneRegistrar.add(txtRegistrarCodigo);
                    txtRegistrarCodigo.setColumns(10);
                }
                {
                    txtRegistrarEmail = new JTextField();
                    txtRegistrarEmail.setColumns(10);
                    txtRegistrarEmail.setBounds(58, 44, 158, 20);
                    paneRegistrar.add(txtRegistrarEmail);
                }
                {
                    txtRegistrarNombre = new JTextField();
                    txtRegistrarNombre.setColumns(10);
                    txtRegistrarNombre.setBounds(57, 102, 186, 20);
                    paneRegistrar.add(txtRegistrarNombre);
                }
                {
                    txtRegistrarTelefono = new JTextField();
                    txtRegistrarTelefono.setColumns(10);
                    txtRegistrarTelefono.setBounds(55, 154, 109, 20);
                    paneRegistrar.add(txtRegistrarTelefono);
                }
                {
                    JButton btnRegistrar = new JButton("Registrar");
                    btnRegistrar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            ManteEditorial m = new ManteEditorial();
                            Connection conn = m.conectar();
                            String id_cod = txtRegistrarCodigo.getText().toString();
                            String nom = txtRegistrarNombre.getText().toString();
                            String email = txtRegistrarEmail.getText().toString();
                            String tel = txtRegistrarTelefono.getText().toString();
                            boolean exitoRegistro = m.registrar_editorial(id_cod, nom, email, tel);
                            if (exitoRegistro) {
                                JOptionPane.showMessageDialog(null, "Registro exitoso de la editorial");
                                m.vaciarTabla(tblReporte);
                                ResultSet datos = m.consultar_editoriales();
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
                                } catch (SQLException e5) {
                                }
                                limpiar();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al registrar la editorial");
                            }
                        }
                    });
                    btnRegistrar.setBounds(10, 221, 89, 23);
                    paneRegistrar.add(btnRegistrar);
                }
            }
            {
                JPanel paneEliminar = new JPanel();
                tabbedPane.addTab("Eliminar", null, paneEliminar, null);
                paneEliminar.setLayout(null);
                {
                    JLabel lblCodigo = new JLabel("Codigo");
                    lblCodigo.setBounds(10, 11, 48, 14);
                    paneEliminar.add(lblCodigo);
                }
                {
                    txtEditorialEliminar = new JTextField();
                    txtEditorialEliminar.setColumns(10);
                    txtEditorialEliminar.setBounds(55, 8, 136, 20);
                    paneEliminar.add(txtEditorialEliminar);
                }
                {
                    JButton btnEliminar = new JButton("Eliminar");
                    btnEliminar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            ManteEditorial m = new ManteEditorial();
                            Connection conn = m.conectar();
                            String id_cod = txtEditorialEliminar.getText().toString();
                            boolean exitoEliminar = m.eliminar_editorial(id_cod);
                            if (exitoEliminar) {
                                JOptionPane.showMessageDialog(null, "Eliminación exitosa de la editorial");
                                m.vaciarTabla(tblReporte);
                                ResultSet datos = m.consultar_editoriales();
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
                                } catch (SQLException e5) {
                                }
                                limpiar();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al eliminar la editorial");
                            }
                        }
                    });
                    btnEliminar.setBounds(229, 7, 89, 23);
                    paneEliminar.add(btnEliminar);
                }
            }
            {
                JPanel paneConsultar = new JPanel();
                tabbedPane.addTab("Consultar", null, paneConsultar, null);
                paneConsultar.setLayout(null);
                {
                    JLabel lblIngreseElCodigo = new JLabel("Ingrese el codigo de la editorial");
                    lblIngreseElCodigo.setBounds(10, 14, 154, 14);
                    paneConsultar.add(lblIngreseElCodigo);
                }
                {
                    txtEditorialCodigo = new JTextField();
                    txtEditorialCodigo.setColumns(10);
                    txtEditorialCodigo.setBounds(167, 12, 104, 20);
                    paneConsultar.add(txtEditorialCodigo);
                }
                {
                    JButton btnBuscar = new JButton("Buscar");
                    btnBuscar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            ManteEditorial m = new ManteEditorial();
                            m.vaciarTabla(tblReporte);
                            Connection conn = m.conectar();
                            String id_cod = txtEditorialCodigo.getText().toString();
                            ResultSet datos = m.buscar_editorial(id_cod);
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
                            } catch (SQLException e5) {
                            }
                        }
                    });
                    btnBuscar.setBounds(281, 11, 89, 23);
                    paneConsultar.add(btnBuscar);
                }
                {
                	JButton btnEditorialReporteTodos = new JButton("Ver todas las editoriales");
                	btnEditorialReporteTodos.addActionListener(new ActionListener() {
        				public void actionPerformed(ActionEvent e) {
        					ManteEditorial m=new ManteEditorial();
        					Connection conn=m.conectar();
        					ResultSet datos=m.consultar_editoriales();
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
        						System.out.println("Error en la la operacion");
        					}
        				}
                	});
                	btnEditorialReporteTodos.setBounds(123, 67, 162, 21);
                	paneConsultar.add(btnEditorialReporteTodos);
                }
            }
        }
        {
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(470, 124, 409, 487);
            contentPanel.add(scrollPane);
            {
                tblReporte = new JTable();
                tblReporte.setModel(new DefaultTableModel(
                        new Object[][]{},
                        new String[]{
                                "Codigo", "Nombre", "Email", "Telefono"
                        }
                ));
                tblReporte.getColumnModel().getColumn(0).setPreferredWidth(44);
                tblReporte.getColumnModel().getColumn(1).setPreferredWidth(100);
                tblReporte.getColumnModel().getColumn(2).setPreferredWidth(100);
                tblReporte.getColumnModel().getColumn(3).setPreferredWidth(100);
                scrollPane.setViewportView(tblReporte);
            }
        }
        {
        	JLabel lblNewLabel_2 = new JLabel("MANTENIMIENTO EDITORIAL");
        	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        	lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
        	lblNewLabel_2.setBounds(64, 10, 335, 28);
        	contentPanel.add(lblNewLabel_2);
        }
    }

    public void limpiar() {
        txtRegistrarCodigo.setText("");
        txtRegistrarNombre.setText("");
        txtRegistrarEmail.setText("");
        txtRegistrarTelefono.setText("");
        txtEditorialActualizarBuscar.setText("");
        txtEditorialActualizarNombre.setText("");
        txtEditorialActualizarEmail.setText("");
        txtEditorialActualizarTelefono.setText("");
        txtEditorialEliminar.setText("");
        txtEditorialCodigo.setText("");
    }
}
