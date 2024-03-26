package vista;
import datos.Empleado;
public class Ejercicio05 {

	public static void main(String[] args) {
		Empleado empleado1 = new Empleado("Richi",25,100);
		System.out.println("El sueldo del empleado es: " + empleado1.getSueldo());
		empleado1.sumaPorcentual(25);
		System.out.println("El sueldo del empleado es: " + empleado1.getSueldo());

	}

}

