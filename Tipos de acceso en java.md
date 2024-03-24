En Java, hay cuatro tipos de modificadores de acceso que controlan la visibilidad y el alcance de las clases, métodos y variables en una aplicación. Estos son:

1. **public:**
   - El modificador `public` hace que un miembro (variable, método, clase) sea accesible desde cualquier otra clase en Java, ya sea en el mismo paquete o en un paquete diferente.
   - Puede ser accedido desde cualquier lugar donde se importe la clase que contiene el miembro público.
   
   ```java
   public class ClasePublica {
       public int variablePublica;
       public void metodoPublico() {
           // Código del método
       }
   }
   ```

2. **private:**
   - El modificador `private` restringe el acceso de un miembro a solo la clase donde está declarado.
   - No puede ser accedido desde ninguna otra clase, incluso si están en el mismo paquete o son subclases.
   - Se utiliza para encapsular y proteger los detalles internos de una clase.
   
   ```java
   public class ClasePrivada {
       private int variablePrivada;
       private void metodoPrivado() {
           // Código del método
       }
   }
   ```

3. **protected:**
   - El modificador `protected` permite que un miembro sea accesible por las clases dentro del mismo paquete y por las subclases (heredadas) de la clase donde está declarado.
   - No puede ser accedido por clases que no estén en el mismo paquete y que no sean subclases.
   - Se utiliza para proporcionar acceso a las subclases mientras se mantiene un cierto nivel de encapsulamiento.
   
   ```java
   public class ClaseProtegida {
       protected int variableProtegida;
       protected void metodoProtegido() {
           // Código del método
       }
   }
   ```

4. **Sin Modificador (Default, Package-Private):**
   - Si no se especifica ningún modificador (ni `public`, ni `private`, ni `protected`), se utiliza el modificador por defecto.
   - Los miembros sin modificador son accesibles solo dentro del mismo paquete en el cual están declarados.
   - No pueden ser accedidos desde clases fuera del paquete, aunque pueden ser accedidos desde cualquier clase dentro del mismo paquete.
   
   ```java
   class ClaseDefault {
       int variableDefault;
       void metodoDefault() {
           // Código del método
       }
   }
   ```

Estos son los tipos de acceso en Java que te permiten controlar quién puede acceder y modificar los miembros de tus clases. Es importante entender cómo funcionan estos modificadores de acceso para diseñar clases seguras y bien encapsuladas en tus aplicaciones Java.