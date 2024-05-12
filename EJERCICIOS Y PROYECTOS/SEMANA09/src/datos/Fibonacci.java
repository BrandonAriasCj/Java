package datos;
import datos.Arreglos;
public class Fibonacci extends Arreglos{
	Arreglos b = new Arreglos();
	public void calcularSerie(int longitud) {
		//1,1,2,3,5,8
		b.numeros = new int[longitud];
		b.numeros[0] = 0;
		b.numeros[1] = 1;
		for(int i = 2; i< longitud; i++) {
			b.numeros[i] = b.numeros[i-1]+b.numeros[i-2];
		}
	}
	public void imprimirSerie() {
		System.out.println("La serie de fibonacci es:");
		for(int i=0; i< b.numeros.length;i++) {
			System.out.println(b.numeros[i]);
		}
	}
}
