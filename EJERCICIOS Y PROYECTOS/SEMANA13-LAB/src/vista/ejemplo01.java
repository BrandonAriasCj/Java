package vista;
import java.util.Scanner;
import datos.Libreria;

public class ejemplo01 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String cod, ape, nom, dir, dis;
		System.out.println("Ingrese codigo");
		cod=s.next();
		System.out.println("Ingrese apellido");
		ape=s.next();
		System.out.println("Ingrese nombre");
		nom=s.next();
		System.out.println("Ingrese direccion");
		dir=s.next();
		System.out.println("Ingrese distrito");
		dis=s.next();

		Libreria lib = new Libreria();
		lib.registrar(cod, ape, nom, dir, dis);
		System.out.println("producto registrado correctamente");
	}

}
