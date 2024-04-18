package datos;

public class Asistente {
	private int codigo;
	private String nombre;
	private String dni;
	private double sueldo;
	private static int cantidad = 0;
	private static double suma = 0;
	public Asistente(int codigo, String nombre, String dni, double sueldo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.dni = dni;
		this.sueldo = sueldo;
		cantidad++;
		suma = suma + this.sueldo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public static int getCantidad() {
		return cantidad;
	}
	public static void setCantidad(int cantidad) {
		Asistente.cantidad = cantidad;
	}
	public static double getSuma() {
		return suma;
	}
	public static void setSuma(double suma) {
		Asistente.suma = suma;
	}
	public String mensaje() {
		String smg;
		if(sueldo > 1500) {
			smg="El sueldo es mayor a 1500";
		} else if(sueldo < 1500) {
			smg="El sueldo es menor a 1500";
		} else {
			smg="El sueldo es igual a 1500";
		}
		return smg;
	}
}
