package datos;
public class Triangulo {
	double cateto1;
	double cateto2;
	public Triangulo(double cateto1, double cateto2) {
		this.cateto1 = cateto1;
		this.cateto2 = cateto2;
	}
	public double Hipotenusa() {
		double hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
		return hipotenusa;
	}
}