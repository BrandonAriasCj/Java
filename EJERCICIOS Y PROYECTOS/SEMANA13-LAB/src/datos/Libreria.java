package datos;
import java.sql.*;
import javax.swing.JOptionPane;

public class Libreria {
	public String driver = "com.mysql.cj.jdbc.Driver";
	public String cadena= "jdbc:mysql://localhost/empresa";
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
	public void registrar(String codigo, String apellidos, String nombres, String direccion, String distrito) {
		try {
			CallableStatement cs = conn.prepareCall("call sp_registro(?,?,?)");
			cs.setString("codigo", codigo);
			cs.setString("apellidos", apellidos);
			cs.setString("nombres", nombres);
			cs.setString("direccion", direccion);
			cs.setString("distrito", distrito);
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


