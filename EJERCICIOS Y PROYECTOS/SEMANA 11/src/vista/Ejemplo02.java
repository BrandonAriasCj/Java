package vista;
import java.sql.*;
import datos.Mantenimiento;
public class Ejemplo02 {

	public static void main(String[] args) {
		Mantenimiento m = new Mantenimiento();
		ResultSet data = m.consulta();
		try {
			while(data.next()) {
				System.out.print(data.getInt(1) + "	");
				System.out.print(data.getString(2) + "		");
				System.out.print(data.getInt(3) + "	");
				System.out.println(data.getDouble(4));
			}
		} catch(SQLException e) {
			System.out.println("Error en la consulta de datos");
		}

	}

}
