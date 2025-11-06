## 📊 **Informe de Métricas de Calidad SonarQube: Bioprint_Sonar**

Este informe resume el estado actual de la calidad del código del proyecto `Bioprint_Sonar`, basado en el análisis de SonarQube, junto con una aclaración sobre el alcance de las métricas.

### ⚠️ **Aclaración Importante sobre el Alcance del Análisis**

**Las métricas presentadas a continuación corresponden al repositorio base que SonarQube está analizando actualmente. No reflejan el estado actual del proyecto.**

* **Progreso en Curso:** Las estrategias para reducir los 135 problemas de mantenibilidad y aumentar la cobertura de código (implementación de pruebas y buenas prácticas) **ya están siendo implementadas**.
* **Motivo de la Discrepancia:** La implementación de SonarQube se realizó sobre un **fork del repositorio** asociado a la cuenta `githublauraa`, debido a restricciones de permisos en el repositorio original.
* **Conclusión:** Los resultados de SonarQube, por lo tanto, muestran las métricas del código **antes** de que las mejoras fueran aplicadas y aún no reflejan el progreso real del desarrollo. 
---

### 📌 **Resumen General de las Métricas Reportadas**

| Métrica | Valor Reportado | Estado | Observación |
| :--- | :--- | :--- | :--- |
| Líneas de Código (LOC) | 659 (Java, XML) | N/A | Total de código analizado. |
| Quality Gate | **Passed** | ✅ | El análisis pasa las reglas configuradas, a pesar de la deuda técnica. |
| **Cobertura (Coverage)** | **0.0%** | **🔴 Crítico** | **No hay pruebas unitarias/integración reportadas en este alcance.** |
| Deuda Técnica (Maintainability) | **135 Open Issues** | **🟡 Alta** | Reflejado en la calificación **"B"**. |
| Seguridad (Security) | 0 Open issues | ✅ | No se encontraron problemas de seguridad. |
| Fiabilidad (Reliability) | 0 Open issues | ✅ | No se encontraron problemas de fiabilidad. |
| Duplicaciones (Duplications) | 0.0% | ✅ | No hay código duplicado. |

![Vista General del proyecto SonarQube](assets/ResumenGeneral.png)

---

### 📉 **Análisis de las Métricas Obsoletas (Previas a las Mejoras)**

#### 1. **Cobertura de Código Críticamente Baja (0.0%)**

* **Métrica:** Cobertura: **0.0%**.
* **Detalle:** El análisis reporta que **Cero** de las **659 Líneas de Código (LOC)** están cubiertas por pruebas, requiriendo cubrir 324 líneas.
* **Contexto de Riesgo (Previo a las Mejoras):** Este valor indicaba un riesgo muy alto para la estabilidad. **Sin embargo, este riesgo se está mitigando con la implementación de pruebas en el fork.**

![Métrica de cobertura del proyecto en SonarQube](assets/DetallesCobertura.png)

#### 2. **Alta Deuda Técnica y Mantenibilidad Media ("B")**

* **Métrica:** Mantenibilidad: **135 Open Issues** (Clasificación **"B"**).
* **Detalle:** El código base presenta un número significativo de problemas que afectan la legibilidad y la modificación futura.
* **Contexto de Riesgo (Previo a las Mejoras):** La calificación "B" indicaba dificultades en el mantenimiento. **Este es el foco de las buenas prácticas y refactorizaciones en curso en el fork, lo que reducirá los 135 problemas reportados.**

![Métrica de mantenibilidad del proyecto en SonarQube](assets/ArchivosMantenibilidad.png)
---

### 🔎 **Archivos con Mayor Deuda Técnica Reportada**

Estos archivos han sido identificados como los principales contribuyentes a la deuda técnica en el código base, y deben ser priorizados para la refactorización y cobertura de pruebas en la rama de desarrollo:

| Archivo | Ruta | Calificación (Mantenibilidad) | LOC | Observación |
| :--- | :--- | :--- | :--- | :--- |
| **Formulario.java** | `src/main/java/.../Formulario.java` | **C** | 211 | Archivo con mayor LOC y Calificación 'C'. |
| **MenuUsuarios.java** | `src/main/java/.../MenuUsuarios.java` | **C** | 50 | Calificación 'C', indica baja mantenibilidad. |
| Otros archivos | Varios | B | Varias | Múltiples archivos con calificación 'B'. |
