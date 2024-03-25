package vista;
import datos.CuentaBancaria;
public class Ejercicio03 {

	public static void main(String[] args) {
		CuentaBancaria Nick= new CuentaBancaria(123456789, "Nick");
		Nick.depositar(10);
		System.out.println(Nick.getSaldo());
		Nick.retirar(4);
		System.out.println(Nick.getSaldo());
	}

}
