package Vista;
public class ejemplo2 {

	public static void main(String[] args) {
		String cadena = "Hola mundo";
		char[] arreglo = cadena.toCharArray();
		char c = arreglo[6];
		String s = String.valueOf(c);
		System.out.println(s);
		s = s.toUpperCase();
		System.out.println(s);
	}

}
