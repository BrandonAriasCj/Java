package Vista;

import java.time.LocalDate;

public class Vista {

	public static void main(String[] args) {
		String cadena1 = "HOLA MUNDO";
		String cadena2 = "hola mundo";
		boolean iguales1 = cadena1.equalsIgnoreCase(cadena2);
		boolean iguales2 = cadena1 == cadena2;
		System.out.println(iguales1);
		System.out.println(iguales2);
		
		LocalDate fechaActual = LocalDate.now();
		System.out.println(fechaActual);
	}

}
