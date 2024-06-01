Un `CallableStatement` es una interfaz en Java que permite ejecutar procedimientos almacenados en una base de datos desde una aplicación Java. Es parte del paquete `java.sql` y se usa para ejecutar procedimientos almacenados que pueden tener parámetros de entrada (IN), salida (OUT) y parámetros de entrada/salida (INOUT).

### Características de `CallableStatement`

1. **Ejecución de Procedimientos Almacenados:** Permite invocar procedimientos almacenados en la base de datos.
2. **Soporte de Parámetros:** Puede manejar parámetros de entrada, salida y entrada/salida.
3. **Gestión de Resultados:** Puede procesar múltiples conjuntos de resultados y valores de retorno.

### Sintaxis General

La sintaxis general para usar un `CallableStatement` es la siguiente:

1. **Registrar el controlador JDBC y establecer la conexión:**

   ```java
   Class.forName("com.mysql.cj.jdbc.Driver");
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miBaseDeDatos", "usuario", "contraseña");
   ```

2. **Crear el `CallableStatement`:**

   ```java
   CallableStatement cstmt = con.prepareCall("{call nombre_del_procedimiento(?)}");
   ```

3. **Establecer los parámetros de entrada:**

   ```java
   cstmt.setInt(1, valor);
   ```

4. **Registrar los parámetros de salida:**

   ```java
   cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
   ```

5. **Ejecutar el procedimiento almacenado:**

   ```java
   cstmt.execute();
   ```

6. **Obtener los parámetros de salida:**

   ```java
   int resultado = cstmt.getInt(2);
   ```

7. **Cerrar la conexión:**

   ```java
   cstmt.close();
   con.close();
   ```

### Ejemplos

#### 1. Procedimiento Almacenado sin Parámetros

**Procedimiento Almacenado en MySQL:**
```sql
CREATE PROCEDURE ObtenerProductos()
BEGIN
    SELECT * FROM Producto;
END;
```

**Código Java:**
```java
import java.sql.*;

public class CallableStatementExample {
    public static void main(String[] args) {
        try {
            // Registrar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miBaseDeDatos", "usuario", "contraseña");

            // Crear el CallableStatement
            CallableStatement cstmt = con.prepareCall("{call ObtenerProductos()}");

            // Ejecutar el procedimiento almacenado
            ResultSet rs = cstmt.executeQuery();

            // Procesar los resultados
            while (rs.next()) {
                System.out.println("ID_Producto: " + rs.getInt("ID_Producto") + ", Nombre: " + rs.getString("Nombre"));
            }

            // Cerrar los recursos
            rs.close();
            cstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

#### 2. Procedimiento Almacenado con Parámetros de Entrada y Salida

**Procedimiento Almacenado en MySQL:**
```sql
CREATE PROCEDURE CalcularPrecioTotal(IN orden_id INT, OUT precio_total DECIMAL(10, 2))
BEGIN
    SELECT SUM(Cantidad * Precio_Unitario) INTO precio_total
    FROM Detalle_Orden
    WHERE ID_Orden = orden_id;
END;
```

**Código Java:**
```java
import java.sql.*;

public class CallableStatementExample {
    public static void main(String[] args) {
        try {
            // Registrar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miBaseDeDatos", "usuario", "contraseña");

            // Crear el CallableStatement
            CallableStatement cstmt = con.prepareCall("{call CalcularPrecioTotal(?, ?)}");

            // Establecer el parámetro de entrada
            cstmt.setInt(1, 1); // ID de la orden

            // Registrar el parámetro de salida
            cstmt.registerOutParameter(2, java.sql.Types.DECIMAL);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

            // Obtener el valor del parámetro de salida
            BigDecimal precioTotal = cstmt.getBigDecimal(2);
            System.out.println("Precio total de la orden: " + precioTotal);

            // Cerrar los recursos
            cstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Beneficios de Usar `CallableStatement`

1. **Encapsulación de Lógica:** Permite encapsular la lógica compleja del lado del servidor, mejorando el rendimiento y la seguridad.
2. **Reutilización:** Facilita la reutilización del código SQL almacenado en la base de datos.
3. **Mantenimiento:** Simplifica el mantenimiento de la lógica de negocio al centralizarla en procedimientos almacenados.

### Conclusión

El uso de `CallableStatement` en Java permite interactuar de manera eficiente y segura con procedimientos almacenados en la base de datos, ofreciendo una forma robusta de manejar operaciones complejas y repetitivas, mejorando el rendimiento y la seguridad de las aplicaciones.