package prog3.Trabajo.Especial;

//Backtracking: probar todas las combinaciones posibles hasta encontrar la de menor longitud.
//Se debe sumar la cantidad de piezas a producir en la menor cantidad de puestas en marcha posible



import java.util.ArrayList;
import java.util.List;

public class ExisteSecuencia {
	private List<Maquina> maquinas;
	private int cantPiezasProduccion;
	private List<Maquina> mejorSolucion;
	
	public ExisteSecuencia(int cantPiezasProduccion, List<Maquina> maquinas) {
		this.cantPiezasProduccion = cantPiezasProduccion;
		this.maquinas = maquinas;
		this.mejorSolucion = new ArrayList<>();
	}
	
	
	public boolean existeSecuancia() {
		 List<Maquina> actual = new ArrayList<>();
		 return existeSecuenciaRec(cantPiezasProduccion, actual);
	}
	
	public boolean existeSecuenciaRec(int piezasRestantes, List<Maquina> actual) {
		//caso  base
		if (piezasRestantes == 0) {
		    if (mejorSolucion.isEmpty() || actual.size() < mejorSolucion.size()) {
		        mejorSolucion.clear();
		        mejorSolucion.addAll(new ArrayList<>(actual));
		    }
		    return true;
		}
		
		//poda
		if (piezasRestantes < 0) return false;
		
		//caso recursivo
		boolean encontrado = false;
		for (Maquina m : maquinas) {
		    actual.add(m); // Usamos la máquina
		    if (existeSecuenciaRec(piezasRestantes - m.piezas, actual)) {
		        encontrado = true;
		    } // Restamos sus piezas y seguimos
		    actual.remove(actual.size() - 1); // Backtrack: deshacemos la elección
		}
		return encontrado;
	}
	public List<Maquina> getMejorSolucion() {
	    return mejorSolucion;
	}
}
