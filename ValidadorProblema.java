package prog3.Trabajo.Especial;

import prog3.Trabajo.Especial.Maquina;
import prog3.Trabajo.Especial.Problema;

public class ValidadorProblema {

    public ValidadorProblema(){

    }
    public static boolean esProblemaValido(Problema problema) {
        // Validar que el total de piezas a producir sea mayor que cero
        if (problema.getPiezasTotales() <= 0) {
            return false;
        }

        // Validar que al menos una máquina tenga producción mayor a cero
        for (Maquina m : problema.getMaquinas()) {
            if (m.getPiezas() > 0) {
                return true;
            }
        }

        // Si ninguna máquina tiene producción positiva, no hay forma de producir piezas
        return false;
    }
}
