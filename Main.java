package prog3.Trabajo.Especial;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
   public static void main (String [] args) {
	   try {
	        String ruta = "maquinas.txt"; 
	        LectorArchivo lector = new LectorArchivo(ruta);
			lector.leerArchivo();

		   	Problema p = new Problema(lector.getPiezasTotales(), lector.getMaquinas());

		   	Solucion greedy = new Greedy().ejecutar(p);
			System.out.println(greedy);

	        Solucion backtracking = new Backtracking().ejecutar(p);
		   	System.out.println(backtracking);

	    } catch (IOException e) {
	        System.out.println("Error leyendo el archivo: " + e.getMessage());
	    }
	}


	public void backup(){
	   Configuracion config = new Configuracion(0,new ArrayList<>());
		ExisteSecuencia buscador = new ExisteSecuencia(config.getPiezasTotales(), config.getMaquinas());
		boolean existeSolucion = buscador.existeSecuencia();

		if (existeSolucion) {
			System.out.println("Secuencia de maquinas: ");
			for (Maquina m : buscador.getMejorSolucion()) {
				System.out.print(m.getNombre() + " ");
			}
			System.out.println("\n");

			int suma =0;
			for (Maquina m : buscador.getMejorSolucion()) {
				suma += m.getPiezas();

			}
			System.out.println("Cantidad de piezas producidas: "+ suma);

			int puestasEnFuncionamiento = buscador.getMejorSolucion().size();

			System.out.println("Puestas en funcionamiento: " + puestasEnFuncionamiento);

			System.out.println("Estados generados: " + buscador.getEstadosGenerados());
		} else {
			System.out.println("No hay solución posible.");
		}


	}

}
