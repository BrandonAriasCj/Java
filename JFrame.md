Un `JFrame` en Java es una ventana que se utiliza para crear interfaces gráficas de usuario (GUI) en aplicaciones de escritorio utilizando la biblioteca Swing. Un `JFrame` actúa como el marco principal en el que se pueden colocar otros componentes de GUI, como botones, etiquetas, campos de texto, etc.

Aquí tienes un ejemplo básico de cómo crear y mostrar un `JFrame` en Java:

```java
import javax.swing.JFrame;

public class MiVentana {

    public static void main(String[] args) {
        // Crear un nuevo JFrame
        JFrame ventana = new JFrame("Mi Ventana");

        // Configurar el tamaño de la ventana
        ventana.setSize(400, 300);

        // Configurar la operación predeterminada al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
```

En este ejemplo:

- Se importa la clase `JFrame` del paquete `javax.swing`.
- Se crea una nueva instancia de `JFrame` llamada "ventana".
- Se establece el título y el tamaño de la ventana.
- Se configura la operación predeterminada al cerrar la ventana para que la aplicación se cierre cuando se hace clic en el botón de cerrar.
- Finalmente, se hace visible la ventana llamando al método `setVisible(true)`.

Este es solo un ejemplo básico para mostrarte cómo se crea y muestra un `JFrame`. Puedes personalizarlo agregando más componentes y funcionalidades según tus necesidades.