package prog3.Trabajo.Especial;

import java.util.List;

/*
 * Estrategia Backtracking:
 * - Se genera el árbol de exploracion probando todas las posibles combinaciones de máquinas.
 * - En cada nivel del árbol se prueba con cada máquina disponible, restando su producción al total restante.
 * - Un estado solución es aquel que logra que piezasRestantes == 0.
 * - Se guarda la mejor solución con menor cantidad de puestas en funcionamiento .
 * - Se implementa poda: si piezasRestantes < 0, no se continúa con esa rama.
 */
public class Backtracking implements Algoritmo {

    private Solucion mejorSolucion;
    private int estadosGenerados;

    public Backtracking() {
        this.mejorSolucion = null;
        this.estadosGenerados = 0;
    }

    @Override
    public Solucion ejecutar(Problema p) {
        Solucion actual = new Solucion(Solucion.MetodoResolucion.BACKTRACKING);
        mejorSolucion = null;
        estadosGenerados = 0;

        ejecutarRecursivo(p.getPiezasTotales(), actual, p.getMaquinas());

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
            actual.agregarMaquina(m);
            ejecutarRecursivo(piezasRestantes - m.getPiezas(), actual, maquinas);
            actual.quitarUltima();
        }
    }
}
