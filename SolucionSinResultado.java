package prog3.Trabajo.Especial;

public class SolucionSinResultado extends Solucion {

    public SolucionSinResultado(MetodoResolucion metodo) {
        super(metodo);
    }

    @Override
    public String toString() {
        return metodo + " - No se encontró una solución válida.\n" +
                "Costo (" + (metodo == MetodoResolucion.BACKTRACKING ? "estados generados" : "candidatos considerados") + "): " + getCosto() + "\n";
    }

    @Override
    public void agregarMaquina(Maquina maquina) {
        // Nada: No se puede agregar maquinas si no hay resultado
    }

    @Override
    public void quitarUltima() {
        // Nada: No se puede quitar maquinas si no hay resultado
    }
}
