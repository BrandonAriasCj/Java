package vista;
import java.sql.*;
import datos.Libreria;

public class ejemplo02 {

	public static void main(String[] args) {
		Libreria lib =  new Libreria();
		ResultSet datos = lib.consulta();
		try {
			while(datos.next()) {
				System.out.print(datos.getString(1)+ " ");
				System.out.print(datos.getString(2)+ " ");
				System.out.print(datos.getString(3)+ " ");
				System.out.print(datos.getString(4)+ " ");
				System.out.println(datos.getString(5)+ " ");
			}
		}catch(SQLException e){
			
		}

	}

}
