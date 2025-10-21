# Diagrama de Componentes - Calculadora de Huella de Carbono


## Estructura de Componentes

### Interfaz de Usuario (UI)
- **InterfazUsuario:** Módulo central de interacción. Permite ingresar datos, visualizar resultados y notificaciones.  
- **MascotaVirtual:** Representa gráficamente el progreso del usuario y su impacto ecológico positivo.

> Este módulo interactúa directamente con el usuario y actúa como punto de entrada del sistema.

---

### Gestión de Usuarios / Datos
- **RegistroUsuario:** Gestiona la creación, autenticación y actualización de usuarios.  
- **HistorialUsuario:** Almacena los cálculos previos y resultados de cada usuario.  
- **RankingUsuarios:** Genera clasificaciones entre usuarios, fomentando la competencia ecológica.

> Este módulo garantiza la persistencia y organización de la información del usuario.

---

### ⚙️ Cálculo de Huella
- **CalculadoraHuella:** Núcleo lógico del sistema. Coordina el cálculo de emisiones y aplica las estrategias correspondientes.  
- **GrupoFuentes:** Agrupa distintas fuentes de emisión (electricidad, transporte, alimentación, etc.).  
- **FuenteHuellaFactory:** Implementa el patrón **Factory Method** para instanciar las fuentes adecuadas.  
- **FuenteHuella:** Clase base que define la interfaz común de todas las fuentes de emisión.

> Este módulo representa el motor de cálculo y abstracción de fuentes de impacto.

---

### Módulo de Transporte (Strategy)
- **EstrategiaTransporte:** Interfaz del patrón **Strategy**. Define el contrato común para las estrategias de transporte.  
- **EstrategiaBus, EstrategiaCarro, EstrategiaBici:** Estrategias concretas para calcular emisiones según el medio de transporte.  
- **Transporte:** Clase que utiliza las estrategias para obtener los resultados específicos.

> Este módulo permite extender fácilmente nuevos medios de transporte sin modificar el cálculo principal.

---

### Sistema de Notificación (Observer)
- **Sujeto:** Clase observable. Notifica cambios relevantes del sistema (por ejemplo, nuevos resultados).  
- **Observador:** Interfaz que define el comportamiento de los observadores.  
- **ConsolaObservador:** Implementación concreta que muestra las notificaciones al usuario.

> Se aplica el patrón **Observer**, separando la lógica de notificación del resto del sistema.

---

### Conversor de Equivalencias (Adapter)
- **ArbolesAdapter:** Implementa el patrón **Adapter**, conectando el sistema con servicios externos que convierten emisiones en equivalencias ecológicas.  
- **Equivalencia:** Clase que representa las equivalencias calculadas (por ejemplo, “X árboles necesarios para absorber tu huella”).

> Este módulo adapta los datos de cálculo a métricas más comprensibles para el usuario.

---

## Relaciones Clave

| Desde | Hacia | Descripción |
|-------|-------|--------------|
| InterfazUsuario | CalculadoraHuella | El usuario solicita cálculos desde la interfaz. |
| InterfazUsuario | Sujeto | Envía eventos para notificación. |
| CalculadoraHuella | GrupoFuentes | Agrega las diferentes fuentes de emisiones. |
| GrupoFuentes | FuenteHuella | Define las fuentes concretas a usar. |
| Transporte | EstrategiaTransporte | Aplica el patrón Strategy. |
| CalculadoraHuella | ArbolesAdapter | Convierte los resultados en equivalencias. |
| CalculadoraHuella | Sujeto | Notifica nuevos cálculos a los observadores. |

---

## Patrones de Diseño Utilizados

| Patrón | Propósito | Aplicación |
|--------|------------|------------|
| **Factory Method** | Crear fuentes de huella dinámicamente. | `FuenteHuellaFactory` |
| **Strategy** | Seleccionar el método de cálculo del transporte. | `EstrategiaTransporte` y sus derivados |
| **Adapter** | Integrar equivalencias ecológicas externas. | `ArbolesAdapter` |
| **Observer** | Desacoplar notificaciones de eventos. | `Sujeto` y `Observador` |
| **Singleton** | Garantizar una única instancia global de cálculo. | `CalculadoraHuella` |

---

