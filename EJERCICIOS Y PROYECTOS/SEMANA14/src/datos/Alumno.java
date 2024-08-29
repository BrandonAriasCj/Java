package datos;

public class Alumno {
	private int codigo;
	private String apellidos;
	private String nombres;
	private String especialidad;
	private double pension;
	public Alumno(int codigo, String apellidos, String nombres, String especialidad, double pension) {
		super();
		this.codigo = codigo;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.especialidad = especialidad;
		this.pension = pension;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public double getPension() {
		return pension;
	}
	public void setPension(double pension) {
		this.pension = pension;
	}
	
	
}
