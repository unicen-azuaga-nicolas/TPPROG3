package prog3.Trabajo.Especial;

import java.util.List;

public class Problema {
    private int piezasTotales;
    private List<Maquina> maquinas;

    public Problema(int piezasTotales, List<Maquina> maquinas) {
        this.piezasTotales = piezasTotales;
        this.maquinas = maquinas;
    }

    public int getPiezasTotales() {
        return piezasTotales;
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }
}
