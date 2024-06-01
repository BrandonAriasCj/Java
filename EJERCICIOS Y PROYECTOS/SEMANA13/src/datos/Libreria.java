package datos;
import java.sql.*;
import javax.swing.JOptionPane;

public class Libreria {
	public String driver = "com.mysql.cj.jdbc.Driver";
	public String cadena= "jdbc:mysql://localhost/inventario2024";
	public String usuario = "root";
	public String clave = "";
	public Connection conn;
	public Libreria() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(cadena,usuario,clave);
		}catch(ClassNotFoundException e1){
			
		}catch(SQLException e2){
			
		}
	}
	public void registrar(String nombre, int cantidad, String categoria) {
		try {
			CallableStatement cs = conn.prepareCall("call sp_registro(?,?,?)");
			cs.setString("nombre", nombre);
			cs.setInt("cantidad", cantidad);
			cs.setString("categoria", categoria);
			cs.execute();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error en el registro");
		}
	}
	
	public ResultSet consulta() {
		ResultSet data = null;
		try {
			Statement st = conn.createStatement();
			data=st.executeQuery("call sp_consulta()");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la consulta");
		}
		return data;
	}
}


