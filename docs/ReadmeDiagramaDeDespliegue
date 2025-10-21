# 🌿 Diagrama de Despliegue — Calculadora de Huella de Carbono

Este diagrama de despliegue representa la arquitectura física y lógica del sistema **Calculadora de Huella de Carbono**, mostrando cómo se distribuyen los componentes principales entre los distintos nodos del sistema y cómo se comunican entre sí.

---

## 🧩 Descripción general

El sistema está compuesto por tres nodos principales:

### 1. 🖥️ Cliente Web
Este nodo representa el entorno del usuario final.  
Incluye la **InterfazUsuario**, encargada de:
- Mostrar formularios para ingresar datos de consumo o transporte.  
- Visualizar los resultados del cálculo de la huella.  
- Mostrar la **MascotaVirtual**, que reacciona según el impacto ambiental del usuario.  
- Presentar el **Ranking de Usuarios** con base en sus huellas registradas.  

El cliente se comunica con el **API Backend** a través de peticiones **HTTP**, enviando y recibiendo datos en formato JSON.

---

### 2. ⚙️ API Backend
Nodo que contiene la lógica principal del sistema.  
Su función es procesar las solicitudes provenientes del cliente y coordinar las operaciones necesarias para calcular la huella de carbono, utilizando los componentes internos del sistema:
- **CalculadoraHuella** para los cálculos.
- **FuenteHuellaFactory** y sus estrategias para distintos tipos de fuentes (transporte, energía, dieta).  
- Gestión de observadores y equivalencias visuales mediante adaptadores.

El backend actúa como intermediario entre el **Cliente Web** y la **Base de Datos**, garantizando la integridad de los datos y la separación de responsabilidades.

---

### 3. 🗄️ Base de Datos
Contiene la información persistente del sistema:
- **Usuarios registrados.**
- **Historial de huellas** individuales.  
- **Ranking general** de usuarios según sus resultados.  

La comunicación con el backend se realiza mediante **JDBC / ORM**, lo que facilita las operaciones CRUD (crear, leer, actualizar y eliminar) sin exponer directamente la estructura interna de la base de datos.

---

## 🔗 Flujo de comunicación

1. El **Cliente Web** envía solicitudes HTTP al **API Backend** para realizar cálculos o consultar datos.  
2. El **API Backend** procesa la lógica solicitada y, si es necesario, consulta o actualiza la **Base de Datos**.  
3. El resultado (por ejemplo, la huella total, el promedio o el ranking) es devuelto al cliente para su visualización en la interfaz.  
