package datos;
import java.sql.*;
public class mantenimiento extends escuela{
	Statement sen1;
	PreparedStatement sen2;
	ResultSet data;
	public boolean insertar(int codigo,String apellidos,String nombre,String dni,String direccion) {
		try {
			String sql="insert into alumno values(?,?,?,?,?)";
			sen2=conectar().prepareStatement(sql);
			sen2.setInt(1,codigo);
			sen2.setString(2,apellidos);
			sen2.setString(3,nombre);
			sen2.setString(4,dni);
			sen2.setString(5,direccion);
			sen2.executeUpdate();
		}catch(SQLException e) {
			System.out.println("ERROR0");
		}

		return true;
	}
	
	public ResultSet consulta() {
		try {
			String sql="select * from alumno";
			sen2=conectar().prepareStatement(sql);
			data=sen2.executeQuery();
		}catch(SQLException e) {
			System.out.println("ERROR3");
		}
		
		return data;
	}
	

	public ResultSet busqueda(String codigosql) {
		try {
			String sql=codigosql;
			sen1=conectar().createStatement();
			data=sen1.executeQuery(sql);
		}catch(SQLException e) {
			System.out.println("Error en busqueda");
		}
		return data;
		
	}
}
