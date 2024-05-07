```java
// clase abstracta
abstract class Figura {
	abstract double calcularArea();
	void imprimirArea(){
		System.out.println("El aréa es: " + calcularArea());
	}
}

//Clase concreta

class Circulo extends Figura {
	private double radio;
	Circulo(double radio){
		this.radio = radio;
	}
	double calcularArea() {
	return Math.PI * radio * radio;
	}
}
```

```JAVA
import java.util.Collection;
import java.util.ArrayList;

pubblic class Main {
	public static void main()
}
```