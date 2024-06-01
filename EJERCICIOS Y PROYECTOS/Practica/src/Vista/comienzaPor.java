package Vista;
import java.util.ArrayList;
import java.util.List;
public class comienzaPor {

	public static void main(String[] args) {
		String cadena1 = "hola mundo tatata";
		String cadena2 = "que tal como estas";
		boolean primera = cadena1.startsWith("o");
		boolean segunda = cadena2.startsWith("hol");
		System.out.println(primera);
		System.out.println(segunda);
		List<boolean> numeros = List.of(true, false, true);
		System.out.println(numeros);
		
	}

}
