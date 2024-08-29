package vista;
import datos.mantenimiento;
import java.util.Scanner;
import java.sql.*;
public class menu {
	public static void main(String[] args) {
		mantenimiento m = new mantenimiento();
		Scanner s = new Scanner(System.in);
		imprimirMenuOpciones();
		int num = s.nextInt();
        switch (num) {
        case 1:
        	Scanner a = new Scanner(System.in);
        	String ape, nom, ruc, dir, tel;
        	int cod;
        	double lc;
        	System.out.println("Ingrese el codigo");
        	cod = a.nextInt();
        	System.out.println("Ingrese el apellido");
        	ape = a.next();
        	System.out.println("Ingrese el nombre");
        	nom = a.next();
        	System.out.println("Ingrese el RUC");
        	ruc = a.next();
        	System.out.println("Ingrese la linea de credito");
        	lc = a.nextDouble();
        	System.out.println("Ingrese la dirección");
        	dir = a.next();
        	System.out.println("Ingrese el teléfono");
        	tel = a.next();
            m.insertar(cod, ape, nom, ruc, lc, dir, tel);
            System.out.println("Registro exitoso!!");

            break;
        case 2:
            ResultSet dataConsulta= m.consulta();
            imprimirData(dataConsulta);
            break;
            
        case 3:
        	Scanner b = new Scanner(System.in);
        	System.out.println("Ingrese el código del elemento buscado");
        	int cod_b = b.nextInt();
            ResultSet dataBusquedaCod = m.busqueda("select * from cliente where cod = "+cod_b);
            imprimirData(dataBusquedaCod);
            break;
        case 4:
        	System.out.println("Ingrese el RUC del elemento buscado");
        	Scanner c = new Scanner(System.in);
        	String ruc_b = c.next();
            ResultSet dataBusquedaRUC = m.busqueda("select * from cliente where ruc = '"+ ruc_b +"'");
            imprimirData(dataBusquedaRUC);
        	break;
        default:
            System.out.println("Número desconocido");
            break;
        }
    }
	
	public static void imprimirMenuOpciones() {
		System.out.println("Menu de Opciones:");
		System.out.println("1. Insertar");
		System.out.println("2. Lista");
		System.out.println("3. Buscar por Codigo");
		System.out.println("4. Buscar por RUC");
		System.out.print("Ingrese el número de la opción que desea ejecutar: ");
	}
	public static void imprimirData(ResultSet data) {
		System.out.println(" ");
		try {
			while(data.next()) {				
				System.out.print(data.getInt(1)+"	");
				System.out.print(data.getString(2)+"	");
				System.out.print(data.getString(3)+"	");
				System.out.print(data.getString(4)+"	");
				System.out.print(data.getDouble(5)+"	");
				System.out.print(data.getString(6)+"	");
				System.out.println(data.getString(7)+"	");
				
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener datos");	
		}
	}
}
