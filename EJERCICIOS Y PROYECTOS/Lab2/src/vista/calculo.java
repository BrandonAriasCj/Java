package vista;
import java.util.Scanner;
import datos.producto;
public class calculo {

	public static void main(String[] args) {
		
		int cod,cant;
		String dsp;
		double pU, Ig,PP;
		
		producto p = new producto();
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese el codigo");
		cod =s.nextInt();
		System.out.println("Ingrese la descripción");
		dsp = s.next();
		System.out.println("Ingrese la cantidad");
		cant = s.nextInt();
		System.out.println("Ingrese su precio unitario");
		pU= s.nextDouble();
		
		
		p.setCodigo(cod);
		p.setDescripcion(dsp);
		p.setCantidad(cant);
		p.setPrecioUnitario(pU);
		
		System.out.println(p.getCodigo());
		System.out.println(p.getDescripcion());
		System.out.println(p.getCantidad());
		System.out.println(p.getPrecioUnitario());
		
		PP = p.precioT();
		Ig = p.Igv();
		System.out.println("//////////////////////////////////////////////////////////////////////");
		System.out.println("El precio total es de "+PP);
		System.out.println("El IGV sobre el precio total es de " + Ig);
		System.out.println("El total a pargar es de:  " + (PP +Ig));
		System.out.println("//////////////////////////////////////////////////////////////////////");
		
		
	}

}