#  Calculadora de Huella de Carbono

## Descripción general

Este proyecto implementa una **calculadora de huella de carbono** modular basada en principios de **orientación a objetos** y el uso de **patrones de diseño**.  
La aplicación permite obtener la huella de carbono de un usuario mediante formularios interactivos, gestionando datos personales, históricos y un ranking de consumo sostenible.  
Además, incluye una interfaz que conecta con una **mascota virtual educativa**.

El sistema está dividido en paquetes bien definidos, según responsabilidades lógicas y patrones de diseño.

---

## Estructura por paquetes

### **1. CalculoHuella**
Encargado del **núcleo lógico** que realiza el cálculo de la huella total a partir de distintas fuentes.

**Clases:**
- `CalculadoraHuella` *(Singleton)*:  
  Clase única que centraliza los cálculos.  
  - Métodos: `getInstance()`, `calcularTotal(GrupoFuentes grupo)`
- `GrupoFuentes` *(Composite)*:  
  Permite agrupar múltiples fuentes de huella (electricidad, agua, transporte, etc.).  
  - Métodos: `addFuente()`, `calcularHuellaTotal()`
- `FuenteHuella`:  
  Interfaz base para representar una fuente de emisión individual.
- `FuenteHuellaFactory` *(Factory)*:  
  Crea objetos `FuenteHuella` adaptados según el tipo de consumo ingresado.

---

### **2. Transporte (Strategy)**
Contiene las estrategias para calcular emisiones según el tipo de transporte utilizado.

**Clases:**
- `EstrategiaTransporte`:  
  Interfaz general del patrón *Strategy*.
- `EstrategiaBus`, `EstrategiaCarro`, `EstrategiaBici`:  
  Implementan distintas fórmulas de cálculo de CO₂ según el medio de transporte.
- `Transporte`:  
  Contexto del patrón *Strategy*. Usa una estrategia concreta y también implementa `FuenteHuella` para integrarse al cálculo general.

---

### **3. Adapter**
Permite traducir la huella total en una equivalencia visual (por ejemplo, en árboles plantados).

**Clases:**
- `Equivalencia`:  
  Interfaz general que define cómo representar la equivalencia.
- `ArbolesAdapter` *(Adapter)*:  
  Adapta la huella numérica a un formato de interpretación ecológica comprensible.

---

### **4. Observer**
Gestiona la notificación de resultados y actualizaciones de cálculo a observadores externos (por ejemplo, consola o interfaz).

**Clases:**
- `Sujeto` *(Observable)*:  
  Permite registrar, eliminar y notificar observadores cuando se calcula una nueva huella.
- `Observador`:  
  Interfaz del patrón *Observer*.
- `ConsolaObservador`:  
  Implementa la visualización de actualizaciones en la consola.

---

### **5. Usuarios / Base de Datos**
Gestiona la información de usuarios y sus registros históricos.

**Clases:**
- `RegistroUsuario`:  
  Contiene los datos del usuario (nombre, edad, correo, etc.).
- `HistorialUsuario`:  
  Guarda el historial de cálculos previos del usuario.
- `RankingUsuarios`:  
  Ordena a los usuarios según su huella total (de menor a mayor consumo).

---

### **6. InterfazUsuario**
Simula la capa de interacción del usuario con el sistema.

**Clases:**
- `InterfazUsuario`:  
  Representa la interfaz que conecta los formularios, la mascota y la lógica de cálculo.
- `MascotaVirtual`:  
  Entidad visual/educativa que acompaña al usuario y ofrece retroalimentación positiva sobre sus hábitos.

---

