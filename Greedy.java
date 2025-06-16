package prog3.Trabajo.Especial;

import java.util.Collections;
import java.util.List;

public class Greedy {


    public static Solucion execute(int piezasTotales, List<Maquina> maquinas) {
        Solucion solucion = new Solucion(Solucion.MetodoResolucion.GREEDY);
        Collections.sort(maquinas); // Ordeno de mayor a menor

        int piezasRestantes = piezasTotales;

        while (piezasRestantes > 0) {
            Maquina candidato = buscarCandidato(maquinas, piezasRestantes, solucion);

            //No hay solución
            if (candidato == null) {
                return solucion;
            }

            solucion.agregarMaquina(candidato);
            piezasRestantes -= candidato.getPiezas();
        }

        return solucion;
    }



    private static Maquina buscarCandidato(List<Maquina> maquinas, int piezasRestantes, Solucion solucion) {
        for (Maquina m : maquinas) {
            solucion.incrementarCosto();
            if (m.getPiezas() <= piezasRestantes) {
                return m;
            }
        }
        return null;
    }


}
