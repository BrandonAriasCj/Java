package vista;
import datos.Persona;

public class Ejercicio01 {

	public static void main(String[] args) {
		Persona Brandon = new Persona("Brandon", 17, "Masculino");
		Persona Brayan = new Persona("Brayan", 18, "Masculino");
		System.out.println("La edad de Brandon es: " + Brandon.getEdad());
		System.out.println("La edad de Brayan es: " + Brayan.getEdad());
	}
}
