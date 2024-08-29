package datos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManteEditorial {
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String cadena = "jdbc:mysql://localhost/patulibro";
    public String usuario = "root";
    public String clave = "";
    public Connection conn;
    public Statement sen;
    public ResultSet data;

    public Connection conectar() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(cadena, usuario, clave);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        return conn;
    }



    public void vaciarTabla(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Elimina todas las filas de la tabla
    }

    // Métodos para gestionar la tabla EDITORIAL

    public boolean registrar_editorial(String id_editorial, String nombre, String email, String telefono) {
        try {
            CallableStatement cs = conn.prepareCall("CALL sp_registrar_editorial(?, ?, ?, ?)");
            cs.setString(1, id_editorial);
            cs.setString(2, nombre);
            cs.setString(3, email);
            cs.setString(4, telefono);
            cs.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el registro de la editorial: " + e.getMessage());
            return false;
        }
    }

    public ResultSet consultar_editoriales() {
        ResultSet data = null;
        try {
            Statement st = conn.createStatement();
            data = st.executeQuery("CALL sp_consultar_editoriales()");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de editoriales: " + e.getMessage());
        }
        return data;
    }

    public ResultSet buscar_editorial(String id_editorial) {
        ResultSet data = null;
        try {
            CallableStatement cs = conn.prepareCall("CALL sp_buscar_editorial_por_id(?)");
            cs.setString(1, id_editorial);
            data = cs.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la búsqueda de la editorial: " + e.getMessage());
        }
        return data;
    }

    public boolean actualizar_editorial(String id_editorial, String nombre, String email, String telefono) {
        try {
            CallableStatement cs = conn.prepareCall("CALL sp_actualizar_editorial(?, ?, ?, ?)");
            cs.setString(1, id_editorial);
            cs.setString(2, nombre);
            cs.setString(3, email);
            cs.setString(4, telefono);
            cs.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la actualización de la editorial: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar_editorial(String id_editorial) {
        try {
            CallableStatement cs = conn.prepareCall("CALL sp_eliminar_editorial(?)");
            cs.setString(1, id_editorial);
            cs.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hay libros que dependen de esta editorial, no se puede eliminar");
            return false;
        }
    }
}
