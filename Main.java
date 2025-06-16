package prog3.Trabajo.Especial;

import java.io.IOException;
import java.util.List;


public class Main {
   public static void main (String [] args) {
	   try {
	        String ruta = "maquinas.txt"; 
	        Configuracion config = LectorArchivo.leerArchivo(ruta);

	        ExisteSecuencia buscador = new ExisteSecuencia(config.getPiezasTotales(), config.getMaquinas());
	        boolean existeSolucion = buscador.existeSecuencia();

	        if (existeSolucion) {
	            System.out.println("Secuencia de maquinas: ");
	            for (Maquina m : buscador.getMejorSolucion()) {
	                System.out.print(m.nombre + " ");
	            }
	            System.out.println("\n");
	           
	            int suma =0;
	            for (Maquina m : buscador.getMejorSolucion()) {
	            	 suma += m.piezas;
	                
	            }
	            System.out.println("Cantidad de piezas producidas: "+ suma);
	            
	            int puestasEnFuncionamiento = buscador.getMejorSolucion().size();
	            
	            System.out.println("Puestas en funcionamiento: " + puestasEnFuncionamiento);
	            
	            System.out.println("Estados generados: " + buscador.getEstadosGenerados());
	        } else {
	            System.out.println("No hay solución posible.");
	        }

	    } catch (IOException e) {
	        System.out.println("Error leyendo el archivo: " + e.getMessage());
	    }
	}


	public Solucion greedy(int piezasTotales, List<Maquina> maquinaList ){

	   Solucion mejorSolucion = null;
	   boolean terminoDeEvaluar = piezasTotales == 0;
	   while (!terminoDeEvaluar){
		   Maquina mejor = null;
	   }

	   return mejorSolucion;
	}
}
