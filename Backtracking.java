package prog3.Trabajo.Especial;

import java.util.ArrayList;
import java.util.List;

public class Backtracking implements Algoritmo {

    private List<Maquina> mejorSolucion;

    public Backtracking() {
        this.mejorSolucion = new ArrayList<>();
    }

    @Override
    public Solucion ejecutar(Problema p) {
        Solucion solucion = new Solucion(Solucion.MetodoResolucion.BACKTRACKING);
        List<Maquina> actual = new ArrayList<>();
        ejecutarRecursivo(p.getPiezasTotales(), actual, p.getMaquinas(), solucion);

        // Agregamos la mejor solución a la instancia de Solucion
        for (Maquina m : mejorSolucion) {
            solucion.agregarMaquina(m);
        }

        return solucion;
    }

    private boolean ejecutarRecursivo(int piezasRestantes, List<Maquina> actual, List<Maquina> maquinas, Solucion solucion) {
        solucion.incrementarCosto(); // Estado generado

        // Caso base: solución exacta encontrada
        if (piezasRestantes == 0) {
            if (mejorSolucion.isEmpty() || actual.size() < mejorSolucion.size()) {
                mejorSolucion.clear();
                mejorSolucion.addAll(new ArrayList<>(actual));
            }
            return true;
        }

        // Poda por exceso
        if (piezasRestantes < 0) return false;

        // Poda por subóptimo
        if (!mejorSolucion.isEmpty() && actual.size() >= mejorSolucion.size()) return false;

        boolean encontrado = false;

        for (Maquina m : maquinas) {
            actual.add(m);  // Tomar decisión
            if (ejecutarRecursivo(piezasRestantes - m.getPiezas(), actual, maquinas, solucion)) {
                encontrado = true;
            }
            actual.remove(actual.size() - 1);  // Deshacer decisión
        }

        return encontrado;
    }
}
