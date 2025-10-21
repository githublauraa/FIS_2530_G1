# 🌎 Calculadora de Huella de Carbono — Diagrama de GUI

Este documento muestra la arquitectura visual de la **interfaz gráfica (GUI)** del sistema de cálculo de huella de carbono, en relación con los módulos de **lógica** y **base de datos**.  
El diagrama refleja cómo interactúan los distintos componentes desde la vista del usuario hasta la persistencia de los datos.

---

## 🧩 Estructura General

El sistema se divide en **tres módulos principales**:

### 🖥️ Interfaz de Usuario
- Gestiona la interacción con el usuario final.
- Permite ingresar datos mediante formularios, visualizar resultados y mantener un historial.
- Incluye una **mascota virtual** que reacciona a los resultados de huella de carbono.
- También muestra un **ranking de usuarios** basado en su consumo de CO₂.

**Clases principales:**
- `PantallaPrincipal`
- `FormularioHuella`
- `ResultadosHuella`
- `MascotaVirtual`
- `HistorialUsuario`
- `RankingUsuarios (UI)`

---

### 🌱 Cálculo de Huella de Carbono
- Contiene la lógica central del cálculo.
- Aplica patrones de diseño como **Singleton**, **Strategy**, **Composite** y **Adapter**.
- Permite calcular la huella total combinando fuentes (energía, transporte, alimentación, etc.).

**Clases principales:**
- `CalculadoraHuella (Singleton)`
- `GrupoFuentes (Composite)`
- `Transporte (Strategy Context)`
- `EstrategiaCarro / Bus / Bici (Concrete Strategies)`
- `ArbolesAdapter (Adapter)`

---

### 🗄️ Base de Datos
- Gestiona la persistencia de usuarios y sus resultados.
- Permite registrar, validar y mantener el historial de huellas por usuario.
- Ofrece un ranking global basado en el consumo promedio.

**Clases principales:**
- `RegistroUsuario`
- `HistorialUsuario`
- `RankingUsuarios`

