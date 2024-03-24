###   Ejercicio: Clase Persona

Escribe una clase `Persona` que tenga los siguientes atributos y métodos:

- Atributos:
    - `nombre` (tipo `String`)
    - `edad` (tipo `int`)
    - 
- Constructores:
    
    - Un constructor sin argumentos que inicialice `nombre` como "Sin nombre" y `edad` como 0.
    - Un constructor con argumentos para establecer `nombre` y `edad` según los valores proporcionados.
- Métodos:
    
    - `getNombre()`: Devuelve el nombre de la persona.
    - `setNombre(String nombre)`: Establece el nombre de la persona.
    - `getEdad()`: Devuelve la edad de la persona.
    - `setEdad(int edad)`: Establece la edad de la persona.

Asegúrate de utilizar los modificadores de acceso adecuados para los atributos y métodos.

```java
public class Persona {
	private String nombre;
	private int edad;
	public Persona(){
		this.nombre = "Sin nombre";
		this.edad = 0;
	}
	public Persona(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
	} 
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre = nombre
	}
	public int getEdad(){
		return edad;
	}
	public void setEdad(int edad){
		this.edad = edad;
	}
}
```