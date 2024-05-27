package datos;
import java.sql.*;
public class Mantenimiento extends Libreria {
	Statement sen1;
	PreparedStatement sen2;
	ResultSet data;
	public boolean insertar(int codigo,String nombre,int cantidad, double precio) {
		try {
			String sql = "insert into producto values(?,?,?,?)";
			sen2=conectar().prepareStatement(sql);
			sen2.setInt(1, codigo);
			sen2.setString(2, nombre);
			sen2.setInt(3, cantidad);
			sen2.setDouble(4, precio);
			sen2.executeUpdate();
		} catch(SQLException e) {
			
		}
		return true;
	}
	public ResultSet consulta() {
		try {
			String sql="select * from producto";
			sen2 = conectar().prepareStatement(sql);
			data=sen2.executeQuery();
			
		}catch(SQLException e) {
			
		}
		return data;
	}
	
	public ResultSet busqueda(String codigosql) {
		try {
			String sql=codigosql;
			sen1=conectar().createStatement();
			data=sen1.executeQuery(sql);
		}catch(SQLException e) {
			
		}
		return data;
	}

}
