package vista;
import java.sql.*;
import java.util.Scanner;
import datos.mantenimiento;
public class ejemplo2 {
	public static void main(String[] args) {
		mantenimiento m=new mantenimiento();
		ResultSet data=m.consulta();
		try {
			while(data.next()) {
				System.out.println(data.getInt(1)+"");
				System.out.println(data.getString(2)+"");
				System.out.println(data.getInt(3)+"");
				System.out.println(data.getDouble(4)+"");
				
			}
		}catch(SQLException e) {}

	}
}
