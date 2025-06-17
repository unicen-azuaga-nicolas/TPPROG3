# Trabajo Práctico Especial - Resolución de Producción Óptima de Piezas

---

## 👥 Grupo 91

### Integrantes

- Azuaga Nicolás
- Loustau Carlota Agustina

---
## 🎯 Objetivo

Determinar una **secuencia óptima de utilización de máquinas** en una fábrica de autopartes, bajo ciertas restricciones de funcionamiento, para producir una **cantidad determinada de piezas**.

El objetivo es **minimizar la cantidad de puestas en funcionamiento de las máquinas**, teniendo en cuenta que:

- Cada máquina produce una cantidad fija de piezas por ciclo.
- Las máquinas pueden reutilizarse las veces que sea necesario.

El problema se aborda mediante dos enfoques de resolución:

- 🔁 **Backtracking**
- ⚡ **Greedy**

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
- Se aplica **poda por inutilidad**: se descartan máquinas con producción igual a 0, ya que no aportan al objetivo.

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

---

## ▶️ Ejecución del Programa

### 📄 Archivo de entrada: `maquinas.txt`

El archivo debe contener la configuración del problema, especificando:

1. **Primera línea**: la cantidad total de piezas a producir (un número entero positivo).
2. **Líneas siguientes**: una lista de máquinas disponibles, cada una en una línea con el formato:

#### ✅ Ejemplo de archivo válido:

```txt
7
M1,3
M2,2
M3,1
```
---

### 🏁 Cómo ejecutar

1. Asegurarse de tener el archivo `maquinas.txt` en la raíz del proyecto o en la ubicación esperada por el `LectorArchivo`.
2. Ejecutá el `Main.java`. El programa leerá el archivo y ejecutará ambos algoritmos (`Backtracking` y `Greedy`).
3. En consola vas a ver la solución encontrada por cada estrategia, incluyendo:
    - La secuencia de máquinas utilizadas.
    - Las piezas producidas.
    - La cantidad de puestas en funcionamiento.
    - El costo computacional (estados generados o candidatos evaluados).

---

## 📁 Estructura del Proyecto

```bash
├── Algoritmo.java  
├── Backtracking.java  
├── Greedy.java  
├── LectorArchivo.java
├── Main.java   
├── Maquina.java   
├── Problema.java  
├── Solucion.java  
├── SolucionSinResultado.java  
├── ValidadorProblema.java  
└── maquinas.txt <-- input
```

