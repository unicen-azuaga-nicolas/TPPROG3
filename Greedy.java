package prog3.Trabajo.Especial;

import java.util.Collections;
import java.util.List;

public class Greedy {

    public static Solucion execute(int piezasTotales, List<Maquina> maquinas ){

        Solucion solucion = new Solucion(Solucion.MetodoResolucion.GREEDY);

        // Ordenar de mayor a menor
        Collections.sort(maquinas);

        int piezasRestantes = piezasTotales;

        while (piezasRestantes > 0){
            boolean encontroCandidato = false;
            for (Maquina m : maquinas) {
                solucion.incrementarCosto();
                if(m.getPiezas() <= piezasRestantes){
                    solucion.agregarMaquina(m);
                    piezasRestantes -= m.getPiezas();
                    encontroCandidato = true;
                    break;
                }
            }

            if (!encontroCandidato) break;
        }

        return solucion;

    }
}
