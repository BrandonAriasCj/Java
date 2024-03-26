package datos;
public class Libro {
	private String titulo;
	private String autor;
	private int añoPublicacion;
	private boolean prestado;
	public Libro(String titulo, String autor, int añoPublicacion){
		this.titulo = titulo;
		this.autor = autor;
		this.añoPublicacion = añoPublicacion;
		this.prestado = false;
	}
	public String getTitulo(){
		return titulo;
	}
	
	public String getAutor(){
		return autor;
	}
	public int getAñoPublicacion(){
		return añoPublicacion;
	}
	public boolean getPrestamo(){
		return prestado;
	}

	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	public void setAutor(String autor){
		this.autor = autor;
	}
	public void setAñoPublicación(int añoPublicacion){
		this.añoPublicacion = añoPublicacion;
	}
	public void setPrestamo(boolean prestado){
		this.prestado = prestado;
	}
	public void prestar(){
		this.prestado = true;
	}
	public void debolver(){
		this.prestado = false;
	}
} 