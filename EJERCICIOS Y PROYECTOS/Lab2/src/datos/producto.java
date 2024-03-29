package datos;
public class producto {
	private int codigo;
	private String descripcion;
	private int cantidad ;
	private double precioUnitario;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public double precioT(){
		double T= cantidad * precioUnitario;
		return T;
	}
		
	public double Igv(){ 
		double imp= (cantidad * precioUnitario) * 0.18;
		return imp;
	}

}