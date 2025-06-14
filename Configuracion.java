package prog3.Trabajo.Especial;

import java.util.List;

public class Configuracion {
	private int piezasTotales;
    private List<Maquina> maquinas;

    public Configuracion(int piezasTotales, List<Maquina> maquinas) {
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
