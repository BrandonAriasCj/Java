package vista;
import datos.Arreglos;
import java.util.Scanner;
public class Ejemplo1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n, num;
		System.out.println("Ingrese el número de terminos");
		n=s.nextInt();
		Arreglos a = new Arreglos();
		a.numeros=new int[n];
		for(int i=0;i<n;i++) {
			System.out.println("Ingrese un número");
			num=s.nextInt();
			a.numeros[i]= num;
		}
		a.imprimir();
	}

}
