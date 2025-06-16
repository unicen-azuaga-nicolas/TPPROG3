package prog3.Trabajo.Especial;

public class Maquina implements Comparable<Maquina> {
	String nombre;
    int piezas;

    public Maquina(String nombre, int piezas) {
        this.nombre = nombre;
        this.piezas = piezas;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int compareTo(Maquina o) {
        return Integer.compare(o.piezas, this.piezas);
    }
}
