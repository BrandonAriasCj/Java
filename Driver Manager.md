La clase `DriverManager` en Java es parte del paquete `java.sql` y se utiliza para gestionar un conjunto de controladores JDBC. Además del método `getConnection`, `DriverManager` proporciona varios métodos útiles para interactuar con la gestión de controladores y la configuración de conexiones. Aquí están algunos de los métodos más importantes de la clase `DriverManager`:

### Métodos Principales de `DriverManager`

1. **getConnection**
   - **Descripción:** Establece una conexión a la base de datos.
   - **Sobrecargas:**
     ```java
     public static Connection getConnection(String url) throws SQLException;
     public static Connection getConnection(String url, String user, String password) throws SQLException;
     public static Connection getConnection(String url, Properties info) throws SQLException;
     ```

2. **registerDriver**
   - **Descripción:** Registra un controlador JDBC con el `DriverManager`.
   - **Firma:**
     ```java
     public static void registerDriver(Driver driver) throws SQLException;
     ```
   - **Ejemplo:**
     ```java
     DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
     ```

3. **deregisterDriver**
   - **Descripción:** Elimina el registro de un controlador JDBC previamente registrado.
   - **Firma:**
     ```java
     public static void deregisterDriver(Driver driver) throws SQLException;
     ```
   - **Ejemplo:**
     ```java
     DriverManager.deregisterDriver(new com.mysql.cj.jdbc.Driver());
     ```

4. **getDriver**
   - **Descripción:** Devuelve un controlador JDBC que puede manejar la URL especificada.
   - **Firma:**
     ```java
     public static Driver getDriver(String url) throws SQLException;
     ```
   - **Ejemplo:**
     ```java
     Driver driver = DriverManager.getDriver("jdbc:mysql://localhost:3306/miBaseDeDatos");
     ```

5. **getDrivers**
   - **Descripción:** Devuelve una enumeración de todos los controladores JDBC actualmente registrados.
   - **Firma:**
     ```java
     public static Enumeration<Driver> getDrivers();
     ```
   - **Ejemplo:**
     ```java
     Enumeration<Driver> drivers = DriverManager.getDrivers();
     while (drivers.hasMoreElements()) {
         Driver driver = drivers.nextElement();
         System.out.println(driver.getClass().getName());
     }
     ```

6. **setLoginTimeout**
   - **Descripción:** Establece el tiempo de espera en segundos para que una conexión a la base de datos se complete.
   - **Firma:**
     ```java
     public static void setLoginTimeout(int seconds);
     ```
   - **Ejemplo:**
     ```java
     DriverManager.setLoginTimeout(30); // Tiempo de espera de 30 segundos
     ```

7. **getLoginTimeout**
   - **Descripción:** Devuelve el tiempo de espera en segundos para que una conexión a la base de datos se complete.
   - **Firma:**
     ```java
     public static int getLoginTimeout();
     ```
   - **Ejemplo:**
     ```java
     int timeout = DriverManager.getLoginTimeout();
     System.out.println("Login timeout: " + timeout + " seconds");
     ```

8. **setLogWriter**
   - **Descripción:** Establece un objeto `PrintWriter` para imprimir mensajes de seguimiento de depuración.
   - **Firma:**
     ```java
     public static void setLogWriter(PrintWriter out);
     ```
   - **Ejemplo:**
     ```java
     PrintWriter logWriter = new PrintWriter(System.out);
     DriverManager.setLogWriter(logWriter);
     ```

9. **getLogWriter**
   - **Descripción:** Devuelve el objeto `PrintWriter` que se usa para imprimir mensajes de seguimiento de depuración.
   - **Firma:**
     ```java
     public static PrintWriter getLogWriter();
     ```
   - **Ejemplo:**
     ```java
     PrintWriter logWriter = DriverManager.getLogWriter();
     if (logWriter != null) {
         logWriter.println("This is a log message.");
     }
     ```

10. **setLogStream** (obsoleto en favor de `setLogWriter`)
    - **Descripción:** Establece un objeto `PrintStream` para imprimir mensajes de seguimiento de depuración (obsoleto).
    - **Firma:**
      ```java
      public static void setLogStream(PrintStream out);
      ```

11. **getLogStream** (obsoleto en favor de `getLogWriter`)
    - **Descripción:** Devuelve el objeto `PrintStream` que se usa para imprimir mensajes de seguimiento de depuración (obsoleto).
    - **Firma:**
      ```java
      public static PrintStream getLogStream();
      ```

### Ejemplo de Uso Combinado de Métodos

A continuación se muestra un ejemplo que ilustra cómo usar algunos de estos métodos juntos para registrar un controlador, establecer el tiempo de espera de inicio de sesión y obtener una conexión.

```java
import java.sql.*;
import java.util.Properties;
import java.util.Enumeration;

public class DriverManagerExample {
    public static void main(String[] args) {
        try {
            // Registrar el controlador JDBC
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Establecer el tiempo de espera para la conexión
            DriverManager.setLoginTimeout(30);

            // Crear un objeto Properties y configurar las propiedades
            Properties props = new Properties();
            props.setProperty("user", "usuario");
            props.setProperty("password", "contraseña");

            // Obtener una conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/miBaseDeDatos";
            Connection conn = DriverManager.getConnection(url, props);

            // Verificar la conexión
            if (conn != null) {
                System.out.println("Conexión establecida con éxito!");

                // Obtener todos los controladores registrados
                Enumeration<Driver> drivers = DriverManager.getDrivers();
                while (drivers.hasMoreElements()) {
                    Driver driver = drivers.nextElement();
                    System.out.println("Controlador registrado: " + driver.getClass().getName());
                }
            }

            // Cerrar la conexión
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### Conclusión

La clase `DriverManager` ofrece una variedad de métodos para gestionar controladores JDBC y establecer conexiones a bases de datos. Además de `getConnection`, estos métodos permiten registrar y eliminar controladores, configurar tiempos de espera y gestionar la salida de logs, proporcionando una interfaz completa para la gestión de conexiones JDBC en aplicaciones Java.