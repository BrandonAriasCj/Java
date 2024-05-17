package vista;
import java.sql.*;
import datos.Mantenimiento;
public class ejemplo01 {

	public static void main(String[] args) {
		Mantenimiento m = new Mantenimiento();
		m.conectar();
		ResultSet datos = m.consulta();
		try {
			while(datos.next()) {
				System.out.print(datos.getInt(1) + "	");
				System.out.print(datos.getString(2) + "		");
				System.out.print(datos.getInt(3) + "	");
				System.out.println(datos.getDouble(4));
			}
		} catch(SQLException e) {
			System.out.println("Error en la consulta de datos");
		}
		
	}

}
