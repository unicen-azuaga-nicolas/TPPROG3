package prog3.Trabajo.Especial;

import java.util.ArrayList;
import java.util.List;

public class Solucion {

    public enum MetodoResolucion {
        BACKTRACKING,
        GREEDY
    }

    private List<Maquina> secuenciaMaquinas;
    private int piezasProducidas;
    private int puestasEnFuncionamiento;
    private int costo; // Estados generados o candidatos considerados
    private MetodoResolucion metodo; // "Backtracking" o "Greedy"

    public Solucion(MetodoResolucion metodo) {
        this.secuenciaMaquinas = new ArrayList<>();
        this.piezasProducidas = 0;
        this.puestasEnFuncionamiento = 0;
        this.costo = 0;
        this.metodo = metodo;
    }

    public void agregarMaquina(Maquina maquina) {
        this.secuenciaMaquinas.add(maquina);
        this.puestasEnFuncionamiento++;
        this.piezasProducidas += maquina.getPiezas();
    }

    public void incrementarCosto() {
        this.costo++;
    }

    // Getters
    public List<Maquina> getSecuenciaMaquinas() { return secuenciaMaquinas; }
    public int getPiezasProducidas() { return piezasProducidas; }
    public int getPuestasEnFuncionamiento() { return puestasEnFuncionamiento; }
    public int getCosto() { return costo; }
    public MetodoResolucion getMetodo() { return metodo; }

    public void setMetodo(MetodoResolucion metodo){
        this.metodo = metodo;
    }

    @Override
    public String toString() {
        return metodo + " - Solución:\n" +
                "Secuencia: " + secuenciaMaquinas + "\n" +
                "Piezas producidas: " + piezasProducidas + "\n" +
                "Puestas en funcionamiento: " + puestasEnFuncionamiento + "\n" +
                "Costo (" + (metodo.equals("Backtracking") ? "estados generados" : "candidatos considerados") + "): " + costo;
    }
}
