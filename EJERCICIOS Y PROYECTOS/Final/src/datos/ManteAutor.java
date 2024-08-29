package datos;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class ManteAutor {
	public String driver="com.mysql.cj.jdbc.Driver";
	public String cadena="jdbc:mysql://localhost/patulibro";
	public String usuario="root";
	public String clave="";
	public Connection conn;
	public Statement sen;
	public ResultSet data;
	public Connection conectar() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(cadena,usuario,clave);
		}catch(ClassNotFoundException e1) {
		}catch(SQLException e2) {
		}
		return conn;
	}
	public ResultSet consulta_autor() {
		ResultSet data = null;
		try {
			Statement st=conn.createStatement();
			data=st.executeQuery("call sp_consulta_autor");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la consulta");
		}
		return data;
	}
	public boolean registrarAutor(int id_cod, String nombre, String apellido, String pais) {
		try {
			CallableStatement cs=conn.prepareCall("call sp_registroautor(?,?,?,?)");
			cs.setInt("id_autor", id_cod);
			cs.setString("nombre", nombre);
			cs.setString("apellido", apellido);
			cs.setString("pais", pais);
			cs.execute();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en el registro");
		}
		return true;
	}
	public ResultSet buscar_autor(int id_cod) {
		ResultSet data = null;
		try {
			CallableStatement cs=conn.prepareCall("call sp_busqueda_autor(?)");
			cs.setInt(1, id_cod);
			data=cs.executeQuery();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la busqueda");
		}
		return data;
	}
	public boolean actualizar_autor(int id_cod, String nombre, String apellido, String pais) {
		try {
			CallableStatement cs=conn.prepareCall("call sp_actualizar_autor(?,?,?,?)");
			cs.setInt(1, id_cod);
			cs.setString(2, nombre);
			cs.setString(3, apellido);
			cs.setString(4, pais);
			cs.execute();
			return true;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar");
			return false;
		}
	}
	public boolean eliminar_autor(int id_cod) {
		try {
			CallableStatement cs=conn.prepareCall("call sp_eliminar_autor(?)");
			cs.setInt(1, id_cod);
			cs.execute();
			return true;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Este autor no se puede eliminar, hay libros que dependen de él");
			return false;
		}
	}
    public void vaciarTabla(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Elimina todas las filas de la tabla
    }
}
