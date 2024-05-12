package datos;
public class Arreglos implements Constante{
	public int numeros[];
	public int mayor() {
		// TODO Auto-generated method stub
		int numMay;
		numMay = numeros[0];
		for(int i=1; i<numeros.length;i++) {
			if(numMay < numeros[i]) {
				numMay=numeros[i];
			}
		}
		return numMay;
	}

	public int menor() {
		// TODO Auto-generated method stub
		int numMen;
		numMen = numeros[0];
		for(int i=1; i<numeros.length;i++) {
			if(numMen>numeros[i]) {
				numMen=numeros[i];
			}
		}
		return numMen;
	}

	public double promedio() {
		// TODO Auto-generated method stub
		double suma=0, prom;
		for(int i=0; i<numeros.length;i++) {
			suma=suma+numeros[i];
		}
		prom=suma/numeros.length;
		return prom;
	}
	
	public void imprimir() {
		System.out.println("El promedio es: "+promedio());
		System.out.println("El mayor es: "+mayor());
		System.out.println("El menor es: "+menor());
	}
}
