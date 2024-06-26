¡Claro! Aquí te dejo algunos ejercicios básicos que involucran constructores y encapsulamiento en Java. Estos ejercicios te ayudarán a practicar la creación de clases con constructores y el uso de modificadores de acceso para encapsular los campos de la clase. 

Recuerda que el encapsulamiento se refiere a la práctica de ocultar los detalles de implementación de una clase y proporcionar métodos públicos para acceder y modificar sus atributos. Los constructores, por otro lado, se utilizan para inicializar los objetos de una clase. 

### Ejercicio 1: Creación de una Clase "Persona"

Crea una clase `Persona` con los siguientes atributos:

- `nombre` (String)
- `edad` (int)
- `genero` (char)

Incluye un constructor que tome como parámetros el nombre, edad y género para inicializar los atributos. Además, implementa métodos públicos para obtener y establecer estos atributos de manera segura.

```java
package datos;
public class Persona {
	private String nombre;
	private int edad;
	private String genero;
	public Persona(String nombre, int edad, String genero){
		this.nombre = nombre;
		this.edad = edad;
		this.genero = genero;
	}

	public String getNombre(){
		return nombre;
	}
	public int getEdad(){
		return edad;
	}
	public String getGenero(){
		return genero;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public void setEdad(int edad){
		this.edad = edad;
	}
	public void setGenero(String genero){
		this.genero = genero;
	}
} 
```
### Ejercicio 2: Creación de una Clase "Círculo"

Crea una clase `Circulo` que represente un círculo en un plano. Los atributos de la clase serán:

- `radio` (double)
- `color` (String)

Incluye un constructor que tome como parámetros el radio y el color del círculo. Implementa métodos públicos para obtener y establecer estos atributos de manera segura. Además, incluye un método para calcular el área del círculo.

```java
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
```
### Ejercicio 3: Creación de una Clase "Cuenta Bancaria"

Crea una clase `CuentaBancaria` que represente una cuenta bancaria simple. Los atributos de la clase serán:

- `numeroCuenta` (int)
- `saldo` (double)
- `titular` (String)

Incluye un constructor que tome como parámetros el número de cuenta y el titular. Implementa métodos públicos para obtener el saldo y el titular de la cuenta. Además, incluye métodos para depositar y retirar dinero de la cuenta de manera segura.

```java
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
```

[Mejoras](obsidian://open?vault=Java&file=Mejoras%20de%20seguridad%20ejercicio%203%20cuenta%20bancaria)
### Ejercicio 4: Creación de una Clase "Libro"

Crea una clase `Libro` que represente un libro en una biblioteca. Los atributos de la clase serán:

- `titulo` (String)
- `autor` (String)
- `anioPublicacion` (int)
- `prestado` (boolean)

Incluye un constructor que tome como parámetros el título, autor y año de publicación del libro. Implementa métodos públicos para obtener y establecer estos atributos de manera segura. Además, incluye un método para marcar el libro como prestado y otro para devolverlo.

```java
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
```
### Ejercicio 5: Creación de una Clase "Empleado"

Crea una clase `Empleado` que represente a un empleado de una empresa. Los atributos de la clase serán:

- `nombre` (String)
- `edad` (int)
- `sueldo` (double)

Incluye un constructor que tome como parámetros el nombre, edad y sueldo del empleado. Implementa métodos públicos para obtener y establecer estos atributos de manera segura. Además, incluye un método para aumentar el sueldo del empleado en un porcentaje dado.

```java
package datos;
public class Empleado {
	private String nombre;
	private int edad;
	private double sueldo;

	public Empleado (String nombre, int edad , double sueldo){
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}
	public String getNombre (){
		return nombre;
	}
	public int getEdad (){
		return edad;
	}
	public double getSueldo (){
		return sueldo;
	}
	
	public void setNombre (String nombre){
		this.nombre = nombre;
	}
	public void setEdad (int edad){
		this.edad = edad;
	}
	public void setSueldo (double sueldo){
		this.sueldo = sueldo;
	}
	public void sumaPorcentual(double porcentaje){
		sueldo = ((100 + porcentaje) / 100) * sueldo;
	}
}
```

Estos ejercicios te darán una buena práctica en la creación de clases con constructores y el uso del encapsulamiento para garantizar un acceso seguro a los atributos de la clase. ¡Espero que te sean de ayuda! Recuerda que la práctica constante es clave para familiarizarse con estos conceptos en Java.

