package prog3.Trabajo.Especial;

/*
 * Estrategia Backtracking:
 * - Se genera el árbol de exploracion probando todas las posibles combinaciones de máquinas.
 * - En cada nivel del árbol se prueba con cada máquina disponible, restando su producción al total restante.
 * - Un estado solución es aquel que logra que piezasRestantes == 0.
 * - Se guarda la mejor solución con menor cantidad de puestas en funcionamiento .
 * - Se implementa poda: si piezasRestantes < 0, no se continúa con esa rama.
 */


import java.util.ArrayList;
import java.util.List;

public class ExisteSecuencia {
	private List<Maquina> maquinas;
	private int cantPiezasProduccion;
	private List<Maquina> mejorSolucion;
	private int estadosGenerados;
	
	public ExisteSecuencia(int cantPiezasProduccion, List<Maquina> maquinas) {
		this.cantPiezasProduccion = cantPiezasProduccion;
		this.maquinas = maquinas;
		this.mejorSolucion = new ArrayList<>();
		this.estadosGenerados =0;
	}
	
	public int getEstadosGenerados() {
	    return estadosGenerados;
	}
	
	public boolean existeSecuencia() {
		 List<Maquina> actual = new ArrayList<>();
		 return existeSecuenciaRec(cantPiezasProduccion, actual);
	}
	
	public boolean existeSecuenciaRec(int piezasRestantes, List<Maquina> actual) {
		estadosGenerados++;
		
		//caso  base
		if (piezasRestantes == 0) {
		    if (mejorSolucion.isEmpty() || actual.size() < mejorSolucion.size()) {
		        mejorSolucion.clear();
		        mejorSolucion.addAll(new ArrayList<>(actual));
		    }
		    return true;
		}
		
		//poda por exceso de piezas
		if (piezasRestantes < 0) return false;
		//Poda por cantidad de máquinas usadas
	    if (!mejorSolucion.isEmpty() && actual.size() >= mejorSolucion.size()) return false;
		
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
