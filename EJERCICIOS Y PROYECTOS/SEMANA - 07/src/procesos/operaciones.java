package procesos;
import java.util.ArrayList;
import modelo.cuenta;


public class operaciones {
	public ArrayList lista;
	public operaciones() {
		lista = new ArrayList();
	}
	public void registro(cuenta cta) {
		lista.add(cta);
	}
	
	public cuenta leer(int indice) {
		return (cuenta)lista.get(indice);
	}
	
	public void imprimir(javax.swing.JTextArea caja) {
		caja.setText("Numero\tNombre\tTipo\tSaldo\n");
		for(int i=0; 1<lista.size();i++) {
			caja.append("\n" + leer(i).nombre + "\t" + leer(i).tipo + "\t"+ leer(i).saldo);
		}
	}
}
