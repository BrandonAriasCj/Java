package vista;
import java.util.Scanner;
import datos.mantenimiento;
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class ejemplo01 {
	public static void main(String[] args) {

		mantenimiento m = new mantenimiento();
		int cod;
		String apel,nom,dir,dni;
		Scanner s=new Scanner(System.in);
		System.out.println("Ingresar codigo");
		cod=s.nextInt();
		System.out.println("Ingresar apellido");
		apel=s.next();
		System.out.println("Ingresar nombre");
		nom=s.next();
		System.out.println("Ingresar dni");
		dni=s.next();
		System.out.println("Ingresar direccion");
		dir=s.next();
		boolean x=m.insertar(cod,apel,nom,dni,dir);
		if(x==true) {
			System.out.println("Registro ok");
		}else {
			System.out.println("Error en el resgistro");
		}
		
	} 

}
