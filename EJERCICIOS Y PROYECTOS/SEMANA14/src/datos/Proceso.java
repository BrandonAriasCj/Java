package datos;
import java.util.Collection;
import java.util.Vector;
public class Proceso {
	public static Collection<Alumno> listado(){
		Vector<Alumno> lista = new Vector<Alumno>();
		lista.add(new Alumno(1,"Diaz","Carlos", "Avionica", 1500));
		lista.add(new Alumno(2, "Rivera", "Rosa", "Mecánica", 1600));
		lista.add(new Alumno(3, "Vega", "Manuel", "TI", 4522));
		lista.add(new Alumno(4, "Asto","Cesar", "Electrónica", 2562));
		lista.add(new Alumno(5, "Pardo", "Maria", "Industrial", 2500));
		return lista;
	}
}
