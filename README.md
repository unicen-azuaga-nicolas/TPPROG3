# Trabajo Especial - Resolución de Producción Óptima de Piezas

## 🎯 Objetivo

Determinar una **secuencia óptima de utilización de máquinas** en una fábrica de autopartes, bajo ciertas restricciones de funcionamiento, para producir una **cantidad determinada de piezas**.

El objetivo es **minimizar la cantidad de puestas en funcionamiento de las máquinas**, teniendo en cuenta que:

- Cada máquina produce una cantidad fija de piezas por ciclo.
- Las máquinas pueden reutilizarse las veces que sea necesario.

El problema se aborda mediante dos enfoques de resolución:

- 🔁 **Backtracking**
- ⚡ **Greedy**

Ambos métodos han sido implementados y **comparados en cuanto a la calidad de la solución** y el **costo computacional** de cada estrategia.

---

## 🔎 Resolución mediante Backtracking

### 🧠 Estrategia

Se exploran recursivamente **todas las combinaciones posibles** de máquinas cuya suma de piezas sea igual a la cantidad requerida.

- **Estado inicial**: 0 piezas producidas, sin máquinas utilizadas.
- **Estado final**: suma exacta de piezas producidas.
- **Estado solución**: estado final con **menor cantidad de puestas en funcionamiento** (mínima profundidad en el árbol).

### 🌳 Exploración

- En cada nivel del árbol se prueban **todas las máquinas disponibles**, ya que pueden reutilizarse.
- Se representa cada camino del árbol como una posible combinación de máquinas.

### ✂️ Poda

- Se aplica **poda por sobreproducción**: se descartan caminos que superan la cantidad de piezas objetivo.
- Se aplica **poda por no mejora**: se descartan las ramas en las que la cantidad de máquinas utilizadas ya es mayor o igual a la de la mejor solución encontrada hasta el momento.

### ✅ Solución obtenida (ejemplo)

- **Secuencia de máquinas**: `[M1, M3, M4]`
- **Cantidad de piezas producidas**: `12`
- **Puestas en funcionamiento**: `3`
- **Métrica de costo**: `85` estados generados

---

## ⚡ Resolución mediante Greedy

### 🧠 Estrategia

- El algoritmo Greedy (voraz) construye la solución paso a paso, tomando **la mejor decisión local** en cada iteración.
- Se ordenan las máquinas de **mayor a menor producción**.
- En cada paso se selecciona la primera máquina cuya producción **no exceda la cantidad de piezas restantes**.
- La máquina seleccionada se agrega a la solución y se actualiza el total de piezas por producir.
- El proceso se repite hasta alcanzar la cantidad requerida o hasta que no se pueda continuar.

### ❗ Consideraciones

- El algoritmo **no explora todas las combinaciones posibles**, por lo tanto **no garantiza una solución óptima**.
- El algoritmo **puede fallar en encontrar una solución**, incluso cuando existe una, si esta depende de combinaciones que el enfoque voraz no contempla por tomar decisiones basadas solo en el mejor candidato inmediato.
- Las decisiones se basan únicamente en la situación actual (**decisión local**), sin considerar cómo afectarán al resultado final (**visión global limitada**).
- El algoritmo es rápido y eficiente, pero puede ser **miope** en escenarios complejos.

---

## 📊 Comparación de Estrategias

| Estrategia   | ¿Garantiza solución óptima? | Costosa en tiempo | 
|--------------|------------------------------|-------------------|
| Backtracking | ✅ Sí                        | ❌ Sí             | 
| Greedy       | ❌ No                        | ✅ No             | 

---

## 📁 Estructura del Proyecto

```bash
├── Algoritmo.java  
├── Backtracking.java  
├── Greedy.java  
├── LectorArchivo.java  
├── Maquina.java  
├── Main.java  
├── Problema.java  
├── Solucion.java  
├── SolucionSinResultado.java  
└── maquinas.txt

