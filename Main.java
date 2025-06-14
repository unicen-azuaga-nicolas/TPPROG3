package prog3.Trabajo.Especial;

import java.io.IOException;


public class Main {
   public static void main (String [] args) {
	   try {
	        String ruta = "maquinas.txt"; 
	        Configuracion config = LectorArchivo.leerArchivo(ruta);

	        ExisteSecuencia buscador = new ExisteSecuencia(config.getPiezasTotales(), config.getMaquinas());
	        boolean existeSolucion = buscador.existeSecuencia();

	        if (existeSolucion) {
	            System.out.println("Solución encontrada: ");
	            for (Maquina m : buscador.getMejorSolucion()) {
	                System.out.print(m.nombre + " ");
	            }
	        } else {
	            System.out.println("No hay solución posible.");
	        }

	    } catch (IOException e) {
	        System.out.println("Error leyendo el archivo: " + e.getMessage());
	    }
	}
}
