package vista;
import datos.Fibonacci;
import java.util.Scanner;
public class Ejemplo2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("De cuantos numeros va estar compuesto tu serie?");
		int n = s.nextInt();
		Fibonacci a = new Fibonacci();
		a.calcularSerie(n);
		a.imprimirSerie();

	}

}

