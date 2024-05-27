En Java, las listas mutables y las listas inmutables tienen diferentes sintaxis y métodos de creación. A continuación se muestran ejemplos detallados para ambas, ilustrando cómo se crean y cómo se comportan.

### Listas Mutables en Java

Una lista mutable es aquella que puede ser modificada después de su creación. La clase `ArrayList` es comúnmente utilizada para crear listas mutables.

#### Ejemplo de lista mutable:
```java
import java.util.ArrayList;
import java.util.List;

public class ListaMutable {
    public static void main(String[] args) {
        // Crear una lista mutable
        List<Integer> numeros = new ArrayList<>();

        // Agregar elementos a la lista
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);

        // Modificar un elemento de la lista
        numeros.set(1, 10); // Cambia el segundo elemento (índice 1) a 10

        // Eliminar un elemento de la lista
        numeros.remove(0); // Elimina el primer elemento (índice 0)

        // Imprimir la lista
        System.out.println(numeros); // Salida: [10, 3]
    }
}
```

### Listas Inmutables en Java

Una lista inmutable es aquella que no puede ser modificada después de su creación. Desde Java 9, puedes utilizar el método `List.of()` para crear listas inmutables. En versiones anteriores, puedes utilizar `Collections.unmodifiableList()`.

#### Ejemplo de lista inmutable (Java 9 y posteriores):
```java
import java.util.List;

public class ListaInmutableJava9 {
    public static void main(String[] args) {
        // Crear una lista inmutable
        List<Integer> numeros = List.of(1, 2, 3);

        // Intentar modificar la lista lanzará UnsupportedOperationException
        // numeros.add(4); // Lanza UnsupportedOperationException
        // numeros.remove(1); // Lanza UnsupportedOperationException
        // numeros.set(0, 10); // Lanza UnsupportedOperationException

        // Imprimir la lista
        System.out.println(numeros); // Salida: [1, 2, 3]
    }
}
```

#### Ejemplo de lista inmutable (Java 8 y versiones anteriores):
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaInmutableJava8 {
    public static void main(String[] args) {
        // Crear una lista mutable
        List<Integer> listaMutable = new ArrayList<>();
        listaMutable.add(1);
        listaMutable.add(2);
        listaMutable.add(3);

        // Crear una lista inmutable a partir de la lista mutable
        List<Integer> listaInmutable = Collections.unmodifiableList(listaMutable);

        // Intentar modificar la lista lanzará UnsupportedOperationException
        // listaInmutable.add(4); // Lanza UnsupportedOperationException
        // listaInmutable.remove(1); // Lanza UnsupportedOperationException
        // listaInmutable.set(0, 10); // Lanza UnsupportedOperationException

        // Imprimir la lista
        System.out.println(listaInmutable); // Salida: [1, 2, 3]
    }
}
```

### Comparación de Sintaxis

1. **Creación de una lista mutable**:
   ```java
   List<Integer> numeros = new ArrayList<>();
   ```

2. **Creación de una lista inmutable (Java 9 y posteriores)**:
   ```java
   List<Integer> numeros = List.of(1, 2, 3);
   ```

3. **Creación de una lista inmutable (Java 8 y versiones anteriores)**:
   ```java
   List<Integer> listaMutable = new ArrayList<>();
   List<Integer> listaInmutable = Collections.unmodifiableList(listaMutable);
   ```

### Resumen
- **Listas mutables**: Puedes agregar, eliminar y modificar elementos. Utilizan clases como `ArrayList`.
- **Listas inmutables**: No puedes cambiar su contenido después de la creación. A partir de Java 9, puedes usar `List.of()`, y en versiones anteriores, `Collections.unmodifiableList()` para crear listas inmutables.