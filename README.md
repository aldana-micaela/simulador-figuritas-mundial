# 🏆 Simulador de Figuritas del Mundial

Este proyecto es una simulación estadística desarrollada en **Java**, cuyo objetivo es estimar cuántos paquetes de figuritas, en promedio, se necesitan para completar un álbum del Mundial. A través de diferentes escenarios configurables y una interfaz gráfica interactiva, el usuario puede observar y comparar los resultados de cada simulación.

---

## 🚀 Funcionalidades principales

- Simulación de compra de paquetes de figuritas.
- Cálculo estadístico de la cantidad necesaria para completar el álbum.
- Comparación de diferentes escenarios de simulación.
- Visualización de los resultados mediante interfaz gráfica.

---

## ⚙️ Tecnologías y conceptos aplicados
- **Java** (POO)
- **Interfaces**
- **Enum**
- **Observador (Observer Pattern)**
- **Java Swing** (Interfaz gráfica)
- **JUnit** (Pruebas unitarias)
- **Manejo de excepciones**
- **Colecciones (List, Set, Map)**
- **Lógica de simulación probabilística**

### 🖥️ Lenguaje:
- **Java** (JDK 8+)
- Programación Orientada a Objetos (POO)

### 🎨 Interfaz gráfica:
- **Java Swing**: 
  - Uso de componentes como `JFrame`, `JPanel`, `JButton`, `JLabel`, entre otros.
  - Clases destacadas: `SimuladorInterface.java`, `Menu.java`.
 
## 🧪 Pruebas unitarias
Se implementaron pruebas unitarias utilizando **JUnit** para validar:

- El comportamiento del álbum (registro, duplicados, llenado).
- La lógica de creación de paquetes y selección aleatoria de figuritas.
- El control de estadísticas de simulación.


### 🔁 Principios de diseño y patrones:
- **Interfaces Java**:
  - `Generador`, `Escenario` y `Observador` como contratos para implementación flexible.
- **Patrón Observador (Observer Pattern)**:
  - Implementación propia en el paquete `observador`, con clases como `ObservadorGrafico` y `ObservadorPorInterfaz`.
- **Separación de responsabilidades**:
  - `escenarios`: diferentes lógicas de simulación.
  - `generador`: generación aleatoria o prefijada de paquetes.
  - `interfaz`: interacción con el usuario.
  - `observador`: actualización de la vista según los eventos de simulación.

---

## 📁 Estructura del proyecto
```
src/
├── escenarios/ # Escenarios de simulación (Escenario1, Escenario2, etc.)
├── generador/ # Generación de paquetes de figuritas
├── interfaz/ # Interfaz gráfica con Swing
├── observador/ # Implementación del patrón Observer
├── Simulador.java # Clase principal
```
---

## 📄 Documentación

- Se incluye un informe técnico (`InformeTP3.adoc`) con explicación del diseño, los algoritmos implementados y resultados obtenidos tras ejecutar múltiples simulaciones.

---

## ▶️ Cómo ejecutar el proyecto

1. Abrí el proyecto en un IDE como **Eclipse** o **IntelliJ IDEA**.
2. Asegurate de tener instalado **Java 8 o superior**.
3. Ejecutá la clase `Simulador.java`.
4. Desde el menú, seleccioná el escenario de simulación y observá los resultados.

---

## 👩‍💻 Autoría

Desarrollado como proyecto académico para aplicar conocimientos de programación orientada a objetos, patrones de diseño e interfaces gráficas en Java.

---

