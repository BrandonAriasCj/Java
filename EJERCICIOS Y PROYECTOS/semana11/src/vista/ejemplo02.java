package vista;
import java.sql.*;
import datos.mantenimiento;
public class ejemplo02 {
	public static void main(String[] args) {
		mantenimiento m=new mantenimiento();
		ResultSet data=m.consulta();
		try {
			while(data.next()) {
				System.out.print(data.getInt(1)+"	");
				System.out.print(data.getString(2)+"	");
				System.out.print(data.getString(3)+"	");
				System.out.print(data.getString(4)+"	");
				System.out.println(data.getString(5)+"	");
				
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejemplo02");	
		}

	}
}
