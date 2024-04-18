package vista;
import datos.Asistente;
import java.util.Scanner;
public class Ejemplo02 {
	public static void main(String[] args) {
		int numero;
		double sueldo;
		String nombre, dni;
		
		Ejemplo02 e2 = new Ejemplo02();
		Scanner s = new Scanner(System.in);
		
		System.out.println("Introduce el nombre del asistente: ");
		nombre = s.next();
		System.out.println("Introduce el numero de asistente: ");
		numero = s.nextInt();
		System.out.println("Introduce el dni de asistente: ");
		dni = s.next();
		System.out.println("Introduce el monto del sueldo: ");
		sueldo = s.nextDouble();


		Asistente n = new Asistente(numero, nombre, dni, sueldo);
		e2.listado(n);
		System.out.println("Numeo de asistentes: " + Asistente.getCantidad());
		System.out.println("Sueldo total: " + Asistente.getSuma());
	}
	public void listado(Asistente a) {
		System.out.println(a.getCodigo());
		System.out.println(a.getNombre());
		System.out.println(a.getDni());
		System.out.println(a.getSueldo());
		System.out.println(a.mensaje());
	}

}
