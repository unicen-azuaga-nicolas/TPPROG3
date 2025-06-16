package prog3.Trabajo.Especial;

import java.io.IOException;


public class Main {
   public static void main (String [] args) {
	   try {
		   String ruta = "maquinas.txt";
		   Problema problema = LectorArchivo.cargarMaquinasDesdeArchivo(ruta);

		   Solucion greedy = new Greedy().ejecutar(problema);
		   System.out.println(greedy);

		   Solucion backtracking = new Backtracking().ejecutar(problema);
		   System.out.println(backtracking);

	    } catch (IOException e) {
	        System.out.println("Error leyendo el archivo: " + e.getMessage());
	    }
	}

}
