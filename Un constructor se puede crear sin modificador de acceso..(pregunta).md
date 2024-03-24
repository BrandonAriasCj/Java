Sí, en Java es posible definir un constructor sin especificar un modificador de acceso. Cuando no se especifica ningún modificador de acceso, se utiliza el modificador por defecto, también conocido como "package-private" o "sin modificador". Esto significa que el constructor es accesible solo dentro del mismo paquete en el cual está declarado.

Aquí tienes un ejemplo de cómo se vería un constructor sin modificador de acceso en Java:

```java
public class Persona {
    private String nombre;
    private int edad;
    
    // Constructor sin modificador de acceso (package-private)
    Persona() {
        this.nombre = "Sin nombre";
        this.edad = 0;
    }
    
    // Otros métodos de la clase Persona...
}
```

En este ejemplo, el constructor `Persona()` no tiene un modificador de acceso explícito, lo que significa que es accesible solo dentro del mismo paquete en el cual se encuentra la clase `Persona`. Fuera de ese paquete, otros archivos de código no podrán acceder directamente a este constructor.

Es importante tener en cuenta que si deseas que el constructor sea accesible desde otras clases fuera del paquete, necesitarías usar un modificador de acceso (`public`, `private`, `protected`), dependiendo de tus necesidades de diseño y de cómo quieras que se comporte tu programa.

En resumen, es posible definir un constructor sin un modificador de acceso en Java, lo que significa que este utilizará el modificador por defecto y será accesible solo dentro del mismo paquete.