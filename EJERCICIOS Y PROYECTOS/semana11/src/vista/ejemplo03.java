package vista;
import java.util.Scanner;
import java.sql.*;
import datos.mantenimiento;
public class ejemplo03 {

	public static void main(String[] args) {
		mantenimiento m = new mantenimiento();
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese el DNI del alumno que quiere buscar");
		int dni = s.nextInt();
		ResultSet data = m.busqueda("select * from alumno where dni='"+dni +"'");
		try {
			while(data.next()) {
				System.out.print(data.getInt(1) + "		");
				System.out.print(data.getString(2) + "	");
				System.out.print(data.getString(3) + "	");
				System.out.print(data.getString(4) + "	");
				System.out.println(data.getString(5));
			}
		} catch(SQLException e) {
			System.out.println("Error en la busqueda del ejemplo 03");
		}
	}

}
