package vista;
import java.util.Scanner;
import datos.Libreria;

public class ejemplo01 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String nom, cat;
		int can;
		System.out.println("Ingrese nombre");
		nom=s.next();
		System.out.println("Ingrese cantidad");
		can=s.nextInt();
		System.out.println("Ingrese categoria");
		cat=s.next();
		Libreria lib = new Libreria();
		lib.registrar(nom, can, cat);
		System.out.println("producto registrado correctamente");
	}

}
