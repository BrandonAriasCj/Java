package vista;
import datos.Persona;

public class vista {

	public static void main(String[] args) {
		int edad;
		Persona Brandon = new Persona("Brandon", 17, "Masculino");
		Persona Brayan = new Persona("Brayan", 18, "Masculino");
		System.out.println("La edad de Brandon es: " + Brandon.getEdad());
		System.out.println("La edad de Brayan es: " + Brayan.getEdad());
	}
}
