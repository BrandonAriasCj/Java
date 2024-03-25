package datos;
public class CuentaBancaria{
	private int numeroCuenta;
	private double saldo;
	private String titular;
	public CuentaBancaria(int numeroCuenta, String titular){
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
	} 
	public String getTitular(){
		return titular;
	}
	public double getSaldo(){
		return saldo;
	}
	public void setTitular(String titular){
		this.titular = titular;
	}
	public void setSaldo(double saldo){
		this.saldo = saldo;
	}
	public void depositar(double deposito){
		saldo = saldo + deposito;
	}
	public void retirar(double aRetirar){
		saldo = saldo - aRetirar;
	}
}