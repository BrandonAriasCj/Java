package datos;
import java.sql.*;
public class mantenimiento extends conexion{
	Statement sen1;
	PreparedStatement sen2;
	ResultSet data;
	public boolean insertar(int codigo,String apellidos,String nombre, String ruc, double lineaCredito, String direccion, String telefono) {
		try {
			String sql="insert into cliente values(?,?,?,?,?,?,?)";
			sen2=conectar().prepareStatement(sql);
			sen2.setInt(1,codigo);
			sen2.setString(2,apellidos);
			sen2.setString(3,nombre);
			sen2.setString(4,ruc);
			sen2.setDouble(5,lineaCredito);
			sen2.setString(6,direccion);
			sen2.setString(7,telefono);
			sen2.execute();
		}catch(SQLException e) {
			System.out.println("ERROR0");
		}

		return true;
	}
	
	public ResultSet consulta() {
		try {
			String sql="select * from cliente";
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