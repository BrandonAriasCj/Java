package vista;
import datos.Profesor;
public class Ejemplo01 {

	public static void main(String[] args) {
		Ejemplo01 e1= new Ejemplo01();
		Profesor a = new Profesor(1,"Carlos",50,30);
		e1.imprimir(a);
		Profesor b = new Profesor(2,"Mabel",120,35);
		e1.imprimir(b);
		Profesor c = new Profesor(3,"Sebastian",150,25);
		e1.imprimir(c);
		System.out.println("Número de profesores: " + 
		Profesor.getCantidad());
		System.out.println("Sueldo acumulado : " + 
		Profesor.getTotalsueldo());
		
		
	}
	public void imprimir(Profesor x) {
		System.out.println(x.getCodigo());
		System.out.println(x.getNombre());
		System.out.println(x.getHorasTrabajadas());
		System.out.println(x.getTarifa());
		System.out.println(x.obtenerSueldo());
	}

}
