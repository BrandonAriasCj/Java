package datos;
import java.sql.*;
public class Libreria {
	public String driver = "com.mysl.cj.jdbc.Driver";
	public String cadena = "jdbc:mysql://localhost/empresa";
	public String usuario = "root";
	public String clave = "mysql";
	public Connection conn;
	public Connection conectar() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(cadena,usuario,clave);
			
		}catch(ClassNotFoundException e){
			System.out.println("error alñdf");
		}catch(SQLException e){
			System.out.println("error alñdf");
			
		}
		return conn;
	}
}
