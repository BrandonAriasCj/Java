package vista;
import datos.Circulo;
public class Ejercicio02 {

	public static void main(String[] args) {
		Circulo pequeño = new Circulo(0.5,"Rojo");
		Circulo grande = new Circulo(5.0,"Azul");
		System.out.println("El area del circulo pequeño es: " + pequeño.areaCirculo());
		System.out.println("El area del circulo grande es: " + grande.areaCirculo());
	}

}
