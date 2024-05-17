package datos;

import java.sql.*;

public class Mantenimiento {
	public String driver="com.mysql.cj.jdbc.Driver";
	public String cadena="jdbc:mysql://localhost/inventario";
	public String usuario="root";
	public String clave="";
	public Connection conn;
	public Statement sen;
	public ResultSet data;
	public void conectar() { 
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(cadena, usuario,clave);
			sen = conn.createStatement();
			
		} catch(ClassNotFoundException e1) {
			System.out.println("Error en el driver"+e1);
		} catch(SQLException e2) {
			System.out.println("Error len la conexion"+e2);
		}
	}
	public ResultSet consulta() {
		try {
			data = sen.executeQuery("select * from articulo");
		}catch(SQLException e3) {
			System.out.println("Error en la consulta");
		}
		return data;
	}
}
