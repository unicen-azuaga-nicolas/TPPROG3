// LectorArchivo.java
package prog3.Trabajo.Especial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo {

    public static Problema cargarMaquinasDesdeArchivo(String ruta) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            int piezasTotales = Integer.parseInt(br.readLine().trim());
            List<Maquina> maquinas = new ArrayList<>();

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0].trim();
                int piezas = Integer.parseInt(partes[1].trim());
                maquinas.add(new Maquina(nombre, piezas));
            }

            return new Problema(piezasTotales, maquinas);
        }
    }
}
