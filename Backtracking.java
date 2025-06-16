package prog3.Trabajo.Especial;

import java.util.List;

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
        estadosGenerados++; // <— Aumentamos el contador global

        // Caso base: solución exacta
        if (piezasRestantes == 0) {
            if (mejorSolucion == null || actual.getPuestasEnFuncionamiento() < mejorSolucion.getPuestasEnFuncionamiento()) {
                mejorSolucion = new Solucion(actual); // copia profunda
            }
            return;
        }

        // Poda por exceso
        if (piezasRestantes < 0) return;
        //Poda por cantidad de máquinas usadas
        if (mejorSolucion != null && actual.getPuestasEnFuncionamiento() >= mejorSolucion.getPuestasEnFuncionamiento()) return;

        for (Maquina m : maquinas) {
            actual.agregarMaquina(m);
            ejecutarRecursivo(piezasRestantes - m.getPiezas(), actual, maquinas);
            actual.quitarUltima();
        }
    }
}
