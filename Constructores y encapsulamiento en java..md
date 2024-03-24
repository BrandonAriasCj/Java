En Java, los constructores son métodos especiales que se llaman automáticamente cuando se crea un objeto de una clase. Tienen el mismo nombre que la clase y se utilizan para inicializar los objetos de esa clase. Por otro lado, el encapsulamiento es un principio de la programación orientada a objetos que consiste en ocultar los detalles internos de una clase y restringir el acceso directo a ellos desde fuera de la clase. Esto se logra definiendo los atributos de la clase como privados y proporcionando métodos públicos para acceder y modificar esos atributos.

### Constructores en Java:

En Java, los constructores se definen usando el mismo nombre que la clase y no tienen un tipo de retorno. Pueden tener argumentos para inicializar los atributos de la clase. Aquí hay algunos ejemplos de constructores en Java:

1. Constructor sin argumentos:
   
   ```java
   public class Persona {
       private String nombre;
       private int edad;
   
       // Constructor sin argumentos
       public Persona() {
           this.nombre = "Sin nombre";
           this.edad = 0;
       }
   }
   ```


2. Constructor con argumentos:

   ```java
   public class Persona {
       private String nombre;
       private int edad;
   
       // Constructor con argumentos
       public Persona(String nombre, int edad) {
           this.nombre = nombre;
           this.edad = edad;
       }
   }
   ```

3. Constructor por defecto:

   Si no defines ningún constructor en tu clase, Java proporciona uno por defecto sin argumentos que inicializa los campos numéricos en 0, los booleanos en `false` y las referencias en `null`.

   ```java
   public class Persona {
       private String nombre;
       private int edad;
   }
   ```

```java
public class Persona {
	
}   
```

[[Que pasa si una clase no cuenta con un constructor]]
### Encapsulamiento en Java:

El encapsulamiento en Java se logra definiendo los atributos de una clase como privados y proporcionando métodos públicos (también conocidos como "getters" y "setters") para acceder y modificar esos atributos. Esto se hace para controlar el acceso y evitar que se modifiquen los datos de manera inapropiada. Aquí hay un ejemplo:

![[Pasted image 20240324100647.png]]

```java
public class Persona {
    private String nombre;
    private int edad;
    
    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }
    
    // Setter para el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Getter para la edad
    public int getEdad() {
        return edad;
    }
    
    // Setter para la edad
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("La edad no puede ser negativa.");
        }
    }
}
```

En este ejemplo, los atributos `nombre` y `edad` son privados, lo que significa que no se pueden acceder directamente desde fuera de la clase. Los métodos `getNombre()`, `setNombre()`, `getEdad()` y `setEdad()` proporcionan acceso controlado a estos atributos.

Ejemplo de uso de la clase `Persona`:

```java
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.setNombre("Juan");
        persona1.setEdad(30);
        
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Edad: " + persona1.getEdad());
    }
}
```

En este ejemplo, se crea un objeto `persona1` de la clase `Persona`, se establecen el nombre y la edad utilizando los métodos `setNombre()` y `setEdad()`, y luego se imprimen utilizando los métodos `getNombre()` y `getEdad()`.

El encapsulamiento ayuda a mantener un código más limpio y organizado, evitando el acceso directo a los datos internos de una clase y proporcionando métodos para realizar operaciones de manera controlada y segura.

[Encapsulamiento (Informática)](https://es.wikipedia.org/wiki/Encapsulamiento_%28inform%C3%A1tica%29)

