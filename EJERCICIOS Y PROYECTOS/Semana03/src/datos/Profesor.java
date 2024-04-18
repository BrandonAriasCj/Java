package datos;

public class Profesor {
	private int codigo;
	private String nombre;
	private int horasTrabajadas;
	private double tarifa;
	private static int cantidad = 0;
	private static double totalsueldo= 0;
	public Profesor(int codigo, String nombre, int horasTrabajadas, double tarifa) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.horasTrabajadas = horasTrabajadas;
		this.tarifa = tarifa;
		cantidad = cantidad + 1;
		totalsueldo=tarifa*horasTrabajadas;
		totalsueldo=totalsueldo+this.tarifa*this.horasTrabajadas;
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
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}
	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	public double getTarifa() {
		return tarifa;
	}
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	public static int getCantidad() {
		return cantidad;
	}
	public static void setCantidad(int cantidad) {
		Profesor.cantidad = cantidad;
	}
	public static double getTotalsueldo() {
		return totalsueldo;
	}
	public static void setTotalsueldo(double totalsueldo) {
		Profesor.totalsueldo = totalsueldo;
	}
	public double obtenerSueldo() {
		double sueldo = tarifa*horasTrabajadas;
		return sueldo;
	}
	
}
