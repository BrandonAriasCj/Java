package vista;
import java.util.Scanner;
import java.sql.*;
import datos.Mantenimiento;
public class Ejemplo03 {

	public static void main(String[] args) {
		Mantenimiento m = new Mantenimiento();
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese el código de productos a buscar");
		int cod = s.nextInt();
		ResultSet data = m.busqueda("select * from producto where codigo='"+cod+"'");
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
