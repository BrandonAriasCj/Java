package datos;
public class Empleado {
	private String nombre;
	private int edad;
	private double sueldo;

	public Empleado (String nombre, int edad , double sueldo){
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}
	public String getNombre (){
		return nombre;
	}
	public int getEdad (){
		return edad;
	}
	public double getSueldo (){
		return sueldo;
	}
	
	public void setNombre (String nombre){
		this.nombre = nombre;
	}
	public void setEdad (int edad){
		this.edad = edad;
	}
	public void setSueldo (double sueldo){
		this.sueldo = sueldo;
	}
	public void sumaPorcentual(double porcentaje){
		sueldo = ((100 + porcentaje) / 100) * sueldo;
	}
}