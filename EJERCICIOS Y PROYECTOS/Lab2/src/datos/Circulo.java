package datos;

public class Circulo {
	private double radio;
	private String color;
	private double area;
	
	public Circulo(double radio, String color){
		this.radio = radio;
		this.color = color;
	}
	public double getRadio(){
		return radio;	
	}
	public String getColor(){
		return color;
	}
	public void setRadio(double radio){
		this.radio = radio;
	}
	public void setColor(String color){
		this.color = color;
	}
	public double areaCirculo(){
		area = 3.1415 * radio * radio;
		return area;
	}
}
