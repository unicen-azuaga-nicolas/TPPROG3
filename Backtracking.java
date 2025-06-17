package prog3.Trabajo.Especial;

import java.util.ArrayList;
import java.util.List;

/*
 * Estrategia Backtracking:
 * - El árbol de exploración se genera recursivamente, considerando en cada nivel todas las máquinas disponibles, ya que pueden reutilizarse.
 * - Cada nodo representa un estado parcial de la solución: piezas restantes por producir y máquinas utilizadas hasta el momento.
 * - Estados finales: aquellos en los que la suma total de piezas producidas alcanza exactamente el objetivo (piezasRestantes == 0).
 * - Estados solución: entre los estados finales, el que utiliza la menor cantidad de puestas en funcionamiento (mínima profundidad).
 *
 * Podas aplicadas:
 * - ✂️ Poda por sobreproducción: si piezasRestantes < 0, se descarta la rama actual.
 * - ✂️ Poda por no mejora: si la cantidad de máquinas utilizadas ya supera a la de la mejor solución conocida, no se continúa.
 * - ✂️ Poda por inutilidad: se descartan máquinas con producción igual a 0, ya que no aportan al objetivo y generan ramas infinitas.
 */
public class Backtracking implements Algoritmo {

    private Solucion mejorSolucion;
    private int estadosGenerados;

    private int piezasTotales;

    private List<Maquina> maquinas;

    public Backtracking() {
        this.mejorSolucion = null;
        this.estadosGenerados = 0;
        this.piezasTotales = 0;
        this.maquinas = new ArrayList<>();
    }

    @Override
    public Solucion ejecutar(Problema p) {
        Solucion actual = new Solucion(Solucion.MetodoResolucion.BACKTRACKING);

        // Validación temprana
        if (!ValidadorProblema.esProblemaValido(p)){
            return new SolucionSinResultado(Solucion.MetodoResolucion.BACKTRACKING);
        }

        mejorSolucion = null;
        estadosGenerados = 0;
        piezasTotales = p.getPiezasTotales();
        maquinas = p.getMaquinas();

        ejecutarRecursivo(piezasTotales, actual, maquinas);

        if (mejorSolucion != null) {
            mejorSolucion.setCosto(estadosGenerados); // <— copiamos el total de estados generados
            return mejorSolucion;
        } else {
            SolucionSinResultado sinResultado = new SolucionSinResultado(Solucion.MetodoResolucion.BACKTRACKING);
            sinResultado.setCosto(estadosGenerados);
            return sinResultado;
        }
    }

    private void ejecutarRecursivo(int piezasRestantes, Solucion actual, List<Maquina> maquinas) {
        estadosGenerados++;

        // Caso base: solución exacta
        if (piezasRestantes == 0) {
            if (mejorSolucion == null || actual.getPuestasEnFuncionamiento() < mejorSolucion.getPuestasEnFuncionamiento()) {
                mejorSolucion = new Solucion(actual); // copia profunda
            }
            return;
        }

        // Poda por exceso de producción
        if (piezasRestantes < 0) return;
        // Poda por cantidad de máquinas usadas (no se puede mejorar más)
        if (mejorSolucion != null && actual.getPuestasEnFuncionamiento() >= mejorSolucion.getPuestasEnFuncionamiento()) return;

        for (Maquina m : maquinas) {
            if (m.getPiezas() != 0) {
                actual.agregarMaquina(m);
                ejecutarRecursivo(piezasRestantes - m.getPiezas(), actual, maquinas);
                actual.quitarUltima();
            }
        }
    }
}
