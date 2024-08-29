package datos;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class ManteLibro {
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
	public ResultSet consulta_libro() {
		ResultSet data = null;
		try {
			Statement st=conn.createStatement();
			data=st.executeQuery("call sp_consultar_libros");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la consulta");
		}
		return data;
	}
    public boolean registrar_libro(int id_libro, String titulo, String isbn, double precio, int id_autor, String id_editorial) {
        try {
            CallableStatement cs = conn.prepareCall("CALL sp_registrar_libro(?, ?, ?, ?, ?, ?)");
            cs.setInt(1, id_libro);
            cs.setString(2, titulo);
            cs.setString(3, isbn);
            cs.setDouble(4, precio);
            cs.setInt(5, id_autor);
            cs.setString(6, id_editorial);
            cs.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el registro: " + e.getMessage());
            return false;
        }
    }
	public ResultSet buscar_libro(int id_cod) {
		ResultSet data = null;
		try {
			CallableStatement cs=conn.prepareCall("call sp_buscar_libro_por_id(?)");
			cs.setInt(1, id_cod);
			data=cs.executeQuery();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la consulta");
		}
		return data;
	}
    public boolean actualizarLibro(int id_libro, String titulo, String isbn, double precio, int id_autor, String id_editorial) {
        try {
            CallableStatement cs = conn.prepareCall("CALL sp_actualizar_libro(?, ?, ?, ?, ?, ?)");
            cs.setInt(1, id_libro);
            cs.setString(2, titulo);
            cs.setString(3, isbn);
            cs.setDouble(4, precio);
            cs.setInt(5, id_autor);
            cs.setString(6, id_editorial);
            cs.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la actualización: " + e.getMessage());
            return false;
        }
    }
    
	public boolean eliminar_libro(int id_cod) {
		try {
			CallableStatement cs=conn.prepareCall("call sp_eliminar_libro(?)");
			cs.setInt(1, id_cod);
			cs.execute();
			return true;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la eliminacion");
			return false;
		}
	}
    public void vaciarTabla(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Elimina todas las filas de la tabla
    }
}
