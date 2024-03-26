package vista;
import datos.Libro;
public class Ejercicio04 {

	public static void main(String[] args) {
		Libro primero = new Libro("Vendele a la mente no a la gente", "Jurgen Claric", 1990);
		System.out.println("Estado de prestamo: " + primero.getPrestamo());
		primero.setPrestamo(true);
		System.out.println("Estado de prestamo: " + primero.getPrestamo());
		
	}

}
