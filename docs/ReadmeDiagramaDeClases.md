# 🌱 Calculadora de Huella de Carbono — Diagrama de Clases

Este proyecto modela una **aplicación de cálculo de huella de carbono** que permite a los usuarios ingresar sus hábitos de consumo (energía, transporte, alimentación, etc.) para estimar su impacto ambiental.  
El sistema se organiza en módulos que integran distintos **patrones de diseño** para garantizar flexibilidad, reutilización y bajo acoplamiento.

---

## 🧩 Arquitectura General

El sistema se divide en **tres grandes módulos**:

### 1. Módulo de Cálculo de Huella
Contiene la lógica de negocio encargada de **calcular la huella total de carbono** del usuario a partir de diferentes fuentes (energía, transporte, alimentación, etc.).

**Clases principales:**
- `CalculadoraHuella` → Usa el patrón **Singleton** para centralizar el cálculo general.
- `FuenteHuella` → Interfaz común que define el método `calcularHuella()`.
- `GrupoFuentes` → Implementa el patrón **Composite**, permitiendo agrupar varias fuentes de emisión y tratarlas como una sola.
- `FuenteHuellaFactory` → Aplica el patrón **Factory**, creando objetos `FuenteHuella` según el tipo de datos ingresados (energía, transporte, dieta).
- `Transporte` y sus estrategias → Implementan el patrón **Strategy**, permitiendo cambiar dinámicamente la forma de calcular emisiones según el medio de transporte.

---

### 2. Módulo de Base de Datos
Encargado del **registro, almacenamiento y seguimiento** de la información del usuario.

**Clases principales:**
- `RegistroUsuario` → Contiene los datos básicos del usuario (nombre, correo, contraseña).
- `HistorialUsuario` → Guarda los valores históricos de huella registrados.
- `RankingUsuarios` → Genera una lista ordenada de usuarios de menor a mayor huella de carbono.

Relaciones:
- Cada `RegistroUsuario` tiene un `HistorialUsuario`.
- `RankingUsuarios` administra una colección de usuarios para compararlos.

---

### 3. Módulo de Interfaz de Usuario
Gestiona la interacción con el usuario final y muestra resultados de forma visual o textual.

**Clases principales:**
- `InterfazUsuario` → Permite mostrar formularios y resultados.
- `MascotaVirtual` → Representa una entidad visual que **reacciona según el nivel de huella**, motivando hábitos sostenibles.

---

### 4. Módulo de Comunicación y Adaptación
Integra patrones para conversión de datos y notificación de eventos.

**Clases principales:**
- `ArbolesAdapter` → Implementa el patrón **Adapter**, convirtiendo la huella en equivalencias fáciles de entender (por ejemplo, “equivale a plantar 5 árboles”).
- `Equivalencia` → Interfaz base usada por el adaptador.

**Patrón Observer:**
- `Sujeto` → Clase **Observable** que mantiene una lista de observadores.
- `Observador` → Interfaz que define el método `actualizar(huella)`.
- `ConsolaObservador` → Implementación concreta que muestra la huella actualizada por consola.

---

## ⚙️ Patrones de Diseño Implementados

| Patrón | Clases Involucradas | Propósito |
|:------:|:--------------------|:-----------|
| **Singleton** | `CalculadoraHuella` | Garantiza una única instancia del cálculo global de huella. |
| **Factory** | `FuenteHuellaFactory` | Crea objetos `FuenteHuella` según el tipo de fuente de emisión. |
| **Composite** | `GrupoFuentes`, `FuenteHuella` | Permite manejar múltiples fuentes de huella como una sola entidad. |
| **Strategy** | `EstrategiaTransporte`, `EstrategiaCarro`, `EstrategiaBus`, `EstrategiaBici`, `Transporte` | Permite cambiar la estrategia de cálculo según el tipo de transporte. |
| **Adapter** | `ArbolesAdapter`, `Equivalencia` | Convierte la huella de carbono en equivalencias comprensibles. |
| **Observer** | `Sujeto`, `Observador`, `ConsolaObservador` | Notifica cambios en la huella a diferentes componentes interesados. |

---

## 🔗 Relaciones Importantes

- `Transporte` **implementa** `FuenteHuella` → se comporta como una fuente de emisión más.
- `GrupoFuentes` **implementa** `FuenteHuella` → permite tratar conjuntos de fuentes de igual manera.
- `EstrategiaCarro`, `EstrategiaBus` y `EstrategiaBici` **implementan** `EstrategiaTransporte` → cada una define una forma distinta de calcular emisiones.
- `ArbolesAdapter` **implementa** `Equivalencia` → convierte el resultado numérico de CO₂ en equivalentes naturales.
- `Sujeto` **se comunica con** múltiples `Observador` → notifica los cambios en la huella.
- `InterfazUsuario` **usa** `CalculadoraHuella` y `MascotaVirtual` para mostrar los resultados al usuario.


## 🧾 Notas finales

- El diagrama utiliza **estereotipos UML** (`<<Singleton>>`, `<<Factory>>`, etc.) para identificar las clases que aplican patrones de diseño.
- Las **cardinalidades** (`1`, `1..*`, `*`) indican las relaciones entre las clases.

