GRUPO 91 / Azuaga Nicolás - Loustau Carlota
TRABAJO PRÁCTICO ESPECIAL

Objetivo
Determinar una secuencia óptima de utilización de máquinas en una fábrica de autopartes, bajo ciertas restricciones de funcionamiento, 
para producir una cantidad determinada de piezas. Se busca encontrar una solución que minimice la cantidad de puestas en funcionamiento de las máquinas, 
aprovechando que cada máquina produce una cantidad fija de piezas por ciclo y puede reutilizarse las veces que sea necesario. 
El problema se aborda mediante dos enfoques de resolución: Backtracking y Greedy. Ambos métodos han sido implementados y comparados en cuanto a la calidad 
de la solución obtenida y el costo computacional asociado a cada estrategia.

Resolución mediante Backtracking
Se busca explorar recursivamente todas las posibles combinaciones de máquinas cuya suma de piezas sea igual a la cantidad total requerida. 
Cada nodo del árbol de exploración representa un estado parcial de la producción ( piezas producidas, máquinas utilizadas hasta ese momento).
Estados iniciales: Producción total en 0, sin máquinas utilizadas.
Estados finales: Aquellos en los que la suma de piezas producidas alcanza exactamente la cantidad objetivo.
Estados solución: Aquellos estados finales que además tienen la menor cantidad de máquinas (mínima profundidad del camino).
Exploración: En cada nivel del árbol se consideran todas las máquinas disponibles (ya que pueden reutilizarse).
Poda: Se aplica poda por sobreproducción, es decir, se descartan aquellas ramas en las que la suma de piezas supera la cantidad objetivo.
Esto permite reducir el espacio de búsqueda sin perder soluciones válidas.

Solución obtenida:
 Secuencia de máquinas: [M1, M3, M4]
 Cantidad de piezas producidas: 12
 Puestas en funcionamiento requeridas: 3
Métrica de costo:
 Cantidad de estados generados: 85

Resolución mediante Greedy
