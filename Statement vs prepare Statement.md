En Java, al trabajar con bases de datos usando JDBC (Java Database Connectivity), tienes varias opciones para ejecutar consultas SQL, entre ellas `Statement` y `PreparedStatement`. Aquí te explico las diferencias clave entre ambos:

### 1. `Statement`

- **Uso:** Se utiliza para ejecutar consultas SQL sin parámetros.
- **Seguridad:** Más susceptible a ataques de inyección SQL.
- **Eficiencia:** Menos eficiente para consultas que se ejecutan repetidamente, ya que cada ejecución es tratada como una nueva consulta.
- **Sintaxis:**
  ```java
  Statement stmt = connection.createStatement();
  ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = 1");
  ```

#### Ejemplo:
```java
public void getUserById(int id) {
    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        connection = DriverManager.getConnection(url, username, password);
        stmt = connection.createStatement();
        String sql = "SELECT * FROM users WHERE id = " + id;
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println("User ID: " + rs.getInt("id"));
            System.out.println("Username: " + rs.getString("username"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar recursos
    }
}
```

### 2. `PreparedStatement`

- **Uso:** Se utiliza para ejecutar consultas SQL con parámetros.
- **Seguridad:** Más seguro contra inyección SQL, ya que los parámetros se envían por separado.
- **Eficiencia:** Más eficiente para consultas repetitivas, ya que puede precompilar la consulta.
- **Sintaxis:**
  ```java
  PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
  pstmt.setInt(1, 1);
  ResultSet rs = pstmt.executeQuery();
  ```

#### Ejemplo:
```java
public void getUserById(int id) {
    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        connection = DriverManager.getConnection(url, username, password);
        String sql = "SELECT * FROM users WHERE id = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println("User ID: " + rs.getInt("id"));
            System.out.println("Username: " + rs.getString("username"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar recursos
    }
}
```

### Comparación

| Característica         | `Statement`                                 | `PreparedStatement`                        |
|------------------------|---------------------------------------------|--------------------------------------------|
| **Uso**                | Consultas SQL sin parámetros                | Consultas SQL con parámetros               |
| **Seguridad**          | Susceptible a inyección SQL                 | Protegido contra inyección SQL             |
| **Eficiencia**         | Menos eficiente para consultas repetitivas  | Más eficiente para consultas repetitivas   |
| **Precompilación**     | No                                          | Sí                                         |
| **Flexibilidad**       | Consultas simples y directas                | Consultas con parámetros y repetitivas     |
| **Código SQL**         | Integrado directamente en el código         | Separado del código, usando marcadores `?` |

### ¿Cuándo usar cada uno?

- **`Statement`:** Úsalo para consultas simples y directas donde no hay parámetros y la consulta no se ejecuta repetidamente.
- **`PreparedStatement`:** Úsalo para consultas que incluyen parámetros, se ejecutan repetidamente, o cuando necesitas protegerte contra la inyección SQL.

En resumen, `PreparedStatement` es generalmente la opción preferida para consultas con parámetros y situaciones donde la seguridad y eficiencia son importantes.