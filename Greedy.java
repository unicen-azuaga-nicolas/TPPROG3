package prog3.Trabajo.Especial;

import java.util.Collections;
import java.util.List;

public class Greedy implements Algoritmo  {


    public Greedy(){

    }

    @Override
    public  Solucion ejecutar(Problema p) {
        Solucion solucion = new Solucion(Solucion.MetodoResolucion.GREEDY);
        Collections.sort(p.getMaquinas()); // Ordeno de mayor a menor

        int piezasRestantes = p.getPiezasTotales();

        while (piezasRestantes > 0) {
            Maquina candidato = buscarCandidato(p.getMaquinas(), piezasRestantes, solucion);

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
