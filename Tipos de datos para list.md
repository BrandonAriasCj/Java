En Java, la clase `List` es una interfaz genérica que puede contener cualquier tipo de dato, no solo `Integer`. La declaración `List<Integer> numeros = List.of(1, 2, 3);` crea una lista inmutable de enteros usando el método `List.of()`. Aquí tienes una lista de otros tipos de datos que también pueden ser utilizados con `List.of()`:

### Tipos de Datos Comunes

1. **`String`**:
   ```java
   List<String> strings = List.of("uno", "dos", "tres");
   ```

2. **`Double`**:
   ```java
   List<Double> doubles = List.of(1.1, 2.2, 3.3);
   ```

3. **`Character`**:
   ```java
   List<Character> characters = List.of('a', 'b', 'c');
   ```

4. **`Boolean`**:
   ```java
   List<Boolean> booleans = List.of(true, false, true);
   ```

5. **`Float`**:
   ```java
   List<Float> floats = List.of(1.1f, 2.2f, 3.3f);
   ```

6. **`Long`**:
   ```java
   List<Long> longs = List.of(100000L, 200000L, 300000L);
   ```

### Tipos de Datos Personalizados

También puedes usar tipos de datos personalizados (objetos de tus propias clases) dentro de una lista. Aquí hay un ejemplo con una clase `Persona`:

```java
class Persona {
    String nombre;
    int edad;

    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = List.of(
            new Persona("Juan", 25),
            new Persona("Ana", 30),
            new Persona("Luis", 35)
        );

        personas.forEach(System.out::println);
    }
}
```

### Uso de `List.of` con Distintos Tipos de Datos

El método `List.of()` se puede usar para crear listas inmutables de cualquier tipo de dato. Aquí algunos ejemplos:

- **Lista de enteros**:
  ```java
  List<Integer> numeros = List.of(1, 2, 3);
  ```

- **Lista de cadenas**:
  ```java
  List<String> palabras = List.of("uno", "dos", "tres");
  ```

- **Lista de dobles**:
  ```java
  List<Double> decimales = List.of(1.1, 2.2, 3.3);
  ```

- **Lista de caracteres**:
  ```java
  List<Character> caracteres = List.of('a', 'b', 'c');
  ```

- **Lista de booleanos**:
  ```java
  List<Boolean> valores = List.of(true, false, true);
  ```

### Importante

Recuerda que las listas creadas con `List.of()` son inmutables. Esto significa que no puedes modificar la lista después de crearla (no puedes agregar, eliminar o cambiar elementos). Si necesitas una lista mutable, puedes usar `ArrayList`:

```java
List<Integer> numeros = new ArrayList<>(List.of(1, 2, 3));
numeros.add(4);  // Esto es posible porque ArrayList es mutable
```

### Resumen

El método `List.of()` es muy flexible y puede ser utilizado para crear listas inmutables de cualquier tipo de dato, ya sea un tipo primitivo envuelto en su correspondiente clase (como `Integer`, `Double`, `Character`, etc.) o un tipo de dato personalizado. Esto permite una gran variedad de aplicaciones en la programación en Java.