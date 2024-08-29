Sí, es cierto. En Java, cuando una clase está marcada como `static`, no se puede instanciar utilizando el operador `new`. Veamos con más detalle qué significa tener una clase `static` y cómo afecta la creación de instancias:

### Clase `static` en Java

En Java, `static` se aplica principalmente a variables, métodos y clases anidadas. Cuando aplicamos `static` a una clase, estamos indicando que esa clase pertenece a la definición de la clase exterior y no a las instancias individuales de esa clase exterior. Aquí hay dos casos comunes en los que se utiliza `static` con clases:

1. **Clases Anidadas Estáticas (Nested Static Class)**:
   - Una clase anidada estática es una clase interna que se declara con `static`.
   - No tiene acceso directo a los miembros no estáticos de la clase exterior.
   - Se puede acceder a una clase anidada estática sin instanciar su clase externa.

   ```java
   public class OuterClass {
       // Código de la clase OuterClass

       static class StaticNestedClass {
           // Código de la clase StaticNestedClass
       }
   }
   ```

2. **Métodos Estáticos que Devuelven una Instancia**:
   - A veces, una clase puede tener un método estático que devuelve una instancia de sí misma (patrón de diseño Singleton, por ejemplo).
   - Aunque el método es estático, devuelve una instancia de la clase.

   ```java
   public class MyClass {
       private static MyClass instance;

       private MyClass() {
           // Constructor privado para evitar la creación directa de instancias
       }

       public static MyClass getInstance() {
           if (instance == null) {
               instance = new MyClass();
           }
           return instance;
       }
   }
   ```

### No se Puede Instanciar una Clase `static` Directamente

Cuando una clase está marcada como `static`, no es posible crear instancias de esa clase utilizando `new`. Esto se debe a que la palabra clave `static` en una clase tiene un significado diferente: indica que la clase no está asociada con instancias específicas de la clase contenedora, sino que existe independientemente de cualquier instancia particular.

Por lo tanto, intentar crear una instancia de una clase `static` arrojará un error de compilación en Java. Aquí tienes un ejemplo de cómo no se debe intentar instanciar una clase `static`:

```java
public class StaticClassExample {
    static class StaticNestedClass {
        // Código de la clase anidada estática
    }

    public static void main(String[] args) {
        // Intento incorrecto de instanciar una clase estática
        // Esto dará un error de compilación
        // StaticNestedClass instance = new StaticNestedClass();
    }
}
```

En resumen, en Java, cuando una clase está marcada como `static`, no puedes crear instancias de ella utilizando el operador `new`. Las clases estáticas se utilizan principalmente para encapsular funcionalidades que son independientes de las instancias de la clase contenedora y para mejorar la modularidad del código.