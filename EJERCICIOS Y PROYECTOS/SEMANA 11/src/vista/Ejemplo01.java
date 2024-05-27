package vista;
import java.util.Scanner;
import datos.Mantenimiento;
public class Ejemplo01 {

	public static void main(String[] args) {
		Mantenimiento m = new Mantenimiento();
		int cod,can; String nom; double pre;
		Scanner s = new Scanner(System.in);
		System.out.println("Ingresar codigo");
		cod=s.nextInt();
		System.out.println("Ingresar nombre");
		nom=s.next();
		System.out.println("Ingresar cantidad");
		can=s.nextInt();
		System.out.println("Ingresar precio");
		pre=s.nextDouble();
		boolean x=m.insertar(cod,nom,can,pre);
		if(x) {
			System.out.println("Registro OK");
		}else {
			System.out.println("Error en el registro");
		}
	}

}
