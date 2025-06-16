package prog3.Trabajo.Especial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo {
    private String ruta;
    private int piezasTotales;

    private List<Maquina> maquinas;

    public LectorArchivo(String ruta) {
        this.ruta = ruta;
        this.maquinas = new ArrayList<>();
        this.piezasTotales = 0;
    }

    public int getPiezasTotales() {
        return piezasTotales;
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public void leerArchivo() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(this.ruta))) {
            // Leer la primera línea (piezasTotales)
            piezasTotales = Integer.parseInt(br.readLine().trim());

            // Leer las demás líneas
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0].trim();
                int piezas = Integer.parseInt(partes[1].trim());
                maquinas.add(new Maquina(nombre, piezas));
            }
        }
    }
}
