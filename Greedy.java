package prog3.Trabajo.Especial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Estrategia Greedy:
 * - Los candidatos son las máquinas disponibles cuya producción no excede la cantidad de piezas restantes a producir.
 * - Estrategia de selección de candidatos: se ordenan las máquinas de mayor a menor producción, y se elige en cada paso
 *   la primera máquina que pueda ser utilizada sin superar las piezas restantes.
 * - En cada iteración se selecciona un único candidato, se lo agrega a la solución, y se actualiza el total de piezas por producir.
 *
 * Consideraciones respecto a encontrar o no solución:
 * - El algoritmo Greedy no garantiza encontrar una solución óptima ni siquiera una solución válida en todos los casos.
 * - Esto ocurre porque toma decisiones locales (la máquina de mayor producción posible en ese momento) sin considerar combinaciones futuras.
 * - Puede fallar en casos donde la solución óptima requiere usar varias máquinas de menor producción que, combinadas, logran la cantidad exacta.
 * - Si en algún momento no se encuentra una máquina válida para cubrir las piezas restantes, se finaliza indicando que no hay solución
 *   desde la perspectiva voraz (greedy).
 */
public class Greedy implements Algoritmo  {


    public Greedy(){

    }

    @Override
    public  Solucion ejecutar(Problema p) {
        Solucion solucion = new Solucion(Solucion.MetodoResolucion.GREEDY);

        // Validación temprana
        if (!ValidadorProblema.esProblemaValido(p)) {
            return new SolucionSinResultado(Solucion.MetodoResolucion.GREEDY);
        }

        int piezasRestantes = p.getPiezasTotales();
        List<Maquina> maquinasDeMayorAMenor = new ArrayList<>(p.getMaquinas());
        Collections.sort(maquinasDeMayorAMenor);

        while (quedanPiezasPorProducir(piezasRestantes)) {
            Maquina candidato = buscarCandidato(maquinasDeMayorAMenor, piezasRestantes, solucion);

            //No hay solución
            if (candidato == null) {
                return new SolucionSinResultado(Solucion.MetodoResolucion.GREEDY);
            }

            solucion.agregarMaquina(candidato);
            piezasRestantes -= candidato.getPiezas();
        }

        return solucion;
    }



    private static Maquina buscarCandidato(List<Maquina> maquinasDeMayorAMenor, int piezasRestantes, Solucion solucion) {
        for (Maquina m : maquinasDeMayorAMenor) {
            solucion.incrementarCosto();
            if (m.getPiezas() > 0 && m.getPiezas() <= piezasRestantes) {
                return m;
            }
        }
        return null;
    }

    private boolean quedanPiezasPorProducir(int piezasRestantes) {
        return piezasRestantes > 0;
    }


}
