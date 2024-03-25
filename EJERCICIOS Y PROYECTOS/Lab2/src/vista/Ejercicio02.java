package vista;

import datos.Circulo;

public class Ejercicio02 {

	public static void main(String[] args) {
		Circulo pequeño = new Circulo(0.5,"Rojo");
		Circulo grande = new Circulo(5.0,"Azul");


		System.out.println(preseCirc("grande") + grande.areaCirculo());
		System.out.println(preseCirc("pequeño") + pequeño.areaCirculo());
	}
	
	public static String preseCirc(String nombre){
		String concatenado = String.format("El area del circulo %s es: ", nombre);
		return concatenado;
	}

}
