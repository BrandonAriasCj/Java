En Java, tanto las clases abstractas como las interfaces son herramientas para la abstracción y la definición de contratos para las clases que las implementan, pero tienen diferencias clave en su implementación y uso.

1. **Clase abstracta**:
   - Una clase abstracta es una clase que no se puede instanciar directamente, es decir, no se pueden crear objetos de una clase abstracta. En cambio, se utiliza como base para otras clases mediante la herencia.
   - Puede contener tanto métodos concretos como métodos abstractos.
   - Puede tener campos de instancia (variables de clase) y constructores.
   - Se utiliza para modelar clases que comparten características comunes, pero que pueden tener diferentes implementaciones para algunos métodos.
   - Se declara utilizando la palabra clave `abstract`.

```java
abstract class Animal {
    String nombre;
    
    abstract void hacerSonido();
    
    void dormir() {
        System.out.println("Zzz");
    }
}

class Perro extends Animal {
    @Override
    void hacerSonido() {
        System.out.println("Guau");
    }
}
```

2. **Interface**:
   - Una interfaz en Java es una colección de métodos abstractos y constantes (variables estáticas finales). No puede contener métodos concretos ni campos de instancia.
   - Define un contrato que las clases que la implementan deben seguir. Es decir, las clases que implementan una interfaz deben proporcionar implementaciones para todos los métodos definidos en la interfaz.
   - No puede tener constructores ya que no se pueden instanciar.
   - Se utiliza para definir comportamientos comunes que pueden ser compartidos por diferentes clases, independientemente de su jerarquía.
   - Se declara utilizando la palabra clave `interface`.

```java
interface Animal {
    void hacerSonido();
}

class Perro implements Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }
}

class Gato implements Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }
}
```

En resumen, la principal diferencia radica en que una clase abstracta puede contener implementaciones de métodos y campos, mientras que una interfaz solo puede contener definiciones de métodos y constantes. Además, una clase puede implementar múltiples interfaces pero solo puede heredar de una clase abstracta. La elección entre una clase abstracta y una interfaz depende del diseño y los requisitos específicos de tu aplicación.