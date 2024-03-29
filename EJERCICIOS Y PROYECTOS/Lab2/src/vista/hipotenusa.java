package vista;
import java.util.Scanner;
import datos.Triangulo;
public class hipotenusa {

	public static void main(String[] args) {
		double cat1, cat2;
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese el primer cateto: ");
		cat1  = s.nextDouble();
		System.out.println("Ingrese el segundo cateto: ");
		cat2  = s.nextDouble();
		Triangulo triangulo1 = new Triangulo(cat1, cat2);
		
		System.out.println("La hipotenusa del triangulo descrito mide: " + triangulo1.Hipotenusa());
		

	}

}
