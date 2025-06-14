package prog3.Trabajo.Especial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo {
	public static Configuracion leerArchivo(String ruta) throws IOException {
        List<Maquina> maquinas = new ArrayList<>();
        int piezasTotales;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
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

        return new Configuracion(piezasTotales, maquinas);
    }
}
