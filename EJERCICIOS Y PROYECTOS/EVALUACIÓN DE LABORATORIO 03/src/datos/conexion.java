package datos;
import java.sql.*;
public class conexion {
	public String driver="com.mysql.cj.jdbc.Driver";
	public String cadena="jdbc:mysql://localhost/empresa_peru";
	public String usuario="root";
	public String clave="";
	public Connection conn;
	public Connection conectar() {
	
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(cadena,usuario,clave);
		}catch(ClassNotFoundException e) {
			System.out.println("ERROR conexion con el motor");
		}catch(SQLException e) {
			System.out.println("ERROR conexion con la base de datos");
		}
		return conn;
	}
}