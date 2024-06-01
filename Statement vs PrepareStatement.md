En Java JDBC (Java Database Connectivity), `Statement` y `PreparedStatement` son interfaces utilizadas para ejecutar sentencias SQL en una base de datos. Aunque ambos se usan para ejecutar comandos SQL, tienen diferencias significativas en cuanto a funcionalidad, rendimiento, y seguridad. Aquí se detallan las diferencias entre `Statement` y `PreparedStatement`:

### 1. **`Statement`**

#### Uso:
- Se utiliza para ejecutar sentencias SQL estáticas sin parámetros.
  
#### Creación:
- Un objeto `Statement` se crea usando el método `createStatement()` de la clase `Connection`.

#### Ejemplo de Uso:
```java
Connection connection = DriverManager.getConnection(url, user, password);
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

while (resultSet.next()) {
    System.out.println(resultSet.getString("username"));
}
```

#### Ventajas:
- Simple de usar para sentencias SQL simples y estáticas.
  
#### Desventajas:
- Menos seguro frente a ataques de inyección SQL, ya que las sentencias SQL se construyen concatenando cadenas.
- Menos eficiente para sentencias SQL repetidas con parámetros diferentes, ya que el plan de ejecución no se reutiliza.

### 2. **`PreparedStatement`**

#### Uso:
- Se utiliza para ejecutar sentencias SQL precompiladas con parámetros.
  
#### Creación:
- Un objeto `PreparedStatement` se crea usando el método `prepareStatement(String sql)` de la clase `Connection`.

#### Ejemplo de Uso:
```java
Connection connection = DriverManager.getConnection(url, user, password);
String sql = "SELECT * FROM users WHERE username = ?";
PreparedStatement preparedStatement = connection.prepareStatement(sql);
preparedStatement.setString(1, "john_doe");

ResultSet resultSet = preparedStatement.executeQuery();

while (resultSet.next()) {
    System.out.println(resultSet.getString("username"));
}
```

#### Ventajas:
- **Seguridad**: Protege contra ataques de inyección SQL porque los parámetros se envían de forma separada.
- **Rendimiento**: Las sentencias SQL se precompilan y el plan de ejecución se reutiliza, lo que mejora el rendimiento para sentencias repetitivas.
- **Flexibilidad**: Facilita el uso de sentencias SQL con parámetros.

#### Desventajas:
- Requiere una preparación previa de la sentencia SQL, lo que puede ser un poco más complicado de implementar para sentencias muy simples.

### Resumen de Diferencias

| Característica       | `Statement`                              | `PreparedStatement`                        |
|----------------------|------------------------------------------|--------------------------------------------|
| **Creación**         | `createStatement()`                      | `prepareStatement(String sql)`             |
| **Parámetros**       | No soporta parámetros                    | Soporta parámetros mediante marcadores `?` |
| **Seguridad**        | Vulnerable a inyección SQL               | Protege contra inyección SQL               |
| **Rendimiento**      | No reutiliza el plan de ejecución        | Reutiliza el plan de ejecución             |
| **Complejidad**      | Simplicidad en sentencias SQL estáticas  | Mayor complejidad en configuración inicial |
| **Flexibilidad**     | Menor flexibilidad con sentencias dinámicas | Alta flexibilidad con parámetros           |

### Ejemplo Comparativo

#### `Statement`:

```java
Statement statement = connection.createStatement();
String username = "john_doe";
String query = "SELECT * FROM users WHERE username = '" + username + "'";
ResultSet resultSet = statement.executeQuery(query);
```

#### `PreparedStatement`:

```java
String query = "SELECT * FROM users WHERE username = ?";
PreparedStatement preparedStatement = connection.prepareStatement(query);
preparedStatement.setString(1, "john_doe");
ResultSet resultSet = preparedStatement.executeQuery();
```

En el ejemplo con `Statement`, la consulta SQL se construye concatenando cadenas, lo que puede ser inseguro y propenso a errores de inyección SQL. En cambio, el ejemplo con `PreparedStatement` utiliza un marcador de posición (`?`) y el método `setString` para proporcionar el valor, lo que es más seguro y eficiente.

En resumen, `PreparedStatement` es generalmente preferido sobre `Statement` para la mayoría de las aplicaciones debido a sus ventajas en seguridad y rendimiento, especialmente cuando se manejan entradas de usuario o se ejecutan sentencias repetitivas con diferentes parámetros.