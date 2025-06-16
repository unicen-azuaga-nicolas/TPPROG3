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
    protected MetodoResolucion metodo; // "Backtracking" o "Greedy"

    public Solucion(MetodoResolucion metodo) {
        this.secuenciaMaquinas = new ArrayList<>();
        this.piezasProducidas = 0;
        this.puestasEnFuncionamiento = 0;
        this.costo = 0;
        this.metodo = metodo;
    }

    public Solucion(Solucion otra) {
        this.secuenciaMaquinas = new ArrayList<>(otra.secuenciaMaquinas);
        this.piezasProducidas = otra.piezasProducidas;
        this.puestasEnFuncionamiento = otra.puestasEnFuncionamiento;
        this.costo = otra.costo;
        this.metodo = otra.metodo;
    }

    public void agregarMaquina(Maquina maquina) {
        this.secuenciaMaquinas.add(maquina);
        this.puestasEnFuncionamiento++;
        this.piezasProducidas += maquina.getPiezas();
    }

    public void quitarUltima() {
        if (!secuenciaMaquinas.isEmpty()) {
            Maquina ultima = secuenciaMaquinas.remove(secuenciaMaquinas.size() - 1);
            piezasProducidas -= ultima.getPiezas();
            puestasEnFuncionamiento--;
        }
    }


    public void incrementarCosto() {
        this.costo++;
    }

    public void setCosto(int costo){
        this.costo = costo;
    }

    public int getCosto(){
        return this.costo;
    }

    public int getPuestasEnFuncionamiento(){
        return this.puestasEnFuncionamiento;
    }
    @Override
    public String toString() {
        return metodo + " - Solución:\n" +
                "Secuencia: " + secuenciaMaquinas + "\n" +
                "Piezas producidas: " + piezasProducidas + "\n" +
                "Puestas en funcionamiento: " + puestasEnFuncionamiento + "\n" +
                "Costo (" + (metodo == Solucion.MetodoResolucion.BACKTRACKING ? "estados generados" : "candidatos considerados") + "): " + costo + "\n";
    }
}
